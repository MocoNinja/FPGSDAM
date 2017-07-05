package EVALUACION2.clase.Mondrian03;

import java.applet.Applet;
import java.awt.*;

public class TronchoAntiHorario
{
	
	int posX, posY;
	int ancho, alto;
	
	Color color;
	
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte DCHA = 4;
	static final byte IZQ = 2;
	byte direccion;
	
	static final int margen = 30;
	int TECHO, SUELO, PARED_I, PARED_D;
	int velocidadX = 1, velocidadY = 1;
	
	public TronchoAntiHorario(int x, int y, int ancho, int alto, Color color)
	{
		posX = x;
		posY = y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.direccion = IZQ;
		
		TECHO = y;
		SUELO = y + margen;
		PARED_I = x;
		PARED_D = x  + margen;
		
	}
	
	public void mostrar(Graphics ggez)
	{
		ggez.setColor(color);
		ggez.fillRect(posX, posY, ancho, alto);
	}

	public void mueve()
	{
		switch (direccion){
		case ARRIBA:
			posY -= velocidadY;
			if (posY <= TECHO){
				direccion = IZQ;
			}
			break;
		case ABAJO:
			posY += velocidadY;
			if (posY >= SUELO){
				direccion = DCHA;
			}
			break;
		case DCHA:
			posX += velocidadX;
			if (posX >= PARED_D){
				direccion = ARRIBA;
			}
			break;
		case IZQ:
			posX -= velocidadX;
			if (posX <= PARED_I){
				direccion = ABAJO;
			}
			break;
	}
	}
	
}
	
