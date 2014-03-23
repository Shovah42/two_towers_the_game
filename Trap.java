public class Trap extends Building implements Visitable {

	public Trap() {
		System.out.println("CALL class Trap method Trap()");
	}
	/**
	 * 
	 * @param character
	 */
	public void effectCharacter(Character character) {
		// TODO - implement Trap.effectCharacter
		throw new UnsupportedOperationException();
	}

	@Override
	public void accept(Visitor v) {
		System.out.println("alt Visitable==Trap");
		System.out.println("CALL class Trap method accept(Visitor v)");
		v.visit(this);
		
	}

}