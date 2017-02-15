package zClase.Ejercicio14;
import java.awt.*;
public class RectanguloHorario extends Rectangle{
	int topeDer, topeIzq, topeArr, topeAb;
	Color color;
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte IZQUIERDA = 2;
	static final byte DERECHA = 4;
	byte direccion;
	
    public RectanguloHorario(int pX, int pY, int ancho, int alto, Color color) {
    	x = pX;
    	y = pY;
    	width = ancho;
    	height = alto; 
    	this.color = color;
    	direccion = DERECHA;
    	topeDer = x + 20;
    	topeIzq = y;
    	topeArr = y;
    	topeAb = x + 20;
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
						direccion = DERECHA;
					break;
				case ABAJO:
					y++;
					if(y >= topeAb)
						direccion = IZQUIERDA;
					break;
				case DERECHA:
					x++;
					if(x >= topeDer)
						direccion = ABAJO;
					break;
				case IZQUIERDA:
					x--;
					if(x <= topeIzq)
						direccion = ARRIBA;
			}
     }
    
}