public class CharacterMaster implements Updatable {

	private Character figure;
	private int tickCount;

        public CharacterMaster(Character tm) {
		this.figure=tm;
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