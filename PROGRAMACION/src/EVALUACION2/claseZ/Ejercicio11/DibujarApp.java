package EVALUACION2.claseZ.Ejercicio11;
import java.awt.*;

public class DibujarApp extends Frame{
	MiCanvas canvas;
	public static void main(String args[]){
		DibujarApp fap = new DibujarApp();
	}

    public DibujarApp() {
    	super("Dibujando en el Frame");
    	setup();
    	pack();
    	resize(400, 400);
    	show();
    }
    
    public void setup(){
    	setupMenuBar();
    	canvas = new MiCanvas(DosPuntos.LINEA);
    	this.add("Center", canvas);
    }
    
    public void setupMenuBar(){
    	MenuBar menuBar = new MenuBar();
    	Menu menu = new Menu("Fichero");
    	menu.add(new MenuItem("Nuevo"));
    	menu.addSeparator();
    	menu.add(new MenuItem("Salir"));
    	menuBar.add(menu);
    	Menu menu2 = new Menu("Dibujar");
    	menu2.add(new MenuItem("L�nea"));
    	menu2.add(new MenuItem("�valo"));
    	menu2.add(new MenuItem("Rect�ngulo"));
    	menuBar.add(menu2);
    	
    	this.setMenuBar(menuBar);
    }
    
    
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}else if(ev.id == Event.ACTION_EVENT){
    		if(ev.target instanceof MenuItem){
    			if(ev.arg.equals("Salir")){
    				System.exit(0);
    				return true;
    			}else if(ev.arg.equals("�valo")){
    				canvas.setTipo(DosPuntos.OVALO);
    				return true;
    			}else if(ev.arg.equals("Rect�ngulo")){
    				canvas.setTipo(DosPuntos.RECTANGULO);
    				return true;
    			}else if(ev.arg.equals("L�nea")){
    				canvas.setTipo(DosPuntos.LINEA);
    				return true;
    			}
    		}
    	}
    	return false;
    }
}

