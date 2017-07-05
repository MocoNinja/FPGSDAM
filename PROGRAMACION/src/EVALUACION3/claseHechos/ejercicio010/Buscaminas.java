package EVALUACION3.claseHechos.ejercicio010;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

/*
* Buscaminas 10 x 10
* 10 minas (aleatorias)
* 
*/
public class Buscaminas extends Applet {
	Image[] sprites;
	private final int CASILLA = 0, MINA = 1, MINA_ACTIVADA = 2, BANDERA = 3;
	public static final int FILAS = 10, COLUMNAS = 10;
	private final int MAX_MINAS = FILAS * COLUMNAS / 10 + 1;
	private boolean gameOver = false;
	private boolean gameWin = false;
	Casilla[][] campo;

	@Override
	public void init() {
		super.init();
		setupSprites();
		campo = new Casilla[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS * COLUMNAS; i++) {
			campo[i / FILAS][i % COLUMNAS] = new Casilla(i / FILAS * Casilla.ANCHO, i % COLUMNAS * Casilla.ALTO,
					sprites[CASILLA], this);
		}
		setupMinas();
		for (int i = 0; i < FILAS * COLUMNAS; i++) {
			campo[i / FILAS][i % COLUMNAS].calcularMinasAdyacentes(campo, i / FILAS, i % COLUMNAS);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (gameOver) {
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 72));
			g.drawString("MURISTE!", getWidth() / 2 - 175, getHeight() / 2);

		} else if (gameWin) {
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 72));
			g.drawString("FAKIN CHAMPION!", getWidth() / 2 - 175, getHeight() / 2);

		} else {
			for (int i = 0; i < FILAS * COLUMNAS; i++) {
				campo[i / FILAS][i % COLUMNAS].pinta(g, this);
			}
		}
	}

	public void setupSprites() {
		sprites = new Image[4];
		sprites[0] = getImage(getCodeBase(), "EVALUACION3/claseHechos/ejercicio010/sprites/casilla.gif");
		sprites[1] = getImage(getCodeBase(), "EVALUACION3/claseHechos/ejercicio010/sprites/mina.gif");
		sprites[2] = getImage(getCodeBase(), "EVALUACION3/claseHechos/ejercicio010/sprites/mina_fin.gif");
		sprites[3] = getImage(getCodeBase(), "EVALUACION3/claseHechos/ejercicio010/sprites/bandera.gif");
	}

	public void setupMinas() {
		/*
		 * Otra forma de hacer numeros aleatorios sin repeticion creamos un
		 * vector de resultados resultados resultado = new int[DIM]; creamos un
		 * vector con todas las posibilidades vector = new int[DIM][DIM], que se
		 * carga con un for i -> DIM * DIM generemos un valor entre 0 y
		 * vector.lenghh ponemos el numero con el indice generado en resultado
		 * copiamos el elemento ultimo a ese generamos un valor entre 0 y
		 * vector.length - 1 ...
		 */
		Random rand = new Random();
		int minasRestantes = MAX_MINAS;
		int casillaMinaNueva;
		while (minasRestantes-- > 0) {
			casillaMinaNueva = rand.nextInt(FILAS * COLUMNAS);
			while (campo[casillaMinaNueva / FILAS][casillaMinaNueva % COLUMNAS].isMina()) {
				casillaMinaNueva = rand.nextInt(FILAS * COLUMNAS);
			}
			campo[casillaMinaNueva / FILAS][casillaMinaNueva % COLUMNAS].setMina();
			campo[casillaMinaNueva / FILAS][casillaMinaNueva % COLUMNAS].setImagenMina(sprites[MINA]);
		}
	}

	public boolean mouseDown(Event ev, int x, int y)
	{
		if (gameOver) return false;
		else{
			for (int i = 0; i < FILAS * COLUMNAS; i++)
			{
				Casilla casillaSeleccionada = campo[i / FILAS][i % COLUMNAS];
				if (casillaSeleccionada.contains(x, y))
				{
					if (casillaSeleccionada.isMina())
					{
						gameOver = true;
					}
					else
					{
						if(casillaSeleccionada.minasPegas() == 0) casillaSeleccionada.limpiarCero(campo, i / FILAS, i % COLUMNAS);
						casillaSeleccionada.descubrir(campo, i / FILAS, i % COLUMNAS);
						if(casillaSeleccionada.minasAdyacetes() == 0) casillaSeleccionada.descubrir(campo, i / FILAS, i % COLUMNAS);
					}
					break;
			}
		}
		gameWin = victory();
		repaint();
		}
		return true;
	}

	public boolean victory() {
		int aciertos = 0;
		for (int i = 0; i < FILAS * COLUMNAS; i++) {
			if (campo[i / FILAS][i % COLUMNAS].isDescubierta() || (campo[i / FILAS][i % COLUMNAS].isMina()))
				aciertos++;
		}
		System.out.println("Aciertos: " + aciertos);
		return aciertos == FILAS * COLUMNAS;
	}
}
