package EVALUACION1.clase;


/*
* Cadena de texto
* Tenemos otra subcadena de subcaracteres
* Hacer una funcion que devuelva el numero de veces que se repite la subcadena
*/

public class Ej70 {

	public static void main(String[] args) {
		
		char[] palabra = {'p', 'l', 'a', 't', 'a', 'n', 'o', '3', 'a','n','o', 's','7', 'a', 'n', 'k', '8', '9', 'a','o','a', 'n', 'o','a', 'n', 'o'};
		char[] subCadena = {'a', 'n', 'o'};
		System.out.printf("Veces: %d%n",cuentaSubcadenasProfe(palabra, subCadena));
	}

	public static int cuentaSubcadenasYop(char[] palabra, char[] texto){
		int veces = 0;
		int coincidencias;
		for (int i = 0; i < palabra.length  - texto.length + 1; ++i){ //Busca en todas las letras, salvo si la cadena a buscar es más grande que las letras que quedan.
			//System.out.println(palabra[i]);
			coincidencias = 0;
			if (palabra[i] == texto[0]){
				++coincidencias; //no olvidarse.
				++i;
				for (int j = 1; j < texto.length; ++j){
					if (palabra[i] == texto[j]){
						++coincidencias;
						if (j != texto.length - 1){ //OJAZO con las redundancias
							++i;
						}
					} else {
						//System.out.println("Coincidencia fallada. Saliendo del bucle for...");
						break;
					}
				}
			}
			if (coincidencias == texto.length){ //Si ha habido estas repeticiones, es que estaba íntegra.
				++veces;
			}
		}
	return veces;
	}
	
	public static int cuentaSubcadenasProfe(char[] cad, char[] sub){
		/*
		* Hay varias formas de hacerlo: si buscamos nn en nnnn pueden devolverse 2 (lo que hice yo) o 3 ocurrencias
		*/
		int cont = 0;
		int i;
		for (int pral = 0; pral < cad.length - sub.length + 1; ++pral){
			i = pral;
			while((i < cad.length) && (cad[i] != sub[0])) //Recordar la tabla de verdad del AND
				++i;
			//if (i < cadena.length) //Tener en cuenta que en el while no se incrementa al final si no ha entrado
			if (cad[i] == sub[0]){
				int i2 = i + 1;
				int j = 1;
				pral = i;
				while((j < sub.length) && (cad[i2] == sub[j])){
					i2++;
					j++;
				}
				if (j == sub.length)
					 cont++;
			}		
		}
	return cont;
	}

/*
*	==============================TODO==============================
*
* 	Esta mierda puede hacerse mucho más limpiamente, no me cabe duda
* 							Fuckin' do it!!!!
*/
}
