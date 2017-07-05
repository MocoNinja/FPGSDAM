package EVALUACION3.claseHechos.ejercicio008;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SolitarioApp extends Applet
{
	public static final String[] palos = {"_of_spades", "_of_hearts", "_of_clubs", "_of_diamonds"};
	public static final String[] cartas = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	final String MULETILLA = "EVALUACION3/claseHechos/ejercicio008/sprites/";
	public static final Color[] colores = {Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.WHITE, Color.BLACK};
	private static final String MazoJuego = null;
	final String extension = ".png";
	Image[][] cartasSprites;
	MazoObjetivo[] mazoFinal = {null, null, null, null};
	MazoJuego[] mazoJuego = {null, null, null, null, null, null, null};
	Image reversoSprite;
	Baraja baraja;
	MazoSecundario mazo;
	Graphics aux;
	Image buffer;
	Rectangle reverso;
	Carta cartaSeleccionada;
	Carta cartaSacada;
	private int posXSaved, posYSaved;

	public void init()
	{
		setupSprites();
		baraja = new Baraja(this, cartasSprites, reversoSprite);
		for (int i = 0; i < 4; i++) mazoFinal[i] = new MazoObjetivo(i);
		for (int i = 0; i < 7; i++) mazoJuego[i] = new MazoJuego(i);
		this.resize(1200, 900);
		mazo = new MazoSecundario();
		mazo.meterCarta(baraja.sacarCarta());
		buffer = createImage(2000, 2000);
		aux = buffer.getGraphics();
	}
	
	public void paint(Graphics g)
	{
		Random rand = new Random();
		aux.setColor(colores[rand.nextInt(colores.length)]);
		aux.setColor(Color.BLACK);
		aux.fillRect(0, 0, getWidth(), getHeight());
		aux.drawImage(reversoSprite,0,0, 150, 217, this);
		pintaCartas(aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	private void pintaCartas(Graphics g)
	{
		for (MazoObjetivo mazos : mazoFinal) mazos.paint(g);
		for (MazoJuego mazos : mazoJuego) mazos.paint(g);
		mazo.pintarMazo(g);
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		reverso = new Rectangle(0, 0, 150, 217);
		
		if (reverso.contains(x, y))
		{
			if (baraja.getBaraja().size() == 0)
			{
				for (Carta carta : mazo.getCartas()) baraja.meterCarta(carta);
				mazo = new MazoSecundario();
			}
			cartaSacada = baraja.sacarCarta();
			mazo.meterCarta(cartaSacada);
			cartaSacada = null;
		}
		else if (mazo.sacarCarta().contains(x, y))
		{
			cartaSeleccionada = mazo.sacarCarta();
			posXSaved = cartaSeleccionada.x;
			posYSaved = cartaSeleccionada.y;
		}
		else return false;
		repaint();
		return true;
	}
	
	public boolean mouseDrag(Event ev, int x, int y)
	{
		if (cartaSeleccionada != null)
		{
			cartaSeleccionada.move(x - Carta.ANCHO / 2, y - Carta.ALTO / 2);
		}
		repaint();
		return true;
	}
	
	public boolean mouseUp(Event ev, int x, int y)
	{
		if (cartaSeleccionada != null)
		{
			for (MazoObjetivo mazos : mazoFinal)
			{
				if (mazos.intersects(cartaSeleccionada) && mazos.entraCarta(cartaSeleccionada))
				{
					mazo.eleminarCarta();
					cartaSeleccionada = null;
					repaint();
					return true;
				}
			
			}
			for (MazoJuego mazos : mazoJuego)
			{
				if (mazos.intersects(cartaSeleccionada) && mazos.entraCarta(cartaSeleccionada))
				{
					mazo.eleminarCarta();
					cartaSeleccionada = null;
					repaint();
					return true;
				}
			}
			mazo.recolocarCarta(cartaSeleccionada);
			cartaSeleccionada = null;
		}
		repaint();
		return true;
	}
	
	private void setupSprites()
	{
		cartasSprites = new Image[palos.length][cartas.length];
		
		for (int palo = 0; palo < palos.length; palo++)
		{
			for (int carta = 0; carta < cartas.length; carta++)
			{
				cartasSprites[palo][carta] = getImage(getDocumentBase(), MULETILLA + cartas[carta] + palos[palo] + extension);
			}
		}
		reversoSprite = getImage(getDocumentBase(), MULETILLA + "reverse" + extension);
	}
}
