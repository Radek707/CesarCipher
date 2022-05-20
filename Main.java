package Cesar;

public class Main {
        public static void main(String[] args) {
                String text = "ATTACKATONCE";
                FileOperations sample = new FileOperations();

                text = sample.readFile("test.txt");

                int s = 3;

                String encrypted = String.valueOf(CesarCode.enCrypt(text, s));
                System.out.println("Text  : " + text);
                System.out.println("Shift : " + s);
                System.out.println("Cipher: " + encrypted);

                System.out.println("characters list");
                Helper key = new Helper();

                for (Character element : key.characters) {
                        System.out.print(element + " ");
                }

                System.out.println();

                String textToDecrypt = encrypted;

                System.out.println("Text  : " + textToDecrypt);
                System.out.println("Shift : " + s);
                System.out.println("Decrypted : " + CesarCode.deCrypt(textToDecrypt, s));
        }
}
