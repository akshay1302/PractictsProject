import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomParserEaxmple {

	public static void main(String[] args) {
		
		try{
			File fXmlFile = new File("C:/Users/Akshay/Downloads/test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());

			}
		}catch(Exception e){
			System.out.println("in catch " );
			System.out.println(e.getMessage());
		}
	}
	
	 private static void printNote(NodeList nodeList) {

		    for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName().trim().replaceAll("\\s","") + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent().trim().replaceAll("\\s",""));

				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					
					for (int i = 0; i < nodeMap.getLength(); i++) {
					   System.out.println(i);
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName().trim());
						System.out.println("attr value : " + node.getNodeValue().replaceAll("\\s",""));
					}
				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				
				}
				System.out.println("Node Name =" + tempNode.getNodeName().trim().replaceAll("\\s","") + " [CLOSE]");

			}

		    }
	 }

}
