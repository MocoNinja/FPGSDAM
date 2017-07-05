package EVALUACION2.clase.Ejercicio020T;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
public class ClaseA extends Rectangle {
   	int velX, velY;
   	Color color;
   	int Waleatorio,Haleatorio, ovaly, ovalx;
    public ClaseA(int posX, int posY, int anchura, int altura, Color co) {
    	super( posX, posY, anchura, altura);
		color = co;
		velX = -3;
		velY = -2;
    }
    
    public void dibujar(Graphics g){
    	g.setColor(color);
		g.fillOval(x, y, width, height);
    }
    
    public void actualizar(List<ClaseB> rectangulos,List<ClaseA> ovalos){
    	x += velX;
    	y += velY;
     	if(!ClaseB.sentidoB){
     		for(int i=0;i<rectangulos.size();i++){
	   			for(int j=0; j<ovalos.size();j++){
	   				if(rectangulos.get(i).intersects(ovalos.get(j))){
	   					System.out.println("false");
	   						ovalx = (int) (Math.random()*690+1);
							ovaly = (int) (Math.random()*690+1);
	   					rectangulos.remove(i);
	   					
	   					ovalos.add(new ClaseA(ovalx, ovaly , 10, 10, Color.blue));	
	   				}
	   					
	   			}
	   		}
     	
     	}	 
 		if(rectangulos.size()==0){
 			ClaseB.sentidoB = true;
 			rectangulos.add(new ClaseB(60, 60 , 10, 10, Color.blue));	
 		}
 		
			
    	if((x<=0) || (x>=690))
    		velX = -velX;
		if((y<0) || (y>=690))
			velY = -velY;
    }
}