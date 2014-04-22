
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Character implements Visitable, Visitor {

    private Field field;
    private int speed;
    private int dodge;
    private Species type;
    private final int maxSpeed;
    private int health;
    private int road;

    public int getRoad() {
        return road;
    }

    public void setRoad(int road) {
        this.road = road;
    }
    private Splitter spl;
    private String id;

    public Character(Species type, int mspeed, int dodge, int road) {
        System.out.println("CALL class Character method konstruktor");
        this.maxSpeed = mspeed;
        this.road = road;
        this.dodge = dodge;
        this.type = type;
        this.id = IdCreator.getNextCharacterId();
    }

    public Character(Species type, int life, Field f, int road) {
        if (type == Species.Dwarf) {
            this.maxSpeed = 25;
            this.road = road;
            this.health = life;
            this.dodge = 0;
            this.type = type;
            this.field = f;
        } else if (type == Species.Elf) {
            this.maxSpeed = 15;
            this.road = road;
            this.health = life;
            this.field = f;
            this.dodge = 0;
            this.type = type;
        } else if (type == Species.Hobbit) {
            this.maxSpeed = 25;
            this.road = road;
            this.health = life;
            this.dodge = 10;
            this.type = type;
            this.field = f;
        } else {
            //Humman
            this.maxSpeed = 20;
            this.road = road;
            this.health = life;
            this.dodge = 0;
            this.type = type;
            this.field = f;
        }
        this.speed = this.maxSpeed;
        this.id = IdCreator.getNextCharacterId();
        this.field=f;
        System.out.println("Successfully created a(n)" + this.type + " character at " + this.field.getId() + ".");
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

    public void move() {
        List<Field> fieldList = this.getField().getNearByRoads(1);
        if (fieldList.size() > 1) {
            List<Integer> roadIds=new ArrayList<Integer>();
            List<Field> possibleFields=new ArrayList<Field>();
        	// elagazashoz ertunk
            this.getField().execute(this);
            Random gen=new Random();
            
            for (Field field : fieldList) {
				if(field!=null){
					possibleFields.add(field);
					roadIds.add(fieldList.indexOf(field));
				}
			}
            int i = gen.nextInt(possibleFields.size());
            this.setField(fieldList.get(i));
            fieldList.get(i).addVisitable(this);
            this.setRoad(roadIds.get(i));
            
        } else {
            // nem elagazas
            this.getField().execute(this);
            this.setField(fieldList.get(0));
            fieldList.get(0).addVisitable(this);
        }
        // speed reseteles
        this.setSpeed(maxSpeed);
        // csapdaba lepes visitorminta segitsegevel
        for (Visitable v : this.getField().getVisitables()) {
            v.accept(this);
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
//        System.out.println("CALL class Character method setField(Field field)");
        this.field = field;
    }

    public int getHealth() {
        return this.health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    public Species getType() {
        return this.type;
    }

    /**
     *
     * @param type
     */
    public void setType(Species type) {
        this.type = type;
    }

    /**
     *
     * @param c
     */
    public void hit(Color c) {
        //sebzesek inicializalasa
        int damage = 0;
        int baseDamage = 20;
        int smallIncrease = 10;
        int hugeIncrease = 20;
        //dodge szamitasa
        double randNumber = Math.random();
        double d = randNumber * 100;
        int randomInt = (int) d + 1;
        if (randomInt > dodge) {
            //ha nem tudott dodgeolni
            if (c == Color.Red) {
                // altalanos sebzes noveles
                damage = baseDamage + smallIncrease;
            } else if (c == Color.Green && this.type == Species.Dwarf) {
                // torpe es torpe ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (c == Color.Blue && this.type == Species.Human) {
                // ember es ember ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (c == Color.Yellow && this.type == Species.Elf) {
                // elf es elf ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (c == Color.Purple && this.type == Species.Hobbit) {
                // hobbit es hobbit ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (c == Color.Black) {
                // kettevago lovedek
                spl.createSplitted(type, this.getHealth() / 2, field, this.road);
                damage = this.getHealth() / 2;
            } else {
                // minden mas esetben
                damage = baseDamage;
            }
            // eletero beallitasa
            this.setHealth((this.getHealth() - damage));
            if (this.getHealth() <= 0) {
                // halal eseten eltuntetese
                this.getField().execute(this);
            }
        }
    }

    @Override
    public void visit(Trap t) {
        // csapda hatása erre a karakterre
        t.effectCharacter(this);
    }

    @Override
    public void visit(Character c) {
        // ilyen eset nincs
    }

    @Override
    public void visit(Tower t) {
        // ilyen eset nincs
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	@Override
	public void print(PrintWriter pw) {
		pw.append(getId()+"\n");
		pw.append("life:"+getHealth()+"\n");
		pw.append("speed:"+getSpeed()+"\n");
		pw.append("field:"+getField().getId()+"\n");
	}

    public void visit(java.lang.Character c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
