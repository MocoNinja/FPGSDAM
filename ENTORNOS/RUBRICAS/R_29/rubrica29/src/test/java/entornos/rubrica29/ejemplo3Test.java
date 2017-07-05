package entornos.rubrica29;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class ejemplo3Test
{
	@Test
	public void test()
	{
		// igual que antes
		Comparable c = mock(Comparable.class);
		// aqui se retorna el resultado para cualquier numero
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(3213));
	}
}

