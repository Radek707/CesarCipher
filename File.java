package Cesar;

public class File {
    // read and write operations on file, for now only sample string
    String readFile(String path) {
        return "Sample text digits 1234567890 and special marks *|#@ end of text";
    }

    void writeToFile(String text) {
        System.out.println("Encrytpted sample text: " + text);
    }
}
