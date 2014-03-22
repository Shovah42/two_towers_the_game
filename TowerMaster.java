public class TowerMaster implements Updatable {

	private Tower tower;
	private int tickCount;

	public Tower getTower() {
		return this.tower;
	}

	/**
	 * 
	 * @param tower
	 */
	public void setTower(Tower tower) {
		this.tower = tower;
	}

}