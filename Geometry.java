
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
        return this.hasSomeOneMadeItToMordor;
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
        List<Field> fieldList = new ArrayList<Field>();
        Point thisFieldPos = f.getPosition();
        for (Field field : map) {
            Point pointTmp = field.getPosition();
            if ((thisFieldPos.x - range) <= pointTmp.x && pointTmp.x <= (thisFieldPos.x + range)) {
                if ((thisFieldPos.y - range) <= pointTmp.y && pointTmp.y <= (thisFieldPos.y + range)) {
                    fieldList.add(field);
                }
            }
        }
        return fieldList;
    }

    @Override
    public Field getNextField(Field f, int roadId) {
        System.out.println("CALL class Geometry method getNextField(Field f, int roadId)");
        System.out.println("Return Field");
        return (new Field());
    }

}
