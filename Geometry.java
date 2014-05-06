
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Geometry implements RoadManager {

    //To configure the maximum number of roads
    private static final int roadNumber = 5;
    private static Geometry instance;
    private List<ArrayList<Field>> roads;
    private List<Field> map;
    private static boolean hasSomeOneMadeItToMordor;

    private Geometry() {
        roads = new ArrayList<ArrayList<Field>>();
        for (int i = 0; i < roadNumber; i++) {
            roads.add(new ArrayList<Field>());
        }
    }

    public static Geometry getInstance() {
        if (instance == null) {
            instance = new Geometry();
        }
        return instance;
    }

    public boolean getHasSomeoneMadeItToMordor() {
        return hasSomeOneMadeItToMordor;
    }

    public List<ArrayList<Field>> getRoads() {
        return instance.roads;
    }

    public List<Field> getMap() {
        return map;
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
        Field ret = null;
        for (Field f : map) {
            if (f.getPosition().equals(position)) {
                ret = f;
            }
        }
        return ret;
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
    public List<Field> getNextField(Field f, int roadId) {
        List<Field> possibleRoads = new ArrayList<Field>();
        for (ArrayList<Field> fields : roads) {
            if (fields.contains(f)) {
                if ((fields.indexOf(f) + 2) > fields.size()) {
                    hasSomeOneMadeItToMordor = true;
                    return possibleRoads;
                }
                possibleRoads.add(fields.get(fields.indexOf(f) + 1));
            } else {
                possibleRoads.add(null);
            }
        }

        return possibleRoads;
    }

}
