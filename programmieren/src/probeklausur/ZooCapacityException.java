package probeklausur;

public class ZooCapacityException extends Exception {

	private static final long serialVersionUID = 1L;

	public ZooCapacityException(int max){
		super("Die maximale Kapazität des Zoos ist erreicht! (" + max + ")");
	}
	
}
