package EVALUACION2.claseZ.Ejercicio02;
abstract class Animal {
	int ID;
	private double peso;
	String fnac;
    public Animal(int ID, double p, String f) {
		this.ID = ID;
		peso = p;
		fnac = f;
    }
    abstract void habla();
    public double getPeso(){
    	return peso;
    }
   	public void setPeso(double p){
   		peso = p;
   	}
}