package z;
public class DecimoTercero {
	static int dividendo = 13;
	static int divisor = 4;
	public static void main(String ar[]){
		int resultado = 0;
		int x = dividendo;
		while(x >= divisor){
			x -= divisor;
			resultado++;
		}
		System.out.printf(dividendo + " / " + divisor + " = " + resultado);
    }
    
    
}