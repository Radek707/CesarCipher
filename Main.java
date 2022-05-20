package Cesar;

public class Main {
        public static void main(String[] args) {
                CesarCode cesarCode = new CesarCode();

                FileOperations sample = new FileOperations();
                String text = sample.readFile("test.txt");

                String encrypted = String.valueOf(cesarCode.enCrypt(text, 3));
                System.out.println("Text  : " + text);
                System.out.println("Shift : " + cesarCode.shift);
                System.out.println("Cipher: " + encrypted);

                System.out.println("characters list");
                Helper key = new Helper();

                for (Character element : key.characters) {
                        System.out.print(element + " ");
                }

                System.out.println();

                String textToDecrypt = encrypted;

                System.out.println("Text  : " + textToDecrypt);
                System.out.println("Shift : " + cesarCode.shift);
                System.out.println("Decrypted : " + cesarCode.deCrypt(textToDecrypt, 3));
        }
}
