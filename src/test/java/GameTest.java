import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {
	
	@Test
	public void testNewWorldIsEmpty() {
		
		World world = new World();
		assertEquals(true, world.isEmpty());
	}
	
	
}
