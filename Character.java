
public class Character implements Visitable, Visitor {

    private Field field;
    private int speed;
    private boolean speedChanged;
    private int dodge;
    private Species type;
    private final int maxSpeed;
    private int health;
    private int road;
    private Splitter spl;
    private String id;

    public Character(Species type, int mspeed, int dodge, int road) {
        System.out.println("CALL class Character method konstruktor");
        this.maxSpeed = mspeed;
        this.road = road;
        this.dodge = dodge;
        this.type = type;
        this.id=IdCreator.getNextCharacterId();
    }

    public Character(Species type, int life, Field f, int road) {
        if (type == Species.Dwarf) {
            this.maxSpeed = 25;
            this.road = road;
            this.health = life;
            this.dodge = 0;
            this.type = type;
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
            this.dodge = 20;
            this.type = type;
        } else {
            //Humman
            this.maxSpeed = 20;
            this.road = road;
            this.health = life;
            this.dodge = 0;
            this.type = type;
        }
        this.id=IdCreator.getNextCharacterId();
        System.out.println("Successfully created a(n)"+this.type+" character at "+this.field+".");
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
 //       System.out.println("CALL class Character method move");

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

    public void kill() {
        // TODO - implement Character.kill
        throw new UnsupportedOperationException();
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
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(Character c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(Tower t) {
        // TODO Auto-generated method stub

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

}
