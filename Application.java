
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private int mana;
    
    public void run() {
        // TODO - implement Application.run
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
    	File file=new File("test"+args[0]+".txt");
    	List<String> commands=readFile(file);
    	//parsing the input language
    	//and calling the appropriate test methods
    	for (String cmd : commands) {
			String[] temp=cmd.split(" ");
			if(temp[0].equals("createGameField")){
				createGameField(temp);
			}
			else if(temp[0].equals("createGameField")){
				createGameField(temp);
			}
			else if(temp[0].equals("addRoad")){
				addRoad(temp);
			}else if(temp[0].equals("addChar")){
				addChar(temp);
			}else if(temp[0].equals("print")){
				print(temp);
			}else if(temp[0].equals("refresh")){
				refresh(temp);
			}else if(temp[0].equals("addTower")){
				addTower(temp);
			}else if(temp[0].equals("addTrap")){
				addTrap(temp);
			}else if(temp[0].equals("useStone")){
				useStone(temp);
			}else if(temp[0].equals("addStone")){
				addStone(temp);
			}else if(temp[0].equals("addFog")){
				addFog(temp);
			}
			
    	}
    }
    //Functions for testing


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
		// TODO Auto-generated method stub
		
	}

	private static void print(String[] temp) {
		// TODO Auto-generated method stub
		
	}

	private static void addChar(String[] temp) {
		// TODO Auto-generated method stub
		
	}

	private static void addRoad(String[] temp) {
		// TODO Auto-generated method stub
		
	}

	public void init() {
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
    
    private static void createGameField(String[] args){
    	
    }
    
    //Reads the lines of a file, and returns a list of them
    private static List<String> readFile(File f){
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
