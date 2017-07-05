package EVALUACION3.rehechosCasa.Ruleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Ficha extends Rectangle
{
	Image imagen;
	private int valor;
	public static final int ANCHO = 35, ALTO = 35;
	public static final int VALORES_FICHAS[] = {1,2,5,10,50,100};
	List<Integer> numerosApostados;
	
	public Ficha(int x, int y, int valor)
	{
		super(x, y, ANCHO, ALTO);
		this.valor = valor;
	}
	
	public int getValor()
	{
		return this.valor;
	}
	
	public void pinta(Graphics g)
	{
		g.setFont(new Font("Times", Font.PLAIN, 10));
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		g.drawString(Integer.toString(valor), x + width / 2, y + height / 2);
	}

	public void getCasillasApostadas(List<Casilla> casillas)
	{
		numerosApostados = new ArrayList<Integer>();
		for (Casilla casilla : casillas)
			if (this.intersects(casilla))
			{
				List<Integer> casillasApostadas = casilla.getNumerosApostados();
				for (Integer numeroApostado : casillasApostadas)
				{
					if (numerosApostados.indexOf(numeroApostado) == -1) numerosApostados.add(numeroApostado);
				}
			}
	}
	
	public List<Integer> getNumerosApostados()
	{
		return numerosApostados;
	}
	
	public double dineroApostado()
	{
		double dineroApostado = (double) this.valor / numerosApostados.size();
		return dineroApostado;
	}
}
