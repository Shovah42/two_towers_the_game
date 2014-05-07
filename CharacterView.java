
/**
 * A karakter kirajzoltaasaert felelos osztaly.
 *
 * @author ComboBox
 */
public class CharacterView implements View {

    private Drawable drawable;

    public CharacterView() {
    }

    public CharacterView(Drawable drawable) {
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void updateView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
