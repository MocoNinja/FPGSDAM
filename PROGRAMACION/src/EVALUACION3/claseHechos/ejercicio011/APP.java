package EVALUACION3.claseHechos.ejercicio011;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class APP extends Applet{
	private Casilla[][] tablero;
	public static final int FILAS = 4, COLUMNAS = 4;
	private final char ARRIBA = 'u', ABAJO = 'd', IZQUIERDA = 'l', DERECHA = 'r';
	List<Casilla> casillasNulas;
	
	@Override
	public void init() {
		super.init();
		casillasNulas = new ArrayList<>();
		initTablero();
		generarDos();
		this.resize(600, 1000);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int fila = 0; fila < FILAS; fila++){
			for (int columna = 0; columna < COLUMNAS; columna++){
				tablero[fila][columna].paint(g);
			}
		}
	}
	private void initTablero(){
		tablero = new Casilla[FILAS][COLUMNAS];
		for (int fila = 0; fila < FILAS; fila++){
			for (int columna = 0; columna < COLUMNAS; columna++){
				tablero[fila][columna] = new Casilla(fila, columna);
				casillasNulas.add(tablero[fila][columna]);
			}
		}
	}
	
	private void generarDos(){
		Random rand = new Random();
		int fila = rand.nextInt(FILAS);
		int columna = rand.nextInt(COLUMNAS);
		if (tablero[fila][columna].getValor() == 0) tablero[fila][columna].aumentarValor();
		else generarDos();
	}
	
//	private void generarDos(){
//		if (casillasNulas.size() != 0){
//			Random rand = new Random();
//			int indiceAleatorio = rand.nextInt(casillasNulas.size());
//			Casilla casillaCambiar = casillasNulas.get(indiceAleatorio);
//			casillasNulas.remove(indiceAleatorio);
//			casillaCambiar.aumentarValor();
//		}
//	}
	
	
	
	public boolean mouseDown(Event ev, int x, int y){
		for (int fila = 0; fila < FILAS; fila++){
			for (int columna = 0; columna < COLUMNAS; columna++){
				if (tablero[fila][columna].contains(x, y)){
					System.out.println(tablero[fila][columna].getValor());
//					tablero[fila][columna].aumentarValor();
					break;
				}
			}
		}
		repaint();
		return true;
	}
	
	public boolean keyDown(Event ev, int tecla){
		System.out.println(tecla);
			switch (tecla) {
			
			case 32:
				// ESPACIO
				generarDos();
				repaint();
				break;
				
			case 1004:
//				mover(ARRIBA);
				for (int i = 0; i < COLUMNAS; i++)
				for (int columna = COLUMNAS - 1; columna >= 0; columna--){
					mover(ARRIBA, 0, columna);
				}
				generarDos();
				break;
				
			case 1005:
				System.out.println("pabajo");
				for (int i = 0; i < COLUMNAS; i++)
				for (int columna = COLUMNAS - 1; columna >= 0; columna--){
					mover(ABAJO, FILAS - 1, columna);
				}
				generarDos();
				break;
				
			case 1006:
//				mover(IZQUIERDA);
				for (int i = 0; i < FILAS; i++)
					for (int fila = FILAS - 1; fila >= 0; fila--){
						mover(IZQUIERDA, fila, 0);
				}
				generarDos();
				break;
				
			case 1007:
//				mover(DERECHA);
				for (int i = 0; i < FILAS; i++)
				for (int fila = FILAS - 1; fila >= 0; fila--){
					mover(DERECHA, fila, COLUMNAS - 1);
				}
				generarDos();
				break;

			default:
				break;
			}
		return true;
	}
	
	private void mover(char DIRECCION, int fila, int columna){
		switch (DIRECCION){
		
		case ABAJO:
			if (fila == 0) break;
			System.out.println("Posicion: " + fila + ", " + columna);
			// System.out.println("Valor: " + tablero[fila][columna].getValor());
			// System.out.println("Valor de la de arriba: " +  tablero[fila - 1][columna].getValor());
			if (tablero[fila][columna].getValor() == 0){
				System.out.println("La casilla actual vale 0, hay que meterle la de arriba");
				tablero[fila][columna].setValor(tablero[fila - 1][columna].getValor());
				tablero[fila - 1][columna].setValor(0);
			} else if (tablero[fila - 1][columna].getValor() - tablero[fila][columna].getValor() == 0){
				tablero[fila][columna].aumentarValor();
				tablero[fila - 1][columna] = new Casilla(fila - 1, columna);
				fila --;
			}
			fila--;
			repaint();
			mover(ABAJO, fila , columna);
			break;
			
		case IZQUIERDA:
			if (columna == COLUMNAS - 1) break;
			System.out.println("Posicion: " + fila + ", " + columna);
			// System.out.println("Valor: " + tablero[fila][columna].getValor());
			// System.out.println("Valor de la de arriba: " +  tablero[fila - 1][columna].getValor());
			if (tablero[fila][columna].getValor() == 0){
				System.out.println("La casilla actual vale 0, hay que meterle la de arriba");
				tablero[fila][columna].setValor(tablero[fila][columna + 1].getValor());
				tablero[fila][columna + 1].setValor(0);
			} else if (tablero[fila][columna + 1].getValor() - tablero[fila][columna].getValor() == 0){
				tablero[fila][columna].aumentarValor();
				tablero[fila][columna + 1] = new Casilla(fila, columna + 1);
				columna++;
			}
			columna++;
			repaint();
			mover(IZQUIERDA, fila , columna);
			break;
			
		case DERECHA:
			if (columna == 0) break;
			System.out.println("Posicion: " + fila + ", " + columna);
			// System.out.println("Valor: " + tablero[fila][columna].getValor());
			// System.out.println("Valor de la de arriba: " +  tablero[fila - 1][columna].getValor());
			if (tablero[fila][columna].getValor() == 0){
				System.out.println("La casilla actual vale 0, hay que meterle la de arriba");
				tablero[fila][columna].setValor(tablero[fila][columna - 1].getValor());
				tablero[fila][columna - 1].setValor(0);
			} else if (tablero[fila][columna - 1].getValor() - tablero[fila][columna].getValor() == 0){
				tablero[fila][columna].aumentarValor();
				tablero[fila][columna - 1] = new Casilla(fila, columna - 1);
				columna--;
			}
			columna--;
			repaint();
			mover(DERECHA, fila , columna);
			break;
			
		case ARRIBA:
			if (fila == FILAS - 1) break;
			System.out.println("Posicion: " + fila + ", " + columna);
			// System.out.println("Valor: " + tablero[fila][columna].getValor());
			// System.out.println("Valor de la de arriba: " +  tablero[fila - 1][columna].getValor());
			if (tablero[fila][columna].getValor() == 0){
				System.out.println("La casilla actual vale 0, hay que meterle la de arriba");
				tablero[fila][columna].setValor(tablero[fila + 1][columna].getValor());
				tablero[fila + 1][columna].setValor(0);
			} else if (tablero[fila + 1][columna].getValor() - tablero[fila][columna].getValor() == 0){
				tablero[fila][columna].aumentarValor();
				tablero[fila + 1][columna] = new Casilla(fila + 1, columna);
				fila ++;
			}
			fila++;
			repaint();
			mover(ARRIBA, fila , columna);
			break;
		}
		repaint();
	}
}
