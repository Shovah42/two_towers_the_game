
/**
 * Az epitmeny osztaly. Belole szarmazik le a torony (Tower) es a csapda (Trap)
 * osztaly. Kozos attributumaik: Szin (Color).
 *
 * @author ComboBox
 */
public abstract class Building {

    private Color color;

    /**
     * Az epitmenyek (Tower, Trap) szinet tarolo attributum erteke. Lehet Red,
     * Green, Blue, Yellow, Purple, Pink, Colorless, Black.
     *
     * @return az epitmeny szine.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Az epitmenyek (Tower, Trap) szinet beallito fuggveny. Lehet Red, Green,
     * Blue, Yellow, Purple, Pink, Colorless, Black.
     *
     * @param color az epitmeny uj szine.
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
