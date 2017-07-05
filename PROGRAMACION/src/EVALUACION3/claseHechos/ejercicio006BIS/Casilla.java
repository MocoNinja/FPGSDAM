package EVALUACION3.claseHechos.ejercicio006BIS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Casilla extends Rectangle
{
	private final int[] negros = {2, 4, 6, 8, 10, 11, 13, 14, 15, 17, 20, 22, 23, 24, 26, 28, 29, 31, 33, 35};
	private final int[] rojos = {1, 3, 5, 7, 9, 12, 16, 18, 19, 21, 25, 27, 30, 32, 34, 36};
	
	public final static int WIDTH = 85, HEIGHT = 45;
	
	private int numero;
	private Color color;
	
	public Casilla(int x, int y, int numero)
	{
		super(x, y, WIDTH, HEIGHT);
		this.numero = numero;
		color = setColor(numero);
	}
	
	private final List<Integer> arrayToList(int[] array)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) list.add(array[i]);
	return list;
	}
	
	public int getNumero()
	{
	return numero;
	}
	
	private Color setColor(int number)
	{
		List<Integer> rojos = arrayToList(this.rojos);
		if (rojos.indexOf(number) != -1) return Color.RED;
		else return Color.BLACK;
	}

	public void paint(Graphics g)
	{
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(Color.WHITE);
		g.drawRect(this.x, this.y, this.width, this.height);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 17));
		g.drawString(Integer.toString(this.numero), this.x + this.width / 2 - 3, this.y + this.height / 2 + 3);
	}
}
