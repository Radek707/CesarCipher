package Cesar;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
User menu
<<<<<<< HEAD
1. Encrypt
2. Decrypt text
3. Brute force
4. Statistic analise
5. Exit
=======
>>>>>>> origin/main
 */
public class Menu {

    public static String askUserForStringInput() {
        String userChoice;

        Scanner scanner = new Scanner(System.in);

        userChoice = scanner.nextLine();

        return userChoice;
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Cesar Cipher testing field!");
    }

    static void printEndMessage() {
        System.out.println("Thank you for using Cesar Cipher testing field!");
    }

    static void printMenu() {
        System.out.println("Choose option: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Break the code using brute force");
        System.out.println("4. Break the code using statistic analise");
        System.out.println("5. Exit");
    }

    public static void printEncryptSubMenu() {
        System.out.println("Enter file name to encrypt");
    }

    public static int askForIntegerInput() {
        int input = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("It was not an integer value");
        }

        return input;
    }

    public static void printWriteFileMenu() {
        System.out.println("Do you want to write text into a file?");
        System.out.println("Enter: Yes or No");
    }
}
