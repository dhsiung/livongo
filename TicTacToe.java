import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends GameBoard {

	// the 4 game statuses, will be constantly checked to update game accordingly
	public enum GameStatus {
		PLAYING, TIE, PLAYER_WIN, AI_WIN
	}
	public static final int ROWS = 3;
	public static final int COLS = 3;
	private GameStatus currentStatus = GameStatus.PLAYING; //initialize to PLAYING
	private Marker currentPlayer = Marker.CROSS; // X is human, O is circle, human always goes first
	private GameBoard board;
	private static Scanner in = new Scanner(System.in);

	public TicTacToe() {
	    board = new GameBoard(ROWS,COLS);
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		board.initBoard();
		// This do while loop will keep the game going as long as nobody as won or there is no tie
		board.drawBoard();
		do {
			// playerInput();
			// aiMove();
			makeMove(currentPlayer);	// makeMove will allow players to input a move, or the AI to make a move
			updateGameStatus(currentPlayer); // check to see if there is a WIN or TIE
			if (currentStatus == GameStatus.PLAYER_WIN) {
				board.drawBoard();
				System.out.println("You have beaten my AI!");
				break; // this break is purely so I don't print the board again.
			}
			else if (currentStatus == GameStatus.AI_WIN) {
				board.drawBoard();
				System.out.println("Only a fool would think they could beat me!");
				break; // this break is purely so I don't print the board again.
			}
			else if (currentStatus == GameStatus.TIE) {
				board.drawBoard();
				System.out.println("It's a tie!");
				break; // this break is purely so I don't print the board again.
			}
			changePlayer();	//switch between the player and AI
			board.drawBoard();
		} while (currentStatus == GameStatus.PLAYING); 
	}

	/* 
     * This method checks the GameStatus
     * If there is a PLAYER_WIN, AI_WIN, or TIE
     * the game will terminate, otherwise it does not change the GameStatus
     */
	public void updateGameStatus(Marker player) {
		if ( board.check_win(player) ) {
			currentStatus = (player == Marker.CROSS) ? GameStatus.PLAYER_WIN : GameStatus.AI_WIN;
		}
		else if (board.check_tie()){
			currentStatus = GameStatus.TIE;
		}
	}

	/*
	 * This method is what allows the player/AI to make a move
	 * The AI is very naive, and merely makes a random selection out of the available moves
	 * This method is basically a combined method for the commented out playerMove() and aiMove()
	 */
    public void makeMove(Marker currentPlayer) {
		String cellPosition="";
    	if (currentPlayer == Marker.CROSS) {
    		System.out.print("Where to? ");
			int input = in.nextInt();
			boolean validInput = false;
			do {
				//error handling of input outside of gameboard dimensions
				if (input>=1 && input <= 9) {
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
					// error handling of cells that are already taken
					if ( board.cells[currRow][currCol].content != Marker.BLANK ) {
						System.out.println("That cell is already taken! Pick a different one!");
						makeMove(currentPlayer);
						break;
					}
					else {
						board.cells[currRow][currCol].content = Marker.CROSS;
						board.currRow = currRow;
						board.currCol = currCol;
						System.out.println("You have put an X in the " + cellPosition + ".");
						validInput = true; //exit the loop because its a valid input
					}
				}
				else {
					System.out.println("Invalid input. Please try again.");
					makeMove(currentPlayer);
					break;
				}

			} while (!validInput); 
    	}
    	else if (currentPlayer == Marker.CIRCLE) {
			Random r = new Random();
			int low = 1;
			int high = 10;
			int randomNum = r.nextInt(high-low) + low;
			switch (randomNum) {
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
			if ( board.cells[currRow][currCol].content != Marker.BLANK) {
				makeMove(currentPlayer);
			}
			else {
				board.cells[currRow][currCol].content = Marker.CIRCLE;
				board.currRow = currRow;
				board.currCol = currCol;
				System.out.println("I will put an O in the " + cellPosition + ".");
			}
    	}
    }

    /*
     * This method changes the current player, switching back and forth between CIRCLE and CROSS
     * CROSS always goes first, and is always the human.
     */
    public void changePlayer() {
    	if (currentPlayer == Marker.CROSS) currentPlayer = Marker.CIRCLE;
    	else if (currentPlayer == Marker.CIRCLE) currentPlayer = Marker.CROSS;
    }

	public static void main (String[] args) {
		TicTacToe ttt = new TicTacToe(); //instantiate new TicTacToe, constructor will do all the work.
	}
	/*
method not used
    public void aiMove(){
			Random r = new Random();
			int low = 1;
			int high = 10;
			int randomNum = r.nextInt(high-low) + low;
			switch (randomNum) {
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
			while ( board.cells[currRow][currCol].content != Marker.BLANK) {
				makeMove(currentPlayer);
			}
			board.cells[currRow][currCol].content = Marker.CIRCLE;
			board.currRow = currRow;
			board.currCol = currCol;
			System.out.println("I will put an O in the " + cellPosition + ".");
    }
    */

    /*
method not used
	public void playerInput() {
		System.out.print("Where to? ");
			int input = in.nextInt();
			boolean validInput = false;
			do {
				//error handling of input outside of gameboard dimensions
				if (input>=1 && input <= 9) {
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
					// error handling of cells that are already taken
					if ( board.cells[currRow][currCol].content != Marker.BLANK ) {
						System.out.println("That cell is already taken! Pick a different one!");
						makeMove(currentPlayer);
						break;
					}
					else {
						board.cells[currRow][currCol].content = Marker.CROSS;
						board.currRow = currRow;
						board.currCol = currCol;
						System.out.println("You have put an X in the " + cellPosition + ".");
						validInput = true; //exit the loop because its a valid input
					}
				}
				else {
					System.out.println("Invalid input. Please try again.");
					makeMove(currentPlayer);
					break;
				}

			} while (!validInput); 
	}
	*/

}