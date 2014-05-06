
import java.awt.Point;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A mezo osztaly.
 *
 * @author ComboBox
 */
public class Field implements Monitor, Drawable {

    private Point position;
    private boolean free;
    private boolean road;
    private RoadManager roadmanager;
    private List<Visitable> visitables;
    private String id;

    /**
     * A mezo parameter nelkuli konstruktora.
     */
    public Field() {
        this.visitables = new ArrayList<Visitable>();
        this.roadmanager = Geometry.getInstance();
        this.free = true;
        this.id = IdCreator.getNextFieldId();
    }

    /**
     * A mezo parameteres konstruktora.
     *
     * @param pos az adott mezo pozicioja.
     */
    public Field(Point pos) {
        this.visitables = new ArrayList<Visitable>();
        this.roadmanager = Geometry.getInstance();
        this.free = true;
        this.position = pos;
        this.id = IdCreator.getNextFieldId();
    }

    /**
     * Jelzi, hogy az adott mezo szabad-e. Egy mezo akkor szabad, ha nincs rajta
     * epitmeny(Tower vagy Trap).
     *
     * @return true, ha szabad kulonben false.
     */
    public boolean isFree() {
        return this.free;
    }

    /**
     * Az adott mezo szabad attributuma allithato be vele.
     *
     * @param free szabad attributum uj erteke.
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * Jelzi, hogy az adott mezo ut-e. Egy mezo akkor ut, ha ra a karakter tud
     * lepni. Amennyiben ut akkor csapda (Trap) rakhato ra, ha nem akkor torony
     * (Tower) rakhato ra.
     *
     * @return ut-e.
     */
    public boolean isRoad() {
        return this.road;
    }

    /**
     * Az adott mezo ut attributuma allithato be vele.
     *
     * @param road ut attributum uj erteke.
     */
    public void setRoad(boolean road) {
        this.road = road;
    }

    /**
     * A mezo poziciojat szamon tarto attributum.
     *
     * @return Point a mezo pozicioja.
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * A mezo poziciojanak beallitasara szolgalo attributum.
     *
     * @param position a mezo uj pozicioja (Point).
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a mezo kap id-t.
     *
     * @return az adott id szama.
     */
    public String getId() {
        return id;
    }

    /**
     * A sanpshotkeszites soran a konnyu azonositas vegett a mezo kap id-t. Ezen
     * id beallithato a snapshot helyreallitasahoz.
     *
     * @param id a mezo uj id erteke.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A mezo altal tartalmazott meglatogathato objektumok listaja.
     *
     * @return a meglatogathato objektumok listaja.
     */
    public List<Visitable> getVisitables() {
        return this.visitables;
    }

    /**
     * A mezhoz tartozo vizitor listahoz uj elem hozzaadasa.
     *
     * @param v az uj vizitalhato elem.
     */
    public void addVisitable(Visitable v) {
        this.visitables.add(v);
    }

    /**
     * A mezo meglatogathato objektumai kozul eltavolitja a parameterkent
     * megadott karaktert.
     *
     * @param c az eltavolitando karakter.
     */
    public void execute(Character c) {
        this.getVisitables().remove(c);

    }

    //    /**
//     * A mezon epitmenyek epiteset vegzo fuggveny.
//     */
//    public void build() {
//        if(this.isFree()){
//            if (this.isRoad()){
//                Trap t = new Trap();
//                this.addVisitable(t);
//            }else{
//                
//                Tower t = new Tower();
//                TowerMaster tm = new TowerMaster(t);
//                this.addVisitable(t);
//            }
//        }
//        
//    }
    /**
     * A mezo kozelben levo utal elkeresere szolgalo fuggveny.
     *
     * @param i a mezo i sugaru kornyezeteben kerulnek az utak elkeresre.
     * @return mezolista mely tartalmazz az i sugarban talalhato utakat.
     */
    public List<Field> getNearByRoads(int i) {
        List<Field> fieldList = new ArrayList<Field>();
        if (this.isRoad()) {
            fieldList = roadmanager.getNextField(this, i);
        } else {
            fieldList = roadmanager.getRoadsInRange(this, i);
        }
        return fieldList;
    }

    /**
     *
     * @param uvisitor
     */
    public void upgradeBuilding(UpgradeVisitor uvisitor) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!(s.equals("tower") || s.equals("trap"))) {
            s = sc.nextLine();
        }
        if (s.equals("tower")) {
            this.visitables.add(new Tower());
        } else {
            this.visitables.add(new Trap());
        }

        this.getVisitables().get(0).accept(uvisitor);
        sc.close();
    }

    @Override
    public void print(PrintWriter pw) {
        for (Visitable vis : getVisitables()) {
            vis.print(pw);
        }
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
