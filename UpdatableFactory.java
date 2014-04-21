
public class UpdatableFactory implements Splitter {

    public UpdatableFactory() {
        System.out.println("CALL class UpdatableFactory method UpdatableFactory()");
    }

    /**
     *
     * @param road
     * @param f
     */
    public Updatable createUpdatable(int road, Field f) {
        System.out.println("CALL class UpdatableFactory method createUpdatable(int road, Field f)");
        Character c = new Character(Species.Hobbit, 100, 20, road);
        CharacterMaster cm = new CharacterMaster(c);
        c.setField(f);
        f.addVisitable(c);
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
        TowerMaster tm = new TowerMaster(t);
        return tm;
    }

    @Override
    public Updatable createSplited(Species type, int life, Field f, int road) {
        Character c = new Character(type, life, f, road);
        f.addVisitable(c);
        CharacterMaster cm = new CharacterMaster(c);
        f.addVisitable(c);
        return cm;
    }

}
