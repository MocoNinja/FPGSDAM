import static org.junit.Assert.*;
import org.junit.Test;

public class EjercicioProgramacionTest
{

	/*
	* Objetivos del test
	* Comprobar que el programa act�a seg�n su cometidos
	* Comprobar que dejar el String vacio, ya que sea por no pasarle nada o por generar un string sin caracteres validos no retorna null
	*/
	
	@Test
	public void test()
	{
		assertTrue(EjercicioProgramacion.makeStandard("�����").equals("aiueo"));
		assertTrue(EjercicioProgramacion.makeStandard("�����").equals("aiueo"));
		assertTrue(EjercicioProgramacion.makeStandard("J� **r     EEEm��s").equals("jereeemias"));
		assertTrue(EjercicioProgramacion.makeStandard("- ��{{[6238a�").equals("��au"));
		assertNotNull(EjercicioProgramacion.makeStandard(""));
		assertNotNull(EjercicioProgramacion.makeStandard("-3424*23"));
	}

}
