package EVALUACION2.examen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola extends Rectangle
{
	private final int RADIO = 15;
	private final int TECHO = 0 + RADIO, SUELO = AppletApp.HEIGHT - RADIO;
	private final int PARED_I = 0 + RADIO, PARED_D = AppletApp.WIDTH - RADIO;
	private  int xSpeed, ySpeed;
	private int xAcc, yAcc;
	private Random rand = new Random();
	private Color color;
	private boolean dibujable = true;
	
	public Bola()
	{
		x = rand.nextInt(AppletApp.WIDTH - 2 * RADIO) + RADIO; // Desde 15 hasta 575;
		y = - 10; // Fuera de la pantalla
		width = RADIO;
		height = width;
		xSpeed = 5 + rand.nextInt(5); // Desde 5 a 10;
		ySpeed = 5 + rand.nextInt(5); // Desde 5 a 10;
		color = Color.YELLOW;
		xAcc = 1; // Inicialmente hacia la derecha
		yAcc = 1; // Inicialmente hacia abajo; No debe variar con los chocques
	}
	
	public void mueve(Rectangulo presa)
	{
		x += xAcc * xSpeed;
		y += yAcc * ySpeed;
		if (x <= PARED_I || x >= PARED_D)
		{
			xAcc *= -1;
		}
		if (y >= SUELO)
		{
			dibujable = false;
		}
		if (this.intersects(presa))
		{
			presa.kill();
		}
	}
	
	public void pinta(Graphics g)
	{
		if (dibujable)
		{
			g.setColor(color);
			g.fillOval(x, y, width, height);
		}
	}
	
	public boolean isAlive()
	{
	return dibujable;
	}
}