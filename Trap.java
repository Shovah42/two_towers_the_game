import java.io.PrintWriter;


public class Trap extends Building implements Visitable {
	String id;
    public Trap() {
    	id=IdCreator.getNextTrapId();
    	this.setColor(Color.Colorless);
    	System.out.println("Successfully created a trap with color: "+this.getColor().toString());
    }

    /**
     *
     * @param character
     */
    public void effectCharacter(Character character) {
        character.setSpeed(character.getSpeed()-1);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }

	@Override
	public void print(PrintWriter pw) {
                System.out.println(id);
		pw.append(id+"\n");
                System.out.println("color: "+getColor());
		pw.append("color: "+getColor()+"\n");
		
	}

}
