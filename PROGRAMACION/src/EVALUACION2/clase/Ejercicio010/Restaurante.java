package EVALUACION2.clase.Ejercicio010;
import java.awt.*;


public class Restaurante extends Frame{
    final static String LOOKANDFEEL = "Metal";
    String[] comidas = {"Desayuno", "Almuerzo", "Cena"};
    String[][] platos = {{"Leche", "Cafe", "Huevos", "Tostadas", "Mermelada", "Judias", "Bacon"}, {"Bocata de lentejas", "Lentejas sin bocata", "Paella", "Sopa", "Verde", "Chichote", "Pescau", "Almondigas"},{"Tortilla", "Cafeina en vena", "Caviar", "Vinagre"}};
    TextField texto;
    Choice chComidas;
    List platosComida; // Va a ser el puntero al objeto de la clase List seleccionado de los 3.
    // Es decir, va a haber 3 objetos lista, apuntados por 4 punteros, siendo uno el anterior y los otros 3 que instanciaremos en el vector.
    List[] listaPlatos; // Esto va a contener las 3 listas (los 3 punteros que apunten a ellas).

    public static void main(String[] args) {
        Restaurante fap = new Restaurante();
    }
    
    public Restaurante(){
        super("Cooking Mama");
        setup();
        pack();
        resize(275,175);
        show();
    }

    public void setup(){
        chComidas = new Choice();
        texto = new TextField("", 40);
        for (int i = 0; i < comidas.length; i++)
           chComidas.addItem(comidas[i]);

        add("North", new Label("Selecciona la comanda:"));
        add("West", chComidas);

        listaPlatos = new List[3];
        
        for (int i = 0; i < listaPlatos.length; i++){
            listaPlatos[i] = new List(5, true); // elementos max a display, permite eleccion multiple
            for (int j = 0; j < platos[i].length; j++){
                listaPlatos[i].addItem(platos[i][j]);
            }
        }
        platosComida = listaPlatos[0];
        add("East", platosComida);
        add("South", texto);

    }

    public boolean handleEvent(Event ev){
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
    return true;
        }
        else if(ev.id == Event.ACTION_EVENT && ev.target instanceof Choice){
            // System.out.println("He pillado la acción");
            // int indice = getSelectedIndex();
            // System.out.println(getSelectedIndex());
            remove(platosComida);
            // System.out.println(chComidas.getSelectedIndex());
            platosComida=listaPlatos[chComidas.getSelectedIndex()];
            texto.setText("");
            add("East", platosComida);
            show();
    return true;
        } 
        else if ((ev.target instanceof List) && ((ev.id == Event.LIST_SELECT) || ev.id == Event.LIST_DESELECT)){
            String resultado = chComidas.getSelectedItem() + ":";
            String[] seleccionados = platosComida.getSelectedItems();
            for (int i = 0; i < seleccionados.length; i++){
                resultado += " ";
                resultado += seleccionados[i];
            }
            texto.setText(resultado);
    return true;
        }
    return false;
    }
}