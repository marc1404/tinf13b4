package xm.aufgabe1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Start {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document doc = parser.parse("http://maps.googleapis.com/maps/api/geocode/xml?address=karlsruhe&sensor=false");
		Element root = doc.getDocumentElement();
		Node formattedAddress = root.getElementsByTagName("formatted_address").item(0);
		Node addressComponent = root.getElementsByTagName("address_component").item(0);
		Node location = root.getElementsByTagName("location").item(0);
		Node bounds = root.getElementsByTagName("bounds").item(0);
		Node southwest = bounds.getChildNodes().item(1);
		Node northeast = bounds.getChildNodes().item(3);
		String north = northeast.getChildNodes().item(1).getTextContent();
		String east = northeast.getChildNodes().item(3).getTextContent();
		String south = southwest.getChildNodes().item(1).getTextContent();
		String west = southwest.getChildNodes().item(3).getTextContent();
		
		System.out.println("Adresse: "+ formattedAddress.getTextContent());
		System.out.println("Long Name: " + addressComponent.getChildNodes().item(1).getTextContent());
		System.out.println("Location: (latitude=" + location.getChildNodes().item(1).getTextContent() + ", longitude=" + location.getChildNodes().item(3).getTextContent() + ")");
		System.out.println("Bounds: (east=" + east + ", north=" + north + ", west=" + west + ", south=" + south + ")");
	}
	
}
