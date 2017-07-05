package EVALUACION3.claseHechos.ejercicio009;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Applet implements Runnable
{
	List<Casilla> casillas;
	private final int IMAGENES = 9;
	private final int FILAS = 4, COLUMNAS = 4;
	Image buffer;
	Graphics aux;
	Image[] sprites;
	Casilla casillaGuardada;
	Thread thread;
	private int segundos = 0;
	
	@Override
	public void start() {
		thread = new Thread();
		thread.start();
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				System.out.println(segundos);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			segundos++;
			repaint();
		}
	}
	public void init()
	{
		buffer = createImage(2000, 2000);
		aux = buffer.getGraphics();
		setupSprites();
		setupCuadricula();
	}
	
	public void setupSprites()
	{
		sprites = new Image[9];
		for (int i = 1; i <= IMAGENES; i++)
		{
			sprites[i - 1] = getImage(getCodeBase(), "EVALUACION3/claseHechos/ejercicio009/sprites/" + i + ".png");
		}
	}
	
	public void setupCuadricula()
	{
		double indiceImagen = 0;
		casillas = new ArrayList<Casilla>();
		for (int fila = 0; fila < FILAS; fila ++)
		{
			for (int columna = 0; columna < COLUMNAS; columna++)
			{
				casillas.add(new Casilla(fila * Casilla.ALTO, columna * Casilla.ANCHO, sprites[(int) indiceImagen], sprites[8], this));
				indiceImagen += 0.5;
			}
		}
		mezclarCasillas();
	}
	
	public void paint(Graphics g)
	{
		
		pintarCasillas(aux);
		aux.drawString("Segundos transcurridos: " + segundos, 50, 50);
		g.drawImage(buffer, 0, 0, this);
	}
	// SOLO FUNCIONA SI LA IMAGEN HA SALIDO ANTES si cambio el orden del if dormir despues
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void pintarCasillas(Graphics g)
	{
		for (Casilla casilla : casillas) casilla.paint(g);
	}
	
	public void mezclarCasillas()
	{
		int veces = 100;
		int xSaved, ySaved;
		int xOld, yOld;
		int indiceCasillaAleatoria;
		Casilla casillaVieja, casillaNueva;
		Random rand = new Random();
		while(veces -- >= 0)
		{
			for (int i = 0; i < casillas.size(); i++)
			{
				casillaVieja = casillas.get(i);
				xOld = casillaVieja.x;
				yOld = casillaVieja.y;
				indiceCasillaAleatoria = rand.nextInt(casillas.size());
				casillaNueva = casillas.get(indiceCasillaAleatoria);
				xSaved = casillaNueva.x;
				ySaved = casillaNueva.y;
				casillaNueva.move(xOld, yOld);
				casillaVieja.move(xSaved, ySaved);
			}
		}
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		for (Casilla casilla : casillas)
		{
			if (casilla.contains(x, y) && !casilla.isEstatica())
			{
				casilla.girar();
				repaint();
				if (casillaGuardada == null)
				{
					casillaGuardada = casilla;
					break;
				}
				else
				{
					if (casilla.isVisible() && isPareja(casilla))
					{
						fijarCasillas(casilla);
					}
					else
					{
						revertirCasillas(casilla);
					}
					casillaGuardada = null;
					break;
				}
			}
		}
		repaint();
		return true;
	}

	private void revertirCasillas(Casilla casilla)
	{
		casilla.girar();
	}
	
	private void fijarCasillas(Casilla casilla)
	{
		casilla.setEstatica();
		casillaGuardada.setEstatica();
	}
	
	private boolean isPareja(Casilla casilla)
	{
		return (casilla.getImage() == casillaGuardada.getImage());
	}
	
}
