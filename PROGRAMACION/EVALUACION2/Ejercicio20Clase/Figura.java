package Ejercicio20Clase;

import java.awt.*;
import java.util.Random;

public abstract class Figura extends Rectangle{
	
	final int APPLET_WIDTH = 600, APPLET_HEIGHT = 600;
	Color color;
	int vX = 1, vY = 1;
	int posX, posY;
	final int ancho = 35, alto = 35;
	
	final int TECHO = 0 + ancho, SUELO = APPLET_HEIGHT - ancho;
	final int PARED_I = 0 + ancho, PARED_D = APPLET_WIDTH - ancho;
	
	Random rand;
	
	public Figura() // Declaramos el constructor para llamarlo de las subclases, no crear objetos
	{
		super();
		rand = new Random();
		posX = rand.nextInt(PARED_D);
		posY = rand.nextInt(SUELO);
		x = posX;
		y = posY;
		width = ancho;
		height = alto;
	}
	
	public void actualizar()
	{
		x += vX;
		y += vY;
		if (x >= PARED_D || x <= PARED_I)
				vX *= -1;
		if (y >= SUELO || x <= TECHO)
				vY *= -1;
	}
	
	public abstract void dibujar(Graphics g); // Método abstracto: no hace nada pero *obliga* a implementar este método en las subclases
											  // Es el encabezado, como lo implements Runnable y tal
}
