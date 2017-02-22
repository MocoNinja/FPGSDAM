package Ejercicio19;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Font;


public class ArkanoidApp extends Applet implements Runnable 
{
	public static final int FILAS = 5, COLUMNAS = 10;
	public static final int ANCHO = 58,  ALTO = 20;
	public static final int ANCHO_BARRA = ANCHO * 2;
	public static final int ESPACIO = 2;
	
	public static final int DCHA = 0, IZQ = 1;
	
	Color[] colores = {Color.RED, Color.CYAN, Color.GREEN, Color.ORANGE, Color.MAGENTA};
	List<Block> pared = new ArrayList<Block>();
	
	Graphics ninja;
	Image imagen;
	
	Thread juego;
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
			if (bola.derrota || pared.size() == 0)
			{
				System.exit(0);
			}
		}
	}
	
	
	
	public void paint (Graphics gg){
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		setBackground(Color.BLACK);
		
		if (bola.derrota)
		{
			ninja.setColor(Color.RED);
			ninja.setFont(new Font("Comic Sans MS",Font.PLAIN, 48));
			ninja.drawString("Congraturation", 200, 400); 
			ninja.drawString("Eres el master de las pelotas", 100, 600);
		} 
		else
		{
			bola.pinta(ninja);
			barra.pinta(ninja);
			for (int i = 0; i < pared.size(); i++)
			{
				pared.get(i).pinta(ninja);
			}
		}
		gg.drawImage(imagen, 0, 0, this);
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
	
	public boolean keyDown(Event e, int key )
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
