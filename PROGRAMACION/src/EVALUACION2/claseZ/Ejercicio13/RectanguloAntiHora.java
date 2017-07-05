package EVALUACION2.claseZ.Ejercicio13;
import java.awt.*;
public class RectanguloAntiHora {
	int posX, posY, anchura, altura;
	int topeDer, topeIzq, topeArr, topeAb;
	Color color;
	static final byte ARRIBA = 0;
	static final byte ABAJO = 1;
	static final byte IZQUIERDA = 2;
	static final byte DERECHA = 4;
	byte direccion;
	
    public RectanguloAntiHora(int pX, int pY, int ancho, int alto, Color color) {
    	posX = pX;
    	posY = pY;
    	anchura = ancho;
    	altura = alto; 
    	this.color = color;
    	direccion = DERECHA;
    	topeDer = posX + 20;
    	topeIzq = posX;
    	topeArr = posY;
    	topeAb = posY + 20;
    }
    
    public void dibujar(Graphics gg){
    	gg.setColor(color);
    	gg.fillRect(posX, posY, anchura, altura);
    }
    
    public void actualizar(){
    		switch(direccion){
				case ARRIBA:
					posY--;
					if(posY <= topeArr)
						direccion = IZQUIERDA;
					break;
				case ABAJO:
					posY++;
					if(posY >= topeAb)
						direccion = DERECHA;
					break;
				case DERECHA:
					posX++;
					if(posX >= topeDer)
						direccion = ARRIBA;
					break;
				case IZQUIERDA:
					posX--;
					if(posX <= topeIzq)
						direccion = ABAJO;
			}
     }
    
}