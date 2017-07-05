package EVALUACION2.claseZ.Ejercicio02;
public class SobreAnimales {

    public static void main(String args[]) {
    	
    	//Animal animalico = new Animal(100, 23, "12/10/2015"); No lo permite porque la clase Animal es abstract
    	Perro perro1 = new Perro(100, 3, "12/10/2015", "Chihuahua");
    	Gallo gallo1 = new Gallo(101, 4.3, "15/03/2016");
    	
    	Perro perro2 = new Perro(102, 25, "03/10/2009", "Boxer");
    	Gallo gallo2 = new Gallo(103, 4, "10/11/2015", 5, 5);
    	
    	gallo1.setNumCombates(3);
    	gallo1.setCombGanados(2);
    	
    	perro1.habla();
    	gallo1.habla();
    	perro2.habla();
    	gallo2.habla();
    }
    
    
}