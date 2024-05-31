package com.tictactoe.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AIPlayerTest {
    private Board board;
    private AIPlayer aiPlayer;

    @BeforeEach
    public void setUp() {
        board = new Board();
        aiPlayer = new AIPlayer('O');
    }

    @Test
    public void testAIMakesValidMove() {
        int[] move = aiPlayer.getMove(board);
        assertTrue(move[0] >= 0 && move[0] < 3);
        assertTrue(move[1] >= 0 && move[1] < 3);
        assertEquals('O', board.getBoard()[move[0]][move[1]]);
    }
}
