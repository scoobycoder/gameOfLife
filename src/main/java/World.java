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
		if (shouldGiveBirth())
			cellBirth();
		else if (shouldCheckRemainingCells())
			removeNonAdjacentCells();
		
		lastCellDies();
	}

	private boolean shouldGiveBirth() {
		return cells.size() == 3;
	}

	private boolean shouldCheckRemainingCells() {
		return cells.size() > 1;
	}

	private void cellBirth() {
		Cell newCell = new Cell(1,1);
		cells.add(newCell);
	}

	private void removeNonAdjacentCells() {
		int removedCount = 0;
		for (int cellNumber = 0; cellNumber <= cells.size() - removedCount; cellNumber++) {
			removedCount = removeNonAdjCell(removedCount, cellNumber);
		}
	}

	private int removeNonAdjCell(int removedCount, int cellNumber) {
		if (checkIfCellsNotAdjacent(cellNumber)) {
			cells.remove(cellNumber);
			removedCount++;
		}
		return removedCount;
	}

	private boolean checkIfCellsNotAdjacent(int cellNumber) {
		if (cells.size() > cellNumber + 1) {
			return cells.get(cellNumber).adj(cells.get(cellNumber + 1)) == false;
		}
		return false;
	}

	private void lastCellDies() {
		if (cells.size() == 1) {
			cells.remove(0);
		}
	}

}
