
public class CharacterMaster implements Updatable {

    private Character figure;
    private int tickCount;

    public CharacterMaster(Character tm) {
        this.figure = tm;
        this.tickCount = 0;
    }

    public Character getFigure() {
        return this.figure;
    }

    /**
     *
     * @param figure
     */
    public void setFigure(Character figure) {
        this.figure = figure;
    }

    @Override
    public boolean update() {
        if (this.figure.getHealth() <= 0) {
            return false;
        }
        if (this.tickCount++ >= this.figure.getSpeed()) {
            this.figure.move();
            this.tickCount = 0;
        }
        return true;
    }

}
