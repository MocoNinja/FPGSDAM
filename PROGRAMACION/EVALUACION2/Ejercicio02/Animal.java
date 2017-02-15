package Ejercicio02;
/*
* EN LAS clases
* public: permite usars la clase en otros proyectos
* si no lleva ningún modificador, puede cogerse siempre y cuando este en el mismo paquete
* abstract: son aquellas sobre las cuales NO pueden crearse objetos de esta (no puedes hacer new), pero si de subclases
*   vamor a ver un ejemplo de esta
*/

/*
* EN LOS metodos
* abstract: no se implementa, se define
*   esto es poner el nombre y plás
*   crea la *obligacion* en las subclases de implementar este metodo -> ahora daria error al compilar
*/
abstract class Animal{
    int ID;
    private double peso;
    String fechaNac;
    public Animal(int ID, double d1, String s1){
        this.ID = ID; //No olvidar lo del this
        peso = d1; //Recordar también que sigue siendo valido this.peso, aunque no haya ambiguedad
        fechaNac = s1;
    }

    abstract void hablar();
    public double leePeso(){
        return peso;
    }
}