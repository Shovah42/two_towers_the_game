
public class IdCreator {
	private static int fieldCounter=1;
	private static int towerCounter=1;
	private static int charCounter=1;
	private static int trapCounter=1;

	public static String getNextFieldId(){
		return "F"+fieldCounter++;
		
	}
	public static String getNextCharacterId(){
		return "C"+charCounter++;
		
	}
	public static String getNextTowerId(){
		return "T"+towerCounter++;
		
	}
	public static String getNextTrapId(){
		
		return "Cs"+trapCounter++;
	}
}
