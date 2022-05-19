package Cesar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
    // read and write operations on file, for now only sample string

    static String readFile(String path) {
        File file = new File(path);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with reading the file");
        }
        return null;
    }

    static void writeToFile(String text) {
        System.out.println("Encrytpted sample text: " + text);
    }
}
