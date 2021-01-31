package fr.esgi.filewriters;

import java.io.File;

public class DirectoryCreation {

    public static void checkDirectory(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            createDirectory(path);
        }
    }

    private static void createDirectory(String path) {
        File directory = new File(path);
        directory.mkdir();
    }

}
