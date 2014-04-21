
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
        System.out.println("CALL class UpgradeVisitor method constructor");
    }

    public void setColor(Color color) {
        System.out.println("CALL class UpgradeVisitor method setColor(Color color)");
        this.color = color;
    }

    @Override
    public void visit(Trap t) {
        System.out.println("CALL class UpgradeVisitor method visit(Trap t)");
        t.setColor(this.color);
    }

    @Override
    public void visit(Character c) {
        System.out.println("CALL class UpgradeVisitor method visit(Character c)");

    }

    @Override
    public void visit(Tower t) {
        System.out.println("CALL class UpgradeVisitor method visit(Tower t)");
        t.setColor(this.color);
    }

}
