package EVALUACION3.claseHechos.ejercicio008;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MazoSecundario
{
	List <Carta> mazo;
	private final int X = 250, Y = 0;
	
	public MazoSecundario()
	{
		mazo = new ArrayList<Carta>();
	}
	
	public Carta sacarCarta()
	{
		return mazo.get(mazo.size() - 1);
	}
	
	public void meterCarta(Carta cartaNueva)
	{
		mazo.add(cartaNueva);
		recolocarCarta(cartaNueva);
	}
	
	public void eleminarCarta()
	{
		mazo.remove(mazo.size() - 1);
	}
	public void recolocarCarta(Carta carta)
	{
		carta.move(X, Y);
	}
	
	public void pintarMazo(Graphics g)
	{
		for (Carta carta : mazo) carta.pinta(g);
	}
	
	public List<Carta> getCartas()
	{
		return mazo;
	}
}
