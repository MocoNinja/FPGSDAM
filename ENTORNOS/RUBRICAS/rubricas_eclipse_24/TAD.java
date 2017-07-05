package rubricas_eclipse_24;

import java.util.ArrayList;
import java.util.List;

public class TAD
{
	public static String dosElevadoA(int exp)
	{
		if (exp == 0) return "0";
		List<Integer> digitos = new ArrayList<Integer>();
		digitos.add(1);
		
		int tamanyo = 1;
		int numeroActual;
		int acarreo = 0;
		
		for (int i = 0; i < exp; i++)
		{
			for (int indice = 0; indice < tamanyo; indice++)
			{
				numeroActual = digitos.get(indice);
				numeroActual *= 2;
				numeroActual += acarreo;
				acarreo = 0;
				if (numeroActual > 9)
				{
					numeroActual -= 10;
					acarreo = 1;
				}
				digitos.set(indice, numeroActual);
			}
			
			if (acarreo == 1)
			{
				digitos.add(acarreo);
				tamanyo++;
				acarreo = 0;
			}
		}
		String resultado = "";
		for (int i = digitos.size() - 1; i >= 0; i--) resultado += digitos.get(i);
	return resultado;
	}
}
