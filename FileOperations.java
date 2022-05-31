package Cesar;

import java.io.*;

public class FileOperations {
    // read and write operations on file, for now only sample string
    String mainDirectory = "Files/";

    public String readFile(String path) {
        path = mainDirectory + path;
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
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                return null;
            }
        }
    }

    public boolean writeToFile(String text, String path) {
        path = mainDirectory + path;
        File file = new File(path);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Something went wrong with file writing");
        } finally {
            try {
                writer.close();
                return true;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}

