package zClase.Ejercicio03;
public class EjecutableNif {

    public static void main(String args[]) throws NifException, DniException{
    	Nif nif1, nif2;
    	int x;
    	
    	/*try{
	    	x = 7/0;
    	}catch(ArithmeticException excepcion){
    		System.out.println("Cuidadín, que estás dividiendo por cero");
    	}catch(Exception exc){};
    	*/
    	//nif1 = new Nif(3456123, 'A');
    	
    	nif2 = new Nif(290911998);
    	
    	//nif1.escribir();
    	nif2.escribir();
    	
    	
    }
    
    
}