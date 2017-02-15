package Ejercicio09;
import java.awt.*;

public class CheckboxApp extends Frame{
    CheckBoxPanel cbPanel;
    CheckBoxPanelGroup cbgPanel;
    public static void main(String[] args) {
        CheckboxApp fap = new CheckboxApp();
    }

    public CheckboxApp(){
        super("Encabezado original");
        setup();
        pack();
        resize(minimumSize());
        show();
    }
    public void setup(){
        String[] deportes = {"Counter Strike", "Sillonbol", "Levantamiento de jarra", "Comer perritos calientes", "Pleiesteision"};
        String[] edades = {"Menos de 20", "Menos de 40", "Menos de 60", "Viejismo"};
        setLayout(new GridLayout(1, 2));
        cbPanel = new CheckBoxPanel("Deportes that you like?", deportes);
        cbgPanel = new CheckBoxPanelGroup("Cuan viejuno es vuesa merced?", edades);
        add("Center", cbPanel);
        add(cbgPanel);
    }

    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            System.exit(0);
    return true;
        }
    return false;
    }
}

class CheckBoxPanel extends Panel{
    Checkbox[] misCheckboxes;
    public CheckBoxPanel(String pregunta, String[] respuesta){
        super();
        setLayout(new GridLayout(respuesta.length + 1, 1));
        add(new Label(pregunta));
        misCheckboxes = new Checkbox[respuesta.length];
        for (int i = 0; i < respuesta.length; i++){
            misCheckboxes[i] = new Checkbox(respuesta[i]);
            add(misCheckboxes[i]);
        }
    }
}

class CheckBoxPanelGroup extends CheckBoxPanel{
    // Checkbox[] misCheckboxes; // ESTA HEREDADO
    public CheckBoxPanelGroup(String pregunta, String[] respuesta){
        super(pregunta, respuesta);
        CheckboxGroup grupo = new CheckboxGroup();
        for (int i = 0; i < misCheckboxes.length; i++){
            misCheckboxes[i].setCheckboxGroup(grupo); // Notar que aqui va al reves
        }
    }
}
