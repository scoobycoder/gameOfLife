
public class Cell {

	private int x_loc;
	private int y_loc;
	private Cell cell_loc;
	
	public Cell(int x, int y) {
		x_loc = x;
		y_loc = y;
	}

	public boolean alive() {
		return true;
	}

	public boolean adj(Cell cell) {
		cell_loc = cell;
		
		if (Math.abs(cell_loc.y_loc - y_loc) > 1 || Math.abs(cell_loc.x_loc - x_loc) > 1) {
			return false;
		}
		else if (one_coordinate_equal())
			return true;
		else if (diagnal_within_one())
			return true;
		else
			return false;
	}

	private boolean diagnal_within_one() {
		return Math.abs((cell_loc.x_loc - x_loc)) == 1;
	}

	private boolean one_coordinate_equal() {
		return y_coordinate_equal() || x_coordinate_equal();
	}

	private boolean x_coordinate_equal() {
		return cell_loc.x_loc == x_loc;
	}

	private boolean y_coordinate_equal() {
		return cell_loc.y_loc == y_loc;
	}

}
