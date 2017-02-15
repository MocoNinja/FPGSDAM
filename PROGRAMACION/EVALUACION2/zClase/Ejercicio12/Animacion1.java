package zClase.Ejercicio12;
import java.awt.*;

public class Animacion1 extends Frame implements Runnable{
	String frames[] = {"*", "**", "***", "****","*****", "******", "*****", "****", "***", "**", "*"};
	Thread animacion;
	int actual = 0;
	
	public static void main(String args[]){
		Animacion1 an = new Animacion1();
	}

    public Animacion1() {
    	super("Animación sencilla");
    	
    	pack();
    	resize(200, 200);
    	show();
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public boolean handleEvent(Event ev){
    	if(ev.id == Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}
    	return false;
    }
    
    public void paint(Graphics g){
    	g.drawString(frames[actual], 100, 100);
    }
    
    public void run(){
    	do{
			actual = (actual + 1) % frames.length;
			repaint();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){	};
    	}while(true);
    }
    
}