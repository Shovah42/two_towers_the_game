
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * A torony osztaly.
 *
 * @author ComboBox
 */
public class Tower extends Building implements Visitor, Visitable, Drawable {

    private int range;
    private int speed;
    private Field field;
    private List<Character> shootableCharacters;
    private String id;

    /**
     * A torony osztaly parameter nelkuli konstruktora.
     */
    public Tower() {
        this.range = 2;
        this.speed = 30;
        this.setColor(Color.Colorless);
        this.shootableCharacters = new ArrayList<Character>();
        this.id = IdCreator.getNextTowerId();
    }

    /**
     * A torny osztaly parameteres konstruktora.
     *
     * @param field a torony mezeje.
     * @param speed a torny sebessege.
     * @param range a torny hatotavolsaga.
     */
    public Tower(Field field, int speed, int range) {
        this.range = range;
        this.speed = speed;
        this.field = field;
        this.setColor(Color.Colorless);
        this.shootableCharacters = new ArrayList<Character>();
        this.id = IdCreator.getNextTowerId();

    }

    /**
     * A torony hatotavolsaga.
     *
     * @return a torony hatotavolsaga.
     */
    public int getRange() {
        return range;
    }

    /**
     * A totony hatotavolsaganak beallitasa.
     *
     * @param range a torony uj taotavolsaga.
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * A torony lovesi sebessegenek beallitasa. Minel nagyobb az erteke annal
     * lassabban tuzel az adott torony.
     *
     * @return lovesi sebessege.
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * A torny tuzelelesi sebessegenek beallitasa. Minel nagyobb az erteke annal
     * lassabban tuzel a torony.
     *
     * @param speed a torony uj tuzelesi sebessege.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * A torony mezejenek elkerese.
     *
     * @return a toeony mezoje.
     */
    public Field getField() {
        return this.field;
    }

    /**
     * A torony mezojenek beallitasa.
     *
     * @param field a torony uj mezoje.
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a torony kap id-t.
     *
     * @return az adott id szama.
     */
    public String getId() {
        return id;
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a torony kap id-t.
     * Ezen id beallithato a snapshot helyreallitasahoz.
     *
     * @param id a torony uj id erteke.
     */
    public void setId(String id) {
        this.id = id;
    }

    public void surroundWithFog() {
        this.range = 1;
    }

    /**
     * A torny tuzeleseert felelos fuggveny.
     */
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

    /**
     * A torony vizitornak onmagat atado fuggvenye.
     *
     * @param visitor a meglatogatni kivant elem.
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    /**
     * A torony csapdat meglatogato fuggvenye.
     *
     * @param trap a meglatogatni kivant csapda.
     */
    @Override
    public void visit(Trap trap) {
        // TODO Auto-generated method stub

    }

    /**
     * A torony karaktert meglatogato fuggvenye.
     *
     * @param character a meglatogatni kivant karakter.
     */
    @Override
    public void visit(Character character) {
        this.shootableCharacters.add(character);
    }

    /**
     * A torony tornyot meglatogato fuggvenye.
     *
     * @param tower a meglatogatni kivant torony.
     */
    @Override
    public void visit(Tower tower) {
        // TODO Auto-generated method stub

    }

    @Override
    public void print(PrintWriter pw) {
        System.out.println(this.id);
        pw.append(this.id + "\n");
        System.out.println("field: " + getField().getId());
        pw.append("field: " + getField().getId() + "\n");
        System.out.println("color:" + getColor().toString());
        pw.append("color: " + getColor().toString() + "\n");
        System.out.println("speed: " + getSpeed());
        pw.append("speed: " + getSpeed() + "\n");
        System.out.println("range: " + range);
        pw.append("range: " + range + "\n");
    }

    @Override
    public void attach(View v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach(View v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
