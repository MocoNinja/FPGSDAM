import java.awt.*;
import java.applet.*;

public class Baraja{
	Carta cartas[];
	int proxima = 0; 
    public Baraja(Image imagenes[]) {
		cartas = new Carta[BlackJack.NUM_CARTAS];
		for(int i=0; i<BlackJack.NUM_CARTAS; i++)
			cartas[i] = new Carta(imagenes[i], (i % BlackJack.CPP) + 1);
    }
	
	public void barajar(){
		Carta auxiliar;
		for(int i=0; i<100; i++){
			int p1 = (int)(Math.random() * BlackJack.NUM_CARTAS);
			int p2 = (int)(Math.random() * BlackJack.NUM_CARTAS);
			auxiliar = cartas[p1];
			cartas[p1] = cartas[p2];
			cartas[p2] = auxiliar;
		}
	}
	
	public Carta sacar(){
		return cartas[proxima++];
	}

}