package entornos.rubrica29;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.mockito.Mockito;

public class ejemplo6Test {
	@Test
	public void OutputStreamWriter_Buffers_And_Forwards_To_OutputStream() throws IOException{  
		//crear el flujo de salida y mockearlo
	 OutputStream mock= Mockito.mock(OutputStream.class);
	 OutputStreamWriter osw=new OutputStreamWriter(mock);
	 	// escribir a y limpiar
	 osw.write('a');
	 osw.flush();

	 // Arreglado según lo visto en clase
	 BaseMatcher <byte []> arrayStartingWithA = new BaseMatcher <byte []>(){
		 
	  public boolean matches(Object item) {
	   byte[] actual=(byte[]) item;
	   return actual[0]=='a';
	  }

	  public void describeTo(Description description) {
			// necesario
	  }
	 };
	 Mockito.verify(mock).write(Mockito.argThat(arrayStartingWithA), Mockito.eq(0), Mockito.eq(1)); 
	}
}
