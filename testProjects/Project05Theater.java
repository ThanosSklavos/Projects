package gr.aueb.cf.projects.testProjects;

import java.util.Scanner;

public class Project05Theater {

    static Scanner in = new Scanner(System.in);
    static boolean[][] theater = new boolean[30][12];

    public static void main(String[] args) {
        boolean quit = false;
        String choice;

        do {
            printMenu();
            choice = getChoice();
            if (choice.matches("[Qq]")) {
                System.out.println("Thank you for using theater seat management system");
                quit = true;
            }
            else {
                try {
                    handleChoiceController(choice);
                }catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    System.out.println("Please choose option 1 or 2.");
                }

            }
        }while (!quit);
    }

    public static void printMenu() {

        for (boolean[] array : theater) {
            for (boolean seat : array) {
                if (seat) {
                    System.out.print("| O ");
                }else System.out.print("| X ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Welcome to theater seat management system. Choose");
        System.out.println("1 to Book a seat.");
        System.out.println("2 to Cancel a booked seat.");
        System.out.println("Qq to quit.");
        System.out.println();

    }

    public static String getChoice() {
        System.out.println("Choose an option: ");
        return in.nextLine().trim();
    }

    public static void  handleChoiceController(String ch) throws IllegalArgumentException {
        int choice = Integer.parseInt(ch);
        int row;
        int column;

        if ((choice <= 0) || (choice >= 3)) {
            throw new IllegalArgumentException();
        }
        switch (choice) {
            case 1:
                row = getRow();
                column = getColumn();
                book(row, column);
                break;
            case 2:
                row = getRow();
                column = getColumn();
                cancel(row, column);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void book(int row, int column) {
        if (theater[row][column]) {
            System.out.println("Seat already booked");
        }else {
            theater[row][column] = true;

        }
    }

    public static void cancel(int row, int column) {
        if (!theater[row][column]) {
            System.out.println("Seat is not booked");

        }else {
            theater[row][column] = false;
            System.out.println("Seat canceled");
        }
    }

    public static int getRow() {
        int row;

        while (true){
            System.out.println("Please insert the number of row between 1 and: " + theater.length);
            if (in.hasNextInt()) {
                row = in.nextInt();
                if ((row <= theater.length) && (row >= 1)) {
                    in.nextLine();
                    return row - 1;
                }
            }
            in.nextLine();
        }
    }

    public static int getColumn() {
        String token;
        char column;
        int col;
        int cnt = 0;

        while (true) {
            System.out.println("Please insert the letter (A-L) of column:");

            token = in.nextLine();
            if (token.length() > 1) continue;

            token = token.trim();
            token = token.toUpperCase();
            column = token.charAt(0);
            col = (int) column;

            if ((col >= 65) && (col <= 76)) {
                for (int i = 65; i <= 76; i++) {
                    if (col == i) col = cnt;
                    cnt++;
                }
                return col;
            }
        }
    }
}
