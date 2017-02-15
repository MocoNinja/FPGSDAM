package Ejercicio12;

// Necesitamos una clase para manipular los procesos en ejecución (Threads) [Convertir un thread a un objeto de Java]
import java.awt.*;

@SuppressWarnings("serial")
public class Animacion1 extends Frame implements Runnable{
	/*
	// Problema de Java: tiene herencia simple (sólo puede ser sublclase de una superclase)
	// Cuando una clase hereda de la superclase, pero también tiene características de otras, implementa lo que se llaman *Interfaces*
	// Una interfaz en Java es una clase que sólo *define* métodos, que implementará la clase
	// En la interfaz runable, está literalmente este único método:
	
	 public class Runnable{
	 	public void run();
	 }
	
	// Al implementar el interfaz runable, debemos implementar este único método run
	*/
	
	int actual = 0;
	Thread animacion;
	String frames[] = {"*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**", "*"};
	// TextArea pincheBoludo; // Hacerlo sin el TextArea
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Animacion1 an = new Animacion1();
	}
	
	public void run(){ // Es lo que se va a convertir en thread
		while (true){
			actual = 0;
			try{
					for (int i = 0; i < frames.length; i++){
						actual++;
						Thread.sleep(20);
						repaint();
					}
					
			}
			catch(InterruptedException exc){
				
			};
		}
	}
	
	@SuppressWarnings("deprecation")
	public Animacion1(){
		super("Animación sencilla");
		pack();
		resize(450, 450);
		show();
		animacion = new Thread(this); // Puede no recibir ningún parámetro, pero suele pasársele el objeto donde estamos
		animacion.start(); // Esto llama al run
	}
	
	/*
	public void setup(){
		
		pincheBoludo = new TextArea();
		pincheBoludo.setFont(new Font("Serif",Font.PLAIN,20));
		add(pincheBoludo);
		
	}
	*/
	public void paint (Graphics gg){
		gg.drawString(frames[actual], 20, 40);
	}
	
	public boolean handleEvent(Event ev){
		if (ev.id == Event.WINDOW_DESTROY){
			System.exit(0);
		return true;
		}
	return false;
	}
}
