package EVALUACION2.claseZ.Ejercicio02;
public class Gallo extends Animal{
	private int numCombates;
	private int combGanados;
    public Gallo(int ID, double peso, String fn) {
    	super(ID, peso, fn);
    	numCombates = 0;
    	combGanados = 0;
    }
    public Gallo(int ID, double peso, String fn, int nC, int cG) {
    	super(ID, peso, fn);
    	numCombates = nC;
    	combGanados = cG;
    }
    public int getNumCombates(){
    	return numCombates;
    }
    public int getCombGanados(){
    	return combGanados;
    }
    public void setNumCombates(int nc){
    	numCombates = nc;
    }
    public void setCombGanados(int cg){
    	combGanados = cg;
    }
    
    public void habla(){
    	System.out.printf("Kikiriki, soy un gallo que ha peleado en %d combates, habiendo ganado %d, con peso de %.1f\n", numCombates, combGanados, getPeso());
    }
    
}