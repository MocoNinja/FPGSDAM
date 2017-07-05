import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest
{
	Calculadora calc;
	
	@Before
	public void before()
	{
		calc = new Calculadora();
	}
	
	@Test
	public void testSuma()
	{
		assertTrue(calc.sumar(10, 4) == 14);
		assertTrue(calc.sumar(0, 0) == 0);
		assertTrue(calc.sumar(10, -4) == 6);
	}
	@Test
	public void testResta()
	{
		assertTrue(calc.restar(10, 4) == 6);
		assertTrue(calc.restar(0, 0) == 0);
		assertTrue(calc.restar(10, -4) == 14);
	}
}
