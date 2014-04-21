
public class TowerMaster implements Updatable {

    private Tower tower;
    private int tickCount;

    public TowerMaster(Tower tm) {
        System.out.println("CALL class TowerMaster method TowerMaster(Tower tm)");
        this.tower = tm;
    }

    public Tower getTower() {
        return this.tower;
    }

    /**
     *
     * @param tower
     */
    public void setTower(Tower tower) {
        this.tower = tower;
    }

    @Override
    public boolean update() {
        tickCount++;
        if (tickCount >= tower.getSpeed()) {
            tickCount = 0;
            tower.shoot();
        }
        return false;
    }

}
