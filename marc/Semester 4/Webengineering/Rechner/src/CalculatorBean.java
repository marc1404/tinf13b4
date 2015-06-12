import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Marc on 11/06/2015.
 */
@ManagedBean(name = "calculator")
@SessionScoped
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
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
