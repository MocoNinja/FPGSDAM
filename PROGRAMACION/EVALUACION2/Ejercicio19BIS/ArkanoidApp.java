package Ejercicio19BIS;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;


public class ArkanoidApp extends Applet implements Runnable 
{
	public static final int FILAS = 5, COLUMNAS = 10;
	public static final int ANCHO = 58,  ALTO = 20;
	public static final int ANCHO_BARRA = ANCHO * 2;
	public static final int ESPACIO = 2;
	
	public static final int DCHA = 0, IZQ = 1;
	
	Color[] colores = {Color.RED, Color.CYAN, Color.GREEN, Color.ORANGE, Color.MAGENTA};
	List<Block> pared = new ArrayList<Block>(FILAS*COLUMNAS);
	
	Thread juego;
	Image image;
	Graphics ninja;
	Pelota bola;
	Barra barra;
	
	public void init()
	{
		setupLadrillos();
		barra = new Barra(ANCHO_BARRA, ALTO);
		bola = new Pelota();
	}
	public void start()
	{
		juego = new Thread(this);
		juego.start();
		
	}
	
	public void run() 
	{
		while(true)
		{
			bola.mueve(pared, barra);
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void paint(Graphics fake)
	{
		setBackground(Color.BLACK);
		bola.pinta(fake);
		barra.pinta(fake);
		for (int i = 0; i < pared.size(); i++)
		{
				pared.get(i).pinta(fake);
		}
	}
	
	public void setupLadrillos()
	{
		for (int fila = 0; fila < FILAS; fila++)
		{
			for (int columna = 0; columna < COLUMNAS; columna++)
			{
				pared.add(new Block(columna*(ANCHO + ESPACIO) + ESPACIO, fila*(ALTO + ESPACIO) + ESPACIO, ANCHO, ALTO, colores[fila]));
			}
		}
	}
	/*
	public boolean mouseMove(Event e, int x, int y)
	{
		if (x < 600 - ANCHO_BARRA)
			barra.x = x;
		//barra.y = y;
	return true;
	}
	*/
	
	public boolean keyDown( Event e, int key )
	   {
	      System.out.println(key);
	      switch (key) {
				case 49 :
					barra.mueve(IZQ);
					break;
		
				case 51 :
					barra.mueve(DCHA);
					break;
				}
	      return true;  
	   }
}

