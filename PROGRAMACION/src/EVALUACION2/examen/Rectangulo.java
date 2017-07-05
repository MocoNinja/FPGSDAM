package EVALUACION2.examen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Rectangulo extends Rectangle
{
	private final int ANCHO = 15;
	private final int LARGO = 20;
	private Color color;
	private boolean vivo = true;
	
	public Rectangulo()
	{
		x = AppletApp.WIDTH / 2;
		y = AppletApp.HEIGHT * 9 / 10;
		width = ANCHO;
		height = LARGO;
		color = Color.MAGENTA;
	}
	
	public void pinta(Graphics g)
	{
			g.setColor(color);
			g.fillRect(x, y, width, height);
	}
	
	public boolean isAlive()
	{
	return vivo;
	}
	
	public void kill()
	{
		vivo = false;
	}
}
