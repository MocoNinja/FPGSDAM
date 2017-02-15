package Ejercicio19;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	static final int LADRILLO = 0;
	static final int BARRA = 1;
	static final int BOLA = 2;
	
	int tipo; // Porque vamos a usarla como superclase para hacer pelotas y ladrillos
	Color color;
	boolean visible = true;
	
	public Block(int posX, int posY, Color color, int tipo)	// Ladrillo de Color *definido"
	{
		this.x = posX;
		this.y = posY;
		this.width = 60;
		this.height = 20;
		this.color = color;
		this.tipo = tipo;
	}
	
	public Block(int tipo)
	{
		this.color = Color.RED;
		this.tipo = tipo;
	}
	
	public void pinta(Graphics gg)
	{
		gg.setColor(color);
		if (visible)
		{
			switch (tipo)
			{
			case BOLA:
				gg.fillRoundRect(x, y, width, height, width, height);
				break;
			case LADRILLO:
				gg.fillRect(x, y, width, height);
				break;
			case BARRA:
				gg.fillRect(x, y, width, height);
				break;
			}
			
		}
	}
}
