package EVALUACION2.claseZ.Ejercicio10;
import java.awt.*;
public class Restaurante extends Frame{
	String[] comidas = {"Desayuno", "Almuerzo", "Cena"};
	String[][] platos = {{"Leche", "Café", "Huevos", "Tostadas", "Mermelada", "Beacon"}, 
						{"Paella", "Sopa", "Macarrones", "Ensalada", "Filete", "Pescado", "Albóndigas", "Hamburguesa"}, 
						{"Tortilla", "Sopa", "Hamburguesa", "Ensalada", "Pollo", "Bocadillo", "Sandwich"}};
	Choice chComidas;
	List platosComida;
	List[] listasPlatos;
	TextField texto;
	
	public static void main(String args[]){
		Restaurante fap = new Restaurante();
	}

    public Restaurante() {
    	super("Restaurante Aplicación");
    	setup();
    	pack();
    	resize(275, 175);
    	show();
    }    
    
    public void setup(){
		this.add("North", new Label("Elige tu comanda"));
		chComidas = new Choice();
		for(int i=0; i<comidas.length; i++)
			chComidas.addItem(comidas[i]);
		this.add("West", chComidas);
		listasPlatos = new List[comidas.length];
		for(int i=0; i<comidas.length; i++){
			listasPlatos[i] = new List(5, true);
			for(int j=0; j<platos[i].length; j++)
				listasPlatos[i].addItem(platos[i][j]);
		}
		platosComida = listasPlatos[0];
		this.add("East", platosComida);
		texto = new TextField("", 40);
		this.add("South", texto);
		
    }	
    	
    public boolean handleEvent(Event ev){
    	if(ev.id==Event.WINDOW_DESTROY){
    		System.exit(0);
    		return true;
    	}else if(ev.id==Event.ACTION_EVENT){
    			if(ev.target instanceof Choice){
    				this.remove(platosComida);
    				platosComida = listasPlatos[chComidas.getSelectedIndex()];
    				this.add("East", platosComida);
    				this.show();
    				return true;
    			}
    	}else if((ev.id == Event.LIST_SELECT) || (ev.id == Event.LIST_DESELECT)){
    		String peticion = chComidas.getSelectedItem() + " : ";
    		String seleccionados[] = platosComida.getSelectedItems();
    		for(int i=0; i<seleccionados.length; i++)
    			peticion += seleccionados[i] + " ";
    		
    		texto.setText(peticion);
    		
    		return true;
    	}
    	
    	
    	return false;
    }
}