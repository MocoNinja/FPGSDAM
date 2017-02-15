package zClase.Ejercicio09;
import java.awt.*;

public class CheckboxApp extends Frame{
	CheckBoxPanel chbPanel;
	CheckBoxPanelGroup chbGPanel;
	public static void main(String args[]){
		CheckboxApp fap = new CheckboxApp();
	}

    public CheckboxApp() {
    	super("Checkbox Aplicación");
    	setup();
    	pack();
    	resize(minimumSize());
    	show();
    }
    public void setup(){
    	this.setLayout(new GridLayout(1, 2));
    	String deportes[] = {"Fútbol", "Natación", "Baloncesto", "Tenis", "Ajedrez"};
    	String edades[] = {"Menos de 20", "De 20 a 39", "De 40 a 59", "De 60 a 79", "80 o más"};
    	chbPanel = new CheckBoxPanel("¿Qué deportes te gustan?", deportes);
    	chbGPanel = new CheckBoxPanelGroup("¿Cuál es tu edad?", edades);
    	
    	this.add("West", chbPanel);
    	this.add("East", chbGPanel);
    }
    
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}
    	return false;
    }
}

class CheckBoxPanel extends Panel{
	Checkbox checkboxes[];
	public CheckBoxPanel(String pregunta, String[] opciones){
		super();
		this.setLayout(new GridLayout(opciones.length + 1, 1));
		this.add(new Label(pregunta));
		checkboxes = new Checkbox[opciones.length];
		for(int i = 0; i < opciones.length; i++){
			checkboxes[i] = new Checkbox(opciones[i]);
			this.add(checkboxes[i]);
		}
	}
}

class CheckBoxPanelGroup extends CheckBoxPanel{
	
	public CheckBoxPanelGroup(String pregunta, String[] opciones){
		super(pregunta, opciones);
		CheckboxGroup grupo = new CheckboxGroup();
		for(int i=0; i<checkboxes.length; i++)
			checkboxes[i].setCheckboxGroup(grupo);
	}
	
	
}