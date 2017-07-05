package EVALUACION2.clase.Ejercicio004;
public class Resultado{
    // Decalarar un int[6][8] con una funcion para cargarlo y otra para mostarlo
    //Va a ser el programa ejecutable

    //Me daba problemas porque habia creado bombito en main y no en cargar();
    /*
    * Diferencias en clase:
    * Crea la variable GLOBAL (fuera de main) private int resultado[][];
    * Lo instancia en main con resultad0 = new resultado[6][8];
    * Fuera de main hace Bombo Bombo;
    * Y dentro lo instancia mediante bombo = new Bombo();
    * Eso implica que su metodo rellenar es void y no se le pasa nada, ojito
    */
    public static void main(String[] args) {
        
       leer(cargar());
    }
    public static int[][] cargar(){
        Bombo bombito = new Bombo();
        int[][] resultados = new int[6][8];
        for (int fila = 0; fila < resultados.length; fila++){
            for (int columna = 0; columna < resultados[fila].length; columna++){
                resultados[fila][columna] = bombito.sacaBolas();
            }
        }
    return resultados;
    }
    public static void leer(int[][] vector){
        for (int fila = 0; fila < vector.length; fila++){
            for (int columna = 0; columna < vector[fila].length; columna++){
                System.out.printf("%2d  ", vector[fila][columna]);
            }
            System.out.println();
        }
    }
}