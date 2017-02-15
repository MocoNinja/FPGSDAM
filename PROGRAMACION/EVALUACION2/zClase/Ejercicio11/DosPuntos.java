package zClase.Ejercicio11;
import java.awt.*;
public class DosPuntos {
	public static final int LINEA = 0;
	public static final int OVALO = 1;
	public static final int RECTANGULO = 2;
	public int tipo, inicioX, inicioY, finX, finY;
    public DosPuntos(int tipoObjeto, int ix, int iy, int fx, int fy) {
    	tipo = tipoObjeto;
    	inicioX = ix;
    	inicioY = iy;
    	finX = fx;
    	finY = fy;
    }
    public DosPuntos(int tipoObjeto, int ix, int iy){
    	this(tipoObjeto, ix, iy, ix, iy);
    }
    public DosPuntos(){
    	this(LINEA, 0, 0, 0, 0);
    }
    public void dibujar(Graphics g){
    	if(tipo == LINEA)
    		g.drawLine(inicioX, inicioY, finX, finY);
    	else{
    		int ancho = Math.abs(finX - inicioX);
    		int alto = Math.abs(finY - inicioY);
    		if(tipo == OVALO)
    			g.drawOval(inicioX, inicioY, ancho, alto);
    		else
    			g.drawRect(inicioX, inicioY, ancho, alto);
    	}
    }
}