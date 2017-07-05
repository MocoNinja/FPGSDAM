package rubricas_eclipse_24;

import static org.junit.Assert.*;

import org.junit.Test;

public class TADTest 
{
	@Test
	public void test()
	{
		// Comprobando la validez del algoritmo
		
		assertEquals("2", TAD.dosElevadoA(1));
		assertEquals("16", TAD.dosElevadoA(4));
		
		// Asegurar que tipos de datos inválidos retornan 1
		assertEquals("1", TAD.dosElevadoA(-23));
		assertEquals("1", TAD.dosElevadoA(Integer.parseInt("-24")));
		
		// Asegurar que cumple casos válidos que pueden catalogarse de preoblemáticos
		assertEquals("16", TAD.dosElevadoA(Integer.parseInt("4")));
		assertEquals("0", TAD.dosElevadoA(0));
		
		// Asegurar que no da overflow de tipo
		// Valor máximo para un entero: 2,147,483,647
		// Valor máximo para un long: 9,223,372,036,854,775,808
		// Usar Integer.MAX_VALUE me da errores de tipo y conversión, así que hardcodeo los logaritmos en base 2
		int exponenteNecesarioOverflowInt = 31;
		int exponenteNecesarioOverflowLong = 63;
		assertEquals("2147483648", TAD.dosElevadoA(exponenteNecesarioOverflowInt));
		assertEquals("9223372036854775808", TAD.dosElevadoA(exponenteNecesarioOverflowLong));
	}
}
