package Cesar;

public class Main {
        public static void main(String[] args) {
                CesarCode cesarCode = new CesarCode();

                FileOperations sample = new FileOperations();
                //String text = sample.readFile("test.txt");
                String text = "sample";

                String encrypted = String.valueOf(cesarCode.enCrypt(text, 10));
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

                FileOperations output = new FileOperations();
                output.writeToFile(encrypted, "encryptedtext");

                System.out.println("Text  : " + textToDecrypt);
                String decrypted = cesarCode.deCrypt(textToDecrypt, 10);
                System.out.println("Shift : " + cesarCode.shift);
                System.out.println("Decrypted : " + decrypted);
        }
}
