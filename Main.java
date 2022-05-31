package Cesar;

import Cesar.Cryptography.CesarCode;
import Cesar.Language.Helper;
import Cesar.Language.Language;

public class Main {
        public static void main(String[] args) {
                Menu menu = new Menu();
                FileOperations file = new FileOperations();
                String pathToRead = null;
                String pathToWrite = null;
                Helper charactersList = new Helper();
                Language eng = new Language();
                CesarCode cesarCode = new CesarCode(charactersList, eng);
                String textInput = null;
                String textOutput = null;

                Menu.printWelcomeMessage();

                boolean work = true;

                while (work == true) {
                        int userChoice = Menu.menu();
                        int shift = 0;

                        switch (userChoice) {
                                case 1: //ask for file to encrypt
                                        pathToRead = Menu.askForFileName();
                                        //read file
                                        textInput = file.readFile(pathToRead);
                                        //enrypt
                                        shift = Menu.askForShift();
                                        textOutput = cesarCode.enCrypt(textInput, shift);
                                        //write to file
                                        pathToWrite = Menu.askForFileName();
                                        file.writeToFile(textOutput, pathToWrite);
                                        break;
                                case 2: //ask for file to decrypt
                                        pathToRead = Menu.askForFileName();
                                        //decrypt
                                        textInput = file.readFile(pathToRead);
                                        shift = Menu.askForShift();
                                        textOutput = cesarCode.deCrypt(textInput, shift);
                                        //write to file
                                        pathToWrite = Menu.askForFileName();
                                        file.writeToFile(textOutput, pathToWrite);
                                        break;
                                case 3: //Brute force the code
                                        pathToRead = Menu.askForFileName();
                                        textInput = file.readFile(pathToRead);
                                        textOutput = cesarCode.bruteCrack(textInput);
                                        pathToWrite = Menu.askForFileName();
                                        file.writeToFile(textInput, pathToWrite);
                                        break;
                                case 4: //Statistic analise
                                        pathToRead = Menu.askForFileName();
                                        textInput = file.readFile(pathToRead);
                                        System.out.println("Provide a file with sample text");
                                        pathToRead = Menu.askForFileName();
                                        String sampleText = file.readFile(pathToRead);
                                        textOutput = cesarCode.statisticCrackWithSampleText(textInput, sampleText);
                                        pathToWrite = Menu.askForFileName();
                                        break;
                                case 5: //exit program
                                        work = false;
                                        Menu.printEndMessage();
                                        break;
                        }
                }
        }
}
