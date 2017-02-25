package claseViejo.Ejercicio014;
import java.awt.*;

public class TronchoHorario
{
	
	// Características de un rectángulo...
	int posX, posY;
	int ancho, alto;
	Color color;
	
	// Que ademas es movil
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte DCHA = 4;
	static final byte IZQ = 2;
	byte sentido;
	
	static final int margen = 30;
	int TECHO, SUELO, PARED_I, PARED_D;
	int vX = 10, vY = 10;

	public TronchoHorario(int x, int y, int ancho, int alto, Color color)
	{
		posX = x;
		posY = y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.sentido = DCHA;
		
		int TECHO = y;
		int SUELO = y + margen;
		int PARED_I = x;
		int PARED_D = x  + margen;
		
	}
	
	public void mostrar(Graphics ggez)
	{
		ggez.setColor(color);
		ggez.fillRect(posX, posY, ancho, alto);
	}

	public void mueve()
	{
		switch (sentido){
		case ARRIBA:
			posY -= vY;
			if (posY <= TECHO){
				sentido = DCHA;
			}
			break;
		case ABAJO:
			posY += vY;
			if (posY >= SUELO){
				sentido = IZQ;
			}
			break;
		case DCHA:
			posX += vX;
			if (posX >= PARED_D){
				sentido = ABAJO;
			}
			break;
		case IZQ:
			posX -= vX;
			if (posX <= PARED_I){
				sentido = ARRIBA;
			}
			break;
		}
	}
	
}
	
