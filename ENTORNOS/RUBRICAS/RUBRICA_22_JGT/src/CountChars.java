
public class CountChars
{
	private final String vocales = "aeiouáéíóúäëïöüAEIOUÁÉÍÓÚÄËÏÖÜ";
	
	public int[] countChars(String cadena)
	{
		char currentChar;
		int[] numeros = {0, 0}; // [numeroVocales, numeroConsonantes];
		
		for (int i = 0; i < cadena.length(); i++)
		{
			currentChar = cadena.charAt(i);
			
			if (Character.isLetter(currentChar))
			{
				if (vocales.indexOf(currentChar) != -1) numeros[0]++;
				else numeros[1]++;
			}
		}
	return numeros;
	}
	
	public void readChars(int[] caracteres)
	{
		final String[] charTypes = {"Vocales", "Consonantes"};
		for (int i = 0; i < charTypes.length; i++)
		{
			System.out.printf("El número de %s es: %2d.%n", charTypes[i], caracteres[i]);
		}
	}
}
