package EVALUACION3.rehechosCasa.Ruleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Casilla extends Rectangle
{
	public static final int[] rojos = {1,3,5,7,9,12,14,16,18,21,23,25,27,30,32,34,36};
	private final int[] negros = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
	public static final String[] CASILLAS_ESPECIALES = {"ROJO", "NEGRO", "PAR", "IMPAR", "PASA", "FALTA"};
	private int valor;
	private String etiqueta;
	private List<Integer> valorNumerico;
	private Color color;
	public static final int ANCHO = 100, ALTO = 50;
	
	public Casilla(int x, int y, int valor)
	{
		super(x, y, ANCHO, ALTO);
		this.valor = valor;
		this.etiqueta = Integer.toString(valor);
		this.color = setColor(valor);
		valorNumerico = new ArrayList<Integer>();
		valorNumerico.add(valor);
	}
	
	public Casilla(int x, int y, int valor, int ancho, int alto)
	{
		super(x, y, ancho, alto);
		this.valor = valor;
		this.etiqueta = Integer.toString(valor);
		this.color = setColor(valor);
		valorNumerico = new ArrayList<Integer>();
		valorNumerico.add(valor);
	}
	
	public Casilla(int x, int y, String valor)
	{
		super(x, y, ANCHO, ALTO);
		this.etiqueta = valor;
		this.color = Color.GRAY;
		valorNumerico = new ArrayList<Integer>();
		switch (valor)
		{
		case "ROJO":
			for (int i = 0; i < rojos.length; i++) valorNumerico.add(rojos[i]);
			break;
		case "NEGRO":
			for (int i = 0; i < negros.length; i++) valorNumerico.add(negros[i]);
			break;
		case "PAR":
			for (int i = 1; i <= 36; i++) if (i % 2 == 0) valorNumerico.add(i);
			break;
		case "IMPAR":
			for (int i = 1; i <= 36; i++) if (i % 2 != 0) valorNumerico.add(i);
			break;
		case "PASA":
			for (int i = 1; i <= 18; i++) valorNumerico.add(i);
			break;
		case "FALTA":
			for (int i = 19; i <= 36; i++) valorNumerico.add(i);
			break;
		}
	}
	
	private Color setColor(int valor)
	{
		for (Integer numero : rojos)
			if (valor == numero) return Color.RED;
		return Color.BLACK;
	}

	public void pinta(Graphics g)
	{
		g.setFont(new Font("Times", Font.PLAIN, 12));
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
		g.drawString(etiqueta, x + width / 2, y + height / 2);
	}
	
	public List<Integer> getNumerosApostados()
	{
		return this.valorNumerico;
	}
	
	public void leerNumerosApostados()
	{
		for (Integer numero : valorNumerico) System.out.printf("%5d", numero);
		System.out.println();
	}
}
