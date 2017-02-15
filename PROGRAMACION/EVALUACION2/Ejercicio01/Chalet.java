package Ejercicio01;
/*
Los objetos son siempre punteros (que apuntan a una direccion o a null) 
new reserva la memoria y se llama al constructor, que asigna los parametros
*/
public class Chalet extends Casa{
    /*
        Un chalet es una casa (tiene ventanas, puertas, color) pero que *además* tiene jardín y quizás piscina
        De ahí el extends: HEREDA de la casa los atributos y métodos, además de añadir los suyos propios
    */
    private int mJardin;  //antes estaba no encapsulado. Lo encapsulamos, con el private, para no poder acceder directamente.
    private boolean piscina;

     public Chalet(int np, int nv, String color, int nm, boolean piscina){
         /*
            Puede haber constructores polimorfos! Hacemos que este necesite 5 argumentos.
            En el constructor de una clase subclase de otra (como esta misma)
            LO PRIMERO QUE HAY QUE HACER SIEMPRE ES:
                Llamar al metodo constructor de la Superclase
                    Es decir, hacer la casa (con super()) y luego hacemos el chalet
         */
        super(np,nv,color);
        this.mJardin = nm;
        this.piscina = piscina;
        /*
            Este this puede usarse o no.
            En estos casos conviene usarlo para distinguirlo del atributo y de la variable 
            En los atributos de la clase, el this esta *siempre* implicito. Solo hay que especificarlo cuando sea necesario, como en este caso de piscina
            En estos casos que existe ambigüedad (mismo nombre y tipo) *hay* que usarlo
        */

     }

     public Chalet(int np, int nv, int nm){
        super(np,nv);
        this.mJardin = nm;
     }

     public int getJardin(){  //Esto se llama métodos get. Devuelven algo. En los booleanos, se llaman is
         return mJardin;
     }
     public void setJardin(int nm){  //Esto se llama métodos set. Modofican algo.
         mJardin = nm;
     } 
     public boolean isPiscina(boolean piscina){
         return piscina;
     }
     public void setPiscina(boolean nuevo){
         piscina = nuevo;
     }
     //Estos se usan para el encapsulado, como buena práctica de programación
     public void escribir(){
    	//System.out.printf("Este chalet tiene %d puertas, %d ventanas y es de color %s. Ademas tiene %d metros de jardin.\n", nPuertas, nVentanas, color, mJardin);
        super.escribir();
        System.out.print("Ademas, tiene " + mJardin + " metros de jardin ");
        if (piscina){
            System.out.println("y piscina.");
        } else {
            System.out.println("pero no piscina");
        }
    }
}