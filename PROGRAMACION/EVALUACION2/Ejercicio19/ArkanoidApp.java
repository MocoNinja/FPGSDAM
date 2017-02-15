package Ejercicio19;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

import Ejercicio17REMADE.Pelota;

public class ArkanoidApp extends Applet implements Runnable 
{
	final int FILAS_LADRILLOS = 5, COLUMNAS_LADRILLOS = 10;
	
	Block[][] ladrillos = new Block[FILAS_LADRILLOS][COLUMNAS_LADRILLOS];
	Color[] colores = {Color.RED, Color.CYAN, Color.GREEN, Color.ORANGE, Color.MAGENTA};
	
	Bola bola;
	
	Thread juego;
	
	public void init()
	{
		setupLadrillos();
		setupBola();
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
			bola.mueve();
			try{
				Thread.sleep(45);
				repaint();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			};
		}
	}
	
	
	public void paint(Graphics fake)
	{
		for (int fila = 0; fila < FILAS_LADRILLOS; fila++)
		{
			for (int columna = 0; columna < COLUMNAS_LADRILLOS; columna++)
			{
				ladrillos[fila][columna].pinta(fake);
			}
		}
		bola.pinta(fake);
	}
	
	public void setupLadrillos()
	{
		int posXLadrillo;
		int posYLadrillo = 0;
		Color colorFilaLadrillos;
		for (int fila = 0; fila < FILAS_LADRILLOS; fila++)
		{
			colorFilaLadrillos = colores[fila];
			posXLadrillo = 0;
			for (int columna = 0; columna < COLUMNAS_LADRILLOS; columna++)
			{
				ladrillos[fila][columna] = new Block(
						posXLadrillo + (columna*60), 
						posYLadrillo + (fila*20), 
						colorFilaLadrillos, Block.
						LADRILLO);
				posXLadrillo++;
			}
			posYLadrillo++;
		}
	}
	
	public void setupBola()
	{
		bola = new Bola();
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
	return false;
	}
}

