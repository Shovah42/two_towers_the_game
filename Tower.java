import java.util.List;

public class Tower extends Building implements Visitor, Visitable {

	private int damage;
	private Field field;
	private int speed;
	private List<Character> shootableCharacters;

	public Tower() {
		System.out.println("CALL class Tower method Tower()");
	}
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
		System.out.println("CALL class Tower method setField(Field field)");
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

	@Override
	public void accept(Visitor v) {
		System.out.println("alt Visitable==Tower");
		System.out.println("CALL class Tower method accept(Visitor v)");
		v.visit(this);
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

}