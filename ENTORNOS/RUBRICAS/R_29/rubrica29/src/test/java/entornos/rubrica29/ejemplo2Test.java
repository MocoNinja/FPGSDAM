package entornos.rubrica29;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ejemplo2Test
{

	@Test
	public void test()
	{
		// crea un mock de la clase comparable
		Comparable c = mock(Comparable.class);
		// asigna que el resultado de comparar con Test es 1
		when(c.compareTo("Test")).thenReturn(1);
		assertEquals(1, c.compareTo("Test"));
	}
}
