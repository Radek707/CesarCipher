package Cesar;

import Cesar.Cryptography.CesarCode;
import Cesar.Language.Helper;
import Cesar.Language.Language;

public class Main {
    public static void main(String[] args) {
        FileOperations file = new FileOperations();
        String pathToRead = null;
        String pathToWrite = null;
        Helper charactersList = new Helper();
        Language eng = new Language();
        CesarCode cesarCode = new CesarCode(charactersList, eng);
        String textInput = null;
        String textOutput = null;
        String userInput = null;

        Menu.printWelcomeMessage();

        boolean work = true;

        while (work == true) {
            Menu.printMenu();
            int userChoice = Menu.askForIntegerInput();
            int shift = 0;
            pathToRead = null;
            textInput = null;
            textOutput = null;

            switch (userChoice) {
                case 1: //ask for file to encrypt

                    while (pathToRead == null) {
                        System.out.println("Enter file name for encryption");
                        pathToRead = Menu.askUserForStringInput();
                        //read file
                        textInput = file.readFile(pathToRead);
                    }

                    if (textInput == null) {
                        System.out.println("Try again");
                        pathToRead = null;
                        break;
                    }

                    System.out.println("File content is : ");
                    System.out.println(textInput);

                    //enrypt
                    System.out.println();

                    encrypt(textInput, cesarCode);

                    //write to file
                    Menu.writeTextToFileMenu(textOutput, file);
                    break;
                case 2: //ask for file to decrypt
                    System.out.println("Enter file name to decrypt");
                    pathToRead = Menu.askUserForStringInput();
                    //decrypt
                    textInput = file.readFile(pathToRead);
                    System.out.println("Enter a value of shift to decrypt");
                    shift = Menu.askForIntegerInput();
                    textOutput = cesarCode.deCrypt(textInput, shift);
                    System.out.println("Decrypted text is: ");
                    System.out.println(textOutput);

                    //write to file
                    Menu.writeTextToFileMenu(textOutput, file);
                    break;
                case 3: //Brute force the code
                    System.out.println("Under development.");
//                                        pathToRead = Menu.askUserForStringInput();
//                                        textInput = file.readFile(pathToRead);
//                                        textOutput = cesarCode.bruteCrack(textInput);
//                                        pathToWrite = Menu.askUserForStringInput();
//                                        file.writeToFile(textInput, pathToWrite);
                    break;
                case 4: //Statistic analise
                    System.out.println("Under development.");
//                                        pathToRead = Menu.askUserForStringInput();
//                                        textInput = file.readFile(pathToRead);
//                                        System.out.println("Provide a file with sample text");
//                                        pathToRead = Menu.askUserForStringInput();
//                                        String sampleText = file.readFile(pathToRead);
//                                        textOutput = cesarCode.statisticCrackWithSampleText(textInput, sampleText);
//                                        pathToWrite = Menu.askUserForStringInput();
                    break;
                case 5: //exit program
                    work = false;
                    Menu.printEndMessage();
                    break;
                default:
                    System.out.println("Enter a proper choice.");
            }
        }
    }

    private static void encrypt(String textInput, CesarCode cesarCode) {
        int shift = 0;
        while (shift <= 0 || shift > cesarCode.sizeOfKey) {
            System.out.println("Enter a value to shift the alphabet");
            shift = Menu.askForIntegerInput();
        }

        String textOutput = cesarCode.enCrypt(textInput, shift);
        System.out.println("This is encrypted text: ");
        System.out.println(textOutput);
    }
}
