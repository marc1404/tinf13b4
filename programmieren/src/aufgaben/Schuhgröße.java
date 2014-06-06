package aufgaben;

public class Schuhgröße {

	public static void main(String[] args){
		double cm1 = 19.333333;
		
		System.out.println("Zentimeter          | Schuhgröße");
		System.out.println("--------------------------------");
		
		while(cm1 < 33.333333){
			double cm2 = cm1 + 0.666666;
			int schuhgröße = (int)Math.round(cm1 * 1.5);
			
			System.out.printf("%f2.6 - %f2.6 | %d\n", cm1, cm2, schuhgröße);
			
			cm1 += 0.666666;
		}
	}
	
}