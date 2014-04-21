
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Skeleton {

    public void upgradeBuilding() {
        Geometry.getInstance().getFieldOfCoordinate(new Point());
        Field field = new Field();
        Color color = Color.Green;
        System.out.println();
        System.out.println("Create uvisitor");
        UpgradeVisitor uvisitor = new UpgradeVisitor();
        uvisitor.setColor(color);
        field.upgradeBuilding(uvisitor);
    }

    public void buildTrap() {
        Geometry.getInstance().getFieldOfCoordinate(new Point());
        Field field = new Field();
        field.build();
    }

    public void buildTower() {
        Geometry.getInstance().getFieldOfCoordinate(new Point());
        Field field = new Field();
        Tower t = new Tower();
        UpdatableFactory uFactory = new UpdatableFactory();
        GameMaster.getInstance().addUpdatable(uFactory.createUpdatable(t, field));
    }

    public void move() {
        Character character = new Character(null, 0, 0, 0);
        Field field1 = new Field();
        Field field2 = new Field();
        character.move();
        field1.getNearByRoads(1);
        field2 = Geometry.getInstance().getNextField(field1, 1);
        character.setField(field2);
        field2.getVisitables();
        Trap trap = new Trap();
        trap.accept(character);
        trap.effectCharacter(character);
    }

    public void towerShoot() {
        System.out.println("Initialization");
        Point pointTower = new Point();
        pointTower.x = 1;
        pointTower.y = 1;

        Point pointField1 = new Point();
        pointField1.x = 2;
        pointField1.y = 2;
        Point pointField2 = new Point();
        pointField2.x = 1;
        pointField2.y = 2;
        Field field1 = new Field();
        Field field2 = new Field();

        Field towerField = new Field();
        List<Field> map = new ArrayList<Field>();

        field1.setPosition(pointField1);
        field2.setPosition(pointField2);

        towerField.setPosition(pointTower);
        Tower tower = new Tower();
        tower.setField(towerField);
        towerField.setFree(false);
        towerField.setRoad(false);

        field1.setFree(true);
        field1.setRoad(false);
        field2.setFree(true);
        field2.setRoad(false);
        tower.setColor(Color.Red);

        Geometry geo = Geometry.getInstance();
        geo.setMap(map);
        System.out.println("Initialization end");

        tower.shoot();
    }

    public void towerKills() {
        System.out.println("Initialization");
        Color c = Color.Red;
        Character ch = new Character(Species.Hobbit, 0, 0, 0);
        Field f = new Field();
        ch.setField(f);
        System.out.println("Initialization end");
        ch.hit(c);

    }

    void characterDies() {
        System.out.println("Initialization");
        Character character = new Character(null, 0, 0, 0);
        CharacterMaster cm = new CharacterMaster(character);
        character.setHealth(0);
        System.out.println("Character health is 0");
        GameMaster.getInstance().addUpdatable(cm);
        GameMaster.getInstance().refreshUpdatables();
        System.out.println("Test Done!");
    }

    void createCharacter() {
        System.out.println("Initialization");
        int road = 1;
        Geometry.getInstance().getFieldOfCoordinate(new Point());
        Field field = new Field();
        UpdatableFactory uFactory = new UpdatableFactory();
        GameMaster.getInstance().addUpdatable(uFactory.createUpdatable(Species.Elf,100,field,road));
        System.out.println("Test Done!");
    }
}
