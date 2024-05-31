package com.tictactoe.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitialBoardIsEmpty() {
        char[][] expected = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };
        assertArrayEquals(expected, board.getBoard());
    }

    @Test
    public void testPlaceMark() {
        assertTrue(board.placeMark(0, 0));
        assertFalse(board.placeMark(0, 0));
    }

    @Test
    public void testChangePlayer() {
        char current = board.getCurrentPlayer();
        board.changePlayer();
        assertNotEquals(current, board.getCurrentPlayer());
    }

    @Test
    public void testIsBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.placeMark(i, j);
                board.changePlayer();
            }
        }
        assertTrue(board.isBoardFull());
    }

    @Test
    public void testIsWinner() {
        board.placeMark(0, 0); // X
        board.placeMark(1, 0); // O
        board.placeMark(0, 1); // X
        board.placeMark(1, 1); // O
        board.placeMark(0, 2); // X wins

        assertTrue(board.isWinner());
    }

    @Test
    public void testNoWinner() {
        board.placeMark(0, 0); // X
        board.placeMark(0, 1); // O
        board.placeMark(0, 2); // X
        board.placeMark(1, 0); // O
        board.placeMark(1, 1); // X
        board.placeMark(1, 2); // O
        board.placeMark(2, 0); // X
        board.placeMark(2, 1); // O
        board.placeMark(2, 2); // X

        assertFalse(board.isWinner());
    }

    @Test
    public void testGetBoard() {
        char[][] expected = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };
        assertArrayEquals(expected, board.getBoard());
    }
}
