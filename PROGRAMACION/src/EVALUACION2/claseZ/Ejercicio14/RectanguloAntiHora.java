package EVALUACION2.claseZ.Ejercicio14;
import java.awt.*;
public class RectanguloAntiHora extends Rectangle{
	int topeDer, topeIzq, topeArr, topeAb;
	Color color;
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte IZQUIERDA = 2;
	static final byte DERECHA = 4;
	byte direccion;
	
    public RectanguloAntiHora(int pX, int pY, int ancho, int alto, Color color) {
    	x = pX;
    	x = pY;
    	width = ancho;
    	height = alto; 
    	this.color = color;
    	direccion = DERECHA;
    	topeDer = x + 20;
    	topeIzq = x;
    	topeArr = y;
    	topeAb = y + 20;
    }
    
    public void dibujar(Graphics gg){
    	gg.setColor(color);
    	gg.fillRect(x, y, width, height);
    }
    
    public void actualizar(){
    		switch(direccion){
				case ARRIBA:
					y--;
					if(y <= topeArr)
						direccion = IZQUIERDA;
					break;
				case ABAJO:
					y++;
					if(y >= topeAb)
						direccion = DERECHA;
					break;
				case DERECHA:
					x++;
					if(x >= topeDer)
						direccion = ARRIBA;
					break;
				case IZQUIERDA:
					x--;
					if(x <= topeIzq)
						direccion = ABAJO;
			}
     }
    
}