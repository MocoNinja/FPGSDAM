package EVALUACION2.claseZ.Ejercicio18;
import java.awt.*;

public class Raqueta extends Block{
	public static final int VELX = 5;
    public Raqueta() {
		super(120, 270, 60, 10, Color.white);
    }
    public void actualizar(int direccion){
    	if(direccion == Jugando.DERECHA)
    		x += VELX;
    	else
    		x -= VELX;

    	if(x<=0) x=0;
    	if(x>=240) x=240;
    }

}