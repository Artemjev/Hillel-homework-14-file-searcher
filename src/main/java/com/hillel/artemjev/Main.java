package com.hillel.artemjev;

import com.hillel.artemjev.filesearcher.Searcher;

import java.io.File;
import java.io.IOException;

// !!!Класс Main исключительно для проверки работы метода!!!.
public class Main {
    public static void main(String[] args) {
//        String dirPath = "./target1";
//        String dirPath = "./Hillel-homework-14-file-searcher.iml";
//        String dirPath = "./target";

        String dirPath = ".";
//        String fileName ="Hillel-homework-14-file-searcher.iml";
//        String fileName = "inputFiles.lst";
//        String fileName = ".gitignore";
//        String fileName = "Main.java-";
        String fileName = "Main.java";

        File file = new Searcher().findAbsoluteFile(new File(dirPath), fileName);

        if (file != null) {
            try {
                System.out.printf("Found file: path = %s , name = %s\n", file.getCanonicalPath(), file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file not found");
        }
    }
}
