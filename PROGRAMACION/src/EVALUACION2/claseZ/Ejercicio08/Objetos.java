package EVALUACION2.claseZ.Ejercicio08;
import java.awt.*;

public class Objetos extends Frame{
	TextArea textArea;
	public static void main(String args[]){
		Objetos fap = new Objetos();
	}

    public Objetos() {
    	super("Trabajo con Objetos");
    	setup();
    	pack();
    	resize(400, 400);
    	show();
    }
    
    public void setup(){
    	Panel principal = new Panel();
    	principal.setLayout(new GridLayout(3, 3));
    	Panel paneles[][];
    	paneles = new Panel[3][3];
    	for(int i=0; i<3; i++)
    		for(int j=0; j<3; j++){
    			paneles[i][j] = new Panel();
    			paneles[i][j].setLayout(new FlowLayout(FlowLayout.LEFT));
    		}
    	
    	paneles[0][0].add(new Label("Campo de texto: "));
    	paneles[0][0].add(new MiTextField("", 15));
    	
    	paneles[1][0].add(new Label("Area de texto: "));
    	textArea = new TextArea("Es un TextArea", 5, 15);
    	paneles[1][0].add(textArea);
    	
    	paneles[2][0].add(new Label("Button: "));
    	paneles[2][0].add(new MiBoton("Limpiar TextArea", textArea));
    	
    	paneles[0][1].add(new Label("Canvas: "));
    	paneles[0][1].add(new MiCanvas());
    	
    	String choiceStrings[] = {"Sí", "No", "Quizás"};
    	paneles[1][1].add(new Label("Choice: "));
    	paneles[1][1].add(new MiChoice(choiceStrings, textArea));
    	
    	String listaStrings[] = {"Fútbol", "Basket", "Natación", "Balonmano", "Tenis", "Golf", "Hípica"};
    	paneles[2][1].add(new Label("List: "));
    	paneles[2][1].add(new MiLista(listaStrings, textArea));
    	
    	String checkboxStrings[] = {"Checboxes: ", "Colegio", "Salesianos", "Zaragoza"};
    	paneles[0][2].add(new MiCheckBoxGroup(checkboxStrings));
    	
    	paneles[1][2].setLayout(new BorderLayout());
    	paneles[1][2].add("South", new MiScrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 100, textArea));
    	    	
    	paneles[2][2].setLayout(new BorderLayout());
    	paneles[2][2].add("East", new MiScrollbar(Scrollbar.VERTICAL, 50, 10, 0, 100, textArea));
 
    	for(int i=0; i<3; i++)
    		for(int j=0; j<3; j++)
 		    	principal.add(paneles[j][i]);
    	
    	this.add(principal);
    }
    
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}
    	return false;
    }
}


class MiTextField extends TextField{
	
	public MiTextField (String frase, int columnas){
		super(frase, columnas);
	}
	public boolean action(Event ev, Object arg){
		String texto = this.getText();
		this.setText(texto.toUpperCase());
		return true;
	}
}

class MiBoton extends Button{
	TextArea tt;
	public MiBoton(String frontal, TextArea t){
		super(frontal);
		tt = t;
	}
	public boolean action(Event ev, Object arg){
		tt.setText(" ");
		return true;
	}
}

class MiCanvas extends Canvas{
	int posx = 20;
	int posy = 20;
	public MiCanvas(){
		super();
		resize(75, 75);
		setBackground(Color.yellow);
		setForeground(Color.red);
		show();
	}
	public void paint(Graphics g){
		g.fillRect(posx, posy, 5, 5);
	}
	public boolean mouseDown(Event ev, int x, int y){
		posx = x; 
		posy = y;
		repaint();
		return true;
	}
}

class MiChoice extends Choice{
	TextArea tt;
	public MiChoice(String[] elementos, TextArea t){
		super();
		for(int i=0; i<elementos.length; i++)
			this.addItem(elementos[i]);
		tt = t;
	}
	public boolean action(Event ev, Object arg){
		tt.setText(this.getSelectedItem());
		return true;
	}
}

class MiLista extends List{
	TextArea tt;
	public MiLista(String[] deportes, TextArea t){
		super(5, true);
		for(int i=0; i<deportes.length; i++)
			this.addItem(deportes[i]);
		tt = t;
	}
	public boolean handleEvent(Event ev){
		if(ev.id == Event.ACTION_EVENT){
			tt.setText("Doble click");
			return true;
		}else if(ev.id == Event.LIST_SELECT){
				tt.setText("Elemento seleccionado");
				return true;
		}else if(ev.id == Event.LIST_DESELECT){
				tt.setText("Elemento deseleccionado");
				return true;
		}
		return false;
	}
}

class MiCheckBoxGroup extends Panel{
	Checkbox checkBoxes[];
	TextField resultado;
	public MiCheckBoxGroup (String[] elementos){
		super();
		this.setLayout(new GridLayout(elementos.length + 1, 1));
		this.add(new Label(elementos[0]));
		checkBoxes = new Checkbox[elementos.length-1];
		for(int i=1; i<elementos.length; i++){
			checkBoxes[i-1] = new Checkbox(elementos[i]);
			this.add(checkBoxes[i-1]);
		}
		resultado = new TextField("", 15);
		this.add(resultado);
	}
	public boolean handleEvent(Event ev){
		if(ev.id == Event.ACTION_EVENT){
			if(ev.target instanceof Checkbox){
				String mostrar = "";
				for(int i=0; i<checkBoxes.length; i++)
					if(checkBoxes[i].getState())
						mostrar += checkBoxes[i].getLabel() + " ";
				resultado.setText(mostrar);
				return true;
			}
		}
		return false;
	}
}

class MiScrollbar extends Scrollbar{
	TextArea tt;
	public MiScrollbar(int orientacion, int posicion, int anchura, int inicio, int fin, TextArea t){
		super(orientacion, posicion, anchura, inicio, fin);
		tt = t;
	}
	public boolean handleEvent(Event ev){
		if(ev.id == Event.SCROLL_LINE_UP){
			tt.setText("Posición : " + this.getValue());
		}else if(ev.id == Event.SCROLL_LINE_DOWN){
			tt.setText("Posición : " + this.getValue());
		}else if(ev.id == Event.SCROLL_PAGE_UP){
			tt.setText("Posición : " + this.getValue());
		}else if(ev.id == Event.SCROLL_PAGE_DOWN){
			tt.setText("Posición : " + this.getValue());
		}else if(ev.id == Event.SCROLL_ABSOLUTE){
			tt.setText("Posición : " + this.getValue());
		}
		
		
		return false;
	}
}