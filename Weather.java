import java.util.List;

public class Weather implements Updatable, Visitor {

	private int tickCount;
	private int frequency;
	List<String> fields;

	public Weather(int frequency, List<String> fields) {
		this.frequency = frequency;
		this.fields = fields;
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
		t.surroundWithFog();
	}

	@Override
	public boolean update() {
		tickCount++;
		if (tickCount >= frequency)
			for (Field f : Geometry.getInstance().getMap()) {
				if (fields.contains(f.getId()))
					for (Visitable v : f.getVisitables()) {

						v.accept(this);
					}
			}
		return false;
	}

}
