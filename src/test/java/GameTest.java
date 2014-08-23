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
	public void cellShouldTellTrueIfAnotherCellAdjacent() {
		Cell cell00 =  CELL_00;
		Cell cell10 =  CELL_10;
		
		assertEquals(true, cell00.adj(cell10));
	}
	
	@Test
	public void cellShouldTellFalseIfAnotherCellNotAdjacent() {
		Cell cell00 =  CELL_01;
		Cell cell20 =  CELL_10;
		
		assertEquals(false, cell00.adj(cell20));
	}
	
	@Test
	public void worldShouldReturnTwoCellsIfTwoCellsLive() {
		Cell cell = CELL_00;
		Cell cell2 = CELL_10;
		addCell(cell);
		addCell(cell2);

		createWorld();
		
		assertEquals(2, world.cellCount());
	}

	@Test
	public void worldShouldAllowForDeathOfOnlyCell() {
		Cell cell = CELL_00;
		addCell(cell);
		
		createWorld();
		generate();
		
		assertEquals(0, world.cellCount());
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
		
		assertEquals(4, world.cellCount());
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
	
}
