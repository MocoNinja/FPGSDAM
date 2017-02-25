package claseViejo.Ejercicio002;
public class SobreAnimales{
    public static void main(String[] args) {
        Perro ARIEL_OF_DOOM = new Perro(1,5.5,"01/04/2014", "Mezcla de Yorkshire y Bichon Maltes");
        Perro ARIEL_HAPPY = new Perro(2, 5.6,"01/04/2014", "Mezcla de Yorkshire y Bichon Maltes");
        Gallo FUTURA_SOPA = new Gallo(1, 200.45, "-");
        Gallo ROCKY_BALBOA = new Gallo(2, 6, "-", 1000000, 1000000);
        System.out.println(FUTURA_SOPA.leeCombates());
        FUTURA_SOPA.meteCombates(0,10);
        System.out.println(FUTURA_SOPA.leeCombates());
        ARIEL_OF_DOOM.hablar();
        FUTURA_SOPA.hablar();
        ROCKY_BALBOA.hablar();
        ARIEL_HAPPY.hablar();
    }
}