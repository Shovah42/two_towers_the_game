
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Geometry implements RoadManager {

    private static Geometry instance;
    private List<Field>[] roads;
    private List<Field> map;
    private boolean hasSomeOneMadeItToMordor;

    private Geometry() {

    }

    public static Geometry getInstance() {
        if (instance == null) {
            instance = new Geometry();
        }
        return instance;
    }

    public boolean getHasSomeoneMadeItToMordor() {
        // TODO - implement Geometry.getHasSomeoneMadeItToMordor
        throw new UnsupportedOperationException();
    }

    public List<Field>[] getRoads() {
        return this.roads;
    }

    public List<Field> getMap() {
        return this.map;
    }

    /**
     *
     * @param map
     */
    public void setMap(List<Field> map) {
        this.map = map;
    }

    /**
     *
     * @param position
     */
    public Field getFieldOfCoordinate(Point position) {
        System.out.println("CALL class Geometry method getFieldOfCoordinate(Point position)");
        System.out.println("Return Field");
        return null;
    }

    @Override
    public List<Field> getRoadsInRange(Field f, int range) {
        System.out.println("CALL class Geometry method getRoadsInRange(Field f, int range)");
        System.out.println("Return Field List");
        return null;
    }

    @Override
    public Field getNextField(Field f, int roadId) {
        // TODO Auto-generated method stub
        return null;
    }

}
