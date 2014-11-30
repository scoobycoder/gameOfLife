import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class WorldTest {
	
	private World underTest;
	
	@Mock
	Location location;

	private void checkWorldEmpty() {
		assertEquals(true, underTest.isEmpty());
	}
	
	@Before
	public void setup() {
		underTest = new World();
	}
	
	@Test
	public void newWorldIsEmpty() {
		checkWorldEmpty();
	}

	
	@Test
	public void worldStillEmptyAfterTick() {
		underTest.tick();
		
		checkWorldEmpty();
	}
	
	@Test
	public void addingCellLocationBeforeTick() {
		underTest.addCellLocation(location);
		
		assertEquals(false, underTest.isEmpty());
	}
	
	
}