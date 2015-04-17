
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
	private Marker currentPlayer = Marker.CROSS; // X is human, O is circle, human always goes first
	private GameBoard board;
	private static Scanner in = new Scanner(System.in);

	// public static int currRow, currCol = 0;


	public TicTacToe() {
	    board = new GameBoard(ROWS,COLS);
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		board.initBoard();
		do {
			board.drawBoard();
			// playerInput();
			// aiMove();
			// board.drawBoard();
			makeMove(currentPlayer);
    	// System.out.println("Current row: " + currRow);
    	// System.out.println("Current column: " + currCol);
			updateGameStatus(currentPlayer);
			if (currentStatus == GameStatus.PLAYER_WIN) {
				System.out.println("You have beaten my AI!");
			}
			else if (currentStatus == GameStatus.AI_WIN) {
				System.out.println("Only a fool would think they could beat me!");
			}
			else if (currentStatus == GameStatus.TIE) {
				System.out.println("It's a tie!");
			}
			changePlayer();
		} while (currentStatus == GameStatus.PLAYING); 
	}

	/* unfinished, hardcoded to find cell position. fix later! */
	// todo implement check if cell is already taken

	public void playerInput() {
		// int currRow, currCol = 0;
		System.out.print("Where to? ");
		int input = in.nextInt();
		String cellPosition="";
		switch (input) {
			case 1: currRow = 0; currCol=0; cellPosition = "upper left"; break;
			case 2: currRow = 0; currCol=1; cellPosition = "upper middle"; break;
			case 3: currRow = 0; currCol=2; cellPosition = "upper right"; break;
			case 4: currRow = 1; currCol=0; cellPosition = "middle left"; break;
			case 5: currRow = 1; currCol=1; cellPosition = "middle"; break;
			case 6: currRow = 1; currCol=2; cellPosition = "middle right"; break;
			case 7: currRow = 2; currCol=0; cellPosition = "lower left"; break;
			case 8: currRow = 2; currCol=1; cellPosition = "lower middle"; break; 
			case 9: currRow = 2; currCol=2; cellPosition = "lower right"; break;
		}
		board.cells[currRow][currCol].content = Marker.CROSS;
		board.currRow = currRow;
		board.currCol = currCol;
		System.out.println("You have put an X in the " + cellPosition + ".");
	}

	public void updateGameStatus(Marker player) {
		if ( board.check_win(player) ) {
			currentStatus = (player == Marker.CROSS) ? GameStatus.PLAYER_WIN : GameStatus.AI_WIN;
			System.out.println("HIT THE LOOP!");
		}
		else if (board.check_tie()){
			currentStatus = GameStatus.TIE;
		}
	}

    public void aiMove(){
    	Random r = new Random();
		int low = 1;
		int high = 10;
		int randomNum = r.nextInt(high-low) + low;
		System.out.println("Random # : " + randomNum);
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
		// if current cell is taken, pick another one
		if ( board.cells[currRow][currCol].content != Marker.BLANK)
			aiMove();
		board.cells[currRow][currCol].content = Marker.CIRCLE;
		board.currRow = currRow;
		board.currCol = currCol;

    }

    public void makeMove(Marker currentPlayer) {
    	if (currentPlayer == Marker.CROSS) {
    		System.out.print("Where to? ");
			int input = in.nextInt();
			String cellPosition="";
			switch (input) {
				case 1: currRow = 0; currCol=0; cellPosition = "upper left"; break;
				case 2: currRow = 0; currCol=1; cellPosition = "upper middle"; break;
				case 3: currRow = 0; currCol=2; cellPosition = "upper right"; break;
				case 4: currRow = 1; currCol=0; cellPosition = "middle left"; break;
				case 5: currRow = 1; currCol=1; cellPosition = "middle"; break;
				case 6: currRow = 1; currCol=2; cellPosition = "middle right"; break;
				case 7: currRow = 2; currCol=0; cellPosition = "lower left"; break;
				case 8: currRow = 2; currCol=1; cellPosition = "lower middle"; break; 
				case 9: currRow = 2; currCol=2; cellPosition = "lower right"; break;
			}
			board.cells[currRow][currCol].content = Marker.CROSS;
			board.currRow = currRow;
			board.currCol = currCol;
    	}
    	else if (currentPlayer == Marker.CIRCLE) {
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
			if ( board.cells[currRow][currCol].content != Marker.BLANK)
				makeMove(currentPlayer);
			board.cells[currRow][currCol].content = Marker.CIRCLE;
			board.currRow = currRow;
			board.currCol = currCol;
    	}
    }

    public void changePlayer() {
    	if (currentPlayer == Marker.CROSS) currentPlayer = Marker.CIRCLE;
    	else if (currentPlayer == Marker.CIRCLE) currentPlayer = Marker.CROSS;
    }

	public static void main (String[] args) {
		TicTacToe ttt = new TicTacToe();
	}

}