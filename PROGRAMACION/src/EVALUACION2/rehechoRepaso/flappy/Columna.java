package EVALUACION2.rehechoRepaso.flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Columna
{
	Rectangle arriba, abajo;
	final int ANCHO = 50;
	final static int ESPACIO = 250;
	int altura;
	Color color;
	Random rand = new Random();
	final int speed = 5;
	int x;
	public Columna(int posX)
	{
		x = posX;
		altura = rand.nextInt(100) + 100;
		color = Color.WHITE;
		arriba = new Rectangle(posX, 0, ANCHO, altura);
		abajo = new Rectangle(posX, altura + ESPACIO, ANCHO, 1000);
	}
	
	public void mueve(Pajaro pajaro)
	{
		x -= speed;
		arriba.x -= speed;
		abajo.x -= speed;
		if (arriba.intersects(pajaro) || abajo.intersects(pajaro)) pajaro.kill();
	}
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillRect(arriba.x, arriba.y, arriba.width, arriba.height);
		g.fillRect(abajo.x, abajo.y, abajo.width, abajo.height);
	}
}
