import java.util.ArrayList;
import java.util.List;


public class World {

	private List<Location> locations;
	
	public World() {
		locations = new ArrayList<Location>();
	}
	
	public boolean isEmpty() {
		return locations.size() == 0;
	}

	public void tick() {
	}

	public void addCellLocation(Location location) {
		locations.add(location);
	}

}
