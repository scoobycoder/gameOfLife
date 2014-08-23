
public class Cell {

	private int x_loc;
	private int y_loc;
	
	public Cell(int x, int y) {
		x_loc = x;
		y_loc = y;
	}

	public boolean alive() {
		return true;
	}

	public boolean adj(Cell cell) {
		if (cell.y_loc == y_loc)
			return true;
		else
			return false;
	}

}
