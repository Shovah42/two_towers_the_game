import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	private static int mana;
	private static Color color;
	// We don't need run yet, because we don't use time when testing
	public void run() {

		// TODO - implement Application.run
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		File file = new File("test" + args[0] + ".txt");
		List<String> commands = readFile(file);
		// parsing the input language
		// and calling the appropriate test methods
		for (String cmd : commands) {
			String[] temp = cmd.split(" ");
			if (temp[0].equals("createGameField")) {
				createGameField(temp);
			} else if (temp[0].equals("createGameField")) {
				createGameField(temp);
			} else if (temp[0].equals("addRoad")) {
				addRoad(temp);
			} else if (temp[0].equals("addChar")) {
				addChar(temp);
			} else if (temp[0].equals("print")) {
				print(temp);
			} else if (temp[0].equals("refresh")) {
				refresh(temp);
			} else if (temp[0].equals("addTower")) {
				addTower(temp);
			} else if (temp[0].equals("addTrap")) {
				addTrap(temp);
			} else if (temp[0].equals("useStone")) {
				useStone(temp);
			} else if (temp[0].equals("addStone")) {
				addStone(temp);
			} else if (temp[0].equals("addFog")) {
				addFog(temp);
			}

		}
	}

	// Functions for testing
	
	private static void addFog(String[] temp) {
		ArrayList<String> fields=new ArrayList<String>();
		fields.add(temp[1]);
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[1]))
				for (Visitable v : f.getVisitables()) {
					v.accept(new Weather(1,fields));
				}
		}

	}

	private static void addStone(String[] temp) {
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[1]))
				for (Visitable v : f.getVisitables()) {
					v.accept(new UpgradeVisitor(color));
				}
		}
	}

	private static void useStone(String[] temp) {
		color=Color.valueOf(temp[1]);

	}

	private static void addTrap(String[] temp) {
		Field trapField = null;
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[1]))
				trapField = f;
		}
		if (!trapField.isFree() || trapField.isRoad()) {
			System.out.println("Not a valid field");
		} else {
			Trap t = new Trap();
			trapField.getVisitables().add(t);
		}
	}

	private static void addTower(String[] temp) {
		Field towField = null;
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[1]))
				towField = f;
		}
		if (!towField.isFree() || towField.isRoad()) {
			System.out.println("Not a valid field");
		} else {
			Tower t = new Tower(10, towField, Integer.parseInt(temp[3]), 1);
			Updatable u = new UpdatableFactory().createUpdatable(t, towField);
			GameMaster.getInstance().addUpdatable(u);
			towField.getVisitables().add(t);
		}

	}

	private static void refresh(String[] temp) {
		int updateCount = Integer.parseInt(temp[1]);
		for (int i = 0; i < updateCount; i++) {
			GameMaster.getInstance().refreshUpdatables();
		}
	}

	private static void print(String[] temp) {
		
	}

	private static void addChar(String[] temp) {
		Species s = Species.valueOf(temp[1]);
		Field charField = null;
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[3]))
				charField = f;
		}
		if (!charField.isRoad())
			System.out.println("Error: F1 is not a valid position.");
		else {
			Character ch = new Character(s, Integer.parseInt(temp[2]),
					charField, 1);
			ch.setSpeed(Integer.parseInt(temp[5]));
			charField.addVisitable(ch);
			Updatable u = new CharacterMaster(ch);
			GameMaster.getInstance().addUpdatable(u);
		}
	}

	private static void addRoad(String[] temp) {
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[1])) {
				f.setRoad(true);
				Geometry.getInstance().getRoads()
						.get(Integer.parseInt(temp[2])).add(f);
			}
		}

	}

	public static void init() {
		// TODO - implement Application.init
		throw new UnsupportedOperationException();
	}

	public static int getMana() {
		return mana;
	}

	
	
	private static void createGameField(String[] args) {
		String[] fieldsize = args[1].split(":");
		ArrayList<Field> map = new ArrayList<Field>();
		for (int i = 1; i <= Integer.parseInt(fieldsize[0]); i++) {
			for (int j = 1; j <= Integer.parseInt(fieldsize[1]); j++) {
				map.add(new Field(new Point(i, j)));

			}
		}
		Geometry.getInstance().setMap(map);
	}

	// Reads the lines of a file, and returns a list of them
	private static List<String> readFile(File f) {
		List<String> list = new ArrayList<String>();
		File file = new File("file.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				list.add(text);
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
		return list;
	}

}
