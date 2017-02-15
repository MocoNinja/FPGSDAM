package zClase.Ejercicio02;
public class Perro extends Animal{
	String raza;
    public Perro(int ID, double peso, String fn, String raza) {
    	super(ID, peso, fn);
    	this.raza = raza;
    }
    
    public void habla(){
    	System.out.printf("Guau, guau, soy un perro de raza %s nací el %s y peso %.1f\n", raza, fnac, getPeso());
    }
    
}