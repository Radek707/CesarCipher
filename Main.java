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
        String sampleText = null;

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
                    textOutput = encrypt(textInput, cesarCode);
                    //write to file
                    Menu.printWriteFileMenu();
                    userInput = Menu.askUserForStringInput();

                    if (userInput.toLowerCase().equals("yes")) {
                        System.out.println("Enter a file name to save");
                        pathToWrite = Menu.askUserForStringInput();
                        if (!file.writeToFile(textOutput, pathToWrite)) {
                            System.out.println("Try again");
                        } else System.out.println("File " + pathToWrite + " saved.");
                    }
                    break;
                case 2: //ask for file to decrypt
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
                    //decrypt
                    textInput = file.readFile(pathToRead);
                    System.out.println("Enter a value of shift to decrypt");
                    shift = Menu.askForIntegerInput();
                    textOutput = cesarCode.deCrypt(textInput, shift);
                    System.out.println("Decrypted text is: ");
                    System.out.println(textOutput);
                    //write to file
                    Menu.printWriteFileMenu();
                    userInput = Menu.askUserForStringInput();

                    if (userInput.toLowerCase().equals("yes")) {
                        System.out.println("Enter a file name to save");
                        pathToWrite = Menu.askUserForStringInput();
                        if (!file.writeToFile(textOutput, pathToWrite)) {
                            System.out.println("Try again");
                        } else System.out.println("File " + pathToWrite + " saved.");
                    }
                    break;
                case 3: //Brute force the code
                    //ask for file with code to brake
                    while (pathToRead == null) {
                        System.out.println("Enter a file name");
                        pathToRead = Menu.askUserForStringInput();
                        //read file
                        textInput = file.readFile(pathToRead);
                    }

                    if (textInput == null) {
                        System.out.println("Try again");
                        break;
                    }
                    //breke the code
                    textOutput = cesarCode.bruteCrack(textInput);
                    System.out.println("Result of brute force is: ");
                    System.out.println(textOutput);
                    //write to file
                    Menu.printWriteFileMenu();
                    userInput = Menu.askUserForStringInput();

                    if (userInput.toLowerCase().equals("yes")) {
                        System.out.println("Enter a file name to save");
                        pathToWrite = Menu.askUserForStringInput();
                        if (!file.writeToFile(textOutput, pathToWrite)) {
                            System.out.println("Try again");
                        } else System.out.println("File " + pathToWrite + " saved.");
                    }
                    break;
                case 4: //Statistic analise
                    //ask for file with code to brake
                    while (pathToRead == null) {
                        System.out.println("Enter a file name with code to brake");
                        pathToRead = Menu.askUserForStringInput();
                        //read file
                        textInput = file.readFile(pathToRead);
                    }

                    if (textInput == null) {
                        System.out.println("Try again");
                        break;
                    }
                    //ask for file with sample text
                    pathToRead = null;
                    while (pathToRead == null) {
                        System.out.println("Enter a file name with sample text");
                        pathToRead = Menu.askUserForStringInput();
                        //read file
                        sampleText = file.readFile(pathToRead);
                    }

                    if (sampleText == null) {
                        System.out.println("Try again");
                        break;
                    }
                    //brake the code
                    textOutput = cesarCode.statisticCrackWithSampleText(textInput, sampleText);
                    System.out.println("Result of statistic analise is: ");
                    System.out.println(textOutput);
                    //write to file
                    Menu.printWriteFileMenu();
                    userInput = Menu.askUserForStringInput();

                    if (userInput.toLowerCase().equals("yes")) {
                        System.out.println("Enter a file name to save");
                        pathToWrite = Menu.askUserForStringInput();
                        if (!file.writeToFile(textOutput, pathToWrite)) {
                            System.out.println("Try again");
                        } else System.out.println("File " + pathToWrite + " saved.");
                    }
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

    private static String encrypt(String textInput, CesarCode cesarCode) {
        int shift = 0;
        while (shift <= 0 || shift > cesarCode.sizeOfKey) {
            System.out.println("Enter a value to shift the alphabet");
            shift = Menu.askForIntegerInput();
        }

        String textOutput = cesarCode.enCrypt(textInput, shift);
        System.out.println("This is encrypted text: ");
        System.out.println(textOutput);
        return textOutput;
    }
}
