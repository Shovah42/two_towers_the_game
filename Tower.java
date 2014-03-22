public class Tower extends Building implements Visitor, Visitable {

	private int damage;
	private Field field;
	private int speed;
	private List<Characters> shootableCharacters;

	public void shoot() {
		// TODO - implement Tower.shoot
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

	public void getSpeed() {
		// TODO - implement Tower.getSpeed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	private void iShootYou() {
		// TODO - implement Tower.iShootYou
		throw new UnsupportedOperationException();
	}

}