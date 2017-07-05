import java.awt.*;
import java.applet.*;
import java.net.*;

public class Ruleta extends Applet{
	public static final int NUM_JUGADAS = 10;
	public static final int FILAS = 12;
	public static final int COLUMNAS = 3;
	Casilla casillas[][];
	Image imagen;
	Graphics noseve;
	public int rojos[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
	public int valores[] = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000};
	java.util.List<Integer> lRojos;
	java.util.List<Ficha> fichas[];
	Ficha activo;
	Image imgsFicha[];
	int fila = -1;
	int numeroSuerte;
	Button boton;
	int jugadas[];
	int acumulas = 0;
	int dinero = 1000000;
    public void init() {
    	Panel panel = new Panel();
    	boton = new Button("Jugar !");
    	panel.add(boton);
    	this.setLayout(new BorderLayout());
    	this.add("North", panel);
    	imagen = createImage(700, 800);
    	noseve = imagen.getGraphics();
		lRojos = new java.util.ArrayList<Integer>();
		for(int i=0; i<rojos.length; i++)
			lRojos.add(new Integer(rojos[i]));
			
		casillas = new Casilla[FILAS][COLUMNAS];
		for(int i=0; i<casillas.length; i++)
			for(int j=0; j<casillas[i].length; j++)
				if(lRojos.contains(new Integer((i*COLUMNAS)+j+1)))
					casillas[i][j] = new Casilla((j*Casilla.DIM)+ 30, (i*Casilla.DIM)+ 50, (i*COLUMNAS)+j+1, Color.red);
				else
					casillas[i][j] = new Casilla((j*Casilla.DIM)+ 30, (i*Casilla.DIM)+ 50, (i*COLUMNAS)+j+1, Color.black);
					
		imgsFicha = new Image[10];
    	for(int i=0; i<10; i++)
    		imgsFicha[i] = getImage(getCodeBase(), "Fichas/ficha" + (i+1) + ".png");
    	
    	fichas = new java.util.ArrayList[10];
    	for(int i=0; i<fichas.length; i++){
    		fichas[i] = new java.util.ArrayList<Ficha>();
    		fichas[i].add(new Ficha(500, 175 + ((Ficha.DIM + 10)*i), valores[i], imgsFicha[i]));
		}
		
		jugadas = new int[NUM_JUGADAS];
    }
    
    public void paint(Graphics g){
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, 700, 800);
		for(int i=0; i<casillas.length; i++)
			for(int j=0; j<casillas[i].length; j++)
				casillas[i][j].dibujar(noseve);
		for(int i=0; i<fichas.length; i++)
			for(int j=0; j<fichas[i].size(); j++)
				fichas[i].get(j).dibujar(noseve, this);
		String frase = "";
		if(numeroSuerte % 2 == 0)
			frase = "PAR";
		else 
			frase = "IMPAR";
		if(numeroSuerte <= 18)
			frase += " - FALTA";
		else
			frase += " - PASA";
		if(lRojos.contains(new Integer(numeroSuerte))){
			noseve.setColor(Color.red);
			frase += " - ROJO";
		}else{
			noseve.setColor(Color.black);
			frase += " - NEGRO";
		}
		
		noseve.drawString("" + numeroSuerte, 400, 100);
		noseve.setColor(Color.black);
		noseve.drawString(frase, 300, 150);
		
		for(int i=0; i<NUM_JUGADAS; i++){
			if (lRojos.contains(new Integer(jugadas[i])))	
				noseve.setColor(Color.red);
			else
				noseve.setColor(Color.black);
			noseve.drawString("" + jugadas[i], 600, 150+(i*30));
		}
		
		noseve.drawString("Resultado jugada = " + acumulas, 270, 730);
		noseve.drawString("Dinero = " + dinero, 270, 760);		
		g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g){
    	paint(g);
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
    	if(activo != null){
			activo.actualizar(x, y);
			repaint();
    	}
		return true;
	}
    
	public boolean mouseDown(Event ev, int x, int y){
		for(int i=0; i<fichas.length; i++)
			for(int j=0; j<fichas[i].size(); j++)
				if(fichas[i].get(j).contains(x, y)){
					activo = fichas[i].get(j);
					fila = i;
				}
		return true;
	}

	public boolean mouseUp(Event ev, int x, int y){
		activo.cargar_apostados(casillas);
		activo = null;
		if(fila != -1){
			fichas[fila].add(new Ficha(500, 175 + ((Ficha.DIM + 10)*fila), valores[fila], imgsFicha[fila]));
			fila = -1;
			repaint();
		}			
		return true;
	}
	
	public boolean action(Event ev, Object obj){
		if(ev.target instanceof Button){
			numeroSuerte = (int)(Math.random()*37);
			for(int i=NUM_JUGADAS-1; i>0; i--)
				jugadas[i] = jugadas[i-1];
			jugadas[0] = numeroSuerte;
			
			int apuestas = 0;
			int ganas = 0;
			for(int i=0; i<fichas.length; i++)
				for(int j=0; j<fichas[i].size(); j++){
					if(fichas[i].get(j).numeros_apostados.size()!=0)
						apuestas += fichas[i].get(j).precio;
					for(int k=0; k < fichas[i].get(j).numeros_apostados.size(); k++)
						if(fichas[i].get(j).numeros_apostados.get(k).intValue() == numeroSuerte)
							ganas += 36*(fichas[i].get(j).precio / fichas[i].get(j).numeros_apostados.size());
				}
			acumulas = ganas - apuestas;
			dinero += acumulas;
			repaint();
			return true;
		}
		return false;
	}
	
}