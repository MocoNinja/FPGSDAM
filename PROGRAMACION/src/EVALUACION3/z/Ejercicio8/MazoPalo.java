import java.awt.*;
import java.applet.*;

public class MazoPalo extends Rectangle{
	java.util.List<Carta> mazo;
	public static final int POSICIONY = 20;
	int palo;
	
    public MazoPalo(int px) {
    	super(px, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
		mazo = new java.util.ArrayList();
    }
    
    public boolean anadir(Carta c){
    	if(mazo.size()==0){
    		if(c.getValor() == 1){
    			mazo.add(c);
    			recolocar();
    			palo = c.getPalo();
    			return true;
    		}
    	}else{
    		if(palo == c.getPalo())
    			if(mazo.get(mazo.size()-1).getValor() == c.getValor()-1){
    				mazo.add(c);
    				recolocar();
    				return true;	
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
	public void recolocar(){
		mazo.get(mazo.size()-1).setPosx(x);
		mazo.get(mazo.size()-1).setPosy(y);
	}
	public void mostrar(Graphics gg, Applet a){
		gg.setColor(Color.black);
		gg.drawRect(x, y, width, height);
		for(int i=0; i<mazo.size(); i++)
			mazo.get(i).dibujar(gg, a);
	}
	
	
}