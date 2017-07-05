import java.awt.*;
import java.applet.*;

public class Carta extends Rectangle{
	public static final int ANCHURA = 70;
	public static final int ALTURA = 120;
	public static final int ROJO = 1;
	public static final int NEGRO = 2;
	public static final int PICAS = 0;
	public static final int ROMBOS = 1;
	public static final int CORAZONES = 2;
	public static final int TREBOLES = 3;
	
	private Image imagen;
	private int valor;
	private int color;
	private int palo;

    public Carta(Image img, int v, int c, int p) {
    	super(-200, -200, ANCHURA, ALTURA);
    	imagen = img;
		valor = v;
		color = c;
		palo = p;
    }
    
    public Image getImagen(){
    	return imagen;
    }

    public int getValor(){
    	return valor;
    }
    
    public int getColor(){
    	return color;
    }
    
    public int getPalo(){
    	return palo;
    }
    
    public void dibujar(Graphics g, Applet a){
		g.drawImage(imagen, x, y, width, height, a);
    }
    
    public void setPosx(int px){
    	x = px;
    }
    
    public void setPosy(int py){
    	y = py;
    }
}