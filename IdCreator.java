
public class IdCreator {
	private static int fieldCounter=0;
	private static int towerCounter=0;
	private static int charCounter=0;
	private static int trapCounter=0;

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
