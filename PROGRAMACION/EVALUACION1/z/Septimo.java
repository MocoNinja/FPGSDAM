package z;
public class Septimo {

	public static void main(String ar[]){
		int x, y;
		int auxiliar;
		x = 21;
		y = 4;
		if(x < y){
			auxiliar = x;
			x = y;
			y = auxiliar;
		}
		if((x % y) == 0)
			System.out.println(x + " es múltiplo de " + y);
		else
			System.out.println(x + " no es múltiplo de " + y);
    }
        
}