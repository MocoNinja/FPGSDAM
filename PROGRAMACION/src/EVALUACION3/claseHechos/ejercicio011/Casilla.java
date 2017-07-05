package EVALUACION3.claseHechos.ejercicio011;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
	Color colorCustom = Color.decode("0xFF0096");
	public static final Color[] colores = {
			Color.WHITE, Color.YELLOW, Color.RED, Color.GREEN, 
			Color.ORANGE, Color.BLUE, Color.MAGENTA, Color.BLACK, 
			Color.PINK, Color.DARK_GRAY, Color.CYAN
			};
	private int valor;
	private static final int ANCHO = 125, ALTO = 125, BORDE = 10;
	Color colorFondo, colorLetra;
	Font fuente = new Font("Monaco", Font.PLAIN, 46);
	
	public Casilla(int fila, int columna){
		super(0, 0, ANCHO, ALTO);
		x = BORDE + columna * ANCHO;
		y = BORDE + fila * ALTO;
		valor = 0;
		colorCasilla();
		colorFuente(colorFondo);
	}
	public void paint(Graphics g){
		g.setColor(colorCustom);
		g.fillRect(x, y, ANCHO + BORDE, ALTO + BORDE);
		g.setColor(colorFondo);
		g.fillRect(x + BORDE, y + BORDE, ANCHO - BORDE, ALTO - BORDE);
		g.setColor(colorLetra);
		g.drawRect(x, y, ANCHO, ALTO);
		g.setFont(fuente);
		if (valor != 0) g.drawString("" + (int) Math.pow(2, valor), x + ANCHO / 3, y + ALTO / 2);
	}
	private void colorCasilla(){
		if (valor == 0) colorFondo =  colores[0];
		else colorFondo =  colores[valor];
	}
	private void colorFuente(Color colorFondo){
		if (colorFondo == Color.BLACK || colorFondo == Color.DARK_GRAY) colorLetra =  Color.WHITE;
		else colorLetra = Color.BLACK;
	}
	
	private void updateColores(){
		colorCasilla();
		colorFuente(colorFondo);
	}
	public void aumentarValor(){
		if (valor == 0) valor = 1;
		else valor++;
		updateColores();
	}
	public void setValor(int valor){
		this.valor = valor;
		updateColores();
	}
	public int getValor(){
		return valor;
	}
	
//	public int getY(){
//		return this.y;
//	}
//	public int getX(){
//		return this.x;
//	}
	
	public void mover(int x, int y){
		this.x = x;
		this.y = y;
	}
	
//	public boolean contains(int x, int y){
//		if ((this.x >= x && this.x + ANCHO >= x) && (this.y <= y && this.y + ALTO >= y)){
//			return true;
//		}
//		return false;
//	}
}
