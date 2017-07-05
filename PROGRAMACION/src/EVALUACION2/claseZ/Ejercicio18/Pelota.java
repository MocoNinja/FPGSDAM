package EVALUACION2.claseZ.Ejercicio18;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

public class Pelota extends Block{
	int velX, velY;
	boolean fin;
	public Pelota(){
		super(150, 200, 9, 9, Color.white);
		velX = -3;
		velY = -2;
		fin = false;
    }
    
    public void dibujar(Graphics g){
	    	g.setColor(color);
    		g.fillOval(x, y, width, height);
    }
    public void actualizar(List<Block> pared, Raqueta raqueta){
    	x += velX;
    	y += velY;
    	for(int i=0; i<pared.size(); i++)
    	   	if(this.intersects(pared.get(i))){
    	   		pared.remove(i);
    	   		velY = -velY;
    	   	}
    	if(this.intersects(raqueta))
    		velY = -velY;
    	
    	if((x<=0) || (x>=291))
    		velX = -velX;
		if(y<0)
			velY = -velY;
		if(y>300)
			fin = true;
    }
}