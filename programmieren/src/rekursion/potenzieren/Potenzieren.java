package rekursion.potenzieren;

public class Potenzieren {

	public static double xhochn(double x, int n){
		if(n == 0){ // nicht rekursiver Zweig
			return 1;
		}else{ // rekursiver Zweig
			return x * xhochn(x, n - 1);
		}
	}
	
}
