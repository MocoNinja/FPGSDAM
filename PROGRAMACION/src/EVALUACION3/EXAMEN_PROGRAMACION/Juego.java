package EVALUACION3.EXAMEN_PROGRAMACION;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;

public class Juego extends Applet implements Runnable{

	public static final int ANCHO = 500, ALTO = 500;
	private final int INICIAL_GLOBOS = 10;
	private final int TIPOS_GLOBOS = 6;
	private final Color COLOR_FONDO = Color.BLACK;
	private final Color COLOR_TEXTO = Color.YELLOW;
	private final Font fuente = new Font("Arial", Font.BOLD, 15);
	private final int MAX_SEGUNDOS = 60;
	private int segundos;
	private int segundosRestantes;
	private int ciclos;
	private int puntuacion;
	private final int BLOQUE_PUNTOS = 3750;
	private int bloquesSuperados;
	
	Thread thread;
	Image[] globosSprites;
	Image buffer;
	Graphics aux;
	
	List<Globo> globos;
	
	public void init(){
		this.resize(ANCHO, ALTO);
		ciclos = 0;
		segundos = 0;
		segundosRestantes = MAX_SEGUNDOS;
		cargarImagenes();
		cargarGlobosIniciales();
		puntuacion = 0;
		bloquesSuperados = 0;
	}
	
	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	
	public void run(){
		while(true){
			ciclos ++;
			if (ciclos % 10 == 0){
				segundos++;
				meterGlobo();
			}
			segundosRestantes = MAX_SEGUNDOS - segundos;
			if (segundosRestantes == 0) thread.stop();
			try {
				Thread.sleep(100); // 10 ciclos son un segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverGlobos();
			repaint();
		}
	}
	
	private void cargarImagenes(){
		buffer = createImage(ANCHO, ALTO);
		aux = buffer.getGraphics();
		globosSprites = new Image[TIPOS_GLOBOS];
		String prefijo = "EVALUACION3/EXAMEN_PROGRAMACION/globos/globo";
		String sufijo = ".jpg";
		String ruta;
		for (int i = 0; i < TIPOS_GLOBOS; i++){
			ruta = prefijo;
			ruta += (i + 1);
			ruta += sufijo;
			System.out.println("Cargada imagen ruta: " + ruta);
			globosSprites[i] = getImage(getDocumentBase(), ruta);
		}
		
	}
	
	public void paint(Graphics g){
		aux.setColor(COLOR_FONDO);
		aux.fillRect(0, 0, ANCHO, ALTO);
		pintarGlobos(aux);
		pintarMensaje(aux);
		g.drawImage(buffer, 0, 0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	private void pintarMensaje(Graphics g){
		g.setFont(fuente);
		g.setColor(COLOR_TEXTO);
		g.drawString("Juego restante: " + segundosRestantes, 15, 50);
		g.drawString("Puntos: " + puntuacion, ANCHO - 150, 50);
	}
	
	private void pintarGlobos(Graphics g){
		for (Globo globo : globos) globo.paint(g);
	}
	
	private void cargarGlobosIniciales(){
		globos = new ArrayList<>();
		for (int i = 0; i < INICIAL_GLOBOS; i++){
			globos.add(new Globo(globosSprites, this));
		}
	}
	
	private void moverGlobos(){
		Globo actual;
		for (int i = 0; i < globos.size(); i++){
			actual = globos.get(i);
			actual.subir();
			if (!actual.enJuego()) globos.remove(actual);
		}
	}
	
	private void meterGlobo(){
		Globo nuevo = new Globo(globosSprites, this);
		globos.add(nuevo);
		System.out.println("Debo acelerar " + bloquesSuperados + " veces...");
		for (int i = 0; i < bloquesSuperados; i++){
//			System.out.println("Acelerando...");
			nuevo.acelerar();
		}
	}
	
	public boolean mouseDown(Event ev, int x, int y){
		for (Globo globo : globos){
			if (globo.contains(x, y)){
				globo.matar();
				puntuacion += globo.getPuntos();
				bloquesSuperados = puntuacion / BLOQUE_PUNTOS;
				System.out.println(bloquesSuperados);
				break;
			}
		}
		return true;
	}
}

class Globo extends Rectangle{
	
	public static final int ANCHO = 42, ALTO = 50;
	Applet app;
	Image[] sprites;
	Image sprite;
	
	private boolean vivo;
	private int velocidad;
	private int indice;
	private int puntos;
	private boolean inRange;
	private Color colorFuente;
	private Font fuente;
	
	public Globo(Image[] sprites, Applet app){
		super(0, 600, ANCHO, ALTO);
		generarPosicionAleatoriaInicial();
		this.sprites = sprites;
		Random rand = new Random();
		indice = rand.nextInt(sprites.length);
		sprite = sprites[indice];
		puntos = 100 * (1 + indice);
		velocidad = 5 + 5 * indice;
		this.app = app;
		this.inRange = true;
		vivo = true;
		generarColor();
		fuente = new Font("Arial", Font.BOLD, 32);
		
	}
	
	private void generarPosicionAleatoriaInicial(){
		Random rand = new Random();
		int newX = rand.nextInt(401); // x valdrá entre 0 y 400;
		int newY = rand.nextInt(101) + 500; // y valdrá entre 500 y 600
		this.move(newX, newY);
	}

	private void generarColor(){
		switch (indice){
		case 0:
			this.colorFuente = Color.ORANGE;
			break;
		case 1:
			this.colorFuente = Color.PINK;
			break;
		case 2:
			this.colorFuente = Color.BLUE;
			break;
		case 3:
			this.colorFuente = Color.GREEN;
			break;
		case 4:
			this.colorFuente = Color.YELLOW;
			break;
		case 5:
			this.colorFuente = Color.RED;
			break;
		}
	}
	public void paint(Graphics g){
		if (inRange && vivo){
			g.setColor(Color.RED); // Si carga el sprite no se ve
			g.drawImage(sprite, x, y, width, height, app);
		}
		else if (inRange && !vivo){
			g.setFont(fuente);
			g.setColor(colorFuente);
			g.drawString("" + puntos, x, y);
		}
	}
	
	public void subir(){
		this.y -= velocidad;
		if (y < -height - 1) inRange = false;
	}
	
	public void matar(){
		vivo = false;
	}
	public boolean enJuego(){
		return inRange;
	}
	
	public int getPuntos(){
		return this.puntos;
	}
	
	public void acelerar(){
		velocidad += 5;
	}
}