package Ejercicio21_CASA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public class Col{

	Rectangle r1, r2;
	Color color;
	final int ANCHO = 10, HUECO = 10;
	final int ESPACIO_FIGURA = 75;
	Random rand = new Random();
	int alto; 
	int vX = 1;
	
	public Col()
	{
		color = Color.WHITE;
		alto = rand.nextInt(App.HEIGHT/2);
		r1 = new Rectangle(App.WIDTH, 0, ANCHO, alto);
		r2 = new Rectangle(App.WIDTH, alto + ESPACIO_FIGURA, ANCHO, App.HEIGHT - alto);
	}
	
	public void dibujar(Graphics gg)
	{
		gg.setColor(color);
		gg.fillRect(r1.x, r1.y, ANCHO, alto);
		gg.fillRect(r2.x, r2.y, ANCHO, App.HEIGHT - alto);
	}
	
	public int getX()
	{
		return r1.x;
	}
	
	public Rectangle getPos(int choice)
	{
		if (choice == 1)
		{
			return r1;
		}
		else
		{
			return r2;
		}
	}
	
	public void mueve(Pj rect)
	{
		r1.x -= vX;
		r2.x -= vX;
		
		if (r1.intersects(rect) || r2.intersects(rect))
		{
			rect.vivo = false;
			System.out.println("Pajaro: " + rect.vivo);
		}
	}
}
