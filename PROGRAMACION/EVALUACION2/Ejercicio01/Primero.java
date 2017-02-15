package Ejercicio01;
public class Primero {

    public static void main(String args[]) {
    	Casa casa1, casa2;
		Chalet chalet1, chalet2, chalet3;
    	
    	/*Los objetos son variables de tipo puntero. casa1 y casa2 son punteros, que inicialmente apuntan a NULL porque no los hemos definido*/
        /*Vamos a instanciar (crear) -> llamamos al constructor*/
        casa1 = new Casa(1,3,"Verde"); /*new reserva la memoria en la ram*/
    	casa2 = new Casa(2,5);
    	
    	casa1.escribir();
    	casa2.escribir();
    	
    	casa2.pintar("Amarillo chillon");
    	casa1.pintar();	
    	casa1.abrirVentanas(4);
    	
    	casa1.escribir();
    	casa2.escribir();

		chalet1 = new Chalet(2, 9, "Rosa", 250, true);
		chalet2 = new Chalet(2, 9, "Rosa", 250, false);
		chalet3 = new Chalet(2, 9, 500);

		chalet1.escribir();
		chalet1.pintar();
		chalet1.escribir();
		chalet2.escribir();
		chalet3.escribir();

		//System.out.println("El jardin tiene " + chalet1.mJardin + " metros...");
		//AQUI EMPIEZA EL ENCAPSULAMIENTO -> lo anterior no compila
		//No puede accederse por nombre, pero si por el metodo
		System.out.println("El jardin tiene " + chalet1.getJardin() + " metros...");
		//				*Buena practica de progamacion*
    }
}