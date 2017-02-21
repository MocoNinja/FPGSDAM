package Ejercicio20Clase;

import java.awt.*;

public abstract class Figura extends Rectangle{
	
	Color color;
	int vX, vY;
	int posX, posY, ancho, alto;
	public Figura(int posX, int posY, int ancho, int alto, Color color) // Declaramos el constructor para llamarlo de las subclases, no crear objetos
	{
		super();
		x = posX;
		y = posY;
		width = ancho;
		height = alto;
		this.color = color;
	}
	
	public void actualizar()
	{
		x += vX;
		y += vY;
		if (x >= 290 || x <= 0)
				vX *= -1;
		if (y >= 290 || x <= 0)
				vY *= -1;
	}
	
	public abstract void dibujar(Graphics g); // Método abstracto: no hace nada pero *obliga* a implementar este método en las subclases
											  // Es el encabezado, como lo implements Runnable y tal
}
