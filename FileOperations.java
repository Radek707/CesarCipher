package Cesar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
    // read and write operations on file, for now only sample string

    static String readFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Something went wrong with reading the file");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    static void writeToFile(String text) {
        System.out.println("Encrytpted sample text: " + text);
    }
}
