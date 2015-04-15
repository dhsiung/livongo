public class TicTacToe {



	public char[][] board;

	public TicTacToe() {

		board = new char[3][3];
		System.out.println("Welcome to Tic-Tac-Toe.  Please make your move selection by entering a number 1-9 corresponding to the movement option on the right.");
		setBoard();
		printBoard();
	}

	public void setBoard() {
		for(int i=0; i<3;i++) {
			for (int j= 0; j < 3; j++){
				board[i][j] = ' ';
			}
		}

	}

	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
	}

	public static void main (String[] args) {
		TicTacToe test = new TicTacToe();
	}


}