package EVALUACION2.clase.Ejercicio005;
import java.awt.*; // importamos la libreria muerta para crear la ventana

public class OvaloApp extends Frame{

    Ovalo ovulo;

    /*
    * Los elementos deben estar distribuidos -> layout
    * Por defecto se coge la BorderLayout que tiene 5 partes: N,S,E,O,Centro
    * Si quieres otras, hay que llamar al metodo setLayout(laquesea)
    *
    * Queremos meter dos objetos de la clase button:
    *       - crear el objeto e instanciarlo
    *       - meterlo dentro del frame: metodo add
    */

    public OvaloApp(){
        super("Ovuloneitor"); //Al constructor de la ventana puede pasarsele un String con el titulo
        ovulo = new Ovalo();
        Button botoncico1 = new Button("Nuevo ovalo"); //El string es el texto del boton
        Button botoncico2 = new Button("Salir");
        Panel panel = new Panel();

        /*
        * Muchas clases tienen ciclo de vida -> hay metodos que se ejecutan solos, sin ser llamados
        * Ej: naces y nadie dice co.crece, co.muere
        * Van dentro del ciclo de vida
        * Eso pasa con el metodo paint (abajo)
        */

        // Metodos heredados de Frame
        // add("South", botoncico1);
        // add("South", botoncico2);
        // Solo cabe un objeto: en el sur metemos un panel, que ashi si que pueden meterse otros objetos

        add("South", panel);
        panel.add(botoncico1); // este add es un metodo distinto, porque es de la clase panel
        panel.add(botoncico2);
        pack(); // el metodo add puede meter cosas al frame. Este metodo pack empaqueta esas cosas y las distribuye en su sitio
        resize(300,300); // da unas dimensiones a este frame (recordar, va implicito el this.pack, this.resize...)
        show(); //visualizarlo
    }

    public void paint(Graphics titanx){  // DEBE llamarse paint
        titanx.drawString("Pero que API mas fea", 20, 100); 
        ovulo.dibujar(titanx);
    }

    public static void main(String[] args) {
        OvaloApp miOvulo = new OvaloApp();
    }

    /*
    * Al hacer algo, se crea un objeto de la (sub)clase Event
    * El objeto lo crea el programa (el thread generado) <- eso lo veremos mas adelante
    * Ese evento mira en la clase que esta ejecutandose, a ver si hay eventos
    */

    // Vamos a ver el metodo mas general de tratamiento de eventos:
    // la clase evente esta en un paquete importado por defecto (no hay que decirlo, se importa igual)
    // Si hay varios metodos de este tipo, el objeto generado entra a ejcutar solo 1. El mas concreto.

    public boolean handleEvent(Event ev){ // salvo los listener, todos devuelven booleanos y reciben un objeto evento
        if (ev.id == Event.WINDOW_DESTROY){ // este evento es darle a la crucecita de la ventana.
            // static final WINDOW_DESTROY : atributo constante de la clase event que puede accederse por nombre (static)
            System.exit(0);
        return true; // el booleano no se utiliza realmente
         } else if (ev.id == Event.ACTION_EVENT){  // Esto no tiene mucho sentido, porque hay mejores alternativas
             // Un evento de accion depende del objeto sobre el que se produzca;
             // En un boton, sera hacer click
             if (ev.target instanceof Button){ // target indica la clase del objeto sobre el que se ha producido el evento
                 // instance of no es una intruccion, sino un operador;
                 // compara si el elemento es de la clase button
                 if("Salir".equals(ev.arg)){ //equals es un metodo de la clase String --> arg es un String (el "titulo")
                    System.exit(0);
                    return true;
                 } else if ("Nuevo ovalo".equals(ev.arg)){
                     //ovulo = new Ovalo();//nuevo objeto
                     ovulo.inicializar(); //sin nuevo objeto
                     repaint();
                     return true;
                 }
             }
         }
    return false;
    }
}