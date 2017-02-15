package Ejercicio04;
/*
* Tenemos un bombo con 49 bolas, sacadas de forma aleatoria
* Generamos números aleatorios, queserán los índices de las bolas que sacamos
* Movemos la ultima pelota (ultimo elemento del vector) a esa posicion y disminuimos las posiciones
*/

// Paquete: directorio con clases interrelacionadas (son de un tema concreto)
//import java.util.* /*Importa todo*/
import java.util.Random;

public class Bombo{
        private int[] bolas; //Variable de tipo puntero que apunta a NULL
        private int numBolas = 49;
        Random aleatorio;

        public Bombo(){
                bolas = new int[numBolas]; //Recordar: new reserva memoria y devuelve la posicion a partir de la cual se empieza a reservar
                for (int i = 0; i < numBolas; i++){
                        bolas[i] = i+1;
                }
                aleatorio = new Random();
        }
        public int getBolas(){
                return numBolas;
        }
        public int sacaBolas(){
                /*
                * Para sacar un numero aleatorio, vamos a usar el metodo nextInt de la clase Random.
                * Los enteros pueden ser positivos o negativos -> tenerlo en cuenta
                * Esta clase esta metida dentro del paquete utils
                */
                int bolaSacada = 0;
                int numeroAleatorio = aleatorio.nextInt(numBolas);
                bolaSacada = bolas[numeroAleatorio];
                bolas[numeroAleatorio] = bolas[numBolas - 1];
                numBolas--;
        return bolaSacada;
        //return bolas[aleatorio.nextInt(numBolas--)] //Esto hace lo mismo creo. PROBARLO -> Ojo que no lo he sustituido
        }      
}