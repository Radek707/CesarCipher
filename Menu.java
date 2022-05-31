package Cesar;

import java.util.ArrayList;
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
    ArrayList<String> mainMenu = new ArrayList<>();
    ArrayList<String> submenu1 = new ArrayList<>();


    public static int menu() {
        int userChoice = 0;
        Scanner scanner = new Scanner(System.in);

        printMenu();
        userChoice = scanner.nextInt();

        scanner.close();
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

    public static String askForFileName() {
        String fileName = null;

        System.out.println("Enter file name");
        Scanner scanner = new Scanner(System.in);

        fileName = scanner.nextLine();

        scanner.close();
        return fileName;
    }

    public static int askForShift() {
        System.out.println("Enter a value for shifting the alphabet");
        int shift = 0;

        Scanner scanner = new Scanner(System.in);
        shift = scanner.nextInt();

        return shift;
    }
}
