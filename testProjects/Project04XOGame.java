package gr.aueb.cf.projects.testProjects;

import java.util.Scanner;

public class Project04XOGame {

    static Scanner in = new Scanner(System.in);
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    public static void main(String[] args) {
        boolean game = true;

        while (game) {
            printBoard();
            game = play();
        }
    }

    public static boolean play() {
        int row;
        int col;
        int player = 2;

        while (true) {
           if (player == 2) {
               player = 1;
           } else player = 2;

           System.out.println("Its Player's " + player + " turn!");

           System.out.println("Please choose a row: ");
           row = getChoice();
           System.out.println("Please choose a column: ");
           col = getChoice();

           while (board[row][col] != ' ') {
               System.out.println("Please choose an empty block: ");
               System.out.println("Please choose a row: ");
               row = getChoice();
               System.out.println("Please choose a column: ");
               col = getChoice();
           }

           board[row][col] = (player == 1) ? 'O' : 'X';
           printBoard();


           if (checkForWinner()) {
               System.out.println("Player " + player + " won!");
               return playAgain();
           } else if (boardIsFull()) {                          // check for draw
               System.out.println("Its a Draw!");
               return playAgain();
           }
        }
    }

    public static void  printBoard(){
        System.out.println("  +---+---+---+");
        System.out.println(2 +  " | " + board[2][0] +  " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println(1 +  " | " + board[1][0] +  " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println(0 +  " | " + board[0][0] +  " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("    0   1   2  ");
    }

    public static int getChoice() {
        int choice;

        while (true) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if ((choice >= 0) && (choice <= 2)) {
                    return choice;
                } else System.out.println("Please enter a number between 0 and 2: ");
            } else {
                System.out.println("Please enter an integer: ");
                in.nextLine();
            }
        }
    }

    public static boolean checkForWinner() {
         return (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] != ' ') ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != ' ') ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != ' ') ||

                (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != ' ') ||
                (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != ' ') ||

                (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != ' ') ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] != ' ') ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] != ' ');
    }

    public static boolean boardIsFull() {
        int emptyBlocks = 0;

        for (char[] chars : board) {
            for (char ch : chars) {
                if (ch == ' ') emptyBlocks++;
            }
        }
        return emptyBlocks == 0;
    }

    public static boolean playAgain() {
        System.out.println("Play again? y/n");
        while (true) {
            String choice = in.nextLine();
            if (choice.matches("[yY]")) {

                for (int i = 0; i < board.length; i++) {          //reset board
                    for (int j = 0; j < board[i].length; j++) {
                        board[i][j] = ' ';
                    }
                }
                return true;
            } else {
                if (choice.matches("[nN]")) {
                    System.out.println("Thank you for playing! Bye");
                    return false;
                }
            }
        }

    }
}
