import java.awt.*;
import java.applet.*;

public class Caminar extends Applet implements Runnable{
	Image fotogramas[][];
	java.util.List<DibujoAnimado> dibujos;
	String elementos[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"};
	Thread animacion;
	Image imagen;
	Graphics noseve;
    public void init() {
    	imagen = createImage(500, 500);
    	noseve = imagen.getGraphics();
    	fotogramas = new Image[3][4];
    	for(int i=0; i<3; i++)
    		for(int j=0; j<4; j++)
    			fotogramas[i][j] = getImage(getCodeBase(), "Sprites/" + elementos[i] + (j+1) + ".gif");
    	dibujos = new java.util.ArrayList<DibujoAnimado>();
		for(int i=0; i<10; i++)
			dibujos.add(new DibujoAnimado(fotogramas[0]));
    }
    
    public void start(){
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, 500, 500);
    	for(int i=0; i<dibujos.size(); i++)
    		dibujos.get(i).dibujar(noseve, this);
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public void run(){
    	while(true){
			for(int i=0; i<dibujos.size(); i++)
    			dibujos.get(i).actualizar();
			repaint();
    		try{
    			Thread.sleep(300);
    		}catch(InterruptedException e){};
    	}
    }
    
    public boolean keyDown(Event ev, int tecla){
    	switch(tecla){
    		case 103:
    		case 71:
    			for(int i=0; i<dibujos.size(); i++)
    				dibujos.get(i).setImagenes(fotogramas[0]);
    			break;
    		case 104:
    		case 72:
    			for(int i=0; i<dibujos.size(); i++)
    				dibujos.get(i).setImagenes(fotogramas[1]);    			
    			break;
    		case 118:
    		case 86:
    			for(int i=0; i<dibujos.size(); i++)
    				dibujos.get(i).setImagenes(fotogramas[2]);
    	}
    	return true;
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	for(int i=0; i<dibujos.size(); i++)
    		if(dibujos.get(i).contains(x, y))
    			dibujos.remove(i);
    	return true;
    }
}