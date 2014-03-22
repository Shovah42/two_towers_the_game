public class Geometry implements RoadManager {

	private static Geometry instance;
	private List<Field>[] roads;
	private List<Field> map;
	private boolean hasSomeOneMadeItToMordor;

	private Geometry() {
		// TODO - implement Geometry.Geometry
		throw new UnsupportedOperationException();
	}

	public static Geometry getInstance() {
		return this.instance;
	}

	public boolean getHasSomeoneMadeItToMordor() {
		// TODO - implement Geometry.getHasSomeoneMadeItToMordor
		throw new UnsupportedOperationException();
	}

	public List<Field>[] getRoads() {
		return this.roads;
	}

	public List<Field> getMap() {
		return this.map;
	}

	/**
	 * 
	 * @param map
	 */
	public void setMap(List<Field> map) {
		this.map = map;
	}

	/**
	 * 
	 * @param position
	 */
	public void getFieldOfCoordinate(Point position) {
		// TODO - implement Geometry.getFieldOfCoordinate
		throw new UnsupportedOperationException();
	}

}