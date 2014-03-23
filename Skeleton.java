import java.awt.Point;


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
}
