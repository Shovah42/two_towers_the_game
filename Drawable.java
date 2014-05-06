
/**
 * A kirajzolhato objektumok osszegyujteseert felelos interface (osztaly).
 *
 * @author ComboBox
 */
public interface Drawable {

    /**
     * View hozzarendeleseert felelso fuggveny.
     *
     * @param view a hozzarendelni kivent view
     */
    void attach(View view);

    /**
     * A view eldobasaert felelos fuggveny.
     *
     * @param view az eldobando view.
     */
    void detach(View view);

    /**
     * A valtozasrol a view ertesitese.
     */
    void notifyView();
}
