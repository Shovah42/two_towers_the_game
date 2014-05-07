
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Jatek mester osztaly.
 *
 * @author ComboBox
 */
public class GameMaster {

    private ArrayList<Updatable> updatableList;
    private static GameMaster instance;
    private int tickNumber;
    private int frequency;
    private int groupPopularity;
    private boolean outOfCharacters;
    private List<Field> starterFields;

    /**
     * A jatek mester singelton konstruktora.
     *
     * @return GameMaster
     */
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
     * A jatek mester altal kezelt frissitendo objektumokhoz ujabb elem
     * felvetele.
     *
     * @param u az uj frissitendo objektum.
     */
    public void addUpdatable(Updatable u) {
        this.updatableList.add(u);
    }

    /**
     * A frissitendo objektumok frissitese.
     */
    public void refreshUpdatables() {
//        ListIterator<Updatable> iter = updatableList.listIterator();
//        while (iter.hasNext()) {
//            if (!iter.next().update()) {
//                iter.remove();
//            }
//        }
        ArrayList<Updatable> updatableTempList = updatableList;
        for(Updatable updatable : updatableTempList){
            if(updatable.update()){
                updatableList.remove(updatable);
            }
        }
    }

    public void startNextRound() {
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
