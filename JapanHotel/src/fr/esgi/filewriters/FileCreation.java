package fr.esgi.filewriters;

import java.io.File;
import java.io.IOException;

public class FileCreation {

    public static void checkFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            createFile(path);
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
