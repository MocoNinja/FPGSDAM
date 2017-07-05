package rubricas_eclipse_23;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ColaTest
{
	Cola cola;
	
	@Before
	public void instancianeitor()
	{
		cola = new Cola();
	}
	@Test
	public void test() throws Exception
	{
		// Asegurar que la cola se crea
		assertEquals(0, cola.numElementos());
		
		// Asegurar que pueden aÃ±adirse elementos
		cola.encola(3);
		assertEquals(1, cola.numElementos());
		cola.encola(4);
		assertEquals(2, cola.numElementos());
		
		// Asegurar que los elementos se desencolan
		assert(cola.desencola() instanceof Integer);
		assertEquals(1, cola.numElementos());
		assert(cola.desencola() instanceof Integer);
		assertEquals(0, cola.numElementos());
		
		// Asegurar que no puede desencolarse una lista vacÃ­a
		try
		{
			cola.desencola();
			System.out.println("Si pasa de esta linea no ha tirado excepción y el test ha fallado");
			fail();
		} 
		catch(Exception e)
		{
			System.out.println("Petó exitosamente");
			assertEquals(0, cola.numElementos());
		}
	}

}
