package vererbung.periodensystem;

import java.util.ArrayList;
import java.util.Collection;

public class Periodensystem {

	private Element[] elements = new Element[118];
	
	public void addElement(Element element){
		elements[element.getOz()] = element;
	}
	
	public boolean hasElement(int oz){
		return elements[oz] != null;
	}
	
	public Element getElement(int oz){
		return elements[oz];
	}
	
	public Element[] getAllMetalls(){
		Collection<Element> metals = new ArrayList<Element>();
		
		for(Element element:elements){
			if(element instanceof Metall){
				metals.add(element);
			}
		}
		
		return metals.toArray(new Element[metals.size()]);
	}
	
}
