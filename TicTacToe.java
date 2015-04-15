
// package tictactoe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends GameBoard {

	public enum GameStatus {
		PLAYING, TIE, PLAYER_WIN, AI_WIN
	}
	public static final int ROWS = 3;
	public static final int COLS = 3;
	private GameStatus currentStatus = GameStatus.PLAYING;
	private Marker currentPlayer; // X is human, O is circle, human always goes first
	private GameBoard board;
	private static Scanner in = new Scanner(System.in);

int currRow, currCol = 0;


	public TicTacToe() {
	    board = new GameBoard(ROWS,COLS);
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		board.initBoard();
		do {
			board.drawBoard();
			playerInput();
			aiMove();
			board.drawBoard();
		} while (currentStatus == GameStatus.PLAYING); 
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

	public void updateGameStatus(Marker player) {
		if ( board.check_win(player) ) {
			currentStatus = (player == Marker.CROSS) ? GameStatus.PLAYER_WIN : GameStatus.AI_WIN;
		}
		// else if (board.)
	}

    public void aiMove(){
    	Random r = new Random();
		int low = 1;
		int high = 10;
		int randomNum = r.nextInt(high-low) + low;
		switch (randomNum) {
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
		if ( board.cells[currRow][currCol].content == Marker.CROSS)
			aiMove();
		board.cells[currRow][currCol].content = Marker.CIRCLE;

    }
	public static void main (String[] args) {
		TicTacToe ttt = new TicTacToe();
	}

}