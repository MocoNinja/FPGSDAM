package EVALUACION3.claseHechos.ejercicio006BIS;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Applet
{
	private static final int WIDTH = 1200, HEIGHT = 1000;
	private final int X_MARGIN = 150, Y_MARGIN = 100;
	private final int TIPOS_FICHA = 13;
	private final int X0_FICHA = 550;
	private Ficha fichaSeleccionada;
	private Random rand;
	private static int dinero;
	private int[] ultimasApuestas = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	int indiceApuesta = 0;
	final int[] negros = {2, 4, 6, 8, 10, 11, 13, 14, 15, 17, 20, 22, 23, 24, 26, 28, 29, 31, 33, 35};
	final int[] rojos = {1, 3, 5, 7, 9, 12, 16, 18, 19, 21, 25, 27, 30, 32, 34, 36};
	Integer sacado;
	Image buffer;
	Graphics aux;
	
	List<Apuesta> apuestas;
	List<Casilla> casillas;
	List<Ficha> fichas;
	Image[] sprites;
	double[] apuestasValor;
	List<Integer> numerosApostados;
	
	
	public void init()
	{
		dinero = 1000 + 8963; // por las fichas inciales
		buffer = createImage(WIDTH, HEIGHT);
		aux = buffer.getGraphics();
		casillas = new ArrayList<Casilla>();
		setupCasillas();
		sprites = new Image[13];
		for (int i = 0; i < 13; i++)
		{
			String ruta = "EVALUACION3/clase/ejercicio006rehecho/sprites/" + i + ".png";
			sprites[i] = getImage(getDocumentBase(), ruta);
		}
		fichas = new ArrayList<Ficha>();
		setupFichas();
		this.setLayout(new BorderLayout());
		this.add("South", new Button("Gira la ruleta!"));
		numerosApostados = new ArrayList<Integer>();
	}
	
	private void setupFichas()
	{
		for (int i = 0; i < TIPOS_FICHA; i++)
		{
			fichas.add(new Ficha(sprites, i, X0_FICHA, Y_MARGIN));
		}
	}
	
	private void setupCasillas()
	{
		// 3 filas y 12 columnas
		for (int casilla = 0; casilla < 36; casilla++)
		{
			casillas.add(new Casilla(X_MARGIN + (casilla % 3) * Casilla.WIDTH, Y_MARGIN + (casilla / 3) * Casilla.HEIGHT, casilla + 1));
		}
	}

	public int getDinero()
	{
	return this.dinero;
	}
	
	public static void addDinero(int cuanto)
	{
		dinero += cuanto;
	}
	
	public void jugar()
	{
		int ganancias = 0;
		if (numerosApostados.indexOf(sacado) != -1)
		{
			System.out.println("YOU WIN");
			
			int inicial;
			for (Apuesta apuesta : apuestas)
			{
				inicial= (int) apuesta.getValorApuesta();
				ganancias = inicial;
				ganancias -= apuesta.getFicha().getValor();
			}
		}
		else
		{
			System.out.println("YOU LOSE");
		}
		dinero += ganancias;
		fichas.clear();
		setupFichas();
		repaint();
	}
	public static void subDinero(int cuanto)
	{
		dinero -= cuanto;
	}
	public void paint(Graphics g)
	{
		super.paint(aux);
		aux.setColor(Color.GREEN);
		aux.fillRect(0, 0, WIDTH, HEIGHT); // buffer 
		for (Casilla casilla: casillas) casilla.paint(aux);
		for (Ficha ficha: fichas) ficha.paint(aux, this);
		if (sacado != null)
		{
			aux.setColor(Color.GREEN);
			aux.fillRect(0, 0, WIDTH, 50);
			for (int i = 0; i < negros.length; i++)
			{
				if (sacado == 0)
				{
					aux.setColor(Color.YELLOW);
					break;
				}
				if (sacado == negros[i])
				{
					aux.setColor(Color.BLACK);
					break;
				}
				else
					aux.setColor(Color.RED);
			}
			
			aux.setFont(new Font("Arial", Font.BOLD, 25));
			aux.drawString("Número sacado: ", 20, 20);
			aux.drawString(Integer.toString(sacado), 275, 20);
			aux.setColor(Color.decode("#ff03df"));
			aux.drawString("Ultimas jugadas", 375, 20);
			int posXDisplay = 0;
			for (Integer jugadas : ultimasApuestas)
			{
				for (int i = 0; i < negros.length; i++)
				{
					if (jugadas == 0)
					{
						aux.setColor(Color.YELLOW);
						break;
					}
					if (jugadas == negros[i])
					{
						aux.setColor(Color.BLACK);
						break;
					}
					else
						aux.setColor(Color.RED);
				}
				if (jugadas != -1) aux.drawString(Integer.toString(jugadas), 650 + 50 * posXDisplay++, 20);
			}
		}
		aux.setColor(Color.YELLOW);
		aux.drawString("Dinero actual: " + Integer.toString(dinero), 50, 70);
		paintApuestas(aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void paintVictoria(Graphics g)
	{
		g.setFont(new Font("Arial", Font.BOLD, 150));
		g.drawString("GANASTE", 0, 0);
	}
	public void paintApuestas(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(X0_FICHA + 150, Y_MARGIN, 350, HEIGHT);
		aux.setFont(new Font("Arial", Font.BOLD, 25));
		g.setColor(Color.BLACK);
		g.drawString("Apuestas: ", X0_FICHA + 150, Y_MARGIN + 55);
		aux.setFont(new Font("Arial", Font.BOLD, 12));
		if (apuestasValor != null)
		{
			for (int i = 0; i < apuestasValor.length; i++)
			{
				if (apuestasValor[i] != 0)
				{
					g.drawString(Integer.toString(i) + ": " + Double.toString(apuestasValor[i]), X0_FICHA + 150,  Y_MARGIN + 20 * (i + 1));
				}
			}
		}
	}
	
	public void checkApuestas()
	{
		apuestas = new ArrayList<Apuesta>();
		Apuesta apuestaActual;
		for (Ficha ficha : fichas)
		{
			apuestaActual = new Apuesta();
			for (Casilla casilla : casillas)
			{
				if (casilla.intersects(ficha))
				{
					apuestaActual.setCasillas(casilla);
					apuestaActual.setFicha(ficha);
					if (numerosApostados.indexOf(casilla.getNumero()) == -1) numerosApostados.add(casilla.getNumero());
				}
			}
			if (apuestaActual.getCasillasApostadas() != 0)
			{
				apuestas.add(apuestaActual);
			}
		}
	}
	
	public void readApuestas()
	{
		apuestasValor = new double[36];
		for (Apuesta apuesta : apuestas)
		{
			for (Casilla casilla : apuesta.getCasillas())
			{
				apuestasValor[casilla.getNumero()] += apuesta.getValorApuesta();
			}
		}
		for (int i = 0; i < apuestasValor.length; i++)
		{
			if (apuestasValor[i] != 0) System.out.println("Número " + (i) + "; Apuestas: " + apuestasValor[i]);
		}
	}
	public boolean handleEvent(Event ev)
	{
		switch (ev.id) 
		{
		case Event.MOUSE_DOWN:
			numerosApostados.clear();
			sacado = null;
			for (Ficha ficha : fichas)
			{
				if(ficha.contains(ev.x, ev.y))
				{
					fichaSeleccionada = ficha;
					if (fichaSeleccionada.x == X0_FICHA) dinero -= fichaSeleccionada.getValor();
					break;
				}
			}
		break;
		
		case Event.MOUSE_DRAG:
			if(fichaSeleccionada != null)
			{
				fichaSeleccionada.x = ev.x - Ficha.WIDTH / 2;
				fichaSeleccionada.y = ev.y - Ficha.HEIGHT / 2;
				repaint();
			}
		break;
		
		case Event.MOUSE_UP:
			int casillasSelecciondas = 0;
			if (fichaSeleccionada != null)
			{
				for (Casilla casilla : casillas)
				{
					if (casilla.intersects(fichaSeleccionada)) casillasSelecciondas++;
				}
				if (casillasSelecciondas == 0) fichas.remove(fichaSeleccionada);
				checkApuestas();
				readApuestas();
				fichas.add(new Ficha(sprites, fichaSeleccionada.getIndex(), X0_FICHA, Y_MARGIN))	;
				fichaSeleccionada = null;
			}
			repaint();
		break;
		
		case Event.ACTION_EVENT:
//			System.out.println("Click");

			rand = new Random();
			sacado = rand.nextInt(37);
			for (int i = ultimasApuestas.length - 1; i > 0; i--)
			{
				ultimasApuestas[i] = ultimasApuestas[i - 1];
			}
			ultimasApuestas[0] = sacado;
			repaint();
			jugar();
		break;
		}
	return true;
	}
}
