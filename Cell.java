// package tictactoe;

public class Cell{
	public enum Marker {
		BLANK, CROSS, CIRCLE
	}
	
	Marker content;

	int row,col;

	public Cell() {
		// System.out.println("dabien1");
	}

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}

	public void clear() {
		content = Marker.BLANK;
	}

	public void draw() {
		switch (content) {
			case BLANK: System.out.print("   "); break;
			case CROSS: System.out.print(" X "); break;
			case CIRCLE: System.out.print(" O "); break;
		}
	}
}