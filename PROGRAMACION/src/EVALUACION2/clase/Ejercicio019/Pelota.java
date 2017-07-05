package EVALUACION2.clase.Ejercicio019;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Pelota extends Block{
	
	final static int RADIO = 10;
	final static int posX = 300, posY = 300;
	final static int TECHO = 10, SUELO = 600;
	final static int PARED_I = 10, PARED_D = 600;
	
	int xSpeed = 2, ySpeed = 2;
	int yAcc = -1, xAcc = 1;
	Rectangle objetivo;
	
	boolean derrota;
	
	public Pelota()
	{
		super(posX, posY, RADIO, RADIO, Color.RED);
		derrota = false;
	}
	
	public void mueve(List<Block> pared, Rectangle raqueta)
	{
		if (this.intersects(raqueta))
		{
			yAcc *= -1;
		}
		else
		{
			for (int i = 0; i < pared.size(); i++)
			{
				if (this.intersects(pared.get(i)))
				{
					pared.remove(i);
					yAcc *= -1;
					break;
				}
			}
		}
		
		if (x >= PARED_D){
			xAcc = -1;
		}
		if (x <= PARED_I){
			xAcc = 1;
		}
		if (y <= TECHO){
			yAcc = 1;
			xAcc *= -1;
		}
		if (y >= SUELO){
			derrota = true;
		}
		
		x += (xSpeed * xAcc);
		y += (ySpeed * yAcc);
	}

	public void pinta(Graphics gg)
	{
		gg.setColor(color);
		gg.fillRoundRect(x, y, width, height, width, height);
	}
}