package z;
public class SeptuagesimoOctavo {

	public static void main(String arg[]){
		String nombres[] = {"Pepe", "Juan", "María", "Antonio", "Luisa"};

		String inter;
		for(int x=0; x<nombres.length-1; x++)
			for(int i=nombres.length-1; i>x; i--)
				if(nombres[i].compareTo(nombres[i-1]) < 0){
					inter = nombres[i];
					nombres[i] = nombres[i-1];
					nombres[i-1] = inter;
				}
			

		for(int i=0; i<nombres.length; i++)
			System.out.println(nombres[i]);

    }
    
    
}