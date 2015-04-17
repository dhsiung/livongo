// package tictactoe;

public class GameBoard extends Cell{
	
	public static final int ROWS = 3;
	public static final int COLS = 3;
	int currRow, currCol = 0;

	Cell[][] cells = new Cell[ROWS][COLS];
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
      	System.out.println();
    }

    public boolean check_win (Marker player) {
    	// 3 in a row like -
    	System.out.println("player: " + player);
    	if (cells[currRow][0].content == player &&
    		cells[currRow][1].content == player &&
    		cells[currRow][2].content == player) {
    		return true;
    	}
    	// 3 in a col like |
    	else if ( cells[0][currCol].content == player &&
	    		cells[1][currCol].content == player &&
	    		cells[2][currCol].content == player) {
    		return true;
    	}
    	// 3 diagonally like \
    	else if (currRow == currCol && 
	    		cells[0][0].content == player &&
	    		cells[1][1].content == player &&  
	    		cells[2][2].content == player) {
    		return true;
    	}
    	// 3 diagonally like /
    	else if (currRow + currCol == 2 && 
	    		cells[0][2].content == player &&
	    		cells[1][1].content == player &&  
	    		cells[2][0].content == player) {
    		return true;
    	}
//     	System.out.println("Current row: " + currRow);
//     	System.out.println("Current column: " + currCol);
// System.out.println("1: "+cells[0][0].content);
// System.out.println("2: "+cells[0][1].content);
// System.out.println("3: "+cells[0][2].content);
// System.out.println("4: "+cells[1][0].content);
// System.out.println("5: "+cells[1][1].content);
// System.out.println("6: "+cells[1][2].content);
// System.out.println("7: "+cells[2][0].content);
// System.out.println("8: "+cells[2][1].content);
// System.out.println("9: "+cells[2][2].content);
    	return false;
    }

    public boolean check_tie() {
    	for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (cells[row][col].content == Marker.BLANK) {
               return false; 
            }
         }
      }
      return true;
    }
}