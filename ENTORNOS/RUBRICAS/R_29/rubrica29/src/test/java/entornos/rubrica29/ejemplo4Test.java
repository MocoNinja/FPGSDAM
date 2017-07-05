package entornos.rubrica29;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import org.junit.Test;

public class ejemplo4Test
{
	@Test(expected = IOException.class)
	public void test() throws IOException
	{
		// crea un mock de un flujo de salida
	 OutputStream mock = mock(OutputStream.class);
	 	//crea un mock de un flujo de escritura que depende de la salida anterior
	 OutputStreamWriter dependienteMock = new OutputStreamWriter(mock);
	 // cuando se cierre el flujo de salida, tirar una excepcion de E/S
	 doThrow(new IOException()).when(mock).close();
	 // cerrar el flujo de escritorua
	 dependienteMock.close();
	}
}
