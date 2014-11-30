import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class WorldTest {
	
	private World underTest;
	
	@Mock
	Location location;

	@Before
	public void setup() {
		underTest = new World();
	}
	
	@Test
	public void newWorldIsEmpty() {
		assertEquals(true, underTest.isEmpty());
	}
	
	@Test
	public void worldStillEmptyAfterTick() {
		underTest.tick();
		
		assertEquals(true, underTest.isEmpty());
	}
	
	@Test
	public void addingCellLocationBeforeTick() {
		underTest.addCellLocation(location);
		
		assertEquals(false, underTest.isEmpty());
	}
	
	
}
