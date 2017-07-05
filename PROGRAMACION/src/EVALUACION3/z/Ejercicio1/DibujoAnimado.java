import java.awt.*;
import java.applet.*;
public class DibujoAnimado extends Rectangle{
	Image imagenes[];
	int imgActual = 0;
    public DibujoAnimado(Image imgs[]) {
    	super((int)(Math.random() * 400), (int)(Math.random() * 400), 60, 80);
    	imagenes = imgs;
    }
    
    public void dibujar(Graphics gg, Applet a){
    	gg.drawImage(imagenes[imgActual], x, y, width, height, a);
    }
    
    public void actualizar(){
    	imgActual = (imgActual+1) % imagenes.length;
    }
    
    public void setImagenes(Image imgs[]){
    	imagenes = imgs;
    }
}