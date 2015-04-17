public class Cell {
	// The 3 possible cell options
	public enum Marker {
		BLANK, CROSS, CIRCLE
	}
	
	Marker content;
	int row,col;

	//explicit default constructor
	public Cell() {
	}

	// constructor
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}

	// sets cell to BLANK
	public void clear() {
		content = Marker.BLANK;
	}

	// prints the marker in the cell
	public void draw() {
		switch (content) {
			case BLANK: System.out.print("   "); break;
			case CROSS: System.out.print(" X "); break;
			case CIRCLE: System.out.print(" O "); break;
		}
	}
}