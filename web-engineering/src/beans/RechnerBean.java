package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechnerBean {

	private List<String> results = new ArrayList<String>();
	private String operator;
	private String error;
	private double number1;
	private double number2;
	
	public void setNumber1(String number1){
		this.number1 = tryParse(number1);
	}
	
	public void setOperator(String operator){
		this.operator = operator;
	}
	
	public void setNumber2(String number2){
		this.number2 = tryParse(number2);
	}
	
	public List<String> getResults(){
		return results;
	}
	
	public String getError(){
		return error;
	}
	
	public boolean hasError(){
		return error != null && error.length() > 0;
	}
	
	public void calculate(){
		double result = -1;
		
		try{
			switch(operator){
			case "+":
				result = number1 + number2;
				break;
			case "-":
				result = number1 - number2;
				break;
			case "*":
				result = number1 * number2;
				break;
			case "/":
				result = number1 / number2;
				break;
			default:
				result = -1;
			}
		}catch(Exception ex){
			error = ex.getMessage();
			
			return;
		}
		
		results.add(0, getTime() + " " + number1 + " " + operator + " " + number2 + " = " + result);
	}
	
	private double tryParse(String number){
		try{
			return Double.parseDouble(number);
		}catch(Exception ex){
			error = "'" + number + "' ist keine Zahl";
			
			return -1;
		}
	}
	
	private String getTime(){
		return new SimpleDateFormat("[HH:mm]").format(new Date());
	}
	
}
