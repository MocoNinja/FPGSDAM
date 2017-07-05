package EVALUACION3.claseHechos.ejercicio008;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class MazoJuego extends Rectangle
{

	List<Carta> cartas;

	private static final int X = 150, Y = 350;
	private  int numeroMazo;
	private Color color;
	private int colorPalo;
	
	public MazoJuego(int numeroMazo)
	{
		super(X + numeroMazo * Carta.ANCHO, Y, Carta.ANCHO, Carta.ALTO);
		cartas = new ArrayList<Carta>();
		this.numeroMazo = numeroMazo;
		color = SolitarioApp.colores[SolitarioApp.colores.length - 1 - numeroMazo];
	}
	
	public boolean entraCarta(Carta carta)
	{
		Carta cartaMeter = carta;
		if (cartas.size() == 0)
		{
			setColorPalo(getColorPalo(carta));
		}
		else if (!(getColorPalo(carta) == this.colorPalo) && (cartas.get(cartas.size() - 1).getValor() - carta.getValor()) == 1)
		{
			
		}
		else 
		{
			return false;
		}
		setColorPalo(getColorPalo(carta));
		cartas.add(cartaMeter);
		cartas.get(cartas.indexOf(cartaMeter)).move(x, y + (cartas.size()  - 1)* 25);
		this.move(cartas.get(cartas.size() - 1).x, cartas.get(cartas.size() - 1).y);

		return true;
	}
	
	public Carta sacarUltimaCarta()
	{
		return cartas.get(cartas.size() - 1);
	}
	
	
	private void setColorPalo(int color)
	{
		this.colorPalo = color;
	}
	
	private int getColorPalo(Carta carta)
	{
		int palo = carta.getPalo();
		switch(palo)
		{
		case Carta.PICAS:
		case Carta.TREBOLES:
			return Carta.NEGRO;
		case Carta.DIAMANTES:
		case Carta.CORAZONES:
			return Carta.ROJO;
		default:
			return -1;
		}
	}
	
	public void paint(Graphics g)
	{
		if (cartas.size() == 0) pintarRectangles(g);
		for (Carta carta : cartas)
		{
			carta.pinta(g);
		}
	}
	
	private void pintarRectangles(Graphics g)
	{
		
		g.setColor(color);
		g.fillRect(x, y, Carta.ANCHO, Carta.ALTO);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, Carta.ANCHO, Carta.ALTO);
	}
}
