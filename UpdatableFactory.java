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
		System.out.println("CALL class UpdatableFactory method createUpdatable(int UpdatableId, Field f)");
		Species type = Species.Human;
		CharacterMaster cm = new CharacterMaster(f, type);
		return cm;
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