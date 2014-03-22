public interface Visitor {

	/**
	 * 
	 * @param t
	 */
	void visit(Trap t);

	/**
	 * 
	 * @param c
	 */
	void visit(Character c);

	/**
	 * 
	 * @param t
	 */
	void visit(Tower t);

}