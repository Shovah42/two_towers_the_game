public class CharacterMaster implements Updatable {

	private Character figure;
	private int tickCount;

	public CharacterMaster(Field f, Species type) {
		System.out.println("CALL class CharacterMaster method CharacterMaster(Species type,int mspeed, int dodge,int road, Field f)");
		int mspeed = 1;
		int dodge = 1;
		int road = 1;
		figure = new Character(type, mspeed,  dodge, road);
		int speed = 1;
		int health = 1;
		figure.setSpeed(speed);
		figure.setField(f);
		figure.setHealth(health);		
	}

	public Character getFigure() {
		return this.figure;
	}

	/**
	 * 
	 * @param figure
	 */
	public void setFigure(Character figure) {
		this.figure = figure;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

}