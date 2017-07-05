package EVALUACION3.claseHechos.ejercicio002;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App extends Applet
{
	private final int WIDTH = 1000, HEIGHT = 300;
	private final String path = "EVALUACION3/clase/ejercicio003/directorioImagenes/";
	private Image fondo;
	private final int MAX_PIEZAS = 25;
	List<Pieza> piezas;
	List<Hueco> huecos;
	Image[] imagenes;
	int aciertos;
	Random rand;
	Pieza piezaSeleccionada;
	Hueco huecoSeleccionado;
	int posXOldPieza, posYOldPieza;
	Image aux;
	Graphics ninja;
	
	public void init()
	{
		rand = new Random();
		aciertos = 0;
		fondo = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio003/directorioImagenes/mapamundi3.png");
		imagenes = new Image[MAX_PIEZAS];
		piezas = new ArrayList<Pieza>();
		huecos = new ArrayList<Hueco>();
		int fila = 0, columna = 0;
		
		for (int i = 1; i <= MAX_PIEZAS; i++)
		{
			 imagenes[i - 1] = getImage(getDocumentBase(), path + i + ".png");
			 piezas.add(new Pieza((WIDTH / 2) + rand.nextInt(WIDTH / 2) - Pieza.ANCHO, (HEIGHT / 2) + rand.nextInt(HEIGHT / 2) - Pieza.ALTO, imagenes[i - 1]));
			 huecos.add(new Hueco(columna * Hueco.ALTO, fila * Hueco.ANCHO, imagenes[i - 1]));
			 columna++;
			 if (i % 5 == 0)
			 {
				 fila++;
				 columna = 0;
			 }		
		}
		aux = createImage(WIDTH, HEIGHT);
		}
	
	public void paint(Graphics g)
	{
		ninja = aux.getGraphics();
		if (aciertos == MAX_PIEZAS) fondo = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio003/directorioImagenes/mapamundi.png");
		ninja.drawImage(fondo, 0, 0, this);
//		ninja.fillRect(0, 0, 300, 300);
		ninja.fillRect(300, 0, WIDTH - 300, HEIGHT);
		for (Hueco hueco : huecos)
		{
			if (aciertos != MAX_PIEZAS) hueco.dibuja(ninja, this);
			else
			{
				ninja.setColor(Color.MAGENTA);
				ninja.setFont(new Font("Comic Sans MS",Font.PLAIN, 55));
				ninja.drawString("Eres un fakin champion", 350, HEIGHT / 2);
			}
			piezas.get(huecos.indexOf(hueco)).dibuja(ninja, this);
		}
		g.drawImage(aux, 0, 0, this);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	
	public boolean keyDown(Event ev, int tecla)
	{
		System.out.println("Tecla pulsada: " + tecla);
		if (tecla == 32) // Espacio
//		if (tecla == rand.nextInt(100))
		{
			for (Hueco hueco : huecos)
			{
				hueco.dibujable();
				piezas.get(huecos.indexOf(hueco)).kill();
			}
			aciertos = MAX_PIEZAS;
			fondo = getImage(getDocumentBase(), "EVALUACION3/clase/ejercicio003/directorioImagenes/mapamundi.png");
			repaint();
		}
	return true;
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{
		for (Pieza pieza : piezas)
		{
			if (pieza.contains(x, y))
			{
				piezaSeleccionada = pieza;
				posXOldPieza = x;
				posYOldPieza = y;
			}
		}
	return true;
	}

	public boolean mouseDrag(Event ev, int x, int y)
	{
		if (piezaSeleccionada != null)
		{
			piezaSeleccionada.mueve(x - Pieza.ANCHO / 2, y - Pieza.ALTO / 2);
		}
		repaint();
	return true;
	}

	public boolean mouseUp(Event ev, int x, int y)
	{
		for (Hueco hueco : huecos) 
		{
			if (hueco.contains(x, y))
			{
			huecoSeleccionado = hueco;
			break;
			}
		
		}
		System.out.println("Hueco: " + huecos.indexOf(huecoSeleccionado) + "; pieza: " + piezas.indexOf(piezaSeleccionada));
		if(piezaSeleccionada != null)
		{
			if ( huecoSeleccionado != null && huecoSeleccionado.contienePieza(piezaSeleccionada) && huecos.indexOf(huecoSeleccionado) == piezas.indexOf(piezaSeleccionada))
			{
				piezaSeleccionada.kill();
				huecoSeleccionado.dibujable();
				aciertos++;
			}
			piezaSeleccionada.mueve(posXOldPieza, posYOldPieza);
			piezaSeleccionada = null;
			huecoSeleccionado = null;
			repaint();
		}
	return true;
	}
}