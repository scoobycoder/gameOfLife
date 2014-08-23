import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	
	private List<Cell> cellList;

	@Before
	public void setup() {
		cellList = new ArrayList<Cell>();
	}
	
	@Test
	public void cellShouldTakeBirthLocation() {
		Cell cell =  new Cell(0,0);
		
		assertEquals(true, cell.alive());
	}
	
	@Test
	public void worldShouldReturnTwoCellsIfTwoCellsLive() {
		Cell cell = new Cell(0,0);
		Cell cell2 = new Cell(1,0);
		cellList.add(cell);
		cellList.add(cell2);

		World world = new World(cellList);
		
		assertEquals(2, world.cellCount());
	}

	@Test
	public void worldShouldAllowForDeathOfOnlyCell() {
		Cell cell = new Cell(0,0);
		cellList.add(cell);
		
		World world = new World(cellList);
		world.generate();
		
		assertEquals(0, world.cellCount());
	}
	
	@Test
	public void worldShouldIncreasePopulationIfExactlyThreeCells() {
		Cell cell = new Cell(0,0);
		Cell cell2 = new Cell(0,1);
		Cell cell3 = new Cell(1,0);

		cellList.add(cell);
		cellList.add(cell2);
		cellList.add(cell3);
		
		World world = new World(cellList);
		world.generate();
		
		assertEquals(4, world.cellCount());
	}
	
}
