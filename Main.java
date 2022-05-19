package Cesar;

public class Main {
        public static void main(String[] args) {
                String text = "ATTACKATONCE";
                File sample = new File();

                text = sample.readFile("path");

                int s = 3;
                System.out.println("Text  : " + text);
                System.out.println("Shift : " + s);
                System.out.println("Cipher: " + CesarCode.enCrypt(text, s));

                System.out.println("characters list");
                Key key = new Key();

                for (Character element : key.characters) {
                        System.out.print(element + " ");
                }
        }
}
