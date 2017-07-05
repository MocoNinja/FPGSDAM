import java.awt.*;
import java.applet.*;

public class MazoSecundario{
	java.util.List<Carta> mazoB;
	public static final int POSICIONX = 110;
	public static final int POSICIONY = 20;
    public MazoSecundario() {
		mazoB = new java.util.ArrayList();
    }
    
    public void anadir(Carta c){
    	mazoB.add(c);
    }
	public Carta extraer(){
		return mazoB.get(mazoB.size()-1);
	}
	public void eliminar(){
		mazoB.remove(mazoB.size()-1);
	}
	public void recolocar(){
		mazoB.get(mazoB.size()-1).setPosx(POSICIONX);
		mazoB.get(mazoB.size()-1).setPosy(POSICIONY);
	}
	public void mostrar(Graphics gg, Applet a){
		for(int i=0; i<mazoB.size(); i++)
			mazoB.get(i).dibujar(gg, a);
	}
	
	
}