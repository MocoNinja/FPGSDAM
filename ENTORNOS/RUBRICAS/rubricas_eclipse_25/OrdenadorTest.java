package rubricas_eclipse_25;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class OrdenadorTest {
	Generadores gen;
	Ordenador ord;
	int tamanyo;
	@Test
	public void testListas() {
		tamanyo = 20;
		gen = new Generadores(tamanyo, false);
		List<Integer> lista1 = gen.getLista();
		tamanyo = 23;
		gen = new Generadores(tamanyo, false);
		List<Integer> lista2 = gen.getLista();
		ord = new Ordenador(lista1, lista2);
		List<Integer> resultado = ord.getResultado();
		
		for (int i = 0; i < resultado.size() - 1; i++){
			if (resultado.get(i) > resultado.get(i + 1)) fail();
		}
	}
	
	
	@Test
	public void testVectores() {
		tamanyo = 20;
		gen = new Generadores(tamanyo, true);
		Integer[] vector1 = gen.getVector();
		tamanyo = 23;
		gen = new Generadores(tamanyo, true);
		Integer[] vector2 = gen.getVector();
		ord = new Ordenador(vector1, vector2);
		List<Integer> resultado = ord.getResultado();
		
		for (int i = 0; i < resultado.size() - 1; i++){
			if (resultado.get(i) > resultado.get(i + 1)) fail();
		}
	}
}
