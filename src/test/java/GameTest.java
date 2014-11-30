import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {
	
	@Test
	public void testNewWorldIsEmpty() {
		World world = new World();
		assertEquals(true, world.isEmpty());
	}
	
	@Test
	public void testWorldStillEmptyAfterTick() {
		World world = new World();
		world.tick();
		
		assertEquals(true, world.isEmpty());
	}
	
	@Test
	public void testAddingCellLocationBeforeTick() {
		World world = new World();
		
		Location location = new Location();
		world.addCellLocation(location);
		
		assertEquals(false, world.isEmpty());
	}
	
}
