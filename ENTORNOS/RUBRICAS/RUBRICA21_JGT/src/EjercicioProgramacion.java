/*
* Convertir una cadena de caracteres a est�ndar
* Quitando n�meros, vocales, s�mbolos, espacios y retornando todo en min�sculas
*/
public class EjercicioProgramacion 
{
	public static String makeStandard(String string)
	{
		String standard = "";
		char[] nonStandardChars = {'�', '�', '�', '�', '�'};
		char[] standardChars = {'a', 'i', 'u', 'e', 'o'};
		int indiceSustituir;
		for (int i = 0; i < string.length(); i++)
		{
			indiceSustituir = -1;
			for (int j = 0; j < nonStandardChars.length; j++)
			{
				if (string.toLowerCase().charAt(i) == nonStandardChars[j])
				{
					indiceSustituir = j;
					break;
				}
			}
			if (indiceSustituir != -1) standard += standardChars[indiceSustituir];
			else if (Character.isLetter(string.charAt(i))) standard += Character.toLowerCase(string.charAt(i));
		}
		if(standard == "") standard += "Error de entrada";
	return standard;
	}
}
