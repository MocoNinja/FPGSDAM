package EVALUACION3.claseHechos.ejercicio006;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Numero extends Rectangle
{
	private final int[] negros = {2, 4, 6, 8, 10, 11, 13, 14, 15, 17, 20, 22, 23, 24, 26, 28, 29, 31, 33, 35};
	private final int[] rojos = {1, 3, 5, 7, 9, 12, 16, 18, 19, 21, 25, 27, 30, 32, 34, 36};
	private int numero;
	public final static int ANCHO = 80, ALTO = 35;
	Color color;
	List<Integer> apuestaComplex;
	public Numero(int x, int y, int numero)
	{
		super(x, y, ANCHO, ALTO);
		this.numero = numero;
//		color = setColor(this.numero, this.negros, this.rojos);
		color = setColor(this.numero);
	}
	
	
	public void pinta(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		g.drawString(Integer.toString(numero), x + width / 2 , y + height / 2);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, width, height);
	}
	// Mejor con listas
//	public Color setColor(int numero, int[] color1, int[] color2)
//	{
//		for (int i = 0; i < color2.length; i++)
//		{
//			if (numero == color2[i])
//			{
//			return this.color2;
//			}
//		}
//	return this.color1;
//	}
	
	public Color setColor(int numero)
	{
		List<Integer> lista = vectorToLista(rojos);
		Color color;
		if (lista.contains(numero)) color = Color.RED;
		else color = Color.BLACK;
	return color;
	}
	
	public int getNumero()
	{
	return this.numero;
	}
	
	public Color getColor()
	{
	return this.color;
	}
	
	public List<Integer> vectorToLista(int[] vector)
	{
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < vector.length; i++) lista.add(vector[i]);
	return lista;
	}
	
	public void apostar()
	{
		apuestaComplex = new ArrayList<Integer>();
	}
}
