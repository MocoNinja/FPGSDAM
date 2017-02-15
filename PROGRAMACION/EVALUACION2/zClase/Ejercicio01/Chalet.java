package zClase.Ejercicio01;
public class Chalet extends Casa{
	private int mJardin; //encapsulamiento
	boolean piscina;

    public Chalet(int np, int nv, String color, int nm, boolean piscina) {
    	super(np, nv, color);
    	this.mJardin = nm;
    	this.piscina = piscina;
    }
    
    
    public void escribir(){
    	System.out.printf("Esto es un chalet con %d metros de jardín.  ", mJardin);
    	if(piscina)
    		System.out.printf("TIENE PISCINA.  ");
    	else
    		System.out.printf("NO TIENE PISCINA.  ");
    	super.escribir();
    }
    public int getJardin(){
    	return mJardin;
    }
    public void setJardin(int nm){
    	mJardin = nm;
    }
    public boolean tienePiscina(){
    	return piscina;
    }
    public void setPiscina(boolean p){
    	piscina = p;
    }
    public void crearPiscina(){
    	piscina = true;
    }
}