package Ejercicio20;

import java.awt.*;
import java.util.*;


public class Rectangulos extends Rectangle{
	static final int ANCHO = 20, ALTO = 10;
	static Color[] colores = {Color.RED, Color.BLUE, Color.GREEN};
	static Random rand = new Random();
	static final Color COLOR = colores[rand.nextInt(colores.length)];
	static int posX, posY;
	
	
	static final int MIN_X = 0;
	static final int MAX_X = AppletApp.WIDTH - ANCHO;
	static final int MIN_Y = 0;
	static final int MAX_Y = AppletApp.HEIGHT - ALTO;
	
	
	static final int vX = 1, vY = 1;
	static int xAcc = 5, yAcc = 5;
	
	boolean colision = false;
	Rectangle objetivo = null;
	
	public Rectangulos()
	{
		posX = posX = rand.nextInt(AppletApp.WIDTH - ANCHO);
		posY = rand.nextInt(AppletApp.HEIGHT - ALTO);
		width = ANCHO;
		height = ALTO;
		x = posX;
		y = posY;
	}
	
	
	public  void pintar(Graphics gg)
	{
		gg.setColor(COLOR);
		gg.fillRect(x, y, width, height);
	}
	
	public void mueve(Rectangle rectangulo)
	{
		colision = false;
		objetivo = null;
		
		if (x > MAX_X || x < MIN_X)
		{
			xAcc *= -1;
		}
		if (y > MAX_Y || y < MIN_Y)
		{
			yAcc *= -1;
		}
		
		x += vX*xAcc;
		y += vY*yAcc;
		
		if (this.intersects(rectangulo))
		{
			objetivo = rectangulo;
			colision = true;
		}
	}
}
