package gameOfLife;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class CellTest {
	private Cell underTest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		underTest = new Cell(world);
	}
	
	@Mock
	private Location location;
	
	@Mock
	private World world;

	@Test
	public void cellShouldAskForNeighbors() {
		underTest.checkForNeighbors(location);
		
		verify(world).neighborCount(location);
	}
	
}
