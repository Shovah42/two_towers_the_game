import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	private int mana;

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
		// TODO Auto-generated method stub

	}

	private static void addStone(String[] temp) {
		// TODO Auto-generated method stub

	}

	private static void useStone(String[] temp) {
		// TODO Auto-generated method stub

	}

	private static void addTrap(String[] temp) {
		// TODO Auto-generated method stub

	}

	private static void addTower(String[] temp) {
		// TODO Auto-generated method stub

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
		Species s = Species.valueOf(temp[0]);
		Field charField = null;
		for (Field f : Geometry.getInstance().getMap()) {
			if (f.getId().equals(temp[2]))
				charField = f;
		}
		if (!charField.isRoad())
			System.out.println("Error: F1 is not a valid position.");
		else {
			Character ch = new Character(s, Integer.parseInt(temp[1]),
					charField, 1);
			ch.setSpeed(Integer.parseInt(temp[4]));
			charField.addVisitable(ch);
			Updatable u = new CharacterMaster(ch);
			GameMaster.getInstance().addUpdatable(u);
		}
	}

	private static void addRoad(String[] temp) {
		for (Field f : Geometry.getInstance().getMap()) {
			if(f.getId().equals(temp[0])){
				f.setRoad(true);
				Geometry.getInstance().getRoads().get(Integer.parseInt(temp[1])).add(f);
			}
		}

	}

	public static void init() {
		// TODO - implement Application.init
		throw new UnsupportedOperationException();
	}

	public int getMana() {
		return this.mana;
	}

	/**
	 * 
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
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
