package data7.plugins.android;

import data7.Data7UpdateListener;
import data7.ResourcesPath;
import data7.importer.Data7Importer;
import data7.model.Data7;
import data7.project.Project;
import data7.project.ProjectFactory;

import java.io.IOException;
import java.text.ParseException;

public class AndroidImporter {

    public static Data7 generateGenericProject(String path, String projectName, Data7UpdateListener... listeners) throws ParseException, IOException, ClassNotFoundException {

        ResourcesPath rpath = new ResourcesPath("path");
        Project project = ProjectFactory.retrieveProjectInfo(projectName);
        Data7Importer data7Importer = new Data7Importer(rpath, project, listeners);
        data7Importer.addSource(new AndroidSource());
        return data7Importer.updateOrCreateDataset();
    }
}
