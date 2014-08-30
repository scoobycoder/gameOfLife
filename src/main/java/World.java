import java.util.List;


public class World {

	private List<Cell> cells;

	public World(List<Cell> cellList) {
		cells = cellList;
	}

	public int cellCount() {
		return cells.size();
	}

	public void generate() {
		lastCellDies();
		if (cells.size() == 3) {
			Cell newCell = new Cell(1,1);
			cells.add(newCell);
		}
		else if (cells.size() > 1) {
			int removedCount = 0;
			for (int i = 0; i <= cells.size() - removedCount; i++) {
				if (cells.get(i).adj(cells.get(i + 1)) == false) {
					cells.remove(i);
					removedCount++;
				}
			}
		}
		lastCellDies();
			
	}

	private void lastCellDies() {
		if (cells.size() == 1) {
			cells.remove(0);
		}
	}

}
