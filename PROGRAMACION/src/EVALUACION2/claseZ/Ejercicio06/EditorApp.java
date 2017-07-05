package EVALUACION2.claseZ.Ejercicio06;
import java.awt.*;
import java.io.*;
public class EditorApp extends Frame{
	TextArea texto;
	MenuBar menuBar;
	FileDialog abrirFichero;
	FileDialog guardarFichero;
	public static void main(String args[]){
		EditorApp app = new EditorApp();
	}
    public EditorApp() {
    	super("Editor de texto");
    	setup();
    	pack();
    	resize(texto.minimumSize());
    	show();
    }
    public void setup(){
    	setFont(new Font("System", Font.PLAIN, 12));
    	texto = new TextArea(25, 80);
    	add("Center", texto);
    	setupMenuBar();
    	abrirFichero = new FileDialog(this, "Abrir Fichero", FileDialog.LOAD);
    	guardarFichero = new FileDialog(this, "Guardar Fichero", FileDialog.SAVE);
    }
    
    public void setupMenuBar(){
    	menuBar = new MenuBar();
    	Menu archivoMenu = new Menu("Archivo");
    	archivoMenu.add(new MenuItem("Nuevo"));
    	archivoMenu.add(new MenuItem("Abrir"));
    	archivoMenu.addSeparator();
    	archivoMenu.add(new MenuItem("Guardar"));
    	archivoMenu.addSeparator();
    	archivoMenu.add(new MenuItem("Salir"));
    	menuBar.add(archivoMenu);
    	setMenuBar(menuBar);
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
    				}else if(ev.arg.equals("Nuevo")){
    					texto.setText(" ");
    					return true;
    				}else if(ev.arg.equals("Abrir")){
    					abrirFichero.show();
    					String inFile = abrirFichero.getFile();
    					leerFichero(inFile);
    					return true;
    				}else if(ev.arg.equals("Guardar")){
    					guardarFichero.show();
    					String outFile = guardarFichero.getFile();
    					guardarFichero(outFile);
    					return true;
    				}
    			}	
    	}
    	return false;
    }
    
    public void leerFichero(String nomFichero){
    	DataInputStream inStream;
    	try{
    	   	inStream = new DataInputStream(new FileInputStream(nomFichero));
    	   	String nuevo_texto = "";
    	   	String linea;
    	   	while((linea = inStream.readLine()) != null)
    	   		nuevo_texto += linea + "\n";
    	   	texto.setText(nuevo_texto);
    	}catch(FileNotFoundException e){}
    	 catch(IOException e){}
    }
    
    public void guardarFichero(String nomFichero){
    	DataOutputStream outStream;
    	try{
	    	outStream = new DataOutputStream(new FileOutputStream(nomFichero));
	    	outStream.writeBytes(texto.getText());
    	}catch(FileNotFoundException e){}
    	catch(IOException e){}
    }
    
}