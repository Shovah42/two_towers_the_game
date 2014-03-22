public class Field {

	private Point position;
	private boolean free;
	private boolean road;
	private RoadManager roadmanager;
	private List<Visitable> visitables;

	public boolean isFree() {
		return this.free;
	}

	public boolean isRoad() {
		return this.road;
	}

	/**
	 * 
	 * @param free
	 */
	public void setFree(boolean free) {
		this.free = free;
	}

	/**
	 * 
	 * @param road
	 */
	public void setRoad(boolean road) {
		this.road = road;
	}

	public Point getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * 
	 * @param i
	 */
	public List<Field> getNearByRoads(int i) {
		// TODO - implement Field.getNearByRoads
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void execute(Character c) {
		// TODO - implement Field.execute
		throw new UnsupportedOperationException();
	}

	public List<Visitable> getVisitables() {
		return this.visitables;
	}

	/**
	 * 
	 * @param v
	 */
	public void addVisitable(Visitable v) {
		// TODO - implement Field.addVisitable
		throw new UnsupportedOperationException();
	}

}