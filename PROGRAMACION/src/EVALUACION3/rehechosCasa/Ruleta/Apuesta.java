package EVALUACION3.rehechosCasa.Ruleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Apuesta
{
	List<List<Double>> apuestas;
	private double dineroTotal = 0;
	private int fichasApostadas = 0;
	private double valorGanancia = 0;
	
	public Apuesta()
	{
		apuestas = new ArrayList<List<Double>>();
		apuestas.add(new ArrayList<Double>()); // N�meros apostados
		apuestas.add(new ArrayList<Double>()); // Dinero apostado a ese n�mero
	}
	
	private void meterApuesta(int numeroApostado, double dineroApostado)
	{

		if (apuestas.get(0).indexOf((double) numeroApostado) == -1) // NO est� apostado -> meter ambos valores en sus repectivas listas
		{
			apuestas.get(0).add((double) numeroApostado);
			apuestas.get(1).add(dineroApostado);
		}
		else // Ese n�mero ya est� apostado, as� que s�lo hay que incrementar el valor de la apuesta
		{
			int indiceApuesta = apuestas.get(0).indexOf((double) numeroApostado);
			double apuesta = apuestas.get(1).get(indiceApuesta);
			apuesta += dineroApostado;
			apuestas.get(1).set(indiceApuesta, apuesta);
		}
	}
	
	public void leerDatos(List<Ficha> fichas)
	{
		fichasApostadas = fichas.size();
		for (Ficha ficha : fichas)
		{
			for (Integer numero : ficha.getNumerosApostados())
			{
				meterApuesta(numero, ficha.dineroApostado());
			}
		}
	}

	public void leerApuestas()
	{
		for (int i = 0; i < apuestas.get(0).size(); i++)
		{
			System.out.printf("Número apostado: %3.0f | Cantidad apostada: %10.2f.\n", apuestas.get(0).get(i), apuestas.get(1).get(i));
		}
	}

	private void calcularParne()
	{
		dineroTotal = 0;
		for (Double apuesta : apuestas.get(1))
			dineroTotal += apuesta;
		valorGanancia = dineroTotal * 36 / fichasApostadas;
	}
	public double getDineroApostado()
	{
		calcularParne();
		return dineroTotal;
	}
	
	public double getGananciaApuesta()
	{
		return valorGanancia;
	}
	
	private Color setColor(int valor)
	{
		if (valor == 0) return Color.YELLOW;
		for (Integer numero : Casilla.rojos)
			if (valor == numero) return Color.RED;
		return Color.BLACK;
	}
	
	public void paint(Graphics g)
	{
		// Empezar a pintar mensajes para y = 400
		// Mirar para adaptar a pantallas m�s peque�as!
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 325, 1800, 185);
		g.setColor(Color.BLACK);
		g.drawString("N�meros apostados", 0, 375);
		g.drawString("Valor apuesta", 0, 475);
		for (int i = 0; i < apuestas.get(0).size(); i++)
		{
			g.setColor(setColor(apuestas.get(0).get(i).intValue()));
			String casilla = String.format("%1$,.0f", apuestas.get(0).get(i));
			String apuesta = String.format("%1$,.2f", apuestas.get(1).get(i));
			g.drawString(casilla, 200 + 85 * (i % 18), 350 + 50 * (i / 18));
			g.drawString(apuesta, 200 + 85 * (i % 18), 450 + 50 * (i / 18));

		}
		calcularParne();
		if (!Double.isNaN(valorGanancia))
		{
			g.setColor(Color.YELLOW);
			String apuesta = String.format("%1$,.2f", valorGanancia);
			g.drawString("Puedes ganar " + apuesta + " €!", 25, 600);
		}
		else
		{
			g.drawString("", 25, 600);
		}
	}
	
	public boolean premio(int numeroSacado)
	{
		if (apuestas.get(0).indexOf((double) numeroSacado) == -1) return false;
		return true;
	}
}
