package zClase.Ejercicio01;
public class Primero {

    public static void main(String args[]) {
    	Casa casa1, casa2;
    	Chalet chalet1;
    	
    	casa1 = new Casa(1, 3, "Verde");
    	
    	casa2 = new Casa(2, 5);
    	
    	casa1.escribir();
    	casa2.escribir();
    	
    	casa2.pintar("Amarillo chillón");
    	casa1.pintar();
    	casa1.abrirVentanas(2);
    	
    	casa1.escribir();
    	casa2.escribir();
    	
    	chalet1 = new Chalet(2, 9, "Rosa", 250, true);
    	
    	chalet1.escribir();
    	chalet1.pintar();
    	chalet1.escribir();
    	
    	System.out.println("El número de metros del jardín es : " + chalet1.getJardin());
    	
    }
    
    
}