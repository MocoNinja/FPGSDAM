package Ejercicio01;
/*Convenios: clase, empieza en mayuscula; variables y métodos, empiezan en minúscula*/
/*OJO, que es importante seguir esta nomeclatura*/

public class Casa{
    /*Los atributos van aquí. Son como variables globales que pueden usarse en toda la clase*/
	private int nPuertas, nVentanas;    /*tambien suele verse n_puertas, n_Puertas*/
	private String color;
	
    public Casa(int np, int nv, String col){   //MÉTODO CONSTRUCTOR: no devuelve nada, ni siquiera void. Se llama IGUAL que la clase. Siempre está (aunque no lo declaremos). Aunque si no lo declaramos, no hará nada.
        /*El constructor suele cargar los atributos -> de ahí los parámetros que recibe ESTE constructor*/
        /*El constructor INSTANCIA (=crear) un objeto de la clase*/
    	nPuertas = np;
    	nVentanas = nv;
    	color = col;
    } 

    /*Edicion: meter otro constructor que, si no se le pasa el color, sea blanco*/
    
    public Casa(int np, int nv) {
    	nPuertas = np;
    	nVentanas = nv;
    	color = "Blanco";
    } 

    public void pintar(String col){
        color=col;
    } 
    
    public void pintar(){ //Polimorfismo: al no especificar color, pinta de blanco
        color="Blanco";
    }
    
    public void abrirPuerta(){  //esto también sería un método set
    	nPuertas++;
    }
    
    public void abrirPuertas(int np){
    	nPuertas += np;
    }
    
    public void abrirVentana(){
    	nVentanas++;
    }
    
    public void abrirVentanas(int nv){
    	nVentanas+=nv;
    }
    
    public void cerrarVentanas(int nv){
    	if(nVentanas<0){
    		nVentanas = 0;	
    	}
    	nVentanas -= nv;
    }
    
    public void escribir(){
    	System.out.printf("Esta casa tiene %d puertas, %d ventanas y es de color %s\n", nPuertas, nVentanas, color);
    }

    public int getPuertas(){
        return nPuertas;
    }
    public int getVentanas(){
        return nVentanas;
    }
    public String getColor(){
        return color;
    }
}