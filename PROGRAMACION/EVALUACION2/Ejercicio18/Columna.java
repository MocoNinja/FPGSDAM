package Ejercicio18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;
public class Columna extends Rectangle{
	
	Color color = Color.YELLOW;
	final int ancho = 100;
	final int alto = 600;
	Random rand = new Random();
	Color colorHUECO = Color.BLACK;
	int xFill , yFill;
	public Columna()
	{
		x = 0;
		xFill = x;
		y = 0; 
		yFill = 0;
		width = ancho;
		height = rand.nextInt(200) + 100;
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillRect(xFill, yFill, ancho, alto);
		g.setColor(colorHUECO);
		g.fillRect(x, y, width, height);
	}
}