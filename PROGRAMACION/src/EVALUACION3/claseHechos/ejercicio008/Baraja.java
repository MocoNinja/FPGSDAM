package EVALUACION3.claseHechos.ejercicio008;

import java.applet.Applet;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baraja
{
	private final int VECES_BARAJAR = 10;
	Applet app;
	Image[][] sprites;
	Image reverso;
	List <Carta> baraja;
	
	public Baraja(Applet app, Image[][] sprites, Image reverso)
	{
		baraja = new ArrayList<Carta>();
		this.app = app;
		this.sprites = sprites;
		this.reverso = reverso;
		generarMazo(VECES_BARAJAR);
	}

	private void generarMazo(int vecesBarajadas)
	{
		int valor;
		int palo;
		for (int i = 0; i < SolitarioApp.palos.length; i++)
		{
			palo = i;
			for (int j = 0; j < SolitarioApp.cartas.length; j++)
			{
				valor = j + 1;
				baraja.add(new Carta(valor, app, sprites[i][j], reverso, palo));
			}
			mezclar(vecesBarajadas);
		}
	}

	private void mezclar (int veces)
	{
		while(veces-- >= 0)
		{
			Carta cartaGuardada;
			int indiceMezclar;
			Random rand = new Random();
			for (int i = 0; i < baraja.size(); i++)
			{
				indiceMezclar = rand.nextInt(baraja.size());
				cartaGuardada = baraja.get(indiceMezclar);
				baraja.set(indiceMezclar, baraja.get(i));
				baraja.set(i, cartaGuardada);
			}
		}
	}
	
	public List<Carta> getBaraja()
	{
		return this.baraja;
	}
	
	public Carta sacarCarta()
	{
		Carta cartaSacada = baraja.get(0);
		baraja.remove(0);
		return cartaSacada;
	}
	
	public void meterCarta(Carta carta)
	{
		baraja.add(carta);
	}
	
}
