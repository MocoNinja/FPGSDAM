package EVALUACION2.clase.Ejercicio006;
import java.awt.*;
import java.io.*;
/*
* Modificadores:
* Public: puede importarse desde cualquier paquete
* Ausencia de modificador: pueden importarse sólo desde el mismo paquete
*/
/*
* Para manipular un archivo de texto, hay que convertirlo a un objeto de java
* Asi el archivo puede manipularse mediante los metodos de la clase
*
* Hay que conseguir convertir el .txt a un objeto de la clase DataInputStream
* Leeremos líneas mediante el método readLine()
*/
public class EditorApp extends Frame{
    TextArea texto; // Area para escribir, mas grande que un input
    MenuBar menuBar;
    FileDialog abrirArchivo;
    FileDialog guardarArchivo;
    public static void main(String[] arg){
        EditorApp app = new EditorApp();
    }
    public EditorApp(){
        super("Editor");
        setup();
        pack();
        resize(texto.minimumSize()); // necesita las mismas dimensiones del text Area
        show();
    }
    public void setup(){
        setFont(new Font("System", Font.PLAIN,12)); // Este objeto no tiene nombre. Por lo tanto, no podrá ser referenciado después. Pero existe.
        texto = new TextArea(25, 80); // filas, columnas
        add("Center", texto);
        setupMenuBar();
        abrirArchivo = new FileDialog(this, "Abrir Archivo", FileDialog.LOAD); // objeto asociado, texto, tipo de cuadro de diálogo (son static)
        guardarArchivo = new FileDialog(this, "Guardar Archivo", FileDialog.LOAD);
    }
    public void setupMenuBar(){
        /*
        * Menus
        * Tienen 3 niveles:
        * MenuBar -> El objeto entero que tiene los menus, el menu global
        * El file, edit, .. -> objetos de menu
        * El open, close... -> objetos de la clase menu item
        */
        menuBar = new MenuBar();
        Menu archivoMenu = new Menu("Archivo");
        archivoMenu.add(new MenuItem("Nuevo"));
        archivoMenu.add(new MenuItem("Abrir...")); 
        archivoMenu.addSeparator();
        archivoMenu.add(new MenuItem("Guardar..."));
        archivoMenu.addSeparator();
        archivoMenu.add(new MenuItem("Salir"));
        menuBar.add(archivoMenu);
        setMenuBar(menuBar); // Para cargar al frame
    }
   // salvo mi comentario, esto ersta ciopiado / autogerneado. ESTUDIARLO
    public void leerArhivo(String fichero){
        DataInputStream inStream;  // esto es una variable local
        //inStream = new DataInputStream(new FileInputString()); // La clase DataInputStream tiene el método para leer la siguiente línea, pero no uno para abrir el archivo
        try {
			inStream = new DataInputStream(new FileInputStream(fichero));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void guardarArchivo(String fichero){

    }

    public boolean handleEvent(Event ev){ // salvo los listener, todos devuelven booleanos y reciben un objeto evento
        if (ev.id == Event.WINDOW_DESTROY){ // este evento es darle a la crucecita de la ventana.
            // static final WINDOW_DESTROY : atributo constante de la clase event que puede accederse por nombre (static)
            System.exit(0);
    return true; // el booleano no se utiliza realmente
         }
         else if(ev.id == Event.ACTION_EVENT){ // cada objeto tiene un evento de accion asociado (para el menu item, darle)
            if(ev.target instanceof MenuItem){ // el target permite comparar clases. El instanceof es como un ==
                if (ev.arg.equals("Salir")){  // El argumento es, en este caso, el String asociado al menu
                    System.exit(0);
    return true;
                }
                else if(ev.arg.equals("Nuevo")){
                    texto.setText(" ");
    return true;
                } 
                else if(ev.arg.equals("Abrir...")){
                    // texto.setText("He clickao abrir");
                    abrirArchivo.show();
                    String inFile = abrirArchivo.getFile();
                    // Esto coge el nombre del archivo
                    //texto.setText(inFile); // prueba
                    // vamos a hacer nuestro metodo leer fichero 
                    leerArhivo(inFile);
    return true;
            } else if(ev.arg.equals("Guardar...")){
                    // texto.setText("He clickao abrir");
                    guardarArchivo.show();
                    String outFile = guardarArchivo.getFile();
                    guardarArchivo(outFile);
    return true;
            } 
             } 
         }

     // Final    
    return false;
    }
}
    /*
    * Abir archivos
    * Input: lectura
    *  -> Si lo abres y no existe, salta excepcion
    *  -> El contenido del archivo permanece intacto al abrirlo
    * Output: escritura
    *   -> Si lo abres y no existe, se crea
    *   -> El contenido del archivo te lo cargas al abrirlo
    */

    /*
    * Las clases están en paquetes (=directorios)
    * Estas de lectura/escritura, en IO
    */