
public class Character implements Visitable, Visitor {

	private Field field;
	private int speed;
	private boolean speedChanged;
	private int dodge;
	private Species type;
	private final int maxSpeed;
	private int health;
	private int road;

	
	public Character(Species type,int mspeed, int dodge,int road) {
		maxSpeed=mspeed;
		this.road=road;
		this.dodge=dodge;
		this.type=type;
	}
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

	@Override
	public void visit(Trap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Character c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Tower t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}