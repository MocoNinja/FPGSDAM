package Ejercicio02;
public class Gallo extends Animal{
    private int peleasGanadas;
    private int peleasParticipadas;
    //Constructores
    public Gallo(int n1, double d1, String s1, int n2, int n3){
        super(n1, d1, s1);
        peleasGanadas = n2;
        peleasParticipadas = n3;
    }
    public Gallo(int n1, double d1, String s1){
        super(n1, d1, s1);
        peleasGanadas = 0;
        peleasParticipadas = 0;
    }
    //Metodos Set
    public void meteCombates(int ganados, int participados){
        peleasGanadas = ganados;
        peleasParticipadas = participados;
    }
    public void meteCombates(int ganados){
        peleasGanadas = ganados;
    }
    public void meteParticipaciones(int participados){
        peleasParticipadas = participados;
    }
    //Metodos Get
    public int leeCombates(){
        return peleasParticipadas;
    }
    public int leeVictorias(){
        return peleasGanadas;
    }
    public void hablar(){
        System.out.printf("Hola, NO soy Ariel. Sere tu comida! Peso: %.1f%n", leePeso());
    }
}