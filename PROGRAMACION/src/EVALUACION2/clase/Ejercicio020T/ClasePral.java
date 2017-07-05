package EVALUACION2.clase.Ejercicio020T;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;

public abstract class ClasePral extends Rectangle{
	int velX, velY;
   	int Waleatorio,Haleatorio;
   	static boolean sentido = true;
    public ClasePral(int posX, int posY, int anchura, int altura) {
    	x = posX; 
    	y = posY;
    	width = anchura;
    	height = altura;
		velX = -3;
		velY = -2;
    }
    //Obliga a las subclases a implementar el metodo dibujar
    public abstract void dibujar(Graphics g);
   
    public void actualizar(){
    	x += velX;
    	y += velY;
   		
    	if((x<=0) || (x>=670))
    		velX = -velX;
		if((y<0) || (y>=670))
			velY = -velY;
    }
}