import java.awt.*;
import java.applet.*;

public class MazoJuego extends Rectangle{
	java.util.List<Carta> mazo;
	public static final int POSICIONY = 200;
	
    public MazoJuego(int px) {
    	super(px, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
		mazo = new java.util.ArrayList();
    }
    
    public boolean anadir(Carta c){
    	if(mazo.size()==0){
    		recolocar(c);
    		mazo.add(c);
    		return true;
    	}else{
    		if(c.getColor() != mazo.get(mazo.size()-1).getColor()){
	    		if(c.getValor()+1 == mazo.get(mazo.size()-1).getValor()){
		    		recolocar(c);
    				mazo.add(c);
    				return true;
    			}
    		}
    	}
    	
 		return false;
    }
	public Carta extraer(){
		return mazo.get(mazo.size()-1);
	}
	public void eliminar(){
		mazo.remove(mazo.size()-1);
	}
	public void recolocar(Carta c){
		if(mazo.size()==0)
			c.setPosy(y);
		else
			c.setPosy(y + (mazo.size() * 30));
		c.setPosx(x);	
	}
	public void mostrar(Graphics gg, Applet a){
		gg.setColor(Color.black);
		gg.drawRect(x, y, width, height);
		for(int i=0; i<mazo.size(); i++)
			mazo.get(i).dibujar(gg, a);
	}
	
	
}