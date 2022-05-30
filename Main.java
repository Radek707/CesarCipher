package Cesar;

import Cesar.Cryptography.CesarCode;
import Cesar.Cryptography.Helper;
import Cesar.Language.Language;
import Cesar.TextOperations.Text;

import java.util.Map;
import java.util.TreeMap;

public class Main {
        public static void main(String[] args) {
                String directoryForFiles = "Files/";
                String pathToRead = directoryForFiles + "test2.txt";
                String pathToWrite = directoryForFiles + "encryptedtext.txt";
                Helper key = new Helper();
                Language eng = new Language();

                CesarCode cesarCode = new CesarCode(key, eng);

                FileOperations sample = new FileOperations();
                String text = sample.readFile(pathToRead);

                sample.writeToFile(cesarCode.enCrypt(text, 42), pathToWrite);

                pathToRead = directoryForFiles + "encryptedtext.txt";
                String enCryptedText = sample.readFile(pathToRead);


                System.out.println("Shif used in enCrytion: " + cesarCode.shift);
                System.out.println("Available characters count: " + key.characters.size());
                System.out.println("Available characters: ");
                System.out.println(cesarCode.key.characters);

                pathToRead = directoryForFiles + "encryptedtext.txt";

//                Map<Character, Double> lettersFrequenciesInText = new TreeMap<>();
//                lettersFrequenciesInText = Text.findLettersFrequencyInText(enCryptedText);

//                double sumOfFrequencies = 0;
//
//                for (Map.Entry<Character, Double> pair : lettersFrequenciesInText.entrySet()) {
//                        System.out.println("Character: " + pair.getKey() + " frequency: " + pair.getValue() * 100);
//                        sumOfFrequencies += pair.getValue();
//                }
//
//
//                System.out.println("sum of all frequencies = " + sumOfFrequencies);
//
                pathToRead = directoryForFiles + "sample.txt";
                String sampleText = sample.readFile(pathToRead);
                Map<Character, Double> lettersFrequenciesInSampleText = new TreeMap<>();
                lettersFrequenciesInSampleText = Text.findLettersFrequencyInText(sampleText);

                String crackedCodeResult = cesarCode.statisticCrackWithSampleText(enCryptedText, sampleText);
                System.out.println("This is a result of frequency attack based on sample text: \n" +
                        crackedCodeResult);

//
//                double sumOfFrequencies2 = 0;
//
//                for (Map.Entry<Character, Double> pair : lettersFrequenciesInSampleText.entrySet()) {
//                        System.out.println("Character: " + pair.getKey() + " frequency: " + pair.getValue() * 100);
//                        sumOfFrequencies2 += pair.getValue();
//                }
//                System.out.println();
//                System.out.println("sum of all frequencies = " + sumOfFrequencies2);

//                System.out.println("Brute force result: ");
//                System.out.println(cesarCode.bruteCrack(sample.readFile("encryptedtext.txt")));
//
//                //System.out.println(cesarCode.deCrypt(sample.readFile("encryptedtext.txt"), 1));
//
////                System.out.println("text1");
////                System.out.println(cesarCode.findLettersFrequencyInText(text).toString());
////
////                System.out.println("text1 enCrypted");
////                String text1EnCrypted = cesarCode.enCrypt(text, 1);
////                System.out.println(cesarCode.findLettersFrequencyInText(text1EnCrypted).toString());
////
//
////                System.out.println("text2");
////                text = sample.readFile("encryptedtext.txt");
////                System.out.println(cesarCode.findLettersFrequencyInText(text).toString());
//
////                String encrypted = String.valueOf(cesarCode.enCrypt(text, 10));
////                System.out.println("Text  : " + text);
////                System.out.println("Shift : " + cesarCode.shift);
////                System.out.println("Cipher: " + encrypted);
////
////
////                FileOperations output = new FileOperations();
////                output.writeToFile(encrypted, "encryptedtext");
////
//
//                System.out.println("Decryption test: ");
//                String textToDecrypt = sample.readFile("encryptedtext.txt");
//
//                System.out.println("Text to decrypt : " + textToDecrypt);
//                String decrypted = cesarCode.deCrypt(textToDecrypt, cesarCode.shift);
//                System.out.println("Shift : " + cesarCode.shift);
//                System.out.println("Decrypted text: " + decrypted);
        }
}
