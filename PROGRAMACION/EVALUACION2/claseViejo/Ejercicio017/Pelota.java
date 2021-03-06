package claseViejo.Ejercicio017;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota extends Rectangle{
	
	Color[] colores = {Color.RED, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLUE, Color.ORANGE, Color.PINK};
	int arco1, arco2;
	Color color;
	final int TECHO = 10, SUELO = 800;
	final int PARED_I = 10, PARED_D = 800;
	int sentido;
	Random rand = new Random();
	int ySpeed = 30;
	int xSpeed = 30;
	int yAcc = -1;
	int xAcc = 1;
	boolean pintaLienzo = true;
	public Pelota()
	{
		x = rand.nextInt(900);
		y = rand.nextInt(600);
		width = 105;
		height = 105;
		arco1 = width;
		arco2 = height;
		color = colores[rand.nextInt(colores.length)];
	}
	
	public void pinta (Graphics gg)
	{
		gg.setColor(Color.WHITE);
		gg.drawRect(PARED_I, TECHO, PARED_D + width, SUELO + height);
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
		if (width > 10){
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
