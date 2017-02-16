package Ejercicio19BIS;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	Color color;
	
	public Block(int posX, int posY, int ancho, int largo, Color color)	// Ladrillo de Color *definido"
	{
		this.x = posX;
		this.y = posY;
		this.width = ancho;
		this.height = largo;
		this.color = color;
	}
	
	public void pinta(Graphics gg)
	{
		gg.setColor(color);
		gg.fillRect(x, y, width, height);
	}
}
