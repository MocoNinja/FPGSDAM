package EVALUACION3.rehechosCasa.Ruleta;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego extends Applet implements Runnable
{
	Thread thread;
	List<Ficha> fichas;
	List<Ficha> fichasDisponibles;
	List<Casilla> casillas;
	Image buffer;
	Graphics aux;
	Ficha fichaSeleccionada = null;
	Apuesta apuesta;
	int[] numerosUltimos;
	Integer numeroActual;
	boolean errorJugarSinApostar = false;
	boolean displayVictory = false;
	boolean displayLost = false;
	boolean displayDeath = false;
	double dineroReal = 1000.00;
	double dineroTurno = dineroReal;
	public void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				repaint();
				if (displayLost || displayVictory)
				{
					thread.sleep(1000);
					reiniciarJuego();
				}
				else Thread.sleep(35);
			}
			catch (Exception e){}
		}
	}

	public void init()
	{
		this.resize(1330, 900);
		fichas = new ArrayList<Ficha>();
		casillas = new ArrayList<Casilla>();
		numerosUltimos = new int[15];
		for (int i = 0; i < numerosUltimos.length; i++) numerosUltimos[i] = -1;
		setupFichas();
		setupCasillas();
		this.setLayout(new BorderLayout());
		this.add("South", new Button("Gira la ruleta!"));
		buffer = createImage(2000, 2000);
		aux = buffer.getGraphics();
	}
	
	public void reiniciarJuego()
	{
		fichas = new ArrayList<Ficha>();
		apuesta = null;
		errorJugarSinApostar = false;
		displayVictory = false;
		displayLost = false;
		displayDeath = false;
	}
	
	private void generarNumero()
	{
		if (apuesta == null)
		{
			errorJugarSinApostar = true;
		}
		else
		{
			errorJugarSinApostar = false;
			Random rand = new Random();
			numeroActual= rand.nextInt(37);
			meterNumeroAlHistorial(numeroActual);
		}
	}
	
	private void meterNumeroAlHistorial(int numero)
	{
		for (int i = numerosUltimos.length - 1; i > 0; i--)
		{
			numerosUltimos[i] = numerosUltimos[i - 1];
		}
		numerosUltimos[0] = numero;
	}
	
	private void ajustarDinero()
	{
		dineroTurno = dineroReal - apuesta.getDineroApostado();
		repaint();
	}
	
	private Color setColor(int valor)
	{
		if (valor == 0) return Color.YELLOW;
		for (Integer numero : Casilla.rojos)
			if (valor == numero) return Color.RED;
		return Color.BLACK;
	}
	
	public void setupCasillas()
	{
		for (int i = 0; i < 36; i++)
		{
			casillas.add(new Casilla(Casilla.ALTO + (i / 3)*Casilla.ANCHO, (i % 3)*Casilla.ALTO, i + 1));
		}
		casillas.add(new Casilla(0, 0, 0, Casilla.ALTO, Casilla.ALTO * 3));
		for (int i = 0; i < Casilla.CASILLAS_ESPECIALES.length; i++)
		{
			casillas.add(new Casilla(i * Casilla.ANCHO, Casilla.ALTO * 3, Casilla.CASILLAS_ESPECIALES[i]));
		}
	}
	
	public void setupFichas()
	{
		fichasDisponibles = new ArrayList<Ficha>();
		for (int i = 0; i < Ficha.VALORES_FICHAS.length; i++)
		{
			fichasDisponibles.add(new Ficha(30 + (i * (Ficha.ANCHO + 10)), 250, Ficha.VALORES_FICHAS[i]));
		}
	}
	
	public void paint(Graphics g)
	{
		aux.setColor(Color.GREEN);
		aux.fillRect(0, 0, getWidth(), getHeight());
		pintarCasillas(aux);
		pintarFichas(aux);
		pintarMensajes(aux);
		pintarUltimosNumeros(aux);
		pintarErrores(aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	private void pintarErrores(Graphics g)
	{
		int mensajesMostrados = 0;
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		if (errorJugarSinApostar)
		{
			g.drawString("NO PUEDES JUGAR SIN HABER APOSTADO", 250, 650 * (1 + mensajesMostrados++));
		}
		else if (displayVictory)
		{
			g.drawString("Ganaste esta ronda!", getWidth() / 2, 650 * (1 + mensajesMostrados++));
		}
		else if (displayLost)
		{
			g.drawString("Perdiste esta ronda!", getWidth() / 2, 650 * (1 + mensajesMostrados++));
			repaint();
		}
		else if (displayDeath)
		{
			g.drawString("Te quedaste sin dinero!", getWidth() / 2, 650 * (1 + mensajesMostrados++));
			thread.stop();
		}
		else 
		{
			g.drawString("", 20, 120);
		}
	}

	private void ganarDinero()
	{
		dineroTurno += apuesta.getGananciaApuesta();
		dineroReal = dineroTurno;
		displayVictory = true;
	}
	
	private void perderDinero()
	{
		dineroReal = dineroTurno;
		if (dineroReal <= 0) displayDeath = true;
		else displayLost = true;
	}
	
	private void pintarUltimosNumeros(Graphics g)
	{
		// Empezar a pintar en 600
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times", Font.BOLD, 14));
		g.drawString("Últimas jugadas", 0, 700);
		g.drawString("Número sacado: ", 0, 900);
		for (int i = 0; i < numerosUltimos.length; i++)
		{
			if (numerosUltimos[i] != -1)
			{
				g.setColor(setColor(numerosUltimos[i]));
				g.drawString(Integer.toString(numerosUltimos[i]), 150 + i * 45, 700);
			}
		}
		if (numeroActual != null)
		{
			g.setColor(setColor(numeroActual));
			g.drawString(Integer.toString(numeroActual), 150, 900);
		}
	}

	private void pintarMensajes(Graphics g)
	{
		if (apuesta != null) apuesta.paint(g);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Times", Font.BOLD, 26));
		String dinero = String.format("%1$,.2f", dineroTurno);
		g.drawString("Fondos: " + dinero, this.getWidth() - 350, 250);
	}

	private void pintarFichas(Graphics g) 
	{
		for (Ficha ficha : fichasDisponibles) ficha.pinta(g);
		for (Ficha ficha : fichas) ficha.pinta(g);
	}

	private void pintarCasillas(Graphics g)
	{
		for (Casilla casilla : casillas) casilla.pinta(g);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}

	public boolean handleEvent(Event ev)
	{
		switch (ev.id) 
		{
		case Event.MOUSE_DOWN:
			
			for (Ficha ficha : fichasDisponibles)
			{
				if (ficha.contains(ev.x, ev.y))
				{
					fichaSeleccionada = new Ficha(ev.x, ev.y, ficha.getValor());
					fichas.add(fichaSeleccionada);
				}
			}
			for (Ficha ficha : fichas)
			{
				if (ficha.contains(ev.x, ev.y))
				{
					fichaSeleccionada = ficha;
					break;
				}
			}
			break;
			
		case Event.MOUSE_DRAG:
			
			if (fichaSeleccionada != null) fichaSeleccionada.move(ev.x - fichaSeleccionada.width / 2, ev.y - fichaSeleccionada.height / 2);
			break;
			
		case Event.MOUSE_UP:
			
			if (fichaSeleccionada != null)
			{
				fichaSeleccionada.getCasillasApostadas(casillas);
				if (fichaSeleccionada.getNumerosApostados().size() == 0) fichas.remove(fichaSeleccionada);
				fichaSeleccionada = null;
			}
			apuesta = new Apuesta();
			apuesta.leerDatos(fichas);
//			apuesta.leerApuestas();
			ajustarDinero();
			break;
			
		case Event.ACTION_EVENT:
			generarNumero();
			if (apuesta != null && apuesta.premio(numeroActual)) ganarDinero();
			else perderDinero();
			break;
		}
		return true;
	}
}