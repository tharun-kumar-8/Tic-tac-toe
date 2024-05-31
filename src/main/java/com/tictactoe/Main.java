package com.tictactoe;

import com.tictactoe.model.Board;
import com.tictactoe.model.AIPlayer;
import com.tictactoe.view.ConsoleView;
import com.tictactoe.controller.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        ConsoleView view = new ConsoleView();
        AIPlayer aiPlayer = new AIPlayer('O'); // AI plays as 'O'

        GameController controller = new GameController(board, view, aiPlayer);

        Scanner scanner = new Scanner(System.in);
        boolean aiEnabled = false;
        while (true) {
            System.out.println("Do you want to play against AI? (yes/no)");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                aiEnabled = true;
                break;
            } else if (input.equals("no") || input.equals("n")) {
                aiEnabled = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        controller.startGame(aiEnabled);
    }
}
