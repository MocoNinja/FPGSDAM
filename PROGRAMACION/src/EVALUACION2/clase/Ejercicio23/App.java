package EVALUACION2.clase.Ejercicio23;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class App extends Applet implements Runnable
{
	public final static int WIDTH = 1000, HEIGHT = 1000;
	private final String[] palabras = {"Palabra1", "Palabra2", "Palabra3", "Palabra4", "Palabra5"};
	Palabra word;
	Thread app;
	Image canvas;
	Graphics ninja;
	List<Palabra> lista; // Repetir con una Palabra a la que no se le pase inicialmente la palabra
	private int contador;
	
public void init()
	{
		word = new Palabra(palabras[0]);
		lista = new ArrayList<Palabra>();
		contador = 0;
	}
	
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void paint(Graphics g)
	{
		canvas = createImage(WIDTH, HEIGHT);
		ninja = canvas.getGraphics();
		setBackground(Color.BLACK);
		pintarrujeos(ninja);
		g.drawImage(canvas, 0, 0, this);
	}
	
	public void pintarrujeos(Graphics h)
	{
		for (int i = 0; i < lista.size(); i++) lista.get(i).pinta(h);
	}
	
	public void movimientos()
	{
		for (int i = 0; i < lista.size(); i++) lista.get(i).mueve();
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		for (int i = 0; i < lista.size(); i++) if (lista.get(i).contains(x, y)) lista.get(i).click();
	return true;
	}
	
	public void creaPalabras(int valor)
	{
		if (contador % 5 == 0 && lista.size() < palabras.length) lista.add(new Palabra(palabras[lista.size()]));
	}
	
	public void run()
	{
		while(true)
		{
			movimientos();
			creaPalabras(contador++);
			try {
				Thread.sleep(60);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
