package Ejercicio19BIS;

import java.awt.Color;

public class Barra extends Block{
	
	final static int PARED_I = 0, PARED_D = 600;
	final int XSPEED;
	
	public Barra(int ancho, int alto)
	{
		super(300, 550, ancho, alto, Color.WHITE);
		XSPEED = 15;
	}
	public void mueve(int direccion)
	{
		 if (direccion == ArkanoidApp.DCHA)
		 {
			 x += XSPEED;
		 }
		 else
		 {
			 x -= XSPEED;
		 }
		 
		 if (x < PARED_I)
		 {
			 x = 0;
		 }
		 if (x > PARED_D - width)
		 {
			 x = PARED_D - width;
		 }
	}
}
