package EVALUACION3.claseHechos.ejercicio007;

import java.applet.Applet;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baraja
{
	final String[] palos = {"_of_spades", "_of_hearts", "_of_clubs", "_of_diamonds"};
	final String[] cartas = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
	Applet app;
	Image[][] sprites;
	List <Carta> mazo;
	
	public Baraja(Applet app, Image[][] sprites)
	{
		mazo = new ArrayList<Carta>();
		this.app = app;
		this.sprites = sprites;
		generarMazo(10);
	}

	private void generarMazo(int vecesBarajadas)
	{
		boolean generarAs;
		for (int i = 0; i < palos.length; i++)
		{
			for (int j = 0; j < cartas.length; j++)
			{
				generarAs = false;
				int valor;
				switch (cartas[j])
				{
					case "jack":
						valor = 10;
						break;
					case "queen":
						valor = 10;
						break;
					case "king":
						valor = 10;
						break;
					case "ace":
						valor = 11;
						generarAs = true;
						break;
					default:
						valor = Integer.parseInt(cartas[j]);
						break;
				}
				mazo.add(new Carta(valor, app, sprites[i][j], generarAs));
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
			for (Carta carta : mazo)
			{
				indiceMezclar = rand.nextInt(mazo.size());
				cartaGuardada = mazo.get(indiceMezclar);
				mazo.set(indiceMezclar, carta);
				mazo.set(mazo.indexOf(carta), cartaGuardada);
			}
		}
	}
	
	public List<Carta> getBaraja()
	{
	return this.mazo;
	}
}
