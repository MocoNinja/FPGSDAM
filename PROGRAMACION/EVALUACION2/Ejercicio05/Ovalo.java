package Ejercicio05;
import java.awt.*; // Este paquete está acabado, pero lo usamos para Color
import java.util.*; // Para Random

public class Ovalo{
    /*
    * existe la clase drawOval(posX,posY,anchura,altura) -> inscribe el ovalo en esa forma
    * eso solo dibuja el controno. fillOval(...) lo hace lleno
    */

    int posX, posY, anchura, altura;
    Color color;
    /*
    * Hay una clase especifica para el color en Java; hay que importarla
    * Los colores estan en formato RGB (cada color, de 0 a 255)
    * El constructor espera recibir estos 3 enteros
    */
    Random r;
    public Ovalo(){
         r = new Random(); // Ojo que me olvidaba de instanciarlo!
        inicializar();
    }

    public void inicializar(){
       
        // Haremos un frame de 300x300 
        posX = r.nextInt(200);
        posY = r.nextInt(200);
        altura = r.nextInt(500);
        anchura = r.nextInt(3)*altura;
        color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    public void dibujar (Graphics titanx){ 
    	// Ojo a la chicha: fillOval es un metodo de Graphics, pero no basta con crearlo, pues debe ser el del frame para verlo.
    	//-> Por eso el parametro, y no crearlo dentor como han hecho otros
        //titanx.drawOval(posX, posY, anchura, altura);
        titanx.setColor(color);
        titanx.fillOval(posX, posY, anchura, altura);
    }
}