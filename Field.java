
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Field {

    private Point position;
    private boolean free;
    private boolean road;
    private RoadManager roadmanager;
    private List<Visitable> visitables;
    private String id;

    public Field(Point pos) {
        this.visitables = new ArrayList<Visitable>();
        this.roadmanager = Geometry.getInstance();
        this.free=true;
        this.position=pos;
        this.id=IdCreator.getNextFieldId();
    }
    public Field() {
        this.visitables = new ArrayList<Visitable>();
        this.roadmanager = Geometry.getInstance();
        this.free=true;
        this.id=IdCreator.getNextFieldId();
    }

    public boolean isFree() {
        return this.free;
    }

    public void build() {
        System.out.println("CALL class Field method build()");
        Trap t = new Trap();
        this.addVisitable(t);
    }

    public boolean isRoad() {
        return this.road;
    }

    /**
     *
     * @param free
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     *
     * @param road
     */
    public void setRoad(boolean road) {
        this.road = road;
    }

    public Point getPosition() {
        return this.position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     *
     * @param i
     * @return
     */
    public List<Field> getNearByRoads(int i) {
        List<Field> fieldList = new ArrayList<Field>();
        Field field;
        if (this.isRoad()) {
            field = roadmanager.getNextField(this, i);
            fieldList.add(field);
        } else {
            fieldList = roadmanager.getRoadsInRange(this, i);
        }
        return fieldList;
    }

    /**
     *
     * @param c
     */
    public void execute(Character c) {
        this.getVisitables().remove(c);
    }

    public List<Visitable> getVisitables() {
        System.out.println("CALL class Field method getVisitables()");
        System.out.println("Return Visitables");
        return this.visitables;
    }

    public void upgradeBuilding(UpgradeVisitor uvisitor) {
        System.out.println("CALL class Field method upgradeBuilding(UpgradeVisitor uvisitor)");
        System.out.println("Do you want to upgrade a tower of a trap? (tower/trap)");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!(s.equals("tower") || s.equals("trap"))) {
            System.out.println("Do you want to upgrade a tower of a trap? (tower/trap)");
            s = sc.nextLine();
        }
        if (s.equals("tower")) {
            this.visitables.add(new Tower());
        } else {
            this.visitables.add(new Trap());
        }

        this.getVisitables().get(0).accept(uvisitor);
    }

    /**
     *
     * @param v
     */
    public void addVisitable(Visitable v) {
        // TODO - implement Field.addVisitable
        System.out.println("CALL class Field method addVisitable(Visitable v)");
        this.visitables.add(v);
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
