
/**
 * Egy adott toronyert felelos torony mester osztaly.
 *
 * @author ComboBox
 */
public class TowerMaster implements Updatable {

    private Tower tower;
    private int tickCount;

    /**
     * A torony mester parameteres konstruktora.
     *
     * @param tower a torony master altal menedzselt torony
     */
    public TowerMaster(Tower tower) {
        this.tower = tower;
    }

    /**
     * A torony mester altal menedzsel torony.
     *
     * @return menedzselt torony.
     */
    public Tower getTower() {
        return this.tower;
    }

    /**
     * A torony mester altal menedzselt torony beallitasa.
     *
     * @param tower az uj menedzselt torony.
     */
    public void setTower(Tower tower) {
        this.tower = tower;
    }

    /**
     * A torony mester altal menedzselt torony frissiteseert (lovesert) felelos
     * fuggveny.
     *
     * @return mindig igaz.
     */
    @Override
    public boolean update() {
        tickCount++;
        if (tickCount >= tower.getSpeed()) {
            tickCount = 0;
            tower.shoot();
        }
        return true;
    }

}
