
/**
 * Egy adott karakterert felelos karakter mester osztaly.
 *
 * @author ComboBox
 */
public class CharacterMaster implements Updatable {

    private Character character;
    private int tickCount;

    /**
     * A karakter mester osztaly parameteres konstruktora.
     *
     * @param character a karakter master ezen karakterert felelos.
     */
    public CharacterMaster(Character character) {
        this.character = character;
        this.tickCount = 0;
    }

    /**
     * A karakter mester altal menedzselt karakter.
     *
     * @return menedzselt karakter.
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * A karakter mester, mely karaktert legyen felelos.
     *
     * @param character az uj menedzselt karakter.
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * A karakter mester altal menedzselt karakter frissiteseert (lepteteseert)
     * felelos fuggveny.
     *
     * @return false, ha az adott karater meghalt, kulonben igaz.
     */
    @Override
    public boolean update() {
        if (this.character.getHealth() <= 0) {
            return false;
        }
        this.tickCount = this.tickCount + 1;
        if (this.tickCount >= this.character.getSpeed()) {
            this.character.move();
            this.tickCount = 0;
        }
        return true;
    }

}
