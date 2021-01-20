package com.hillel.artemjev.filesearcher;


import java.io.File;
import java.io.FileNotFoundException;


public class Searcher {
    public File findAbsoluteFile(File dir, String fileName) {
        checkDirectoryForSearching(dir);

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                File fileFound = findAbsoluteFile(file, fileName);
                if (fileFound != null) {
                    return fileFound;
                }
            } else {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

    //-----------------------------------------------------
    // думаю, не стоит разделять эту проверку на 2 метода.
    private void checkDirectoryForSearching(File dir) {
        if (!dir.exists()) {
            try {
                throw new FileNotFoundException("There is no such directory: " + dir.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!dir.isDirectory()) {
            try {
                throw new FileNotFoundException("directory for searching \"" + dir.getAbsolutePath() + "\" is a file.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
