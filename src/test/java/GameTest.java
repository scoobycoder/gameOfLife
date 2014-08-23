import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GameTest {

	@Test
	public void cellShouldTakeBirthLocation() {
		Cell cell =  new Cell(0,0);
		
		assertEquals(true, cell.alive());
	}
	
	@Test
	public void worldShouldReturnTwoCellsIfTwoCellsLive() {
		List<Cell> cellList = new ArrayList<Cell>();
		Cell cell = new Cell(0,0);
		Cell cell2 = new Cell(1,0);
		cellList.add(cell);
		cellList.add(cell2);

		World world = new World(cellList);
		
		assertEquals(2, world.cellCount());
		
	}
	
}
