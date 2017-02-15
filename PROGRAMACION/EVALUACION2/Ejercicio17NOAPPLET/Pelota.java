package Ejercicio17NOAPPLET;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota extends Rectangle{
	
	Color[] colores = {Color.RED, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLUE, Color.ORANGE, Color.PINK};
	Color color;
	Random rand = new Random();
	
	int arco1, arco2;
	final static int TECHO = 10, SUELO = 800;
	final static int PARED_I = 10, PARED_D = 800;
	final static int RADIO_MAX = 65;
	
	int xSpeed, ySpeed;
	int yAcc = -1, xAcc = 1;
	
	
	public Pelota()
	{
		x = (int) ((Math.random()*500) + 1);
		y = (int) ((Math.random()*500) + 1);
		
		width = RADIO_MAX;
		height = width;
		arco1 = width;
		arco2 = height;
		color = colores[rand.nextInt(colores.length)];
		
		/* (int) es parsear un entero (convertir)*/
		ySpeed = (int) ((Math.random()*46)); 
		xSpeed = (int) ((Math.random()*46));
	}
	
	public void pinta (Graphics gg)
	{
		gg.setColor(color);
		gg.fillRoundRect(x, y, width, height, arco1, arco2);
	}
	
	public void addSpeed()
	{
		xSpeed += 5;
		ySpeed += 5;
	}
	
	public void rmSize()
	{
		if (width >= 12){
			width -= 2;
			height = width;
		}
	}
	public void mueve(){
		
		if (x >= PARED_D){
			color = colores[rand.nextInt(colores.length)];
			xAcc = -1;
		}
		if (x <= PARED_I){
			color = colores[rand.nextInt(colores.length)];
			xAcc = 1;
		}
		if (y <= TECHO){
			color = colores[rand.nextInt(colores.length)];
			yAcc = 1;
		}
		if (y >= SUELO){
			color = colores[rand.nextInt(colores.length)];
			yAcc = -1;
		}
		
		x += (xSpeed * xAcc);
		y += (ySpeed * yAcc);
	}
}
