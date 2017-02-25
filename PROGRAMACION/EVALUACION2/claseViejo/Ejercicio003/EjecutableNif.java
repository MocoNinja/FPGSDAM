package claseViejo.Ejercicio003;
public class EjecutableNif{
    public static void main(String[] args) throws Exception {
       // Nif nif1 = new Nif(73028338, 'A');
       //nif1.leerNif();

        Nif nif1 = new Nif(730238338); 
       //nif2.asignarLetra(); //Esto queda obsoleto mejorando el constructor, que trivializa ese metodo;
        nif1.leerNif();
        /*
        Nif nifFail1 = new Nif(73028338, 'B'); //Ha exigido poner lo de throws Exception en main, o no compilaba
        nifFail1.leerNif();
        */
        Nif nifFail2 = new Nif(730283383);
        nifFail2.leerNif();
        
    }
}