// package com.tictactoe.view;

// import com.tictactoe.model.Board;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class GUIView extends JFrame implements ViewInterface {
//     private JButton[] buttons;
//     private Board board;

//     public GUIView() {
//         this.board = new Board();
//         setTitle("Tic Tac Toe");
//         setSize(300, 300);
//         setLayout(new GridLayout(3, 3));
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         buttons = new JButton[9];

//         for (int i = 0; i < 9; i++) {
//             buttons[i] = new JButton("");
//             final int index = i;
//             buttons[i].addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     handleButtonClick(index);
//                 }
//             });
//             add(buttons[i]);
//         }

//         setVisible(true);
//     }

//     private void handleButtonClick(int index) {
//         if (board.getCell(index) == ' ') {
//             board.makeMove(index);
//             buttons[index].setText(String.valueOf(board.getCurrentPlayer()));
//             board.changePlayer();
//             if (board.checkWin()) {
//                 JOptionPane.showMessageDialog(this, "Player " + board.getCurrentPlayer() + " wins!");
//                 resetBoard();
//             } else if (board.isFull()) {
//                 JOptionPane.showMessageDialog(this, "It's a draw!");
//                 resetBoard();
//             }
//         }
//     }

//     private void resetBoard() {
//         board.reset();
//         for (JButton button : buttons) {
//             button.setText("");
//         }
//     }

//     @Override
//     public void displayBoard(Board board) {
//         // GUI view updates the board directly on button clicks.
//     }

//     @Override
//     public void displayMessage(String message) {
//         JOptionPane.showMessageDialog(this, message);
//     }

//     @Override
//     public int getPlayerMove(Board board) {
//         // No implementation needed for GUI as moves are handled by button clicks.
//         return 0;
//     }
// }