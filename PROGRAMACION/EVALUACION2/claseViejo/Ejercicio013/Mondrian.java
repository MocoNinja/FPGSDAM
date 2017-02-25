package claseViejo.Ejercicio013;

import java.awt.*;
import java.applet.*;
import java.util.*;
import javax.swing.plaf.ColorUIResource;

public class Mondrian extends Applet implements Runnable{

	/*
	* Ciclo de vida del Applet
	* init() ~~ constructor. Se ejecuta solo
	* start() ojo, no es el mismo de antes
	* paint()
	* stop()
	*/
	
	Color[] colores = {Color.black, Color.red, Color.cyan, Color.green, Color.DARK_GRAY, Color.blue, Color.blue}; 
	Color colorico;
	int posX, posY;
	Graphics ninja; // No se va a ver
	Image imagen; // Necesitamos una imagen, para dibujarla en el Graphics
	// Dentro de la imagen hay otro Graphics.
	
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte DCHA = 4;
	static final byte IZQ = 2;
	
	int velocidadX = 1;
	int velocidadY = 1;
	
	static final int TECHO = 0;
	static final int SUELO = 200;
	static final int PARED_I = 0;
	static final int PARED_D = 200;
	
	byte direccion;
	
	Thread ani;
	Random nA = new Random();
	
	public void init(){
		setBackground(Color.black); // redundante con el nuevo rectangulo negro, pero lo dejo
		posX  = 90;
		posY = 90;
		colorico = Color.lightGray;
		// ani = new Thread(this);
		// ani.start(); // el no lo ha puesto creo // lo ha puesto en un start con el new Thread de antes
		direccion = DCHA;
		imagen = this.createImage(300, 300); // reserva memoria para la imagen
		ninja = imagen.getGraphics(); // devuelve el objeto graphics de imagen -> ninja va a apuntar a imagen, que tiene un atributo que es un puntero 
									  // que apunta a su graphics (getGraphics() devuelve la direccion del objeto Graphics de la imagen.
		}
	
		public void start(){
			ani = new Thread(this);
			ani.start();
		}
		
	public void paint(Graphics a){ // sigue siendo el viejo porque no hay que hacer todo sobre el que se ve
		
		/* CODIGO VIEJO: dibuja sobre el graphics
		
		// ESTE ES EL RECT NEGRO DEL UPDATE
		a.setColor(Color.black);
		a.fillRect(0, 1, 3000, 3000);
		//
		a.setColor(Color.yellow);
		a.fillRect(0, 0, 90, 90);
		a.fillRect(250, 0, 40, 190);
		a.fillRect(80, 110, 100, 20);
		a.setColor(Color.blue);
		a.fillRect(80, 200, 220, 90);
		a.fillRect(100, 10, 90, 80);
		a.setColor(colorico);
		a.fillRect(posX, posY, 110, 90);
		a.setColor(Color.red);
		a.fillRect(200, 0, 45, 45);
		a.fillRect(0, 100, 70, 200);
		a.setColor(Color.magenta);
		a.fillRect(200, 55, 60, 135);
		*/
		
		//CODIGO NUEVO: dibuja sobre el graphics oculto
		
		// ESTE ES EL RECT NEGRO DEL UPDATE
		ninja.setColor(Color.black);
		ninja.fillRect(0, 1, 3000, 3000);
		//
		ninja.setColor(Color.yellow);
		ninja.fillRect(0, 0, 90, 90);
		ninja.fillRect(250, 0, 40, 190);
		ninja.fillRect(80, 110, 100, 20);
		ninja.setColor(Color.blue);
		ninja.fillRect(80, 200, 220, 90);
		ninja.fillRect(100, 10, 90, 80);
		ninja.setColor(colorico);
		ninja.fillRect(posX, posY, 110, 90);
		ninja.setColor(Color.red);
		ninja.fillRect(200, 0, 45, 45);
		ninja.fillRect(0, 100, 70, 200);
		ninja.setColor(Color.magenta);
		ninja.fillRect(200, 55, 60, 135);
		
		// Como tocar ese objeto que se ve para que muestre lo que queremos
		// Este metodo pinta una imagen: como hemos dibujado en el graphics de la imagen, hemos pintado en la imagen
		// Si dibujamos la imagen, vemos el graphics
		a.drawImage(imagen, 0, 0, this); // imagen, x, y, donde
	}


	public void run() {
		while (true){
			try {
				///* JAVI CUSTOM
				 velocidadX = nA.nextInt(100);
				 velocidadY = nA.nextInt(100);
				 colorico = colores[nA.nextInt(colores.length - 1)];
				setBackground(colores[nA.nextInt(colores.length - 1)]);
				//*/
				// /* Ejercicio en serio
				// posX += 1; // Mover a la dcha
				switch (direccion){
					case ARRIBA:
						posY -= velocidadY;
						if (posY <= TECHO){
							direccion = DCHA;
						}
						break;
					case ABAJO:
						posY += velocidadY;
						if (posY >= SUELO){
							direccion = IZQ;
						}
						break;
					case DCHA:
						posX += velocidadX;
						if (posX >= PARED_D){
							direccion = ABAJO;
						}
						break;
					case IZQ:
						posX -= velocidadX;
						if (posX <= PARED_I){
							direccion = ARRIBA;
						}
						break;
				}
				// */
				Thread.sleep(45);
				repaint(); // llama al update -> borra el graphics y vuelve a llamar al paint -> QUEDA FEO
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*// Yo lo quito que a mi no me rula. El parpadeo lo evito con menos ms de sleep
	public void update(Graphics g){
		paint(g); // En este caso el repaint llama a *nuestro* update. No borra. Esto evita el parpadeo pero no borra.
		// Para que no deje rastro, hay que pintar un rectangulo del color de fondo del tamaño del applet
	}
	*/
	
	/*
	* Otra táctica
	* Generar todo en un Graphics oculto e ir metiendo ese al visible
	*/
}

