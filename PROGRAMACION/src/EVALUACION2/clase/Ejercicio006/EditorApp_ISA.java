package EVALUACION2.clase.Ejercicio006;
import java.awt.*;

import java.io.*;
public class EditorApp_ISA extends Frame{
	TextArea texto;
	MenuBar menuBar;
	FileDialog abrirFichero;
	FileDialog guardarFichero;
   	public static void main(String[] args){
    	EditorApp app = new EditorApp();
    }
    public EditorApp_ISA(){
    	super("Editor de texto");
    	setup();
    	pack();
    	resize(texto.minimumSize());
    	show();
    }
    public void setup(){
    	setFont(new Font("System", Font.PLAIN, 12));
    	texto = new TextArea(25, 120);
    	add("Center", texto);
    	setupMenBar();
    	abrirFichero = new FileDialog(this, "Abrir Fichero", FileDialog.LOAD);
    	guardarFichero = new FileDialog(this, "Guardar Fichero", FileDialog.SAVE);
    }
    public void setupMenBar(){
    	menuBar = new MenuBar();
    	Menu ArchivoMenu = new Menu("Archivo");
    	ArchivoMenu.add(new MenuItem("Nuevo"));
    	ArchivoMenu.add(new MenuItem("Abrir"));
    	ArchivoMenu.addSeparator();
    	ArchivoMenu.add(new MenuItem("Guardar"));
    	ArchivoMenu.addSeparator();
    	ArchivoMenu.add(new MenuItem("Salir"));
    	menuBar.add(ArchivoMenu);
    	setMenuBar(menuBar);
    }
    
	public boolean handleEvent(Event ev){
		//Sirve para cerrar la ventana
		if(ev.id == Event.WINDOW_DESTROY){
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
				}else if(ev.arg.equals("Guardar")){
					guardarFichero.show();
					String outFile = guardarFichero.getFile();
					guardarFichero(outFile);
					return true;	
				}else if(ev.arg.equals("Abrir")){
					abrirFichero.show();
					//input-> lectura, el contenido permanece intacto. Si el archivo que intentas abrir no existe, te da una excepcion
					//output-> escritura, te cargas el contenido del archivo. Si el archivo no existe, te crea uno nuevos
					String inFile = abrirFichero.getFile();
					leerFichero(inFile);
					return true;
				}
			}
		}
		return false;
	}
	//Se tiene que leer linea por linea->readline
	//Solo lee los archivos que estan en la mismo directorio
	public void leerFichero(String nomFichero){
		DataInputStream inStream;
		//Hay que somerterlo a tratamiento de excepciones para que no de error. Te obliga a ponerlo
		//Se pueden poner mas de una excepcion con un try
		try{
			inStream = new DataInputStream(new FileInputStream(nomFichero));
			// el metodo readLine. El objeto de la clase dataInputStream tiene un puntero que apunta a una linea, lee lo 
			// de esa linea y lo pasa a una linea. Hay que crear un bucle que lea todas las lineas. El bucle termina
			// cuando lea fin de fichero que devolvera null.
			String nuevo_texto = "";
			String linea;
			while((linea = inStream.readLine())!=null){
				nuevo_texto += linea + "\n";
			}
			texto.setText(nuevo_texto);
			
		}catch(FileNotFoundException e){}
		catch(IOException e){}
		
	}
	
	public void guardarFichero(String nomFichero){
		DataOutputStream outStream;
		//Hay que someterlo a tratamiento de excepciones
		try{
			outStream = new DataOutputStream(new FileOutputStream(nomFichero));	
			//Con el texto.getText lees lo que hay escrito
			outStream.writeBytes(texto.getText());
		}catch(FileNotFoundException e){}
		catch(IOException e){}
		
	}
}