

import java.util.Scanner;

public class TicTacToe extends GameBoard{


	// public char[][] board;

	public TicTacToe() {
		GameBoard board = new GameBoard();
		// board = new char[ROWS][COLS];
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		// setBoard();
		// printBoard();
	}

	// public void setBoard() {
	// 	for(int row=0; i< ROWS;i++) {
	// 		for (int col= 0; j < COL; j++){
	// 			board[row][col] = ' ';
	// 		}
	// 	}

	// }

	// public void printBoard() {
	// 	System.out.println("-------------");
	// 	for (int i = 0; i < 3; i++) {
	// 		System.out.print("| ");
	// 		for (int j = 0; j < 3; j++) {
 //                System.out.print(board[i][j] + " | ");
 //            }
 //            System.out.println();
 //            System.out.println("-------------");
 //        }
	// }

	public static void main (String[] args) {
		TicTacToe ttt = new TicTacToe();
	}
}