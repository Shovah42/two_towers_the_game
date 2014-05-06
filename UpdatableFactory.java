
public class UpdatableFactory implements Splitter {

    public UpdatableFactory() {
        //System.out.println("CALL class UpdatableFactory method UpdatableFactory()");
    }

    /**
     *
     * @param road
     * @param f
     */
    public Updatable createUpdatable(Species type, int life, Field f, int road) {
        Character c = new Character(type, life, f, road);
        CharacterMaster cm = new CharacterMaster(c);
        f.addVisitable(c);
        return cm;
    }

    /**
     *
     * @param t
     * @param f
     */
    public Updatable createUpdatable( Field field, int speed, int range) {
        //System.out.println("CALL class Trap method createUpdatable(Tower t, Field f)");
        Tower t = new Tower(field, speed, range);
        field.addVisitable(t);
        TowerMaster tm = new TowerMaster(t);
        return tm;
    }

    @Override
    public Updatable createSplitted(Species type, int life, Field f, int road) {
        Character c = new Character(type, life, f, road);
        f.addVisitable(c);
        CharacterMaster cm = new CharacterMaster(c);
        return cm;
    }

}
