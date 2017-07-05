package EVALUACION3.claseHechos.ejercicio010;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{

	public static final int ANCHO = 30, ALTO = 30;
	private Image imagenFondo;
	private Image imagenMina;
	private Image imagenBandera;
	private int minasAdyacentes;
	private Applet applet;
	boolean isMina;
	boolean isBandera;
	boolean descubierta;
	
	public Casilla(int x, int y, Image imagenFondo, Applet applet)
	{
		super(x, y, ANCHO, ALTO);
		this.imagenFondo = imagenFondo;
		this.applet = applet;
		isMina = false;
		descubierta = false;
		isBandera = false;
	}
	
	public void pinta(Graphics g, Applet applet)
	{
		if (isMina && descubierta) g.drawImage(imagenMina, x, y, width, height, applet);
		else if (isBandera) g.drawImage(imagenBandera, x, y, width, height, applet);
		else if (!descubierta) g.drawImage(imagenFondo, x, y, width, height, applet);
		else {
			switch (minasAdyacentes) {
			case 1:
				g.setColor(Color.BLACK);
				break;
			case 2:
				g.setColor(Color.YELLOW);
				break;
			case 3:
				g.setColor(Color.RED);
				break;
			case 4:
				g.setColor(Color.BLUE);
				break;
			default:
				g.setColor(Color.GREEN);
				break;
			}
			g.setFont(new Font("Arial", Font.BOLD, 22));
			g.drawImage(imagenFondo, x, y, width, height, applet);
			g.drawString(String.valueOf(minasAdyacentes), x + 9, y + 23);
		}
	}
	
	public boolean isDescubierta()
	{
		return this.descubierta;
	}
	public void setImagenMina(Image imagenMina)
	{
		this.imagenMina = imagenMina;
	}
	public boolean isMina(){
		return this.isMina;
	}
	
	public void setMina()
	{
		isMina = true;
	}

	public int minasAdyacetes()
	{
		return this.minasAdyacentes;
	}
	public void calcularMinasAdyacentes(Casilla[][] campo, int fila, int columna) {
		minasAdyacentes = 0;
		
		int columnaMin, columnaMax, filaMin, filaMax;
		switch(fila)
		{
		case 0: filaMin = 0; filaMax = fila + 1; break;
		case Buscaminas.FILAS - 1: filaMin = fila - 1; filaMax = fila; break;
		default: filaMin = fila - 1; filaMax = fila + 1; break;
		}
		switch(columna)
		{
		case 0: columnaMin = 0; columnaMax = columna + 1; break;
		case Buscaminas.COLUMNAS - 1: columnaMin = columna - 1; columnaMax = columna; break;
		default: columnaMin = columna - 1; columnaMax = columna + 1; break;
		}

		for (int filaActual = filaMin; filaActual <= filaMax; filaActual++)
		{
			for (int columnaActual = columnaMin; columnaActual <= columnaMax; columnaActual++)
			{
				if (campo[filaActual][columnaActual].isMina) minasAdyacentes++;
			}
		}
	}
	
	
	public boolean isRangoValido(int fila, int columna)
	{
		if (!(fila >= 1 && fila < Buscaminas.FILAS)) return false;
		if (!(columna >= 1 && fila < Buscaminas.COLUMNAS)) return false;
		return true;
	}
	
//	public void limpiarVacias(Casilla[][] campo, int fila, int columna)
//	{
//		int columnaMin, columnaMax, filaMin, filaMax;
//		switch(fila)
//		{
//		case 0: filaMin = 0; filaMax = fila + 1; break;
//		case Buscaminas.FILAS - 1: filaMin = fila - 1; filaMax = fila; break;
//		default: filaMin = fila - 1; filaMax = fila + 1; break;
//		}
//		switch(columna)
//		{
//		case 0: columnaMin = 0; columnaMax = columna + 1; break;
//		case Buscaminas.COLUMNAS - 1: columnaMin = columna - 1; columnaMax = columna; break;
//		default: columnaMin = columna - 1; columnaMax = columna + 1; break;
//		}
//
//		for (int filaActual = filaMin; filaActual <= filaMax; filaActual++)
//		{
//			for (int columnaActual = columnaMin; columnaActual <= columnaMax; columnaActual++)
//			{
//				campo[filaActual][columnaActual].descubierta = true;
//			}
//		}
//		if (campo[filaMax + 1][columnaMax + 1].minasAdyacentes == 0) limpiarVacias(campo, filaMax + 1, columnaMax + 1);
//	}

	public void limpiarCero(Casilla[][] campo, int fila, int columna)
	{
		int columnaMin, columnaMax, filaMin, filaMax;
		switch(fila)
		{
		case 0: filaMin = 0; filaMax = fila + 1; break;
		case Buscaminas.FILAS - 1: filaMin = fila - 1; filaMax = fila; break;
		default: filaMin = fila - 1; filaMax = fila + 1; break;
		}
		switch(columna)
		{
		case 0: columnaMin = 0; columnaMax = columna + 1; break;
		case Buscaminas.COLUMNAS - 1: columnaMin = columna - 1; columnaMax = columna; break;
		default: columnaMin = columna - 1; columnaMax = columna + 1; break;
		}

		for (int filaActual = filaMin; filaActual <= filaMax; filaActual++)
		{
			for (int columnaActual = columnaMin; columnaActual <= columnaMax; columnaActual++)
			{
				campo[filaActual][columnaActual].descubierta = true;
			}
		}
	}
	
	public void descubrir(Casilla[][] campo, int fila, int columna)
	{
		descubierta = true;
		if (minasAdyacentes == 0){
		}
	}
	
	public int minasPegas()
	{
		return this.minasAdyacentes;
	}
}
