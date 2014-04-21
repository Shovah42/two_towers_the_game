
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameMaster {

    private ArrayList<Updatable> updatableList;
    private static GameMaster instance;
    private int tickNumber;
    private int frequency;
    private int groupPopularity;
    private boolean outOfCharacters;
    private List<Field> starterFields;

    public void refreshUpdatables() {
        System.out.println("CALL class GameMaster method refreshUpdatables()");

        ListIterator<Updatable> iter = updatableList.listIterator();
        while (iter.hasNext()) {
            if (!iter.next().update()) {
                System.out.println("CALL class GameMaster method removing the dead...");
                iter.remove();
                System.out.println("DONE!");
            }
        }
    }

    public static GameMaster getInstance() {
        if (instance == null) {
            instance = new GameMaster();
        }
        return instance;
    }

    private GameMaster() {
        this.updatableList = new ArrayList<Updatable>();
    }

    /**
     *
     * @param u
     */
    public void addUpdatable(Updatable u) {
        System.out.println("CALL class GameMaster method addUpdatable(Updatable u)");
        this.updatableList.add(u);
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
