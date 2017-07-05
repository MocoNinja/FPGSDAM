package EVALUACION2.clase.Ejercicio015;
import java.awt.*;
public class TronchoHorario extends Rectangle
{
	Color color;
	Color[] colores = {Color.RED, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.BLUE, Color.BLACK, Color.ORANGE, Color.PINK, Color.MAGENTA, Color.YELLOW, Color.GREEN};
	
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte DCHA = 4;
	static final byte IZQ = 2;
	byte direccion;
	
	static final int margen = 20;
	int TECHO, SUELO, PARED_I, PARED_D;
	int velocidadX = 1, velocidadY = 1;
	
	public TronchoHorario(int x, int y, int ancho, int alto, Color color)
	{
		this.x = x;
		this.y = y;
		this.height = alto;
		this.width = ancho;
		this.color = color;
		this.direccion = DCHA;
		
		TECHO = x;
		SUELO = y + margen;
		PARED_I = x;
		PARED_D = x  + margen;
		
	}
	
	public void mostrar(Graphics ggez)
	{
		ggez.setColor(color);
		ggez.fillRect(x, y, width, height);
	}

	public void mueve()
	{
		switch (direccion){
		case ARRIBA:
			y -= velocidadY;
			if (y <= TECHO){
				direccion = DCHA;
			}
			break;
		case ABAJO:
			y += velocidadY;
			if (y >= SUELO){
				direccion = IZQ;
			}
			break;
		case DCHA:
			x += velocidadX;
			if (x >= PARED_D){
				direccion = ABAJO;
			}
			break;
		case IZQ:
			x -= velocidadX;
			if (x <= PARED_I){
				direccion = ARRIBA;
			}
			break;
	}
	}
}
	
