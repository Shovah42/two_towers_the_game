
public interface Visitable extends Monitor {

    /**
     *
     * @param v
     */
    void accept(Visitor v);

}
