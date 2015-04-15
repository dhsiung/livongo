// package tictactoe;

public class GameBoard extends Cell{
	
	public static final int ROWS = 3;
	public static final int COLS = 3;


	Cell[][] cells = new Cell[ROWS][COLS];
	int currRow, currCol;
	int row, col;

	public GameBoard(){
		// System.out.println("dabien");
	}
	public GameBoard(int row, int col) {
		// cells = new Cell[ROWS][COLS];

		for(row = 0; row< ROWS; ++row) {
			for (col= 0; col < COLS; ++col){
				cells[row][col] = new Cell(row, col);
			}
		}
	}

	public void initBoard(){
		for (int row = 0; row < ROWS; ++row) {
	     	for (int col = 0; col < COLS; ++col) {
	        	cells[row][col].clear();
		    }
		}
	}

    public void drawBoard() {
    	for (int row = 0; row < ROWS; ++row) {
         	for (int col = 0; col < COLS; ++col) {
            	cells[row][col].draw();   
            	if (col < COLS - 1) System.out.print("|");
         	}
	        System.out.println();
	        if (row < ROWS - 1) System.out.println("-----------");
      	}
    }


	
	// public static void main (String[] args){

	// 	GameBoard board = new GameBoard(ROWS,COLS);
	// }
}