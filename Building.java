
public abstract class Building {

    private Color color;

    public Color getColor() {
        return this.color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        System.out.println("CALL class Building method setColor(Color color)");
        this.color = color;
    }

    public Species getSpecies() {
        // TODO - implement Building.getSpecies
        throw new UnsupportedOperationException();
    }

}
