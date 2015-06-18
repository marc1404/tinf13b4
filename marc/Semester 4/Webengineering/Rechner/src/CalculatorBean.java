import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Marc on 11/06/2015.
 */
@ManagedBean(name = "calculator")
@RequestScoped
public class CalculatorBean {

    private String operator;
    private String errorMessage;
    private double x;
    private double y;
    private double result;

    public String calculate(){
        switch(operator){
            case "+": add(); break;
            case "-": subtract(); break;
            case "*": multiply(); break;
            case "/": divide(); break;
            default: invalidOperator(); return "ERROR";
        }

        if(result == 42){
            return "42";
        }

        return "OK";
    }

    private void add(){
        result = x + y;
    }

    private void subtract(){
        result = x - y;
    }

    private void multiply(){
        result = x * y;
    }

    private void divide(){
        result = x / y;
    }

    private void invalidOperator(){
        errorMessage = "Choose one of the following operators: +, -, *, /";
    }

    public String getOperator() {
        System.out.println("CalculatorBean: getOperator()");
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        System.out.println("CalculatorBean: setOperator()");
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getX() {
        System.out.println("CalculatorBean: getX()");
        return x;
    }

    public void setX(double x) {
        this.x = x;
        System.out.println("CalculatorBean: setX()");
    }

    public double getY() {
        System.out.println("CalculatorBean: getY()");
        return y;
    }

    public void setY(double y) {
        this.y = y;
        System.out.println("CalculatorBean: setY()");
    }

    public double getResult() {
        System.out.println("CalculatorBean: getResult()");
        return result;
    }

    public void setResult(double result) {
        this.result = result;
        System.out.println("CalculatorBean: setResult()");
    }

}
