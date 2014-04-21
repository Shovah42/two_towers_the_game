
import java.util.List;

public interface RoadManager {

    /**
     *
     * @param f
     * @param range
     */
    List<Field> getRoadsInRange(Field f, int range);

    /**
     *
     * @param f
     * @param roadId
     */
    Field getNextField(Field f, int roadId);

}
