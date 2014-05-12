import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Geometry implements RoadManager {

	// To configure the maximum number of roads
	private static final int roadNumber = 5;
	private static Geometry instance;
	private List<ArrayList<Field>> roads;
	private List<Field> map;
	private static boolean hasSomeOneMadeItToMordor;

	private Geometry() {

		map = new ArrayList<Field>();

		String fields = "";
		File file = new File("map.txt");
		BufferedReader reader = null;
		
		for (int j = 0; j < 19*19; j++) {
			map.add(new Field());
		}
		
	try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				fields = fields + text;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		for (int i = 0; i < 19 * 19; i++) {
			char c = fields.charAt(i);
			if (c == '0') {
				map.get(i).setRoad(false);
				map.get(i).setPosition(new Point(i%19, i - (i%19)));
			} else {
				map.get(i).setRoad(true);
				map.get(i).setPosition(new Point(i%19, i - (i%19)));
			}
		}
		

		roads = new ArrayList<ArrayList<Field>>();
		for (int j = 0; j < roadNumber; j++) {
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
			if ((thisFieldPos.x - range) <= pointTmp.x
					&& pointTmp.x <= (thisFieldPos.x + range)) {
				if ((thisFieldPos.y - range) <= pointTmp.y
						&& pointTmp.y <= (thisFieldPos.y + range)) {
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
