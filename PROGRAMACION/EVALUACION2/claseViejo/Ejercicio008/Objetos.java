package claseViejo.Ejercicio008;
import java.awt.*;

public class Objetos extends Frame{
    /*
    * En un tablero cuadrado de 9 cuadrados (en plan 3 en raya), habrá objetos que interaccionan entre si
    */

    TextArea textArea;
    public static void main(String[] args) {
        Objetos objetito = new Objetos();
    }

    public Objetos(){
        super("Trabajando con Objetos...");
        setup();
        pack();
        resize(800, 800);
        show();
    }

    public void setup(){
        Panel panelPrincipal = new Panel();
        panelPrincipal.setLayout(new GridLayout(3, 3));
        Panel paneles[][]; // puntero a null, por ahora
        paneles = new Panel[3][3]; // Se ha resevado memoria para 3x3 objetos (direcciones de memoria) de panel.
        // notar que no es Panel(), así que no hay *ningun* objeto de la clase panel
        // paneles ahora esta declarado e instanciado, pero no hay ningun panel creado
        for (int filas = 0; filas < paneles.length; filas++){
            for (int columnas = 0; columnas < paneles[filas].length; columnas++){
                paneles[filas][columnas] = new Panel();
                // se confundio. El layout no es linear, es flow. Linear es en android.
                paneles[filas][columnas].setLayout(new FlowLayout(FlowLayout.LEFT));
                // se le pasa una constante de FlowLayout que es LEFT e indica que empieza por la izquierda
            }
        }

        // Cargar cosas
            // Campo de texto
        paneles[0][0].add(new Label("Campo de texto: "));
        paneles[0][0].add(new MiTextField("", 15));
            // TextArea
        paneles[1][0].add(new Label("Area de texto: "));
        textArea = new TextArea("Es un TextArea", 5, 15); // Lo reseñable: lo hemos declarado como atributo de la clae y, en consecuencia, puede manipularse desde cualquier punto de esta
        paneles[1][0].add(textArea);
            // Button
        paneles[2][0].add(new Label("Button: ")); // Limpiará el textArea. Vamos a hacer el botón como subclase de Button
        paneles[2][0].add(new MiPeazoButton("PEAZO BOTON", textArea));
            // Canvas
        paneles[0][1].add(new Label("Un canvas: "));
        paneles[0][1].add(new Gambas()); // El canvas es parecido al Frame. También tiene un Graphics dentro
            // Desplegable -> Tienen String que son los Items (son objetos de la clase Choice)
        String choiceStrings[] = {"Si", "No", "Quizas"};
        paneles[1][1].add(new Label("Un Choice: "));
        paneles[1][1].add(new Chois(choiceStrings, textArea));
            // List: Parecido al Choice, pero se ven varios (los que le digas) y permite selección múltiple.
            // EL EVENTO DE ACCIÓN ES *DOBLE CLICK* 
        String listStrings[] = {"Si", "No", "Quizas", "A lo mejor", "Puede ser", "Broccoli", "Mi perro mola mas que nadie", "Quiero un bocata de calamares"};
        paneles[2][1].add(new Label("Un List: "));
        paneles[2][1].add(new QueLista(listStrings, textArea));
            // Checkbox
        String cbStrings[] = {"CheckBoxGroup: ", "Colegio", "Salesianos", "Zaragoza"};
        paneles[2][2].add(new GrupoCajas(cbStrings));
            // ScrollBar
        paneles[1][2].setLayout(new BorderLayout()); // para que se vea mejor
        paneles[1][2].add("South", new Barrita(Scrollbar.HORIZONTAL, 50, 10, 0, 100, textArea)); // Modo, posicion del botoncito, tamaño del botoncito, los 2 valores que harán las divisiones del scroll
         paneles[2][2].setLayout(new BorderLayout());
         paneles[2][2].add("East", new Barrita(Scrollbar.VERTICAL, 50, 10, 0, 100, textArea));

        // Cargar los paneles

        /*
        // NOOB
        panelPrincipal.add(paneles[0][0]);
        panelPrincipal.add(paneles[1][0]);
        panelPrincipal.add(paneles[0][1]);
        panelPrincipal.add(paneles[2][0]);
        panelPrincipal.add(paneles[1][1]);
        panelPrincipal.add(paneles[2][1]);
        panelPrincipal.add(paneles[2][2]);
        panelPrincipal.add(paneles[1][2]);
        */
        // AS�?N
        for (int i = 0; i < paneles.length; i++)
            for (int j = 0; j < paneles[i].length; j++)
                panelPrincipal.add(paneles[i][j]);
        this.add(panelPrincipal);

    }

    public boolean handleEvent(Event ev){ 
        if (ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
    return true;
         }
    return false;
    }
}

// Se pueden declarar otras clases en un mismo archivo, pero no pueden ser publicas

class MiTextField extends TextField{ // Este TextField será normal, pero su evento (darle al Enter) pasará el texto a mayúsculas

    public MiTextField(String frase, int columnas){ // Aunque la clase no sea pública (y en consecuencia no puede importarse desde otro directorio), el constructor puede ser public
        super(frase, columnas);
    }
    // Al tener una clase extendida, podemos acotar dónde se produce el evento que queremos tratar
    public boolean action(Event ev, Object arg){ // Object es una superclase que no hemos visto todavía. Es un objeto muy general al que le cabe todo
            String texto = getText();
            setText(texto.toUpperCase()); 
    return true;
    }
}

class MiPeazoButton extends Button{
    TextArea objetivo; // Porque al ponerlo en el constructor, es local a este -> No puede utilizarse en el action
    public MiPeazoButton(String titulo, TextArea elTextArea){
        super(titulo);
        objetivo = elTextArea;
    }
    public boolean action(Event ev, Object arg){ 
            objetivo.setText(" ");
    return true;
    }
}

class Gambas extends Canvas{ // MiCanvas
    // Tiene incluido en el ciclo de vida el metodo paint
    int posX = 20, posY = 20;
    public Gambas(){
        super();
        resize(75, 75);
        setBackground(Color.YELLOW);
        setForeground(Color.RED);
        show(); // Realmente no hace falta
    }
    public void paint(Graphics titanx){  // DEBE llamarse paint
        titanx.fillRect(posX, posY, 18, 18);
    }

    // Ahora queremos que se dibujo donde hacemos el click.
    // Ahora vamos a ver eventos de ratón
    public boolean mouseDown(Event ev, int x, int y){  // x, y devuelven ya las coordenadas del ratón.
        posX = x;
        posY = y;
        // System.out.println(x + " " + y);
        repaint(); // LIMPIA y luego redibuja
    return true;
    }
    // Nota para luego: cuando hay varios para tratar eventos, el Event se mete en el método más concreto
}

class Chois extends Choice{
    TextArea objetivo;
    public Chois(String[] items, TextArea textArea){
        super();
        for (int i = 0; i < items.length; i++){
            addItem(items[i]);
        }
        objetivo = textArea;  // Poner textArea = objetivo me ha dado mi primer null Pointer Exception a fecha de 2017/1/18 <3
    }
    public boolean action(Event ev, Object arg){ 
            objetivo.setText(getSelectedItem()); // también existe getSelectedIndex()
    return true;
    }
}

class QueLista extends List{
    TextArea objetivo;
    public QueLista(String[] items, TextArea textArea){
        super(6, true); // El booleano es para selección múltiple
        for (int i = 0; i < items.length; i++){
            addItem(items[i]);
        }
        objetivo = textArea;
    }
    /*
    public boolean action(Event ev, Object arg){ 
        // objetivo.setText(getSelectedItem()); // también existe getSelectedIndex()
        objetivo.setText("");
        System.out.println(getSelectedItems().length);
        for (int i = 0; i < getSelectedItems().length; i++){
                objetivo.setText(objetivo.getText() + getSelectedItems()[i] + "\n");
            }
    return true;
    }
    */
    // Vamos a ver un método más general
    public boolean handleEvent(Event ev){ // No tiene por qué ser el de acción, por eso es más general
        if (ev.id == Event.ACTION_EVENT){
            objetivo.setText("Doble click");
    return true;
        } 
        else if (ev.id == Event.LIST_SELECT){
            objetivo.setText("Seleccionado");
    return true;
        }
        else if (ev.id == Event.LIST_DESELECT){
            objetivo.setText("Deseleccionado");
    return true;
        }
    return false;
    }
}

class GrupoCajas extends Panel{
   Checkbox[] misCheckboxes;
   TextField resultados;
    public GrupoCajas(String[] elementos){
        super();
        setLayout(new GridLayout(elementos.length + 1, 1)); // El 1 de la derecha, para que salgan en vertical. Si no, salen en horizontal.
        add(new Label(elementos[0]));
        misCheckboxes = new Checkbox[elementos.length - 1];
        for (int i = 1; i < elementos.length; i++){
            misCheckboxes[i - 1] = new Checkbox(elementos[i]);
            add(misCheckboxes[i-1]);
        }
        resultados = new TextField("", 15);
        add(resultados);
    }
    /*
    public boolean action(Event ev, Object arg){ // Este evento de acción es sobre el panel
        String resultado = "";
        for (int i = 0; i < misCheckboxes.length; i++){
            if (misCheckboxes[i].getState()){
                resultado += misCheckboxes[i].getLabel() + " ";
            }
        }
        resultados.setText(resultado);
    return true;
    }
    */
    // Hecho así en clase (salvo el &&, que él los ha puesto anidados)
    public boolean handleEvent(Event ev){
        if ((ev.id == Event.ACTION_EVENT) && (ev.target instanceof Checkbox)){
            String resultado = "";
            for (int i = 0; i < misCheckboxes.length; i++){
                if (misCheckboxes[i].getState()){
                    resultado += misCheckboxes[i].getLabel() + " ";
                }
            }
            resultados.setText(resultado);
        }
    return false;
    }
}

class Barrita extends Scrollbar{ // Va a actuar sobre el textArea y le va a meter las posiciones
    TextArea areaTexto;
    public Barrita(int orientacion, int posicion, int anchura, int principio, int fin, TextArea objetivo){
        super(orientacion, posicion, anchura, principio, fin);
        areaTexto = objetivo;
    }
    public boolean handleEvent(Event ev){ // El Scrollbar NO tiene eventos de accion
        if (ev.id == Event.SCROLL_LINE_UP){  // click arriba
            areaTexto.setText("Posicion: " + getValue());
        return true;    
        }
        else if (ev.id == Event.SCROLL_LINE_DOWN){
            areaTexto.setText("Posicion: " + getValue());
        return true;
        }
        else if (ev.id == Event.SCROLL_PAGE_DOWN){
            areaTexto.setText("Posicion: " + getValue());
        return true;
        }
        else if (ev.id == Event.SCROLL_PAGE_UP){
            areaTexto.setText("Posicion: " + getValue());
        return true;
        }
        else if (ev.id == Event.SCROLL_ABSOLUTE){ // Ir arrastrando
            areaTexto.setText("Posicion: " + getValue());
        return true;
        }
    return false;
    }
}