package data7.plugins.android;

import data7.Data7UpdateListener;
import data7.Exporter;
import data7.Importer;
import data7.ResourcesPath;
import data7.importer.Data7Importer;
import data7.model.Data7;
import data7.project.Project;

import java.io.IOException;
import java.text.ParseException;

import static data7.plugins.android.AndroidMetaInf.getAndroid;

public class AndroidImporter {

    public static Data7 generateAndroidProject(ResourcesPath path, Data7UpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {
        Project project = new Project(AndroidMetaInf.ANDROID_NVD, getAndroid());
        Data7Importer data7Importer = new Data7Importer(path, project, listeners);
        data7Importer.addSource(new AndroidSource());
        return data7Importer.updateOrCreateDataset();
    }

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        if (args.length == 1) {
            ResourcesPath rpath = new ResourcesPath(args[0]);
            Data7 data7 = generateAndroidProject(rpath);
            Exporter exporter = new Exporter(rpath);
            exporter.exportDatasetToXML(data7);
        }
    }
}
