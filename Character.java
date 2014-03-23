
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
		System.out.println("CALL class Character method hit(Color c)");
		int damage=0;
		int baseDamage=20;
		int smallIncrease=10;
		int hugeIncrease=20;
		double randNumber = Math.random();
		d = randNumber * 100;
		int randomInt = (int)d + 1;
		//hogy biztosan lelõjuk 0 dode kell
		if(randomInt>dodge){
			if(c==Color.Red){
				damage = baseDamage + smallIncrease;
			}else if (c==Color.Green && this.type==Species.Dwarf){
				damage = baseDamage + hugeIncrease;
			}else if (c==Color.Blue && this.type==Species.Human){
				damage = baseDamage + hugeIncrease;
			}else if (c==Color.Yellow && this.type==Species.Elf){
				damage = baseDamage + hugeIncrease;
			}else if (c==Color.Purple && this.type==Species.Hobbit){
				damage = baseDamage + hugeIncrease;
			}else{
				damage = baseDamage;
			}
			this.setHealth((this.getHealth - damage));
			if(this.getHealth()<=0){
				System.out.println("Now execute is called, Character dies now done.");
				//this.getField().execute(this);
			}
		}
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
		System.out.println("CALL class Character method visit(Tower t)");
		System.out.println("Character added to shootableCharacters");
		t.addShootableCharacters(this);
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}