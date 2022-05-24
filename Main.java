package Cesar;

public class Main {
        public static void main(String[] args) {
                CesarCode cesarCode = new CesarCode();

                FileOperations sample = new FileOperations();
                String text = sample.readFile("test.txt");
// testing mothods for counting frequncy of letters on two different file
// TODO find out how to compare frequencies to crack cipher
                System.out.println("text1");
                System.out.println(cesarCode.findLettersFrequencyInText(text).toString());

                System.out.println("text1 enCrypted");
                String text1EnCrypted = cesarCode.enCrypt(text, 1);
                System.out.println(cesarCode.findLettersFrequencyInText(text1EnCrypted).toString());

                System.out.println("text2");
                text = sample.readFile("sample.txt");
                System.out.println(cesarCode.findLettersFrequencyInText(text).toString());

//                String encrypted = String.valueOf(cesarCode.enCrypt(text, 10));
//                System.out.println("Text  : " + text);
//                System.out.println("Shift : " + cesarCode.shift);
//                System.out.println("Cipher: " + encrypted);
//
//
//                FileOperations output = new FileOperations();
//                output.writeToFile(encrypted, "encryptedtext");
//
//                String textToDecrypt = sample.readFile("encryptedtext.txt");
//
//                System.out.println("Text  : " + textToDecrypt);
//                String decrypted = cesarCode.deCrypt(textToDecrypt, 10);
//                System.out.println("Shift : " + cesarCode.shift);
//                System.out.println("Decrypted : " + decrypted);
        }
}
