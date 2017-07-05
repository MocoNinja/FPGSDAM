package EVALUACION2.claseZ.Ejercicio11;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Event;
import java.util.ArrayList;
import java.util.List;
public class MiCanvas extends Canvas{
	DosPuntos actual;
	private int tipo;
	List<DosPuntos> lista;
    public MiCanvas(int tipo) {
    	super();
    	this.tipo = tipo;
    	lista = new ArrayList<DosPuntos>();
    }
    public void setTipo(int tipo){
    	this.tipo = tipo;
    }
    
    public void paint(Graphics ggg){
    	if(actual!=null)
    		actual.dibujar(ggg);
 		for(int i=0; i<lista.size(); i++)
 			lista.get(i).dibujar(ggg);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
    	actual = new DosPuntos(tipo, x, y);
    	return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
    	actual.finX = x;
    	actual.finY = y;
    	repaint();
    	return true;
    }
    
     public boolean mouseUp(Event ev, int x, int y){
    	lista.add(actual);
    	actual = null;
    	return true;
    }
}