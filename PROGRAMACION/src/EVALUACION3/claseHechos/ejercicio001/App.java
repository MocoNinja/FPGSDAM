package EVALUACION3.claseHechos.ejercicio001;

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
	String[] paths = {"EVALUACION3/clase/ejercicio001/sprites/Guerrillero/g", "EVALUACION3/clase/ejercicio001/sprites/Vaquero/v", "EVALUACION3/clase/ejercicio001/sprites/Hampon/h"};
	final int PJS = paths.length, SPS = 4;
	final int MAX_MALOS = 10;
	// Personaje pj;
	Image fondo;
	List<Personaje> malos;
	Random rand = new Random();
	Bomba bomba;
	
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
		
		// pj = new Personaje(MORO, sprites, 0, 0);
		
		for (int i = 0; i < MAX_MALOS; i++)
		{
			malos.add(new Personaje(rand.nextInt(3), sprites, rand.nextInt(800), rand.nextInt(300)));
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
		// aux.drawImage(imagen, 0, 0, this);
		//fondo = getImage(getCodeBase(), "sprites/" + (pj.getTipo() + 1) + ".gif");
		aux.drawImage(fondo, 0, 0, this);
		// pj.pinta(aux, this);
		
		for (int i = 0; i < malos.size(); i++) malos.get(i).pinta(aux, this);
		if(bomba != null) bomba.pinta(ninja);
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
		
		// System.out.println("click en " + x + ", " + y);
		for (int i = 0; i < malos.size(); i++)
		{
			if (x > malos.get(i).x && x < malos.get(i).x + malos.get(i).ANCHO && y > malos.get(i).y && y < malos.get(i).y + malos.get(i).ALTO)
			{
				malos.remove(i);
				break;
			}
		}
		
		//bomba = new Bomba(x, y, malos, this);
		//bomba.mata();
		//repaint();
	return true;
	}
	
public boolean keyDown(Event e, int tecla)
	{
		System.out.println(tecla);
		// 87 w
		// 65 a
		// 83 s
		// 86 d
		// 109: Guerrillero (m)
		// 103: Guerrillero (g)
		// 104: Hampon (h)
		// 118: Vaquero (v)
		// 1007: flecha derecha
		// if (tecla == 109) pj = new Personaje(MORO, sprites, 0, 0); // Esta forma me gusta menos
		for (int i = 0; i < malos.size(); i++) 
		{
			if (tecla == 104) malos.get(i).setTipo(MAFIAS);
			if (tecla == 118) malos.get(i).setTipo(YANKI);
			if (tecla == 103) malos.get(i).setTipo(MORO);
			if (tecla == 86) malos.get(i).x += 10;
			if (tecla == 55) malos.get(i).x -= 10;
			if (tecla == 87) malos.get(i).y -= 10;
			if (tecla == 83) malos.get(i).y += 10;
		}
		repaint();
	return true;
	}
}

class Bomba extends Rectangle
{
	List<Personaje> malos;
	Image imagen;
	Applet applet;
	
	public Bomba(int x, int y, List<Personaje> malos, Applet applet)
	{
		super();
		this.applet = applet;
		this.x = x;
		this.y = y;
		this.malos = malos;
		imagen = applet.getImage(applet.getDocumentBase(), "sprites/boom.gif");
	}
	
	public void pinta(Graphics g)
	{
		//g.setColor(Color.RED);
		//g.fillOval(x - 75, y - 75, 150, 150);
		g.drawImage(imagen, x, y, 200, 200, applet);
	}
	
	public void mata()
	{
		for (int i = 0; i < malos.size(); i++)
		{
			// investigar: para que valga el contains, pasarle TODO en el constructor.
			if (x > malos.get(i).x && x < malos.get(i).x + malos.get(i).ANCHO && y > malos.get(i).y && y < malos.get(i).y + malos.get(i).ALTO)
			{
				malos.remove(i);
			}
		}
	}
}

