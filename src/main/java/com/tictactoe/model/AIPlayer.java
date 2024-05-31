package com.tictactoe.model;

import java.util.Random;

public class AIPlayer {
    private char marker;
    private Random random;

    public AIPlayer(char marker) {
        this.marker = marker;
        this.random = new Random();
    }

    public int[] getMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.placeMark(row, col));
        return new int[] {row, col};
    }

    public char getMarker() {
        return marker;
    }
}
