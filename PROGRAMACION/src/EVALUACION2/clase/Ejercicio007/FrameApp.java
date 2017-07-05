package EVALUACION2.clase.Ejercicio007;
import java.awt.*;
//import java.io.*;
//Meteremos botones en los contendores. Los botones cambiaran cosas
public class FrameApp extends Frame{
	MenuBar porDefecto;
	MenuBar alternativo;
	String tituloInicial;

	/*Tipos de cursor que hay*/
	// Notar: los cursores son constantes heredadas de Frame (o de alguna superclase suya)
	int[] cursores = {CROSSHAIR_CURSOR, DEFAULT_CURSOR, E_RESIZE_CURSOR, HAND_CURSOR, MOVE_CURSOR, NE_RESIZE_CURSOR, NW_RESIZE_CURSOR, N_RESIZE_CURSOR, SE_RESIZE_CURSOR, SW_RESIZE_CURSOR, S_RESIZE_CURSOR, W_RESIZE_CURSOR, E_RESIZE_CURSOR, TEXT_CURSOR, WAIT_CURSOR};
	int cajaFuerte = 0; // es el iterador. Se llama asi por chistaco.
	/*Tipos de colores*/
	Color[] colores = {Color.magenta, Color.cyan, Color.yellow, Color.black, Color.blue, Color.pink, Color.red, Color.white, Color.gray, Color.lightGray, Color.orange};
	int cajaFuerte2 = 0;
	int cajaFuerte3 = 0;
	/*Sí que hay clase font, pero NO SON CONSTANTES. Hay que poner Strings con los tipos de fuente*/
	String[] fuentes = {"Comic Sans MS", "Arial", "Helvetica", "Consolas", "Courier", "Dialog", "TimesRoman", "DialogInput", "ZapfDingbats"};
	int posLetra = 0;

	public static void main(String args[]){
		FrameApp fap = new FrameApp();
	}
	
	public FrameApp(){
		super("Trabajando con Frames");
		tituloInicial = getTitle(); // this.getTitle();
		System.out.println(tituloInicial);
		setup();
		pack();
		resize(400, 400);
		show();
	}
	
	public void setup(){
		setFont(new Font(fuentes[posLetra], Font.PLAIN, 12));
    	setupPaneles();
    	setupMenuBars();
    }
    
    public void setupMenuBars(){
		// Default
    	porDefecto = new MenuBar();
    	Menu fileMenu = new Menu("File");
    	fileMenu.add(new MenuItem("Exit"));
    	porDefecto.add(fileMenu);
    	setMenuBar(porDefecto);
		// Alternativo
		alternativo = new MenuBar();
    	Menu fileMenu2 = new Menu("Archivo");
    	fileMenu2.add(new MenuItem("Salir"));
    	alternativo.add(fileMenu2);
    }
    
    public void setupPaneles(){
    	Panel principal = new Panel();
    	//Grid es como una tabla
    	principal.setLayout(new GridLayout(4, 1));
    	
    	principal.add(new Label ("Cambian la caracteristicas de la ventana", Label.CENTER));
    	
    	Panel panel1 = new Panel();
    	panel1.add(new Button("Titulo"));
    	panel1.add(new Button("MenuBar"));
    	panel1.add(new Button("Resizable"));
    	principal.add(panel1);
    	
    	principal.add(new Label ("Salidas en la ventana", Label.CENTER));
    	
    	Panel panel2 = new Panel();
    	panel2.add(new Button("Cursor"));
    	panel2.add(new Button("Background-color"));
    	panel2.add(new Button("Foreground"));
    	panel2.add(new Button("FontFamily"));
    	principal.add(panel2);
    	
    	this.add("South",principal);
    }

	public void paint(Graphics titanx){  // DEBE llamarse paint
        titanx.drawString("Pero que API mas fea", 150, 150); 
    }
    
	public boolean handleEvent(Event ev){
		if(ev.id == Event.WINDOW_DESTROY){
			System.exit(0);
			return true;
		} 
		else if(ev.id == Event.ACTION_EVENT){ // Esto se puede saltar
			if(ev.target instanceof Button){
				// System.out.println("Boton pulsado");
				if("Titulo".equals(ev.arg)){ // El argumento es el nombre
					// System.out.println("He pulsado Titulo");
					if(tituloInicial.equals(getTitle())){
						setTitle("Menu alternativo"); // this.
					} else{
						setTitle(tituloInicial);
					}
				return true; 
				} 
				else if("MenuBar".equals(ev.arg)){
					if(porDefecto.equals(getMenuBar())){ // El titulo es la barra;
						setMenuBar(alternativo);
					} else {
						setMenuBar(porDefecto);
					}
				return true;
				} 
				else if("Resizable".equals(ev.arg)){

					/* NO ES LO QUE PEDIA
					// System.out.println(getWidth());
					// System.out.println(getHeight());
					if (getWidth() == 400){
						resize(800, 800);
					} else {
						resize(400, 400);
					}
					*/
					
					/*
					if (isResizable()){ // Los is son los get para booleanos
						// System.out.println("Es resizable");
						setResizable(false);
					} else {
						// System.out.println("NO Es resizable");
						setResizable(true);
					}
					*/
					setResizable(!isResizable()); // LIKE A BOSS
				return true;
				} 
				if("Cursor".equals(ev.arg)){ // El argumento es el nombre
					/*
					// System.out.println("He pulsado Cursor");
					if(cajaFuerte < cursores.length){
						setCursor(cursores[cajaFuerte]);
					} else {
						cajaFuerte = 0;
						setCursor(cursores[cajaFuerte]);
					}
					cajaFuerte++;
					*/
					// Manera más elegante
					setCursor(cursores[cajaFuerte]);
					cajaFuerte = (cajaFuerte + 1) % cursores.length;
				return true; 
				} 
				if("Background-color".equals(ev.arg)){ // El argumento es el nombre
					// System.out.println("He pulsado Cursor");
					/*
					if(cajaFuerte2 < colores.length){
						setBackground(colores[cajaFuerte2]);
					} else {
						cajaFuerte2 = 0;
						setBackground(colores[cajaFuerte2]);
					}
					cajaFuerte2++;
					*/
					// Análogamente
					setBackground(colores[cajaFuerte2]);
					cajaFuerte2 = (cajaFuerte2 + 1) % colores.length;
				return true; 
				}
				if("Foreground".equals(ev.arg)){ // El argumento es el nombre
					// System.out.println("He pulsado Cursor");
					/*
					if(cajaFuerte2 < colores.length){
						setBackground(colores[cajaFuerte2]);
					} else {
						cajaFuerte2 = 0;
						setBackground(colores[cajaFuerte2]);
					}
					cajaFuerte2++;
					*/
					// Análogamente
					setForeground(colores[cajaFuerte3]);
					cajaFuerte3 = (cajaFuerte3 + 1) % colores.length;
				return true; 
				}
				if("FontFamily".equals(ev.arg)){ // El argumento es el nombre
					setFont(new Font(fuentes[posLetra], Font.PLAIN, 18));
					// System.out.println(fuentes[posLetra]);
					posLetra = (posLetra + 1) % fuentes.length;
				return true; 
				}
			}
		return true;
		}
	return false;
	}
}