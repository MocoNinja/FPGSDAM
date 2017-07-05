import static org.junit.Assert.assertArrayEquals;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CountCharsTestXMLREAD
{
	File tests;
	static int[][] respuestas;
	static String[] palabras;
	CountChars clase = new CountChars();
	
	@Test
	public void Test()
	{
		try
		{
			File tests = new File("xml/Test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(tests);
			doc.getDocumentElement().normalize();

			NodeList cadaTest = doc.getElementsByTagName("test");

			for (int test = 0; test < cadaTest.getLength(); test++)
			{
				palabras = new String[cadaTest.getLength()];
				respuestas = new int[cadaTest.getLength()][2];
				Node nNode = cadaTest.item(test);

				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					String palabra = eElement.getElementsByTagName("string").item(0).getTextContent();
					int numLetras = Integer.parseInt(eElement.getElementsByTagName("letras").item(0).getTextContent());
					int numNumeros = Integer.parseInt(eElement.getElementsByTagName("numeros").item(0).getTextContent());
					palabras[test] = palabra;
					respuestas[test][0] = numLetras;
					respuestas[test][1] = numNumeros;
					assertArrayEquals(respuestas[test], clase.countChars(palabras[test]));
				}
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	
}
