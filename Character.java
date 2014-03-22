public class Character implements Visitable, Visitor {

	private Field field;
	private int speed;
	private boolean speedChanged;
	private int dodge;
	private Species type;
	private final int maxSpeed;
	private int health;
	private int road;

	public int getSpeed() {
		return this.speed;
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void move() {
		// TODO - implement Character.move
		throw new UnsupportedOperationException();
	}

	public Field getField() {
		return this.field;
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field) {
		this.field = field;
	}

	public int getHealth() {
		return this.health;
	}

	/**
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public void kill() {
		// TODO - implement Character.kill
		throw new UnsupportedOperationException();
	}

	public Species getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(Species type) {
		this.type = type;
	}

	/**
	 * 
	 * @param c
	 */
	public void hit(Color c) {
		// TODO - implement Character.hit
		throw new UnsupportedOperationException();
	}

}