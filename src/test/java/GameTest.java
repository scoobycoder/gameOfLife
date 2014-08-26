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
		Cell cell =  CELL_00;
		
		assertEquals(true, cell.alive());
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
		Cell cell = CELL_00;
		Cell cell2 = CELL_10;
		addCell(cell);
		addCell(cell2);

		createWorld();
		
		validateLiveCellCount(world.cellCount(), 2);
	}

	@Test
	public void worldShouldAllowForDeathOfOnlyCell() {
		Cell cell = CELL_00;
		addCell(cell);
		
		createWorld();
		generate();
		
		validateLiveCellCount(world.cellCount(), 0);
	}
	
	@Test
	public void worldShouldIncreasePopulationIfExactlyThreeCells() {
		Cell cell00 = CELL_00;
		Cell cell01 = CELL_01;
		Cell cell10 = CELL_10;

		addCell(cell00);
		addCell(cell01);
		addCell(cell10);
		
		createWorld();
		generate();
		
		validateLiveCellCount(world.cellCount(), 4);
	}
	
	@Test @Ignore
	public void worldShouldAllowTwoCellsToDieIfNotAdjacent() {
		Cell cell00 = CELL_00;
		Cell cell20 = CELL_20;

		addCell(cell00);
		addCell(cell20);
		
		createWorld();
		generate();
		
		assertEquals(0, world.cellCount());
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
