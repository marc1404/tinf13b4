package array.aufgaben;

public class MittelwertUndStandardAbweichung {

	public static void main(String[] args){
		int n = 100;
		double[] arr = new double[n];
		StringBuilder randomNumbersString = new StringBuilder();
		
		randomNumbersString.append("Zufallszahlen: ");
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = Math.random() * 10;
			
			randomNumbersString.append(arr[i]).append(", ");
		}
		
		double sum = 0;
		
		for(double value:arr){
			sum += value;
		}
		
		double mittelwert = sum / n;
		double varianz = 0;
		
		for(double value:arr){
			varianz += Math.pow(value - mittelwert, 2);
		}
		
		varianz /= n - 1;
		double standardAbweichung = Math.sqrt(varianz);
		
		System.out.println(randomNumbersString);
		System.out.println("Array mit Größe n = " + n);
		System.out.println("Mittelwert = " + mittelwert);
		System.out.println("Varianz = " + varianz);
		System.out.println("Standardabweichung = " + standardAbweichung);
	}
	
}
