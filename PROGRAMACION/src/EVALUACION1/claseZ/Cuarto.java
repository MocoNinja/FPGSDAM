package EVALUACION1.claseZ;
public class Cuarto {

	public static void main(String ar[]){
		int x, y, z;
		x = 1022;
		y = 73;
		z = 96;
					
		if(x > y){
			if(x > z){
				System.out.println("El mayor es : " + x);
			}else{
				System.out.println("El mayor es : " + z);
			}
		}else{
			if(y > z){
				System.out.println("El mayor es : " + y);
			}else{
				System.out.println("El mayor es : " + z);
			}
		}
	}
}