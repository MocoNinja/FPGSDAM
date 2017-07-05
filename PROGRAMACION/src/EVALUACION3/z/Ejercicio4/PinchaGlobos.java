import java.awt.*;
import java.applet.*;

public class PinchaGlobos extends Applet implements Runnable{
	Image imagen;
	Graphics noseve;
	Thread animacion;
	Image imgArquero;
	Arquero arquero;
	Image imgFlecha;
	java.util.List<Flecha> flechas;
	Image imgGlobo;
	java.util.List<Globo> globos;
    public void init() {
    	imagen = createImage(700, 500);
    	noseve = imagen.getGraphics();
    	imgArquero = getImage(getCodeBase(), "imagenes/arquero.gif");
    	arquero = new Arquero(imgArquero);
    	imgFlecha = getImage(getCodeBase(), "imagenes/flecha.gif");
    	flechas = new java.util.ArrayList<Flecha>();
    	imgGlobo = getImage(getCodeBase(), "imagenes/globo.gif");
    	globos = new java.util.ArrayList<Globo>();
    	for(int i=0; i<20; i++)
    		globos.add(new Globo(imgGlobo, (int)(Math.random()*50)+50));
    }
    
    public void start(){
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public void paint(Graphics g){
    	noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, 700, 500);
		arquero.dibujar(noseve, this);
		for(int i=0; i<flechas.size(); i++)
			flechas.get(i).dibujar(noseve, this);
		for(int i=0; i<globos.size(); i++)
			globos.get(i).dibujar(noseve, this);
    	g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
    	paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
		flechas.add(new Flecha(imgFlecha, y-12));
    	return true;
    }
    
    public boolean mouseMove(Event ev, int x, int y){
		arquero.actualizar(y);
		repaint();
    	return true;
    }
    
    public void run(){
    	while(true){
    		for(int i=0; i<flechas.size(); i++){
				flechas.get(i).actualizar();
				if(flechas.get(i).x > 700)
					flechas.remove(i);
    		}
    		for(int i=0; i<globos.size(); i++)
    			globos.get(i).actualizar();
    			
    		for(int i=0; i<flechas.size(); i++)
    			for(int j=0; j<globos.size(); j++)
    				if(globos.get(j).contains(flechas.get(i).posiciones())){
    					flechas.remove(i);
    					globos.remove(j);
    					break;
    				}
    			
			repaint();
    		try{
    			Thread.sleep(50);
    		}catch(InterruptedException e){};
    	}
    }
}