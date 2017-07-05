package entornos.rubrica29;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Iterator;

import org.junit.Test;

public class ejemplo1Test
{

	@Test
	 public void iterator_will_return_hello_world()
	{
	  Iterator i = mock(Iterator.class); // crea un mock de la clase Iterator
	  when(i.next()).thenReturn("Hello").thenReturn("World"); // Programa el mock para que al invocar al metodo siguiente del iterador retorne en secuencia dos cadenas de texto
	  String result=i.next()+" "+i.next();
	  assertEquals("Hello World", result);
	 }

}
