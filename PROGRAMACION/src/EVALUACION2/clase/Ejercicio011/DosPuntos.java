package EVALUACION2.clase.Ejercicio011;

import java.awt.*;
import java.util.*;

public class DosPuntos{
    public int x0, xf, y0, yf;
    public int figura;
    // Constantes públicas y ESTATICAS: pueden usarse por todo
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;

    public DosPuntos(int tipo, int x1, int y1, int x2, int y2){
        x0 = x1;
        xf = x2;
        y0 = y1;
        yf = y2;
        figura = tipo;
    }

    public DosPuntos(int tipo, int x1, int y1){
        this(tipo, x1, y1, x1, y1);
    }

    public DosPuntos(){
        this(LINEA, 0, 0, 0, 0);
    }
    // No es estático -> no se puede acceder a través del nombre de la clase, sino de un objeto.
    public void dibujar(Graphics g){
        switch (figura) {
            case LINEA:
                g.drawLine(x0, y0, xf, yf);
                break;
            case OVALO:
                g.drawOval(x0, y0, Math.abs(xf - x0), Math.abs(yf - y0));
                break;
            case RECTANGULO:
                g.drawRect(x0, y0, Math.abs(xf - x0), Math.abs(yf - y0));
                break;
            default:
                System.out.println("Oopsie");
                break;
        }
    }
}