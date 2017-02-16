package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Bola extends Block{
	
	final static int TECHO = 10, SUELO = 600;
	final static int PARED_I = 10, PARED_D = 600;
	
	int xSpeed = 5, ySpeed = 5;
	int yAcc = -1, xAcc = 1;
	
	Random rand = new Random();
	public Bola()
	{
		super(Block.BOLA);
		width = 15;
		height = 15;
		x = rand.nextInt(300) + 100;
		y = x;
		color = Color.LIGHT_GRAY;
	}
	
	public void mueve()
	{
		if (x >= PARED_D){
			xAcc = -1;
		}
		if (x <= PARED_I){
			xAcc = 1;
		}
		if (y <= TECHO){
			yAcc = 1;
		}
		if (y >= SUELO){
			yAcc = -1;
		}
		
		x += (xSpeed * xAcc);
		y += (ySpeed * yAcc);
	}
}
