package mio_clase;
public class Ej12{
    
    public static void main(String[] args) {
    	
    	/*Voy a asumir que el numerador es mayor que el denominador.
    	* Si no, habra que hacer el bucle con aux y calcular la inversa.
    	* Y plas
    	*/
    	
		final int numerador = 8;   //Parece que para meter un static dentro de un metodo hay que poner final.
    	final int denominador = 7;

    			/* 									Logica del codigo:
    			*
    			* El cociente entre el factorial de un numero mas grande que otro es el producto de la diferencia entre ellos.
    			* Porque al ser uno mas grande, llegara un punto en el que el numero grande se convertira en el peque駉.
    			* Por lo que tendremos unos numeros que multiplicaran al factorial x y habra que dividirlo por el factorial x.
    			* 
    			*	7!	 	7򉼱򉕗򈭽
    			* 	-- = 	------------- = 	7 � 6 � (5! / 5!) = 42
    			*	5!		  5򉕗򈭽	
    			*
    			*/
    			
    	int resultado = numerador; //el acumulador
    	// el declara el contador fuera
   		final int numeroFinal = numerador - (numerador - denominador) + 1;
   		//Aun mas facil: mayor que el denominador
   		//System.out.println(numeroFinal);
   		if (numerador == denominador)
			resultado = 1;
		else {
   			for (int i = numerador - 1; i >= numeroFinal; --i){
   			//System.out.printf("Antes de bucle: i vale %d; numeroFinal vale %d; resultado vale %d\n", i, numeroFinal, resultado);   		
   			resultado *= i;
   			//System.out.printf("Despues de bucle: i vale %d; numeroFinal vale %d; resultado vale %d\n", i, numeroFinal, resultado);
   			}
   		}
   		System.out.printf("El cociente entre el factorial de %d y el de %d, vale %d\n", numerador, denominador, resultado);
   		/*Explicado ya el printf en clase
   		* %d: numero en base 10
   		* %h: hexadecimal
   		* %f: decimal
   		* \n Secuencia de escape: retorno de carro
   		*/
   		//Esto son 7 elementos tomados de 3 en 3, V37.
    }
}