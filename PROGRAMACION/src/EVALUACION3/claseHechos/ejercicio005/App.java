package EVALUACION3.claseHechos.ejercicio005;
/*
* El juego de desplazar im�genes
* Cada imagen ser� un objeto de la clase point
* Habr� que ir podiendo mover las fichas de forma acorde con recursividad
*/
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class App extends Applet //implements ActionListener
{
	Image[] dibujos;
	Hueco[][] figuras;
	Image aux;
	Random rand;
	Rectangle hitbox;
	int filaHueco, columnaHueco;
	int posHueco;
	final int ARRIBA = 1, ABAJO = 2, IZQUIERDA = 3, DERECHA = 4, NINGUNO = 0;
	private final int WIDTH = 1000, HEIGHT = 500;
	AudioClip error, acierto, win;
	Button boton;
	
	public void init()
	{
		try {
			error = getAudioClip(new URL(getDocumentBase(), "EVALUACION3/clase/ejercicio005/sound/error.wav"));
			acierto = getAudioClip(new URL(getDocumentBase(), "EVALUACION3/clase/ejercicio005/sound/good.wav"));
			win = getAudioClip(new URL(getDocumentBase(), "EVALUACION3/clase/ejercicio005/sound/win.wav"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		dibujos = new Image[25];
		dibujos[24] = null;
		String ruta;
		posHueco = NINGUNO;
		for (int i = 1; i <= 24; i++)
		{
			ruta = "EVALUACION3/clase/ejercicio005/botones/" + i + ".gif";
			dibujos[i - 1] = getImage(getDocumentBase(), ruta);
		}
		
		figuras = new Hueco[5][5];
		for (int fila = 0; fila < 5; fila++)
		{
			for (int columna = 0; columna < 5; columna++)
			{
				figuras[fila][columna] = new Hueco(fila, columna, dibujos, fila * 5 + columna, false, this);
			}
		}
		this.setLayout(new BorderLayout());
		boton = new Button("Mezcla");
//		boton.addActionListener(this);
		this.add("South", boton);
		mezclar();
	}
	
	public boolean correcto()
	{
		int imagen = 0;
		for (int i = 0; i < figuras.length; i++)
		{
			for (Hueco hueco : figuras[i])
			{
				if (!(hueco.getImagen() == dibujos[imagen++]))
				{
					return false;
				}
			}
		}
		win.play();
	return true;
	}
	
	public void paint(Graphics g)
	{
		if (correcto()) g.drawString("CHAMPION", 500, 50);
		for (int fila = 0; fila < 5; fila++)
		{
			for (int columna = 0; columna < 5; columna++)
			{
				figuras[fila][columna].paint(g, this);
			}
		}
	}
	
	public void mezclar()
	{
		rand = new Random();
		int indice;
		Integer numero;
		List<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0; i < dibujos.length; i++)
		{
			lista.add(i);
		}
		
		for (int fila = 0; fila < 5; fila++)
		{
			for (int columna = 0; columna < 5; columna++)
			{
				indice = lista.get(rand.nextInt(lista.size()));
				numero = indice;
				figuras[fila][columna].setImagen(indice);
				lista.remove(numero);
			}
		}
	}
	
	public void cheto()
	{
		int imagen = 0;
		for (int i = 0; i < figuras.length; i++)
		{
			for (Hueco hueco : figuras[i])
			{
				hueco.setImagen(dibujos[imagen++]);
			}
		}
		repaint();
	}

	public int detectaHueco(int fila, int columna)
	{
		filaHueco = -1;
		columnaHueco = -1;
		posHueco = NINGUNO;
		
		for (int i = 0; i < 25; i++)
		{
			if(figuras[i/5][i%5].getImagen() == null)
			{
				filaHueco = i / 5;
				columnaHueco = i % 5;
				break;
			}
		}
		if (filaHueco == fila && figuras[fila][columna].getImagen() != null)
		{
			acierto.play();
			if (columnaHueco < columna) posHueco = IZQUIERDA;
			else posHueco = DERECHA;
		}
		else if (columnaHueco == columna && figuras[fila][columna].getImagen() != null)
		{
			acierto.play();
			if(filaHueco < fila) posHueco = ARRIBA;
			else posHueco = ABAJO;
		}
		else
		{
			error.play();
		}
	return posHueco;
	}

	public void mueve(int fila, int columna)
	{
		switch(posHueco)
		{
		case IZQUIERDA:
			if (columna - 1 == columnaHueco && fila == filaHueco)
			{
				figuras[filaHueco][columnaHueco].setImagen(figuras[fila][columna].getImagen());
				figuras[fila][columna].setImagen(null);
				repaint();
			}
			else
			{
				mueve(fila, columna - 1);
				aux = figuras[fila][columna].getImagen();
				figuras[fila][columna].setImagen(figuras[fila][columna - 1].getImagen());
				figuras[fila][columna - 1].setImagen(aux);
			}
		break;
		case DERECHA:
			if (columna + 1 == columnaHueco && fila == filaHueco)
			{
				figuras[filaHueco][columnaHueco].setImagen(figuras[fila][columna].getImagen());
				figuras[fila][columna].setImagen(null);
				repaint();
			}
			else
			{
				mueve(fila, columna + 1);
				aux = figuras[fila][columna].getImagen();
				figuras[fila][columna].setImagen(figuras[fila][columna + 1].getImagen());
				figuras[fila][columna + 1].setImagen(aux);
			}
		break;
		case ARRIBA:
			if (fila - 1 == filaHueco && columna == columnaHueco)
			{
				figuras[filaHueco][columnaHueco].setImagen(figuras[fila][columna].getImagen());
				figuras[fila][columna].setImagen(null);
				repaint();
			}
			else
			{
				mueve(fila - 1, columna);
				aux = figuras[fila][columna].getImagen();
				figuras[fila][columna].setImagen(figuras[fila - 1][columna].getImagen());
				figuras[fila - 1][columna].setImagen(aux);
			}
		break;
		case ABAJO:
			if (fila + 1 == filaHueco && columna == columnaHueco)
			{
				figuras[filaHueco][columnaHueco].setImagen(figuras[fila][columna].getImagen());
				figuras[fila][columna].setImagen(null);
				repaint();
			}
			else
			{
				mueve(fila + 1, columna);
				aux = figuras[fila][columna].getImagen();
				figuras[fila][columna].setImagen(figuras[fila + 1][columna].getImagen());
				figuras[fila + 1][columna].setImagen(aux);
			}
		break;
		}
		
	}
	
	public boolean mouseDown(Event ev, int x, int y)
	{		
		
		hitbox = new Rectangle(x - 10, y - 10, 20, 20);
		
		for (int i = 0; i < 25; i++)
		{
			if(hitbox.contains(figuras[i/5][i%5].getPoint()))
			{
				detectaHueco(i/5, i%5);
				mueve(i/5, i%5);
			}
		}
	return true;
	}
	
	public boolean action (Event e, Object o)
	{
		System.out.println("Llega");
		if (e.target instanceof Button)
			{
			System.out.println("llega");
			mezclar();
			repaint();
			}
	return true;
	}
	
//	public void actionPerformed(ActionEvent ae)
//	{
//		if (ae.getActionCommand().equals("Mezcla"))
//		{
//			mezclar();
//			repaint();
//		}
//	}
	
	public boolean keyDown(Event ev, int tecla)
	{
		System.out.println(tecla);
		if (tecla == 32)
		{
			mezclar();
		}
		else if (tecla == 97)
		{
			cheto();
		}
	return true;
	}

}