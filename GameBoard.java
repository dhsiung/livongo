public class GameBoard extends Cell{
	
	public static final int ROWS = 3;
	public static final int COLS = 3;
	int currRow, currCol = 0;
	Cell[][] cells = new Cell[ROWS][COLS];
	int row, col;

	//explicit default constructor
	public GameBoard(){
	}

	// constructor
	public GameBoard(int row, int col) {
		for(row = 0; row< ROWS; ++row) {
			for (col= 0; col < COLS; ++col){
				cells[row][col] = new Cell(row, col);
			}
		}
	}

	/* 
     * Initializes the game board 
     * calls cell.clear() to set each individual cell to BLANK 
     */
	public void initBoard(){
		for (row = 0; row < ROWS; ++row) {
	     	for (col = 0; col < COLS; ++col) {
	        	cells[row][col].clear();
		    }
		}
	}

	/* 
     * This method draws the skeleton of the board
     * It calls cell.draw() which will place the appropriate 
     * Marker at each position (BLANK, CROSS, CIRCLE)
     */
    public void drawBoard() {
    	System.out.println("Board:              Movement Options:");
    	int movementOption = 1;
    	for (int row = 0; row < ROWS; ++row) {
         	for (int col = 0; col < COLS; ++col) {
            	cells[row][col].draw();   
            	if (col < COLS - 1) System.out.print("|");
            	
         	}
         	System.out.println("          " + movementOption++ + " | " + movementOption++ + " | " + movementOption++);
	        // System.out.println();
	        if (row < ROWS - 1) System.out.println("-----------         -----------");
      	}
      	System.out.println();
    }

	/* 
     * This method checks if there is a WIN
     * returns true if there is a win condition else false
     */
    public boolean check_win (Marker player) {
    	// 3 in a row like -
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
    	return false;
    }

	/* 
     * This method checks if there is a TIE
     * returns true if there is a tie condition else false
     */
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