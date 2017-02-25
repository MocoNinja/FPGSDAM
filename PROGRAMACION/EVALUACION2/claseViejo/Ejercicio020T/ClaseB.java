package claseViejo.Ejercicio020T;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
public class ClaseB extends ClasePral {
   	int velX, velY;
   	Color color;
   	int Waleatorio,Haleatorio, ovalx, ovaly;
   	static boolean sentidoB = true;
    public ClaseB(int posX, int posY, int anchura, int altura, Color co) {
    	super( posX, posY, anchura, altura);
		color = co;
		velX = -3;
		velY = -2;
    }
    
    public void dibujar(Graphics g){
    	g.setColor(color);
		g.fillRect(x, y, width, height);
    }
    public void actualizar(List<ClaseB> rectangulos,List<ClaseA> ovalos){
    	x += velX;
    	y += velY;
   		if(sentidoB){
	   		for(int i=0;i<rectangulos.size();i++){
	   			for(int j=0; j<ovalos.size();j++){
	   				if(rectangulos.get(i).intersects(ovalos.get(j))){
					ovalx = (int) (Math.random()*690+1);
							ovaly = (int) (Math.random()*690+1);
	   					ovalos.remove(j);
	   					rectangulos.add(new ClaseB(ovalx, ovaly , 10, 10, Color.blue));	
	   				}
	   			}
	   		}	
   		}
   		
   		
   		if(ovalos.size()==0){
   			sentidoB = false;
   			ovalos.add(new ClaseA(60, 60 , 10, 10, Color.blue));	
   		}
   			
   			
     	 	
     	 	
    	if((x<=0) || (x>=690))
    		velX = -velX;
		if((y<0) || (y>=690))
			velY = -velY;
    }
}