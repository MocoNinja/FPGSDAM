import java.awt.*;
import java.applet.*;

public class Casilla {
	Color coloresFondo[] = {Color.pink, Color.orange, Color.blue, Color.green, Color.black, Color.magenta, Color.cyan, Color.magenta, Color.red, Color.lightGray, Color.yellow};
	Color coloresLetra[] = {Color.white, Color.black, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.black, Color.black};
	int x, y;
	public static final int TAM = 50;
	private int valor;
    public Casilla(int posx, int posy) {
    	x = posx; 
    	y = posy;
		valor = 0;
    }

	public int getValor(){
		return valor;
	}

	public void setValor(int num){
		valor = num;
	}
    public void dibujar(Graphics g, Applet a){
    	g.setColor(Color.gray);
		g.fillRect(x, y, TAM, TAM);
		g.setColor(coloresFondo[obtenerIndice()]);
		g.fillRect(x+2, y+2, TAM-4, TAM-4);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(coloresLetra[obtenerIndice()]);
		g.drawString((valor==0)?"":"" + valor, x+8, y+15);
    }
    
    public int obtenerIndice(){
    	int cuanto = 0; 
    	int valorTemp = valor;
    	while(!((valorTemp == 0) || (valorTemp == 1))){
    		cuanto++;
    		valorTemp = valorTemp / 2;
    	}
    	return cuanto;
    }
    
}