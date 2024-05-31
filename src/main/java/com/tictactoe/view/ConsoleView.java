package com.tictactoe.view;

import com.tictactoe.model.Board;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    
    public ConsoleView() {
        scanner = new Scanner(System.in);
    }
    
    // Display the board
    public void displayBoard(Board board) {
        board.printBoard();
    }

    // Get user input for row and column
    public int[] getMove() {
        System.out.print("Enter row and column (0, 1, or 2) separated by space: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[] {row, col};
    }

    // Display the winner
    public void displayWinner(char player) {
        System.out.println("Player " + player + " wins!");
    }

    // Display a draw message
    public void displayDraw() {
        System.out.println("The game is a draw!");
    }
}
