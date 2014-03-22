public class GameMaster {

	private ArrayList<Updatable> updatableList;
	private static GameMaster instance;
	private int tickNumber;
	private int frequency;
	private int groupPopularity;
	private boolean outOfCharacters;
	private List<Field> starterFields;

	public void refreshUpdatables() {
		// TODO - implement GameMaster.refreshUpdatables
		throw new UnsupportedOperationException();
	}

	public static GameMaster getInstance() {
		return this.instance;
	}

	private GameMaster() {
		// TODO - implement GameMaster.GameMaster
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param u
	 */
	public void addUpdatable(Updatable u) {
		// TODO - implement GameMaster.addUpdatable
		throw new UnsupportedOperationException();
	}

	public void startNextRound() {
		// TODO - implement GameMaster.startNextRound
		throw new UnsupportedOperationException();
	}

	public boolean isOutOfCharacters() {
		return this.outOfCharacters;
	}

	/**
	 * 
	 * @param starterFields
	 */
	public void setStarterFields(List<Field> starterFields) {
		this.starterFields = starterFields;
	}

}