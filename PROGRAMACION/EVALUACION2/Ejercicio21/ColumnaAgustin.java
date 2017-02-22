package Ejercicio21;

import java.awt.Graphics;
import java.awt.Rectangle;

public class ColumnaAgustin {

	Rectangle r1, r2;
	
	public ColumnaAgustin()
	{
		int altura = (int)(Math.random() + 150) + 50;
		r1 = new Rectangle(200, 0, 30, altura);
		r2 = new Rectangle(200, altura + 50, 30, 300 - (altura + 50));
	}
	
	public void pintar(Graphics gg)
	{
		
	}
}
