package EVALUACION2.examen;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;

public class FrameApp extends Frame
{
	final static int WIDTH = 750, HEIGHT = 450;
	String[] opciones = {"Botón", "TextArea", "Canvas"};
	TextField text;
	Chois elecciones;
	Component aux;
	TextArea texto;
	String titulo;
	String objeto;
	Panel panelmain;
	
	public static void main(String[] args)
	{
		FrameApp ui  = new FrameApp();
	}
	
	public void init()
	{
		text = new TextField("", 10);
		elecciones = new Chois(opciones);
		texto = new TextArea();
		paneles();
	}
	
	public void paneles()
	{
		panelmain = new Panel();
		Panel cosasIzq = new Panel();
		cosasIzq.add("North", text);
		cosasIzq.add("South", elecciones);
		panelmain.add("West", cosasIzq);
		this.add("West", panelmain);
	}
	
	public FrameApp()
	{
		super("Ejercicio 1");
		init();
		pack();
		resize(WIDTH, HEIGHT);
		show();
	}

	public void crear(String elQue, String nombre)
	{
		// System.out.println(elQue);
		if (aux != null) panelmain.remove(aux);
		switch (elQue) {
		case "Botón":
			aux = new Button(nombre);
			//System.out.println(aux);
			panelmain.add("East", aux);
			this.show();
			break;
		case "TextArea":
			aux = new TextArea(nombre);
			//System.out.println(aux);
			panelmain.add("East", aux);
			this.show();
			break;
		case "Canvas":
			aux = new Gambas(nombre);
			panelmain.add("East", aux);
			this.show();
			break;
		default:
			System.out.println("Oopsie :(");
			break;
		}
	}
	
	public boolean handleEvent(Event ev)
	{
		if (ev.id == Event.WINDOW_DESTROY)
		{
			System.exit(0);
		return true;
		}
		else if (ev.target instanceof Chois)
		{
			objeto = elecciones.getSelectedItem();
			titulo = text.getText();
			crear(objeto, titulo);
		return true;
		}
	return false;
	}
}

class Chois extends Choice
{
	public Chois(String[] elementos){
		super();
		for(int i=0; i<elementos.length; i++) this.addItem(elementos[i]);
    }
	
}

class Gambas extends Canvas{
	int x = 20;
	int y = 20;
	String titulo;
	public Gambas(String elCualo){
		super();
		titulo = elCualo;
		resize(200, 200);
		show();
	}
	public void paint(Graphics g){
		g.drawString(titulo, x, y);
	}
}
