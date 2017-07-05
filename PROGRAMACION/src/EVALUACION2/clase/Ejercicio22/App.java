package EVALUACION2.clase.Ejercicio22;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class App extends Applet implements Runnable
{
	public static final int WIDTH = 600, HEIGHT = 600;
	
	Thread programa;
	private String[] palabras = {"Palabra1", "Palabra2", "Palabra3", "Palabra4", "Palabra5", "Palabra6", "Palabra7", "Palabra8", "Palabra9", "Palabra10"};
	Image imagen;
	Graphics ninja;
	List<Palabra> lista;
	int contador;
	boolean gameOver;
	
	public void init()
	{
		lista = new ArrayList<Palabra>();
		lista.add(new Palabra(palabras[lista.size()]));
		contador = 0;
		gameOver = gameOver();
	}
	
	public void start()
	{
		programa = new Thread(this);
		programa.start();		
	}
	
	public void paint(Graphics g)
	{
		imagen = createImage(WIDTH, HEIGHT);
		ninja = imagen.getGraphics();
		setBackground(Color.BLACK);
		if (!gameOver) pintaPalabras(ninja);
		else pintaGameOver(ninja);
		g.drawImage(imagen, 0, 0, this);
	}
	
	public void run()
	{
		while(true)
		{
			gameOver = gameOver();
			muevePalabras();
			creaPalabras();
			try {
				Thread.sleep(60);
				repaint();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void pintaPalabras(Graphics aux)
	{
		for (int i = 0; i < lista.size(); i++)
		{
			lista.get(i).pinta(aux);
		}
	}
	
	public void muevePalabras()
	{
		for (int i = 0; i < lista.size(); i++)
		{
			lista.get(i).mueve();
			if (!lista.get(i).getEstado()) lista.remove(i);
		}
	}
	
	public void creaPalabras()
	{
			lista.add(new Palabra(palabras[contador++]));
			if (contador == palabras.length) contador = 0;
	}
	
	public boolean gameOver()
	{
	return lista.get(0).getEstado();
	}
	public void pintaGameOver(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawString("Game Over", WIDTH/2, HEIGHT/2);
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		for (int i = 0; i < lista.size(); i++)
		{
			if ((x >= lista.get(i).getX() && x <= (lista.get(i).getX() + lista.get(i).getAncho())) && (y >= lista.get(i).getY() && y <= (lista.get(i).getY() + lista.get(i).getAlto())))
			{
				if(lista.get(i).getHeridas()) lista.remove(i);
				else lista.get(i).setHeridas();
			}
		}
	return true;	
	}
}
