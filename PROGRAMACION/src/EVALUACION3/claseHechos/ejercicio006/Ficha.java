package EVALUACION3.claseHechos.ejercicio006;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ficha extends Rectangle
{
	static Random  rand = new Random();
	private Color colorFicha = Color.YELLOW;
	List<Numero> numeros;
	List<Integer> casillasApostadas;
	private int precio;
	
	public Ficha(List<Numero> numeros, int precio)
	{
		super(400, 40 + precio * 25, 20, 20);
		this.numeros = numeros;
		this.precio = precio;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		g.setColor(colorFicha);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(precio), x + 5, y + 15);
	}
	
	public int numeroCasilla(Numero casilla)
	{
		int numero = casilla.getNumero();
	return numero;
	}
	
	public Color colorCasilla(Numero casilla)
	{
		Color color = casilla.getColor();
	return color;
	}
	
	public void comprobar()
	{
		casillasApostadas = new ArrayList<Integer>();
		for (Numero numero: numeros)
		{
			if (numero.intersects(this))
			{
//				System.out.println("Hay una interseccion. " + "Su n�mero es: " +  numeroCasilla(numero) + "Su color es: " + colorCasilla(numero));
				casillasApostadas.add(numeroCasilla(numero));
			}
		}
	}
	public void leerApuestas()
	{

		System.out.print("Esta ficha apuesta por los n�meros: ");
		for (Integer cual : casillasApostadas)
			System.out.printf(" %2d ", cual);
		System.out.println();
	}
	
	public List<Integer> getApuesta()
	{
		List<Integer> apuestas = new ArrayList<Integer>();
		for (Integer cual : casillasApostadas)
			apuestas.add(cual);
	return apuestas;
	}
	
	public void mueve(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getPrecio()
	{
		return precio;
	}
}