public class UpdatableFactory {

	public UpdatableFactory() {
		System.out.println("CALL class UpdatableFactory method UpdatableFactory()");
	}
	/**
	 * 
	 * @param UpdatableId
	 * @param f
	 */
	public Updatable createUpdatable(int UpdatableId, Field f) {
		// TODO - implement UpdatableFactory.createUpdatable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param f
	 */
	public Updatable createUpdatable(Tower t, Field f) {
		System.out.println("CALL class Trap method createUpdatable(Tower t, Field f)");
		t.setField(f);
		f.addVisitable(t);
		TowerMaster tm=new TowerMaster(t);
		return tm;
	}

}