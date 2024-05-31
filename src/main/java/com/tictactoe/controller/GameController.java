package com.tictactoe.controller;

import com.tictactoe.model.Board;
import com.tictactoe.model.AIPlayer;
import com.tictactoe.view.ConsoleView;

public class GameController {
    private Board board;
    private ConsoleView view;
    private AIPlayer aiPlayer;

    public GameController(Board board, ConsoleView view, AIPlayer aiPlayer) {
        this.board = board;
        this.view = view;
        this.aiPlayer = aiPlayer;
    }

    public void startGame(boolean aiEnabled) {
        while (true) {
            view.displayBoard(board);
            int[] move;

            if (aiEnabled && board.getCurrentPlayer() == aiPlayer.getMarker()) {
                move = aiPlayer.getMove(board);
                System.out.println("AI placed at: " + move[0] + " " + move[1]);
            } else {
                move = view.getMove();
                if (!board.placeMark(move[0], move[1])) {
                    System.out.println("This move is not valid");
                    continue;
                }
            }

            if (board.isWinner()) {
                view.displayBoard(board);
                view.displayWinner(board.getCurrentPlayer());
                break;
            }

            if (board.isBoardFull()) {
                view.displayBoard(board);
                view.displayDraw();
                break;
            }

            board.changePlayer();
        }
    }
}
