package EVALUACION3.claseHechos.ejercicio008;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazoObjetivo extends Rectangle
{
	List<Carta> cartas;

	private int PALO;
	private static final int X = 650, Y = 0;
	private  int numeroMazo;
	private Color color;
	
	public MazoObjetivo(int numeroMazo)
	{
		super(X + numeroMazo * Carta.ANCHO, Y, Carta.ANCHO, Carta.ALTO);
		cartas = new ArrayList<Carta>();
		this.numeroMazo = numeroMazo;
		color = SolitarioApp.colores[numeroMazo];
	}
	
	public boolean entraCarta(Carta carta)
	{
		if (carta.getValor() == 1 && cartas.size() == 0)
		{
			setPalo(carta);
		} else if (carta.getPalo() == this.PALO && (carta.getValor() - cartas.get(cartas.size() - 1).getValor() == 1))
		{
			
		} else
		{
			return false;
		}
		cartas.add(carta);
		return true;
	}
	
	private void meterCarta(Carta carta)
	{
		cartas.add(carta);
	}
	
	private void setPalo(Carta carta)
	{
		this.PALO = carta.getPalo();
	}
	
	public void paint(Graphics g)
	{
		if (cartas.size() == 0) pintarRectangles(g);
		for (Carta carta : cartas)
		{
			carta.move(x, y);
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
