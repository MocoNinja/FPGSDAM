package EVALUACION3.claseHechos.ejercicio007;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

/*
* Player Vs Banca
* Figuras 10; As 1 u 11 (de forma dinamica); Resto, su valor
* A ti te reparten dos cartas visibles, a la banca una visible y una volteada
* Tu vas pidiendo cartas hasta plantarte o pasarte.
* EL valor del as está dado por script
* La banca saca cartas hasta que tiene un minimo de 17, que se planta automatico 
*/

public class BlackJackApp extends Applet
{

	final String[] palos = {"_of_spades", "_of_hearts", "_of_clubs", "_of_diamonds"};
	final String[] cartas = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
	final String MULETILLA = "EVALUACION3/clase/ejercicio007/sprites/";
	final String extension = ".png";
	
	Image[][] cartasSprites;
	Image[] reverso;
	Graphics aux;
	Image buffer;
	List<Carta> mazo;
	List<Carta> cartasBanca;
	List<Carta> cartasJugador;
	int cartasRestantes;
	int posXCartaJugador = 750, posXCartaBanca = 50;
	private boolean errorApuesta = false;
	private boolean derrotaJugador = false, derrotaBanca = false;
	private boolean blackjackJugador = false, blackjackBanca = false;
	private boolean empate = false;
	private boolean ganaBanca = false, ganaJugador = false;
	private boolean endgame = false;
	private int apuesta = 0;
	private int fondos = 5000;
	TextField texto;
	
	public void init()
	{
		setupApplet();
		setupSprites();
		getMazo();
		cartasBanca = new ArrayList<Carta>();
		cartasJugador= new ArrayList<Carta>();
		iniciarPartida();
	}
	
	public void setupApplet()
	{
		texto = new TextField("", 25);
		this.resize(1200, 700);
		buffer = createImage(2000, 2000);
		aux = buffer.getGraphics();
		this.add("South", new Button("Hit me"));
		this.add("South", new Button("Me planto"));
		this.add(new Label("Apuestas: "));
		this.add("North", texto);
	}
	
	public void paint(Graphics g)
	{
		aux.setColor(Color.GREEN);
		aux.fillRect(0, 0, getWidth(), getHeight());
		pintaCartas(aux);
		mensajes(aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public void pintaCartas(Graphics g)
	{
		for (Carta carta : cartasBanca) carta.paint(g);
		for (Carta carta : cartasJugador) carta.paint(g);
	}
	
	public void mensajes(Graphics g)
	{
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.setColor(Color.BLACK);
		g.drawString("Cartas restantes en mazo: " + cartasRestantes, 25, 75);
		if (derrotaBanca) g.drawString("La banca se ha pasado! Está en: " + getValor(cartasBanca), 25, 105);
		else if (blackjackBanca) g.drawString("La banca tiene BlackJack!", 25, 105);
		else g.drawString("La banca está en: " + getValor(cartasBanca), 25, 105);
		g.setColor(Color.RED);
		g.drawString("Fondos: " + fondos, 850, 185);
		g.setColor(Color.BLACK);
		if (derrotaJugador) g.drawString("El jugador se ha pasado! Está en: " + getValor(cartasJugador), 25, 135);
		else if (blackjackJugador) g.drawString("El jugador tiene BlackJack!", 25, 135);
		else g.drawString("El jugador está en: " + getValor(cartasJugador), 25, 135);
		g.setColor(Color.RED);
		if (errorApuesta) g.drawString("Debes apostar antes de hacer una jugada!", 350, 160);
		else g.drawString(" ", 75, 160);
		g.setColor(Color.BLACK);
		g.drawString("Apuesta actual: " + apuesta, 25, 160);
		if (endgame)
		{
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial", Font.BOLD, 58));
			if (ganaBanca) g.drawString("Gana la banca", 550, 105);
			else if (ganaJugador) g.drawString("Gana el jugador", 550, 105);
			else if (empate) g.drawString("Hay empate", 550, 105);
			this.destroy();
			this.start();
		}
	}
		
		public int getValor(List<Carta> manoJugador)
	{
		int valorManoMax = 0, numeroAses = 0;
		
		for (Carta carta : manoJugador)
		{
			valorManoMax += carta.getValor();
			if (carta.esAce) numeroAses++;
		}
		
		int valorManoMin = valorManoMax - 9 * numeroAses;
		int retorno;
		if (valorManoMax <= 21) retorno = valorManoMax;
		else retorno = valorManoMin;
	return retorno;
	}

	public void gestionarFondos()
	{
		if (ganaJugador) fondos += apuesta;
		else if (ganaBanca) fondos -= apuesta;
	repaint();
	}

	public void sacarCartaJugador()
	{
		Carta cartaSacada = mazo.get(0);
		mazo.remove(0);
		cartasRestantes --;
		cartaSacada.mueve(posXCartaJugador += 50, 200);
		cartasJugador.add(cartaSacada);
	}
	
	public void sacarCartaBanca()
	{
		Carta cartaSacada = mazo.get(0);
		mazo.remove(0);
		cartasRestantes --;
		cartaSacada.mueve (posXCartaBanca += 50, 200);
		cartasBanca.add(cartaSacada);
	}
	
	public void juego()
	{
		int puntuacionJugador = getValor(cartasJugador);
		int puntuacionBanca = getValor(cartasBanca);
		
		if (puntuacionBanca == 21) blackjackBanca = true;
		else if (puntuacionBanca > 21) derrotaBanca = true;
		
		if (puntuacionJugador == 21) blackjackJugador = true;
		else if (puntuacionJugador > 21) derrotaJugador = true;
	}
	
	public void checkFinalScore()
	{
		int puntuacionJugador = getValor(cartasJugador);
		int puntuacionBanca = getValor(cartasBanca);
		
		if (derrotaBanca && !derrotaJugador) ganaJugador = true;
		else if(derrotaJugador && ! derrotaBanca) ganaBanca = true;
		else if (puntuacionBanca == puntuacionJugador) empate = true;
		else if(puntuacionBanca > puntuacionJugador) ganaBanca = true;
		else ganaJugador = true;
		endgame = true;
	}
	
	public void iniciarPartida()
	{
		sacarCartaBanca();
		sacarCartaJugador();
		sacarCartaJugador();
	}
	
	public void setupSprites()
	{
		cartasSprites = new Image[4][13];
		
		for (int palo = 0; palo < palos.length; palo++)
		{
			for (int carta = 0; carta < cartas.length; carta++)
			{
				cartasSprites[palo][carta] = getImage(getDocumentBase(), MULETILLA + cartas[carta] + palos[palo] + extension);
			}
		}
	}

	public void getMazo()
	{
		Baraja baraja = new Baraja(this, cartasSprites);
		this.mazo = baraja.getBaraja();
		cartasRestantes = mazo.size();
	}
	
	public boolean action (Event e, Object o)
	{
		if (e.target instanceof Button)
		{
			if (e.arg.equals("Me planto"))
			{
				errorApuesta = false;
				if (apuesta == 0)
				{
					errorApuesta = true;
					repaint();
					return false;
				}
				if (!derrotaJugador) while(!endgame && cartasRestantes > 0 && getValor(cartasBanca) < 17) sacarCartaBanca();
				juego();
				checkFinalScore();
				gestionarFondos();
				repaint();
			}
				
			else 
			{
				errorApuesta = false;
				if (apuesta == 0)
				{
					errorApuesta = true;
					repaint();
					return false;
				}
				if (!endgame && cartasRestantes > 0 && !derrotaJugador && !blackjackJugador) sacarCartaJugador();
				juego();
				repaint();
			}
		}
		else if (e.target instanceof TextField)
		{
			setApuesta(texto.getText());
			repaint();
		}
	return true;
	}
	
	public int getApuesta(String valor)
	{
		int apuesta = 0;
		try
		{
			apuesta = Integer.parseInt(valor);
			if (apuesta > fondos) return 0;
			else
			{
				texto.setEditable(false);
			return apuesta;
			}
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	public void setApuesta(String valor)
	{
		apuesta = getApuesta(valor);
	}
}
