package zClase.Ejercicio05;
import java.awt.*;
public class OvaloApp extends Frame{
	Ovalo ovalo;
	
	public static void main(String args[]){
		OvaloApp app = new OvaloApp();
	}

    public OvaloApp() {
    	super("Dibujando óvalos");
    	ovalo = new Ovalo();
    	Panel panel = new Panel();
    	Button boton1 = new Button("Siguiente");
    	Button boton2 = new Button("Salir");
    	
    	panel.add(boton1);
    	panel.add(boton2);
    		
    	add("South", panel);
    	
    	this.pack();
    	this.resize(300, 300);
    	this.show();
    }
    
    public void paint(Graphics g){
		ovalo.dibujar(g);
    }
    
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}else if(ev.id == Event.ACTION_EVENT){
    				if(ev.target instanceof Button){
    					if("Salir".equals(ev.arg)){
    						System.exit(0);
    						return true;	
    					}else if("Siguiente".equals(ev.arg)){
    						ovalo.inicializar();
    						repaint();
    						return true;
    					}
    				}
    			}
    		
    	return false;
    }
    
}