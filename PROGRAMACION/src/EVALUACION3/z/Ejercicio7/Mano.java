import java.awt.*;
import java.applet.*;

public class Mano{
	java.util.List<Carta> lista;
    public Mano() {
    	lista = new java.util.ArrayList();
    }

    public void mostrar_lista(Graphics g, Applet a, int posy){
		for(int i=0; i<lista.size(); i++){
			lista.get(i).setPosx(200+(i*50));
			lista.get(i).setPosy(posy);
			lista.get(i).dibujar(g, a);
		}
    }
    
    public void anadirALista(Carta carta){
    	lista.add(carta);
    }
    
    public int puntuacion(){
    	int acumulador = 0;
    	boolean as = false;
    	for(int i=0; i<lista.size(); i++){
    		acumulador += lista.get(i).valor;
    		if(lista.get(i).valor == 1) as=true;
    	}
    	if((as) && (acumulador<=11)) acumulador += 10;
    	
    	return acumulador;
    }
    
    public boolean seHaPasado(){
    	return (puntuacion()>21)?true:false;
    }
    
    public boolean menor17(){
    	return (puntuacion()<17)?true:false;
    }
}