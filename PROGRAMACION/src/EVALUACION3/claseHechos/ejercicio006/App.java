package EVALUACION3.claseHechos.ejercicio006;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* Juego de la ruleta
* Hay 3 filas, de 12 n�meros cada 1
* En total 36 n�meros 
* M�s luego el 0
* Luego puedes elegir poner una ficha en 1 -> 4 n�meros; si ganas te dan 36 / n�mero de n�meros
* Otras opciones son par o impar/rojo o negro/ falta y pasa (1-18 19-36)
*/
public class App extends Applet implements Runnable
{
//	private final int NUM_FICHAS = 5;
	// Hacerlo con fichas infinitas
	List<Numero> numeros;
	List<Ficha> fichas;
	Ficha fichaSeleccionada;
	Graphics buffer;
	Image aux;
	Thread thread;
	Random rand;
	List<Integer> currentApuesta;
	
	private final Color[] colores = {Color.RED, Color.BLACK, Color.WHITE, Color.CYAN, Color.MAGENTA, Color.PINK, Color.BLUE};
	
	public void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	public void run()
	{
		try
		{
			Thread.sleep(65);
			repaint();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public void init()
	{
		numeros = new ArrayList<Numero>();
		setupNumbers();
		fichas = new ArrayList<Ficha>();
		setupFichas();
		aux = createImage(2000, 2000);
		buffer = aux.getGraphics();
		rand = new Random();
		currentApuesta = new ArrayList<Integer>();
	}
	
	public void setupNumbers()
	{
		for (int fila = 0; fila < 12; fila++)
		{
			for (int columna = 1; columna <= 3; columna++)
			{
				numeros.add(new Numero(columna * Numero.ANCHO, fila * Numero.ALTO, fila * 3 + columna));
			}
		}
	}
	
	public void setupFichas()
	{
		for (int i = 0; i < 20; i++)
		{
			fichas.add(new Ficha(numeros, i + 1));
		}
	}
	public void paint(Graphics g)
	{
		buffer.setColor(Color.GREEN);
//		buffer.setColor(colores[rand.nextInt(colores.length)]); // FUN MODE
		buffer.fillRect(0, 0, 1000, 1000);
		for (Numero numero : numeros)
			numero.pinta(buffer);
		for (Ficha ficha : fichas)
			ficha.paint(buffer);
		apuestaDraw(buffer);
		g.drawImage(aux, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void apuestaDraw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(550, 0, 200, 1000);
		g.setColor(Color.RED);
		g.drawString("Numeros apostados", 575, 50);
		int columna = 0;
		for (Integer numero : currentApuesta)
		{
			g.drawString(Integer.toString(numero), 560, 70 + (20*columna++));
		}
	}
	public boolean mouseDown(Event ev, int x, int y)
	{
		for (Ficha ficha : fichas)
			if (ficha.contains(x, y))
			{
//				System.out.println("Ficha pulsada");
				fichaSeleccionada = ficha;
				break;
			}
//		for (Numero numero : numeros)
//			if (numero.contains(x, y)) System.out.println("Pulsado el numero " + numero.getNumero() + " y de color" + numero.getColor());
	return true;
	}
	
	public boolean mouseDrag(Event ev, int x, int y)
	{
		if (fichaSeleccionada != null)
		{
			fichaSeleccionada.mueve(x - 10, y - 10);
			repaint();
		}
		return true;
	}
	public boolean mouseUp(Event ev, int x, int y)
	{
		if (fichaSeleccionada != null)
		{
			currentApuesta = new ArrayList<Integer>();
			fichas.add(new Ficha(numeros, fichaSeleccionada.getPrecio()));
			setApuesta();
			fichaSeleccionada = null;
		}
		repaint();
	return true;
	}
	
	public void setApuesta()
	{
		for (Ficha ficha : fichas)
		{
			ficha.comprobar();
			for (Integer numero : ficha.getApuesta())
			{
				if (!(currentApuesta.contains(numero))) currentApuesta.add(numero);
			}
		}
	}
	
	public void leerApuestas()
	{
		System.out.printf("Numeros apostados");
		for (Integer numero : currentApuesta)
		{
			System.out.printf(" %2d ", numero);
		}
		System.out.println();
	}
}
