public interface RoadManager {

	/**
	 * 
	 * @param f
	 * @param range
	 */
	List<Field> getRoadsInRange(field f, int range);

	/**
	 * 
	 * @param f
	 * @param roadId
	 */
	Field getNextField(Field f, int roadId);

}