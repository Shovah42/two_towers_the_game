
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tower extends Building implements Visitor, Visitable {

    private int damage;
    private Field field;
    private int speed;
    private List<Character> shootableCharacters;
    private int range;
    private String id;

    public void setId(String id) {
        this.id = id;
    }
    public void setColor(Color c) {
        super.setColor(c);
        System.out.println("Upgrading tower at "+field.getId()+" with current color.");
    }
    public String getId() {
        return id;
    }

    public void surroundWithFog(){
    	this.range=1;
    }
    
    public Tower() {
        this.damage = 10;
        this.speed = 30;
        this.range = 2;
        this.shootableCharacters = new ArrayList<Character>();
        this.id = IdCreator.getNextTowerId();
        this.setColor(Color.Colorless);
    }

    public Tower(int damage, Field field, int speed, int range) {
        this.damage = damage;
        this.field = field;
        this.speed = speed;
        this.range = range;
        this.shootableCharacters = new ArrayList<Character>();
        this.id = IdCreator.getNextTowerId();
        this.setColor(Color.Colorless);
        System.out.println("Successfully created a tower at "+this.field.getId()+" with speed: "+this.speed+".");
    }

    public void shoot() {
        // kornyezo mezook elkerese
        List<Field> fieldList = new ArrayList<Field>();
        fieldList = field.getNearByRoads(range);
        shootableCharacters.clear();
        // visitable objektumok vegigjarasa
        for (Field f : fieldList) {
            for (Visitable v : f.getVisitables()) {
                // shootablecharacters feltoltese visitorminta segitsegevel
                v.accept(this);
            }
        }
        boolean shot = false;
        // charakter kivalasztasa
        for (Character c : shootableCharacters) {
            // ha eddig nem lotunk egy karakterre se akkor lohetunk
            if (!shot) {
                shot = true;
                // specialis kettevalaszto lovedek sorsolasa
                double randNumber = Math.random();
                double d = randNumber * 100;
                int randomInt = (int) d + 1;
                if (randomInt > 5) {
                    // normal loves
                    c.hit(this.getColor());
                } else {
                    //specialis kettevalaszto lovedek lovese
                    Color coltmp = this.getColor();
                    this.setColor(Color.Black);
                    c.hit(this.getColor());
                    this.setColor(coltmp);
                }
            }
        }
    }

    public Field getField() {
        return this.field;
    }

    /**
     *
     * @param field
     */
    public void setField(Field field) {
        this.field = field;
    }

    public int getSpeed() {
        return this.speed;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Trap t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(Character c) {
        this.shootableCharacters.add(c);
    }

    @Override
    public void visit(Tower t) {
        // TODO Auto-generated method stub

    }

	@Override
	public void print(PrintWriter pw) {
		pw.append(this.id+"\n");
		pw.append("field: "+getField().getId()+"\n");
		pw.append("color:"+getColor().toString()+"\n");
		pw.append("speed:"+getSpeed()+"\n");
		pw.append("range:"+range+"\n");
		pw.append("damage:"+damage+"\n");
	}

}
