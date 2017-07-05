package EVALUACION3.claseHechos.ejercicio003;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Applet implements Runnable
{
	Thread app;
	Image[][] sprites;
	Image aux;
	Graphics ninja;
	final static int WIDTH = 1000, HEIGHT = 500;
	final int MORO = 0, YANKI = 1, MAFIAS = 2;
	// Image imagen;
	String[] paths = {"EVALUACION3/clase/ejercicio002/sprites/Guerrillero/g", "EVALUACION3/clase/ejercicio002/sprites/Vaquero/v", "EVALUACION3/clase/ejercicio002/sprites/Hampon/h"};
	final int PJS = paths.length, SPS = 4;
	final int MAX_MALOS = 2;
	// Personaje pj;
	Image fondo;
	List<Personaje> malos;
	Random rand = new Random();
	int fallos;
	
	public void init()
	{
		// imagen = getImage(url, name)
		// System.out.println(getDocumentBase());
		// System.out.println(getCodeBase());
		// imagen = getImage(getDocumentBase(), "sprites/Guerrillero/g1.gif");
		
		malos = new ArrayList<Personaje>();
		
		sprites = new Image[PJS][SPS];
		
		for (int i = 0; i < PJS; i++)
		{
			for (int j = 1; j <= SPS; j++)
			{
				sprites[i][j - 1] = getImage(getDocumentBase(), paths[i] + j + ".gif");
			}
		}
		
		
		for (int i = 0; i < MAX_MALOS; i++)
		{
			malos.add(new Personaje(MORO, sprites, rand.nextInt(500), rand.nextInt(300)));
		}
	}
	
	public void mueve()
	{
		for (int i = 0; i < malos.size(); i++)
		{
			malos.get(i).mueve();
			if (malos.get(i).x >= WIDTH)
			{
				malos.remove(i);
				malos.add(new Personaje(MORO, sprites, rand.nextInt(500), rand.nextInt(300)));
			}
		}
	}
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void pintarrujeos(Graphics aux)
	{
		setBackground(Color.BLACK);
		aux.drawImage(fondo, 0, 0, this);

		for (int i = 0; i < malos.size(); i++) malos.get(i).pinta(aux, this);
	}
	
	public void paint(Graphics fake)
	{
		aux = createImage(WIDTH, HEIGHT);
		ninja = aux.getGraphics();
		pintarrujeos(ninja);
		fake.drawImage(aux, 0, 0, this);
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				mueve();
				repaint();
				Thread.sleep(65);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		fallos = 0;
		for (int i = 0; i < malos.size(); i++)
		{
			// el contains no funciona por el super; investigar
			if (x > malos.get(i).x && x < malos.get(i).x + malos.get(i).ANCHO && y > malos.get(i).y && y < malos.get(i).y + malos.get(i).ALTO)
			{
				if (malos.get(i).tipo == paths.length - 1) malos.remove(i);
				else malos.get(i).setTipo(++malos.get(i).tipo);
				break;
				
			}
			else fallos++;
		}
		if (fallos == malos.size())
		{
			malos.add(new Personaje(MORO, sprites, rand.nextInt(500), rand.nextInt(300)));
		}
	return true;
	}
}


