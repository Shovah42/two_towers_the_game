
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Tower extends Building implements Visitor, Visitable {

    private int damage;
    private Field field;
    private int speed;
    private List<Character> shootableCharacters;
    private int range;

    public Tower() {
        System.out.println("CALL class Tower method Tower()");
        this.shootableCharacters = new ArrayList<Character>();
    }

    public Tower(int damage, Field field, int speed, int range) {
        System.out.println("CALL class Tower method Tower()");
        this.damage = damage;
        this.field = field;
        this.speed = speed;
        this.range = range;
        this.shootableCharacters = new ArrayList<Character>();

    }

    public void shoot() {
        System.out.println("CALL class Tower method shoot()");
        List<Field> fieldList = new ArrayList<Field>();
        fieldList = field.getNearByRoads(range);
        shootableCharacters.clear();
        //Mivela list ütes csinálunk 1 olyan fildet amire tud lőni a bemutatás végett
        Point pointRoad = new Point();
        pointRoad.x = 2;
        pointRoad.y = 1;
        Field roadField = new Field();
        roadField.setPosition(pointRoad);
        roadField.setFree(true);
        roadField.setRoad(true);
        Character ch = new Character(Species.Hobbit, 0, 0, 0);
        System.out.println("An another init Call will run now (addVisitable)"); 
        System.out.println("Because getRoadsInRange() not implemented yet");
        roadField.addVisitable(ch);
        ch.setField(roadField);
        ch.setHealth(10);
        roadField.getVisitables().get(0).accept(this);
        for (Character c : shootableCharacters) {
            System.out.println("CALLING the character hit method, shoot now done");
            //c.hit(Color.Red);
            break;
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
        System.out.println("CALL class Tower method setField(Field field)");
        this.field = field;
    }

    public void getSpeed() {
        // TODO - implement Tower.getSpeed
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void iShootYou() {
        // TODO - implement Tower.iShootYou
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor v) {
        System.out.println("alt Visitable==Tower");
        System.out.println("CALL class Tower method accept(Visitor v)");
        v.visit(this);
    }

    @Override
    public void visit(Trap t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(Character c) {
        // TODO Auto-generated method stub
        System.out.println("CALL class Tower method visit(Character c)");
        System.out.println("shootableCharacters.add(c)");
        this.shootableCharacters.add(c);
       
    }

    @Override
    public void visit(Tower t) {
        // TODO Auto-generated method stub
        
    }

}
