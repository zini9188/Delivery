package app;

import java.util.Scanner;

public class Reader {
    private static Scanner scanner = new Scanner(System.in);

    public static int readMenu() {
        try {
            System.out.print(">>> ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return readMenu();
        }
    }

    public static String readName() {
        System.out.print(">>> ");
        return scanner.nextLine();
    }

    public static int readPrice() {
        try {
            System.out.print(">>> ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return readPrice();
        }
    }
}
