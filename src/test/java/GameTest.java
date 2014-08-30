import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class GameTest {
	
	private static final Cell CELL_10 = new Cell(1,0);
	private static final Cell CELL_01 = new Cell(0,1);
	private static final Cell CELL_00 = new Cell(0,0);
	private static final Cell CELL_20 = new Cell(2,0);
	private static final Cell CELL_21 = new Cell(2,1);
	private static final Cell CELL_22 = new Cell(2,2);
	private List<Cell> cellList;
	private World world;

	@Before
	public void setup() {
		cellList = new ArrayList<Cell>();
	}
	
	@Test
	public void cellShouldTakeBirthLocation() {
		assertEquals(true, CELL_00.alive());
	}
	
	@Test
	public void cellShouldTellTrueIfAnotherCellAdjacentNorthToSouth() {
		cellsAdjacent(CELL_00, CELL_10);
	}
	
	@Test
	public void cellShouldTellFalseIfAnotherCellNotAdjacentEastToWest() {
		cellsNotAdjacent(CELL_01, CELL_22);
	}
	
	@Test
	public void worldShouldReturnTwoCellsIfTwoCellsLive() {
		addCell(CELL_00);
		addCell(CELL_10);

		createWorld();
		
		validateLiveCellCount(worldCellCount(), 2);
	}

	@Test
	public void worldShouldAllowForDeathOfOnlyCell() {
		addCell(CELL_00);
		
		createWorld();
		generate();
		
		validateLiveCellCount(worldCellCount(), 0);
	}
	
	@Test
	public void worldShouldIncreasePopulationIfExactlyThreeCells() {
		addCell(CELL_00);
		addCell(CELL_01);
		addCell(CELL_10);
		
		createWorld();
		generate();
		
		validateLiveCellCount(worldCellCount(), 4);
	}
	
	@Test
	public void worldShouldAllowTwoCellsToDieIfNotAdjacent() {
		addCell(CELL_00);
		addCell(CELL_20);
		
		createWorld();
		generate();
		
		validateLiveCellCount(worldCellCount(), 0);
	}

	private int worldCellCount() {
		return world.cellCount();
	}
	

	private void addCell(Cell cell) {
		cellList.add(cell);
	}

	private void generate() {
		world.generate();
	}

	private void createWorld() {
		world = new World(cellList);
	}
	
	private void cellsAdjacent(Cell cell00, Cell cell10) {
		assertEquals(true, cell00.adj(cell10));
	}	

	private void cellsNotAdjacent(Cell cell01, Cell cell22) {
		assertEquals(false, cell01.adj(cell22));
	}	

	private void validateLiveCellCount(int cellCount, int liveCells) {
		assertEquals(liveCells, cellCount);
	}	
	
}
