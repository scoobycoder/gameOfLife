import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	
	private World world;

	@Before
	public void setup() {
		world = new World();
	}
	
	@Test
	public void newWorldIsEmpty() {
		assertEquals(true, world.isEmpty());
	}
	
	@Test
	public void worldStillEmptyAfterTick() {
		world.tick();
		
		assertEquals(true, world.isEmpty());
	}
	
	@Test
	public void addingCellLocationBeforeTick() {
		Location location = new Location();
		world.addCellLocation(location);
		
		assertEquals(false, world.isEmpty());
	}
	
	
}
