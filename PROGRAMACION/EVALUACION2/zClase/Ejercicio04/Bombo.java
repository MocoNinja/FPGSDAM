package zClase.Ejercicio04;
import java.util.Random;
public class Bombo {
	private int bolas[];
	private int numBolas = 48;
	Random aleatorio;
    public Bombo() {
    	bolas = new int[numBolas];
		for(int i=0; i<numBolas; i++)
			bolas[i] = i+1;
		aleatorio = new Random();
    }
    public int getNumBolas(){
    	return numBolas;
    }
    public int sacaBola(){
    	int numAleatorio, devuelve;
    	numAleatorio = aleatorio.nextInt(numBolas);
    	devuelve = bolas[numAleatorio];
    	bolas[numAleatorio] = bolas[numBolas-1];
    	numBolas--;
    	return devuelve;
    }
}