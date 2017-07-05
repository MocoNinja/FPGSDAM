package EVALUACION2.clase.Ejercicio011;

import java.awt.*;
import java.util.*; // Para el List (ojo, no confundir con el de awt).

// Son muy importantes en el examen habrá una
// vamos a crear una lista de objetos para guardar todos y poder verlos

public class DibujaApp extends Frame{
    MenuBar menuBar;
    Gambas lienzo;
    int tipo;
 
    
    public DibujaApp(){
        super("Vivah paint");
        setup();
        pack();
        resize(400, 400);
        show();
    }

    public static void main(String[] args) {
        DibujaApp fap = new DibujaApp();
    }

    public void setup(){
        setupMenuBar();
        lienzo = new Gambas(tipo); // Esto es posible porque LINEA es static
        add("Center", lienzo);
    }

    public boolean handleEvent(Event ev){
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
        return true;
        }
        else if (ev.id == Event.ACTION_EVENT && ev.target instanceof MenuItem){
            if(ev.arg.equals("Salir")){
                System.exit(0);
        return true;
            } 
            else if(ev.arg.equals("Nuevo")){
                System.out.println("Que te peten");
            }
            else if(ev.arg.equals("Linea")){
                System.out.println("Que te peten");
                tipo = DosPuntos.LINEA;
                lienzo.setTipo(tipo);
                /*
                * Alternativa (si el tipo no es private)
                * lienzo.tipo = DosPuntos.LINEA
                */
        return true;
            }
            else if(ev.arg.equals("Ovalo")){
                System.out.println("Que te peten");
                tipo = DosPuntos.OVALO;
                lienzo.setTipo(tipo);
        return true;
            }
            else if(ev.arg.equals("Rectangulo")){
                System.out.println("Que te peten");
                tipo = DosPuntos.RECTANGULO;
                lienzo.setTipo(tipo);
            return true;
            }
        return false;
        } 
    return false;
    }

    public void setupMenuBar(){
        menuBar = new MenuBar();
        Menu menu2 = new Menu("Fichero");
        menu2.add(new MenuItem("Nuevo"));
        menu2.addSeparator();
        menu2.add(new MenuItem("Salir"));
        Menu menu = new Menu("Dibujar");
        menu.add(new MenuItem("Linea")); 
        menu.addSeparator();
        menu.add(new MenuItem("Ovalo")); 
        menu.addSeparator();
        menu.add(new MenuItem("Rectangulo")); 
        menuBar.add(menu);
        menuBar.add(menu2);
        setMenuBar(menuBar);
    }
}
