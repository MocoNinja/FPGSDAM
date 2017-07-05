package EVALUACION3.claseHechos.ejercicio006BIS;

import java.util.ArrayList;
import java.util.List;

public class Apuesta
{
	private Ficha ficha;
	private List<Casilla> casillas;
	private int valor;
	
	public Apuesta()
	{
		casillas = new ArrayList<Casilla>();
	}
	
	public List<Casilla> getCasillas()
	{
	return casillas;
	}
	
	public void setCasillas(Casilla casilla)
	{
		casillas.add(casilla);
	}
	
	public int getCasillasApostadas()
	{
	return casillas.size();
	}
	
	public Ficha getFicha()
	{
	return ficha;
	}
	
	public void setFicha(Ficha ficha)
	{
		this.ficha = ficha;
		this.valor = ficha.getValor();
	}

	public double getValorApuesta()
	{
		System.out.println(valor);
		System.out.println(getCasillasApostadas());
		int valorApuesta = 36 * valor / getCasillasApostadas();
		System.out.println(valorApuesta);
	return valorApuesta;
	}
}
