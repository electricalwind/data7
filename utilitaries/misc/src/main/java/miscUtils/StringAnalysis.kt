package miscUtils

import java.io.File
import java.io.IOException
import java.util.regex.Pattern

object StringAnalysis {

    /**
     * Method to extract url from a string
     *
     * @param text text to process
     *
     * @return list of extracted Url
     */
    fun extractUrls(text: String): List<String> {
        val containedUrls = mutableListOf<String>()
        val urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;()~_?\\+-=\\\\\\.&]*)"
        val regex = Regex(urlRegex, RegexOption.IGNORE_CASE)
        val find = regex.findAll(text)

        for (findings in find) {
            containedUrls.add(findings.value)
        }
        return containedUrls
    }

    /**
     * Method to generate the list of File present in a directory and its subdirectory with the given extension
     *
     * @param folder repository to analyze
     * @param extension file extension (default = C files)
     *
     * @return List<String> list of the files
     */
    fun recursiveListOfFilesOfADirectory(folder: String, extension: String = ".*\\.c$"): List<String> {
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

    /**
     * Function to slice A string into a bag of words with their number of occurences
     *
     * @param file : File content (String)
     *
     * @return map of words and their frequency
     */
    fun slicingWord(file: String): Map<String, Int> {
        val listWord = file.split(Regex("\\W+"))
        return mapOfFrequency(listWord
                .filter { word -> !word.equals("") && !word.contains("0x") }
                .filter { word -> !word.matches(Regex("[0-9]+")) && word.length > 1 })
    }

    /**
     * Function to slice A string into a bag of words with their number of occurences
     * without filtering the number and one letter word
     *
     * @param file : File content (String)
     *
     * @return map of words and their frequency
     */
    fun slicingWordWithoutFilter(file: String): Map<String, Int> {
        val listWord = file.split(Regex("\\W+"))
        return mapOfFrequency(listWord
                .filter { word -> !word.equals("") })
    }

    /**
     * Function to remove all C style comment from a file
     *
     * @param content file
     *
     * @return String without the comment
     */
    fun contentWithoutComment(content: String): String {
        val fc = content.split("\n") as MutableList
        val lines = fc.size
        var i = 0
        var deletingMode = false
        while (i < lines) {
            if (deletingMode) {
                if (fc[i].contains("*/")) {
                    deletingMode = false
                }
                fc[i] = ""
            }
            if (fc[i].contains("/*")) {
                deletingMode = true
                fc[i] = ""
            }
            if (fc[i].contains("//")) {
                fc[i] = fc[i].split("//")[0]
            }
            i++
        }
        return fc.joinToString("\n")
    }

    /**
     * Function to verify if a message contains a keywords
     *
     * @param message message to consider
     * @param listOfKeywords list of the keywords
     *
     * @return [Boolean]
     */
    fun containsAKeyword(message: String, listOfKeywords: List<String>): Boolean {
        listOfKeywords.forEach { key -> if (message.contains(key)) return true }
        return false
    }

    /**
     * Function to put generate a map of Frequency from a list of String
     *
     * @param listOfKeywords list of all the string
     *
     * @return map of frequency
     */
    fun mapOfFrequency(listOfKeywords: Iterable<String>): Map<String, Int> {
        return listOfKeywords.fold(mutableMapOf<String, Int>(), {
            map, item ->
            if (!map.containsKey(item)) {
                map.put(item, 1)
            } else {
                map.put(item, map[item]!! + 1)
            }
            map
        })
    }
}