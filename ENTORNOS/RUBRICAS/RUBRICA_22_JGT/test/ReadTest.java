/*
*  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
*  FICHERO PARA APRENDER COMO RULA
*  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
*/


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadTest {

	public static void main(String[] args)
	{
		String[] palabras;
		int[][] respuestas;
		try
		{
			File tests = new File("xml/Test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(tests);
			doc.getDocumentElement().normalize();

//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//			Esto devuelve la marca "padre"
			
			NodeList cadaTest = doc.getElementsByTagName("test");

			for (int test = 0; test < cadaTest.getLength(); test++)
			{
				palabras = new String[cadaTest.getLength()];
				respuestas = new int[cadaTest.getLength()][2];
				Node nNode = cadaTest.item(test);

				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;

//					System.out.println("Test # : " + eElement.getAttribute("id"));
//					System.out.println("Listas Palabras : " + eElement.getElementsByTagName("string").item(0).getTextContent());
					palabras[test] = eElement.getElementsByTagName("string").item(0).getTextContent();
//					System.out.println("Número Letras: " + eElement.getElementsByTagName("letras").item(0).getTextContent());
//					System.out.println("Número Números: " + eElement.getElementsByTagName("numeros").item(0).getTextContent());
					respuestas[test][0] = Integer.parseInt(eElement.getElementsByTagName("letras").item(0).getTextContent());
					respuestas[test][1] = Integer.parseInt(eElement.getElementsByTagName("numeros").item(0).getTextContent());
				}
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}
