
// package tictactoe;
import java.util.Scanner;

public class TicTacToe extends GameBoard {
	public static final int ROWS = 3;
	public static final int COLS = 3;
	private GameBoard board;
	private static Scanner in = new Scanner(System.in);

int currRow, currCol = 0;


	public TicTacToe() {
	    board = new GameBoard(ROWS,COLS);
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		board.initBoard();
		board.drawBoard();
		playerInput();
		board.drawBoard();

	}

	/* unfinished, hardcoded to find cell position. fix later! */

	public void playerInput() {
		// int currRow, currCol = 0;
		System.out.println("Where to? ");
		int input = in.nextInt();
		switch (input) {
			case 1: currRow = 0; currCol=0; break;
			case 2: currRow = 0; currCol=1; break;
			case 3: currRow = 0; currCol=2; break;
			case 4: currRow = 1; currCol=0; break;
			case 5: currRow = 1; currCol=1; break;
			case 6: currRow = 1; currCol=2; break;
			case 7: currRow = 2; currCol=0; break;
			case 8: currRow = 2; currCol=1; break; 
			case 9: currRow = 2; currCol=2; break;
		}
		board.cells[currRow][currCol].content = Marker.CROSS;
		// board.col = currCol;
		// currCol = (input - COLS) % COLS;
		// System.out.println(currCol);

	}
	public static void main (String[] args) {
		TicTacToe ttt = new TicTacToe();
	}

}