import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test
	public void cellShouldReportLifeIfAlive() {
		
		
		Cell cell = new Cell();
		assertEquals(true, cell.alive());
	}

	
}
