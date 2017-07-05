package EVALUACION2.clase.Ejercicio22;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Palabra
{
	// NO USAR NADA ESTÁTICO, QUE SI PONÍA HERIDO ESTÁTICO POR EJEMPLO, AL DARLE A UNO SE HERÍAN TODOS
	private int x, y;
	private int ANCHO, ALTO;
	private final int ANCHO_LETRA = 12;
	private final int xSpeed = -10;
	private boolean dibujable = true;
	private boolean herido = false;
	private String palabra;
	Color color;
	Color[] colores = {Color.WHITE, Color.RED, Color.CYAN, Color.YELLOW, Color.GREEN};
	Random rand = new Random();
	
	public Palabra(String palabra)
	{
		ANCHO = palabra.length() * ANCHO_LETRA;
		ALTO = 20;
		x = App.WIDTH - ANCHO;
		y = rand.nextInt(App.HEIGHT - ALTO);
		color = colores[rand.nextInt(colores.length)];
		this.palabra = palabra;
	}
	
	public void mueve()
	{
		if (!herido) color = colores[rand.nextInt(colores.length)];
		else color = Color.RED;
		x += xSpeed;
		if (x <= 0) dibujable = false;
	}
	
	public void pinta(Graphics g)
	{
		//if (dibujable)
	//	{
			g.setColor(color);
			g.fillRect(x, y, ANCHO, ALTO);
			g.setColor(Color.BLACK);
			g.drawString(palabra, x + ANCHO_LETRA, y + ALTO);
	//	}
	}
	
	public boolean getHeridas()
	{
		return herido;
	}
	public void setHeridas()
	{
		this.herido = true;
	}
	public boolean getEstado()
	{
		return dibujable;
	}
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getAncho()
	{
		return ANCHO;
	}
	
	public int getAlto()
	{
		return ALTO;
	}
}
