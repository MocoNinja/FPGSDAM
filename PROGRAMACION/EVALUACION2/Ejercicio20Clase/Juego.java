package Ejercicio20Clase;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Juego extends Applet implements Runnable{
	
	public List<Ovalo> ovalos;
	public List<Rectangulo> rectangulos;
	Thread th;
	
	public final int NUMERO_MAX = 100;
	
	public void init()
	{
		th = new Thread();
		th.start();
		ovalos = new ArrayList<Ovalo>();
		rectangulos= new ArrayList<Rectangulo>();
		for (int i = 0; i < NUMERO_MAX; i++)
		{
			ovalos.add(new Ovalo());
		}
		rectangulos.add(new Rectangulo());
		
	}
		
	public void paint(Graphics g)
	{
		for (int i = 0; i < ovalos.size(); i++)
		{
			for (int j = 0; j < rectangulos.size(); j++)
			{
				rectangulos.get(j).dibujar(g);
			}
			ovalos.get(i).dibujar(g);
		}
	}

	public void run() {
		while(true)
		{
			for (int i = 0; i < ovalos.size(); i++)
			{
				ovalos.get(i).actualizar();
			}
			for (int i = 0; i < rectangulos.size(); i++)
			{
				rectangulos.get(i).actualizar();
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
