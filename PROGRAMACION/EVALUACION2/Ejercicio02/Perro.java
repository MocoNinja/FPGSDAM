package Ejercicio02;
public class Perro extends Animal{
    String raza;
    public Perro(int n1, double d1, String s1, String s2){
        super(n1, d1, s1);
        raza = s2;
    }
    public void hablar(){
        //System.out.printf("Hola, soy Ariel. Dame comida! Peso: %.1f%n", peso);//Esto deja de funcionar al voler private peso
        System.out.printf("Hola, soy Ariel. Dame comida! Peso: %.1f%n", leePeso()); //Tambien puede this.leerPeso()
    }
}