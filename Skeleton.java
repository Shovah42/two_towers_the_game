import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Skeleton {
	public void upgradeBuilding(){
		Geometry.getInstance().getFieldOfCoordinate(new Point());
		Field field=new Field();
		Color color= Color.Green;
		System.out.println();
		System.out.println("Create uvisitor");
		UpgradeVisitor uvisitor=new UpgradeVisitor();
		uvisitor.setColor(color);
		field.upgradeBuilding(uvisitor);
	}
	public void buildTrap(){
		Geometry.getInstance().getFieldOfCoordinate(new Point());
		Field field=new Field();
		field.build();
	}
	public void buildTower(){
		Geometry.getInstance().getFieldOfCoordinate(new Point());
		Field field=new Field();
		Tower t=new Tower();
		UpdatableFactory uFactory=new UpdatableFactory();
		GameMaster.getInstance().addUpdatable(uFactory.createUpdatable(t, field));
	}
	public void towerShoot(){
                Point pointTower = new Point();
                pointTower.x=1;
                pointTower.y=1;
                
                Point pointField1 = new Point();
                pointField1.x=2;
                pointField1.y=2;
                Point pointField2 = new Point();
                pointField2.x=1;
                pointField2.y=2;
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
		
                
		tower.shoot();
	}
	public void towerKills(){
		Color c =Color.Red;
		Character ch = new Character(Species.Hobbit,0,0,0);
		Field f = new Field();
                ch.setField(f);
		ch.hit(c);
		
	}
}
