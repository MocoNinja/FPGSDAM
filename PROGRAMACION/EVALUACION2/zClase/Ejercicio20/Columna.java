package zClase.Ejercicio20;
import java.awt.*;
public class Columna {
	public static final int HUECO = 50;
	public static final int ANCHURA = 30;
	Rectangle r1;
	Rectangle r2;
	public static final int VELX = -1;
    public Columna(int posx) {
    	int altura = (int)((Math.random() * 150) + HUECO);
    	r1 = new Rectangle(posx, 0, ANCHURA, altura);
    	r2 = new Rectangle(posx, (altura  + HUECO), ANCHURA, 300-(altura+HUECO));
    }
    
    public void dibujar(Graphics g){
    	g.setColor(Color.yellow);
    	g.fillRect(r1.x, r1.y, r1.width, r1.height);
    	g.fillRect(r2.x, r2.y, r2.width, r2.height);
    }
    
    public void actualizar(){
    	r1.x += VELX;
    	r2.x += VELX;
    	if(r1.x <= -30){
    		r1.x += (Jugando.DISTANCIA + ANCHURA) * 3;
    		r2.x += (Jugando.DISTANCIA + ANCHURA) * 3;
    		int altura = (int)((Math.random() * 150) + HUECO);
    		r1.height = altura;
    		r2.y = altura  + HUECO;
    		r2.height = 300-(altura+HUECO);
    		Jugando.contador++;
    	}

    }
    
}