package miscUtils

import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.security.Security
import java.util.regex.Pattern
import java.util.zip.Adler32
import java.util.zip.CheckedInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object Misc {

    /**
     * function to download a file from the internet to a given path
     *
     * @param link of download
     * @param savingPath path of the folder in which the file should be save
     */
    @JvmStatic
    fun downloadFromURL(link: String, savingPath: String) {
        if (link.split(":").first().last() == 's') {
            System.setProperty("java.protocol.handler.pkgs",
                    "com.sun.net.ssl.internal.www.protocol")
            Security.addProvider(com.sun.net.ssl.internal.ssl.Provider())
        }
        val filename = link.split("/").last()

        val url = URL(link)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        val input = connection.inputStream
        val output = FileOutputStream(normalizing(savingPath) + filename)
        copy(input, output, 1024)
        output.close()
    }

    private fun copy(input: InputStream, output: FileOutputStream, i: Int) {
        val but = ByteArray(i)
        var n = input.read(but)
        while (n >= 0) {
            output.write(but, 0, n)
            n = input.read(but)
        }
        output.flush()
    }

    /**
     * Function to unzip one or several file
     *
     * @param filePath path of the file to unzip
     * @param destDirectory directory in which the extracted file should be saved
     */
    @JvmStatic
    fun unzipping(filePath: String, destDirectory: String): Long {
        val file = File(filePath)
        if (!file.exists())
            throw FileNotFoundException("file doesn't exist")
        if (filePath.split(".").last() != "zip") {
            throw FileNotFoundException("This is not a zip file")
        }
        val destsave = normalizing(destDirectory)
        val fis = FileInputStream(filePath)
        val checksum = CheckedInputStream(fis, Adler32())
        val zis = ZipInputStream(BufferedInputStream(checksum))
        var entry: ZipEntry? = zis.nextEntry
        while (entry != null) {
            var count: Int
            val but = ByteArray(1024)
            val fos = FileOutputStream(destsave + entry.name)
            val dest = BufferedOutputStream(fos, 1024)
            count = zis.read(but, 0, 1024)
            while (count != -1) {
                dest.write(but, 0, count)
                count = zis.read(but, 0, 1024)
            }
            dest.flush()
            dest.close()
            entry = zis.nextEntry
        }

        val ch = checksum.checksum.value
        zis.close()
        return ch
    }

    /**
     * Function normalizing a folder path, i.e., adding the missing / or \ depending on the os
     *
     * @param path path to normalize
     */
    fun normalizing(path: String): String {
        if (path.last().toString() != System.getProperty("file.separator"))
            return path + System.getProperty("file.separator")
        else
            return path
    }

    /**
     * Method to generate the list of File present in a directory and its subdirectory with the given extension
     *
     * @param folder repository to analyze
     * @param extension file extension (default = C files)
     *
     * @return List<String> list of the files
     */
    @JvmStatic
    fun recursiveListOfFilesOfADirectory(folder: String, extension: String = ".*"): List<String> {
        val pattern = Pattern.compile(extension);
        try {
            return File(folder).walk().asSequence().filter { path -> path.isFile }.map { path -> path.toString() }
                    .map { path -> path.replace(folder, "") }
                    .filter { path -> pattern.matcher(path).find() }
                    .toMutableList()
        } catch (e: IOException) {
            e.printStackTrace()
            return mutableListOf()
        }
    }

}