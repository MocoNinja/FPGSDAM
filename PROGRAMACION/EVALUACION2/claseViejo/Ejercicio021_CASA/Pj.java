package claseViejo.Ejercicio021_CASA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pj extends Rectangle{
	
	Color color;
	final int ancho = 15, alto = 15;
	
	// No hacen falta para este problema en principio
	final int TECHO = 0, SUELO = App.HEIGHT - alto;
	final int PARED_I = 0, PARED_D = App.WIDTH - ancho;
	
	int vY = 3;
	boolean vivo = true;
	
	public Pj()
	{
		x = 50;
		y = 50 ;
		color = Color.CYAN;
		width = ancho;
		height = alto;
	}
	
	public void dibujar(Graphics g)
	{
		g.setColor(this.color);
		g.fillRect(x, y, width, height);
	}
	
	public void mueve()
	{
		y += vY;
		if (y < TECHO || y > SUELO )
		{
			System.out.println("Te pasaste");
			vivo = false;
		}
	}
}
