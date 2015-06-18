package com.vornetran.marc;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.util.converter.StringToDoubleConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Marc on 18/06/2015.
 */
@Title("Vaadin Calculator")
@Theme("valo")
public class Calculator extends UI {

    VerticalLayout vertical = new VerticalLayout();
    HorizontalLayout horizontal = new HorizontalLayout();
    ComboBox operator = new ComboBox("Operator");
    TextField x = new TextField("X", "0");
    TextField y = new TextField("Y", "0");
    Button calculate = new Button("Calculate", this::calculateAction);
    Label header = new Label("<h1>Vaadin Calculator</h1>", ContentMode.HTML);
    Label result = new Label("", ContentMode.HTML);

    @Override
    public void init(VaadinRequest request) {
        vertical.addComponent(header);
        vertical.addComponent(buildHorizontalLayout());
        vertical.addComponent(result);

        vertical.setMargin(true);
        vertical.setSpacing(true);

        setContent(vertical);
    }

    private HorizontalLayout buildHorizontalLayout(){
        operator.addItem("+");
        operator.addItem("-");
        operator.addItem("*");
        operator.addItem("/");

        operator.setItemCaption("+", "+");
        operator.setItemCaption("-", "-");
        operator.setItemCaption("*", "*");
        operator.setItemCaption("/", "/");

        x.setConverter(new StringToDoubleConverter());
        y.setConverter(new StringToDoubleConverter());

        calculate.setStyleName(ValoTheme.BUTTON_PRIMARY);

        horizontal.addComponent(x);
        horizontal.addComponent(operator);
        horizontal.addComponent(y);
        horizontal.addComponent(calculate);

        horizontal.setSpacing(true);
        horizontal.setComponentAlignment(calculate, Alignment.BOTTOM_CENTER);

        return horizontal;
    }

    private void calculateAction(Button.ClickEvent event){
        String operator = (String)this.operator.getValue();
        double x = (double)this.x.getConvertedValue();
        double y = (double)this.y.getConvertedValue();
        double result;

        if(operator == null){
            invalidOperator();
            return;
        }

        switch(operator){
            case "+": result = x + y; break;
            case "-": result = x - y; break;
            case "*": result = x * y; break;
            case "/": result = x / y; break;
            default: invalidOperator(); return;
        }

        this.result.setValue("<b>Result:</b> " + x + " " + operator + " " + y + " = " + result);
    }

    private void invalidOperator(){
        result.setValue("<b>Invalid Operator!</b>");
    }

}
