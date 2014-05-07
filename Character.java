
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A karakter osztaly.
 *
 * @author ComboBox
 */
public class Character implements Visitable, Visitor, Drawable {

    private final int dodge;
    private final int maxSpeed;

    private int health;
    private int speed;
    private int road;
    private Field field;
    private Species type;
    private Splitter spl;
    private String id;
    private CharacterView characterView;

    /**
     * A karakter parameteres konstruktora.
     *
     * @param type a karkater tipusa.
     * @param mspeed a karakter maximalis sebessege.
     * @param dodge a karkater lovedék elkerulesenek eselye (0-nem tud elkerulni
     * lovedeket, 100-minden lovedeket elkerul).
     * @param road a karkater utjanak szama.
     */
    public Character(Species type, int mspeed, int dodge, int road) {
        System.out.println("CALL class Character method konstruktor");
        this.maxSpeed = mspeed;
        this.road = road;
        this.dodge = dodge;
        this.type = type;
        this.id = IdCreator.getNextCharacterId();
        characterView = new CharacterView(this);
    }

    /**
     * A karakter parameteres konstruktora.
     *
     * @param type a karkater tipusa.
     * @param life a karkater eletereje.
     * @param f a karkater mezoje.
     * @param road a karkater utjanak szama.
     */
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
        this.field = f;
        characterView = new CharacterView(this);
        System.out.println("Successfully created a(n)" + this.type + " character at " + this.field.getId() + ".");
    }

    /**
     * Tartalmazza a karakter eleterejet. Ha 0 vagy annal kevesebb a karakter
     * halottnak tekintendo.
     *
     * @return a karakter eletereje.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Az adott karakter eletereje allithato be vele. Ha 0 vagy annal kevesebb a
     * karakter halottnak tekintendo.
     *
     * @param health a karakter uj eletereje.
     */
    public void setHealth(int health) {
        this.health = health;
        notifyView();
    }

    /**
     * Tartalmazza a karakter sebesseget. Minel nagyobb az erteke annal
     * lassabban lep a kövezkezo mezore.
     *
     * @return karakter sebessege.
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Az adott karakter sebessege allithato be vele. Minel nagyobb az erteke
     * annal lassabban lep a kövezkezo mezore.
     *
     * @param speed karakter uj sebessege.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
        notifyView();
    }

    /**
     * Tartalmazza a karakter utvonalat azonosito szamot.
     *
     * @return a kivalasztott utvonal szama.
     */
    public int getRoad() {
        return road;
    }

    /**
     * Az adott karakter utvonalat allithato be vele. Az utak egy pozitiv egesz
     * szammal azonosithatok.
     *
     * @param road a karakter uj ut azonositoszama.
     */
    public void setRoad(int road) {
        this.road = road;
        notifyView();
    }

    /**
     * Tartalmazza azon mezot, amelyen a karakter eppen tartozkodik.
     *
     * @return azon mezo, amelyen a karakter eppen tartozkodik.
     */
    public Field getField() {
        return this.field;
    }

    /**
     * Az adott karakter mezoje allithato be vele.
     *
     * @param field a karakter uj mezoje.
     */
    public void setField(Field field) {
        this.field = field;
        notifyView();
    }

    /**
     * Tartalmazza a karakter tipusat. Lehet Hobbit, Elf, Human, Dwarf.
     *
     * @return a karakter tipusa.
     */
    public Species getType() {
        return this.type;
    }

    /**
     * Az adott karakter tipusa allithato be vele. Lehet Hobbit, Elf, Human,
     * Dwarf.
     *
     * @param type a karakter uj tipusa.
     */
    public void setType(Species type) {
        this.type = type;
        notifyView();
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a karakter kap id-t.
     *
     * @return az adott id szama.
     */
    public String getId() {
        return id;
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a karakter kap id-t.
     * Ezen id beallithato a snapshot helyreallitasahoz.
     *
     * @param id a karakter uj id erteke.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A karakter mozgatasaert felelos fuggveny.
     */
    public void move() {
        List<Field> fieldList = this.getField().getNearByRoads(1);
        if (fieldList.size() > 1) {
            List<Integer> roadIds = new ArrayList<Integer>();
            List<Field> possibleFields = new ArrayList<Field>();
            // elagazashoz ertunk
            this.getField().execute(this);
            Random gen = new Random();

            for (Field field : fieldList) {
                if (field != null) {
                    possibleFields.add(field);
                    roadIds.add(fieldList.indexOf(field));
                }
            }
            int i = gen.nextInt(possibleFields.size());
            if (fieldList.size() > 1) {
                this.setField(fieldList.get(i));
                fieldList.get(i).addVisitable(this);
                this.setRoad(roadIds.get(i));
            } else {
                System.out.println("Game over, character reached the end of a road. ");
            }

        } else {
            // nem elagazas
            this.getField().execute(this);
            if (fieldList.size() < 1) {
                System.out.println("Game over, character reached the end of a road. ");
            } else {
                this.setField(fieldList.get(0));
                fieldList.get(0).addVisitable(this);
            }
        }
        // speed reseteles
        this.setSpeed(maxSpeed);
        // csapdaba lepes visitorminta segitsegevel
        for (Visitable v : this.getField().getVisitables()) {
            v.accept(this);
        }
    }

    /**
     * A karakter sebzeseert felelos fuggveny.
     *
     * @param color a lovedek (Torony) szine, amely a karaktert meglotte.
     */
    public void hit(Color color) {
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
            if (color == Color.Red) {
                // altalanos sebzes noveles
                damage = baseDamage + smallIncrease;
            } else if (color == Color.Green && this.type == Species.Dwarf) {
                // torpe es torpe ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (color == Color.Blue && this.type == Species.Human) {
                // ember es ember ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (color == Color.Yellow && this.type == Species.Elf) {
                // elf es elf ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (color == Color.Purple && this.type == Species.Hobbit) {
                // hobbit es hobbit ellen hatasos kovel ven upgradelve
                damage = baseDamage + hugeIncrease;
            } else if (color == Color.Black) {
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
                // halal eseten karakter eltuntetese
                this.getField().execute(this);
            }
        }
    }

    /**
     * A karakter csapdat meglatogato fuggvenye.
     *
     * @param trap a meglatogatni kivant csapda.
     */
    @Override
    public void visit(Trap trap) {
        // csapda hatása erre a karakterre
        trap.effectCharacter(this);
    }

    /**
     * A karakter karaktert meglatogato fuggvenye. Jelen specifikacio es
     * implemetalas alapjan soha nem kerulhet meghivasra.
     *
     * @param character a meglatogatni kivant karakter.
     */
    @Override
    public void visit(Character character) {
        // ilyen eset nincs
    }

    /**
     * A karakter tornyot meglatogato fuggvenye. Jelen specifikacio es
     * implemetalas alapjan soha nem kerulhet meghivasra.
     *
     * @param tower a meglatogatni kivant torony.
     */
    @Override
    public void visit(Tower tower) {
        // ilyen eset nincs
    }

    /**
     * A karakter vizitornak onmagat atado fuggvenye.
     *
     * @param visitor a meglatogatni kivant elem.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * A karakter fontosabb adatainak logolasara szolgalo fuggveny.
     *
     * @param pw a fileba mentest szolgalo printwriter.
     */
    @Override
    public void print(PrintWriter pw) {
        System.out.println(getId());
        pw.append(getId() + "\n");
        System.out.println("life: " + getHealth());
        pw.append("life: " + getHealth() + "\n");
        System.out.println("speed: " + getSpeed());
        pw.append("speed:" + getSpeed() + "\n");
        System.out.println("field: " + getField().getId());
        pw.append("field: " + getField().getId() + "\n");
    }

    @Override
    public void attach(View v) {
       
    }

    @Override
    public void detach(View v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyView() {
        
    }

}
