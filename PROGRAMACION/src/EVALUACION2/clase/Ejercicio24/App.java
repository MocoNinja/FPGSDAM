package EVALUACION2.clase.Ejercicio24;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.math.*;

/*
* Partimos de un montón de círculos estáticos
* Tenemos un rectángulo que mueve el ratón
* El rectángulo se come a los círculos
* Sin THREADS
*/
public class App extends Applet{

	Escoba pj;
	List<Circulos> mierdas;
	private final int MAX_BOLAS = 20000;
	Color[] colores = {Color.RED/*, Color.BLACK, Color.WHITE, Color.BLUE*/};
	Random rand;
	
	public void init()
	{
		rand = new Random();
		pj = new Escoba();
		mierdas = new ArrayList<Circulos>();
		for (int i = 0; i < MAX_BOLAS; i++) mierdas.add(new Circulos());
	}
	
	public void paint(Graphics fake)
	{
		setBackground(colores[rand.nextInt(colores.length)]);
		pj.pinta(fake);
		for (int i = 0; i < mierdas.size(); i++) mierdas.get(i).pinta(fake);
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		mierdas.add(new Circulos());
		repaint();
		return true;
	}
	
	public boolean mouseMove(Event ev, int x, int y)
	{
		pj.x = x;
		pj.y = y;
		for (int i = 0; i < mierdas.size(); i++)
		{
			if (Math.abs(mierdas.get(i).x - x) < 25 || Math.abs(mierdas.get(i).y - y) < 25)
			{
				mierdas.remove(i);
				mierdas.add(new Circulos());
			}
			repaint();
		}
		/*
		for (int i = 0; i < mierdas.size(); i++)
		{
			if (mierdas.get(i).intersects(pj)) mierdas.remove(i);
		}
		*/
		repaint();
	return true;
	}
	
}
