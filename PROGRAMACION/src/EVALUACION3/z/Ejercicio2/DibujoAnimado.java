import java.awt.*;
import java.applet.*;
public class DibujoAnimado extends Rectangle{
	public static final int GUERRILLERO = 0;
	public static final int HAMPON = 1;
	public static final int VAQUERO = 2;
	public static final int VELX = 10;
	Image imagenes[][];
	int imgActual = 0;
	private int vectActual = GUERRILLERO;
	int posicionInicial;
    public DibujoAnimado(Image imgs[][], int posIni) {
    	super(posIni, (int)(Math.random() * 400), 60, 80);
    	imagenes = imgs;
    	posicionInicial = posIni;
    }
    
    public int getVectActual(){
    	return vectActual;
    }
    
    public void setVectActual(int va){
    	vectActual = va;
    }
    
    public void dibujar(Graphics gg, Applet a){
    	gg.drawImage(imagenes[vectActual][imgActual], x, y, width, height, a);
    }
    
    public void actualizar(){
    	imgActual = (imgActual+1) % imagenes[vectActual].length;
    	x += VELX;
    	if(x > 500){
    		x = posicionInicial;
    		vectActual = GUERRILLERO;
    		
    	}
    }
}