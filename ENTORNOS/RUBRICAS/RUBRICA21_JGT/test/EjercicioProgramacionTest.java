import static org.junit.Assert.*;
import org.junit.Test;

public class EjercicioProgramacionTest
{

	/*
	* Objetivos del test
	* Comprobar que el programa actúa según su cometidos
	* Comprobar que dejar el String vacio, ya que sea por no pasarle nada o por generar un string sin caracteres validos no retorna null
	*/
	
	@Test
	public void test()
	{
		assertTrue(EjercicioProgramacion.makeStandard("áíúéó").equals("aiueo"));
		assertTrue(EjercicioProgramacion.makeStandard("ÁÍÚÉÓ").equals("aiueo"));
		assertTrue(EjercicioProgramacion.makeStandard("Jé **r     EEEmÍÁs").equals("jereeemias"));
		assertTrue(EjercicioProgramacion.makeStandard("- çç{{[6238aÚ").equals("ççau"));
		assertNotNull(EjercicioProgramacion.makeStandard(""));
		assertNotNull(EjercicioProgramacion.makeStandard("-3424*23"));
	}

}
