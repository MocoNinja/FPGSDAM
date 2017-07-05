package EVALUACION2.claseZ.Ejercicio07;
import java.awt.*;

public class FrameApp extends Frame{
	MenuBar porDefecto;
	MenuBar alternativo;
	String tituloInicial;
	int cursores[] = {CROSSHAIR_CURSOR, DEFAULT_CURSOR, E_RESIZE_CURSOR, HAND_CURSOR, MOVE_CURSOR, NE_RESIZE_CURSOR, NW_RESIZE_CURSOR, N_RESIZE_CURSOR, SE_RESIZE_CURSOR, TEXT_CURSOR, WAIT_CURSOR};
	int posCursor = 0;
	Color colores[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red};
	int posColor1 = 0;
	int posColor2 = 0;
	String fuentes[] = {"Helvetica", "TimesRoman", "Courier", "Dialog", "DialogInput", "ZapfDingbats"};
	int posLetra = 0;
	
	public static void main(String args[]){
		FrameApp fap = new FrameApp();
	}

    public FrameApp() {
    	super("Trabajando con Frames");
    	tituloInicial = this.getTitle();
    	//System.out.print(tituloInicial);
    	setup();
    	pack();
    	resize(400, 400);
    	show();
    }
    
    public void paint(Graphics g){
    	g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    
    public void setup(){
    	setupPaneles();
    	setupMenuBars();
    }
    
    public void setupPaneles(){
    	Panel principal = new Panel();
    	principal.setLayout(new GridLayout(4, 1));
    	
    	principal.add(new Label("Cambian las características de la ventana", Label.CENTER));
    	
    	Panel panel1 = new Panel();
    	panel1.add(new Button("Título"));
    	panel1.add(new Button("MenuBar"));
    	panel1.add(new Button("Resizable"));
    	principal.add(panel1);
    	
    	principal.add(new Label("Salidas en la ventana", Label.CENTER));
    	
    	Panel panel2 = new Panel();
    	panel2.add(new Button("Cursor"));
    	panel2.add(new Button("Background"));
    	panel2.add(new Button("Foreground"));
    	panel2.add(new Button("Font"));
    	principal.add(panel2);
    	
    	this.add("South",principal);
    }
    
    public void setupMenuBars(){
    	porDefecto = new MenuBar();
    	Menu fileMenu = new Menu("File");
    	fileMenu.add(new MenuItem("Exit"));
    	porDefecto.add(fileMenu);
    	
    	alternativo = new MenuBar();
    	Menu fileMenu2 = new Menu("Archivo");
    	fileMenu2.add(new MenuItem("Salir"));
    	alternativo.add(fileMenu2);
    	
    	this.setMenuBar(porDefecto);
    }
       
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}else if(ev.id == Event.ACTION_EVENT){
    			if(ev.target instanceof Button){
    				if("Título".equals(ev.arg)){
    					if(tituloInicial.equals(getTitle()))
    						this.setTitle("Menú alternativo");
    					else
    						setTitle(tituloInicial);
    					return true;
    				}else if("MenuBar".equals(ev.arg)){
    					if(porDefecto.equals(getMenuBar()))
    						this.setMenuBar(alternativo);
    					else
    						setMenuBar(porDefecto);
    					return true;
    				}else if("Resizable".equals(ev.arg)){
						setResizable(!isResizable());
    					return true;
    				}else if("Cursor".equals(ev.arg)){
						posCursor = (posCursor+1) % cursores.length;
						setCursor(cursores[posCursor]);
    					return true;
    				}else if("Background".equals(ev.arg)){
						posColor1 = (posColor1+1) % colores.length;
						setBackground(colores[posColor1]);
    					return true;
    				}else if("Foreground".equals(ev.arg)){
						posColor2 = (posColor2+1) % colores.length;
						setForeground(colores[posColor2]);
    					return true;
    				}else if("Font".equals(ev.arg)){
						posLetra = (posLetra+1) % fuentes.length;
						setFont(new Font(fuentes[posLetra], Font.PLAIN, 12));
    					return true;
    				}
    			}
    	}
    	return false;
    }
}