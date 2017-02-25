package claseViejo.Ejercicio011;

// import java.awt.*;
import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Gambas extends Canvas{

    // DosPuntos figurinya; // ya no sirve, ahora vamos a tener infinitos punteros
	DosPuntos figurinya; // Ahora creamos el puntero para señalar el objeto actual
	// Los llamos igual, pero son conceptualmente dsitintos. Este seria actual.
	
    private int tipo;
    List <DosPuntos> lista; // Crea una lista de objetos de la clase DosPuntos
    
    public Gambas(int tipo){ // Dentro del Canvas hay un objeto Graphics implícito
        super();
        this.tipo = tipo;
        lista = new ArrayList<DosPuntos>(); // List es una clase abstracta -> no puede instanciarse. Instanciamos una subclase.
    }
    
    /*El método paint lo quitamos porque no hay que mostrar un sólo objeto, sino todos los guardados en la lista*/
    
    /*
    public void paint(Graphics gg){ // Forma parte del ciclo de vida del canvas, se ejecutara solo sin que le llame nadie
    	if (figurinya != null)
    		figurinya.dibujar(gg); // Si ponemos esto tal cual, tenemos una NPE porque el objeto se instancia en el mouseDown;
    	// El ciclo de vida solo ejecuta el paint una vez -> habrá que llamarlo
    }
	*/
    public void paint(Graphics gg){
    	for (int i = 0; i < lista.size(); i++){
    		lista.get(i).dibujar(gg);
    	}
    	if (figurinya != null)
    	figurinya.dibujar(gg);
    }
    
    public void setTipo(int tipoNuevo){
        tipo = tipoNuevo;
    }
    
    // Metodos de tratamiento de eventos de raton
    public boolean mouseDown(Event ev, int x, int y){ // Hacer click
    	// inicioX = x;
    	// inicioY = y;
    	figurinya = new DosPuntos(tipo, x, y);
    	//repaint();
    return true;
    }
    /*
    public boolean mouseUp(Event ev, int x, int y){
    	// figurinya = new DosPuntos(1, inicioX, inicioY, x, y);
    	// Mejor
    	figurinya.xf = x;
    	figurinya.yf = y;
    	repaint();
    return true;
    }
    */
    // Estos métodos son puntuales. Hay uno que es arrastrar, que es continuo
    
    public boolean mouseDrag(Event ev, int x, int y){
    	figurinya.xf = x;
    	figurinya.yf = y;
    	repaint();
    return true;
    }
    
    public boolean mouseUp(Event ev, int x, int y){
    	lista.add(figurinya);
    	figurinya = null;
    	repaint();
    return true;
    }
}