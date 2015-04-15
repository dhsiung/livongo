// package tictactoe;

public class GameBoard {
	
	public static final int ROWS = 3;
	public static final int COLS = 3;

	public enum Marker {
		BLANK, CROSS, CIRCLE
	}

	Marker[][] cells;
	int currRow, currCol;

	public GameBoard() {
		cells = new Marker[ROWS][COLS];
		for(int row=0; row< ROWS; row++) {
			for (int col= 0; col < COLS; col++){
				cells[row][col] = Marker.BLANK;
			}
		}
	}

	public void initBoard(){
		for (int row = 0; row < ROWS; ++row) {
         	for (int col = 0; col < COLS; ++col) {
            	cells[row][col] = Marker.BLANK;
         }
      }


	}
	public static void main (String[] args){

		GameBoard board = new GameBoard();
	}
}