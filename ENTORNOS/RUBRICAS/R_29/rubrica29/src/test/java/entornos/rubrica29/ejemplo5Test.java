package entornos.rubrica29;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import org.junit.Test;

public class ejemplo5Test
{

	@Test
	public void test() throws IOException
	{
		// igual que antes
		 OutputStream mock = mock(OutputStream.class);
		 OutputStreamWriter dependencia = new OutputStreamWriter(mock);
		 dependencia.close();
		 // aqui se verifica que el flujo de salida está cerdado
		 verify(mock).close();
	}
}
