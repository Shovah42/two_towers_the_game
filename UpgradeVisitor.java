public class UpgradeVisitor implements Visitor {

	private Color color;

	public Color getColor() {
		return this.color;
	}

	/**
	 * 
	 * @param color
	 */
	public UpgradeVisitor() {
	}

	public UpgradeVisitor(Color c) {
		color = c;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void visit(Trap t) {
		t.setColor(this.color);
	}

	@Override
	public void visit(Character c) {
		
	}

	@Override
	public void visit(Tower t) {
		t.setColor(this.color);
	}

}
