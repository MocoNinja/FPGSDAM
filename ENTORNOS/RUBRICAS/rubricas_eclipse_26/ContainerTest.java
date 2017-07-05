package rubricas_eclipse_26;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContainerTest
{
	Factory fact;
	List<Container> list;
	
	@Before
	public void setup()
	{
		fact = new Factory();
		list = fact.createList();
	}
	@Test
	public void test()
	{
		for (Container contenedor : list)
		{
			String palabra = contenedor.getProperty();
			System.out.println("Leyendo: " + palabra);
			
//			Ineficiente
//			int vecesEnLista = 0;
//			for (Container container : list)
//			{
//				if (container.getProperty() == contenedor.getProperty()) vecesEnLista++;
//				if (vecesEnLista >= 2) break;
//			}
//			assert(vecesEnLista == 1);
			
//			Mejor
			assert (list.indexOf(palabra) == list.lastIndexOf(palabra));
		}
	}

}
