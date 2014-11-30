package gameOfLife;

public class Cell {

	private World world;

	public Cell(World world) {
		this.world = world;
	}
	
	public int checkForNeighbors(Location location) {
		int neighborCount = world.neighborCount(location);
		
		return neighborCount;
	}

}
