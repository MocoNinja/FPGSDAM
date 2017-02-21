package Ejercicio20;

/*
* Va a haber dos clases A y B, que son iguales pero con la diferencia en los dibujos (rectangles)
*  A sibuja ovalos y b rectangulos
*  Este Applet tendra 1 lista de 100 objetos de A y otra con 1 de B
*  Cada vez que un cuadrado choca con un ovalo, lo elimina y lo añade a la clase B
*/

import java.util.*;
import java.util.List;

import Ejercicio17REMADE.Pelota;
import Ejercicio19BIS.Barra;

import java.applet.Applet;
import java.awt.*;

public class AppletApp extends Applet implements Runnable{
	public final static int WIDTH = 600;
	public final static int HEIGHT = 600;
	
	final static int OVALOS_INICIO = 100;
	final static int RECTANGULOS_INICIO = 1;
	
	List<Ovalos> ovals = new ArrayList<Ovalos>();
	List<Rectangulos> rects = new ArrayList<Rectangulos>();
	
	final static int LLENA_OVALOS = 1;
	final static int LLENA_RECTANGULOS = 0;
	static int llena = 1;
	
	Thread programa;
	// HACER QUE CUANDO ACABE, VUELVA A EMPEZAR EN EL SENTIDO OPUESTO
	public void init()
	{
		setup();
	}
	public void start()
	{
		programa = new Thread(this);
		programa.start();
		
	}
	
	@Override
	public void run() {
		while (true)
		{
			for (int j = 0; j < rects.size(); j++)
				{
					for (int i = 0; i < ovals.size(); i++)
					{
							ovals.get(i).mueve(rects.get(j));
							rects.get(j).mueve(ovals.get(i));
							colisionator(ovals.get(i), rects.get(j));
					}
				}
			if (ovals.size() == 0)
				llena = LLENA_OVALOS;
			if (rects.size() == 0)
				llena = LLENA_RECTANGULOS;
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setup()
	{
		// Cargar los ovalos
		for (int i = 0; i < OVALOS_INICIO; i++)
		{
			ovals.add(new Ovalos());
		}
		
		// Cargar los rectangulos
		for (int i = 0; i < RECTANGULOS_INICIO; i++)
		{
			rects.add(new Rectangulos());
		}
	}
	
	public void paint(Graphics g)
	{
		for (int i = 0; i < ovals.size(); i++)
		{
			ovals.get(i).pintar(g);
		}
		for (int i = 0; i < rects.size(); i++)
		{
			rects.get(i).pintar(g);
		}
	}

	public void colisionator(Rectangle objetoEliminar, Rectangle objetoMeter)
	{
		switch (llena)
		{
		case LLENA_OVALOS:
			if (objetoMeter.colision && objetoMeter.objetivo != null)
			{
				rects.remove(objetoEliminar);
				ovals.add(new Ovalos());
			}
			break;
		case LLENA_RECTANGULOS:
			if (objetoMeter.colision && objetoMeter.objetivo != null)
			{
				ovals.remove(objetoEliminar);
				rects.add(new Rectangulos());
			}
			break;
		}
	}
}
