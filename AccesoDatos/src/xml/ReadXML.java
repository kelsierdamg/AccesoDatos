package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadXML {
	private static final String FICHERO = "personas.xml";

	public static void main(String[] args) {
		File f = new File(FICHERO);
		
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(f);
			
			Element raiz = doc.getDocumentElement();
			System.out.println("Elemento raíz: " + raiz.getNodeName());
			
			recursivo(raiz);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void recursivo(Node nodo) {
		NodeList hijos = nodo.getChildNodes();
		for(int i=0; i<hijos.getLength(); i++) {
			Node hijo = hijos.item(i);
			
			if(hijo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) hijo;
				
				System.out.println(e.getNodeName());
				System.out.println(e.getTextContent());
				
				if (e.hasChildNodes()) {
					recursivo(e);
				}
			}
		}
	}
}