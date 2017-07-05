package rubricas_eclipse_25;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GeneradoresTest {
	Generadores gen;
	int longitud;
	
	@Test
	public void testGeneradorVectores() {
		longitud = 20;
		gen = new Generadores(longitud, true);
		if (gen.getVector() == null || gen.getVector().length != longitud) fail();
		for (int i = 0; i < gen.getVector().length - 1; i++) if(gen.getVector()[i] > gen.getVector()[i + 1]) fail();
		longitud = 30;
		gen = new Generadores(longitud, true);
		if (gen.getVector() == null || gen.getVector().length != longitud) fail();
		for (int i = 0; i < gen.getVector().length - 1; i++) if(gen.getVector()[i] > gen.getVector()[i + 1]) fail();
	}
	@Test 
	public void testGeneradorListas(){
		longitud = 20;
		gen = new Generadores(longitud, false);
		if (gen.getLista() == null || gen.getLista().size() != longitud) fail();
		for (int i = 0; i < gen.getLista().size() - 1; i++) if(gen.getLista().get(i) > gen.getLista().get(i + 1)) fail();
		longitud = 30;
		gen = new Generadores(longitud, false);
		if (gen.getLista() == null || gen.getLista().size() != longitud) fail();
		for (int i = 0; i < gen.getLista().size() - 1; i++) if(gen.getLista().get(i) > gen.getLista().get(i + 1)) fail();
	}

}
