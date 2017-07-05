package EVALUACION2.clase.Ejercicio014;

import java.applet.Applet;

import java.awt.*;

public class MondrianObjetos extends Applet implements Runnable
{
	Thread ani;
	Graphics ninja;
	Image imagen;
	TronchoHorario troncho1, troncho2;
	TronchoHorario[] todosDcha = new TronchoHorario[2];
	
	final int HEIGHT = 300, WIDTH = 300;
	
	public void init(){
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		troncho1 = new TronchoHorario(80, 110, 50, 90, Color.BLUE);
		troncho2 = new TronchoHorario(30, 50, 20, 45, Color.GREEN);
		todosDcha[0] = troncho1;
		todosDcha[1] = troncho2;
		
	}
	public void start(){
		ani = new Thread(this);
		ani.start();
	}
	
	public void run() {
		while(true){
			for (int i = 0; i < todosDcha.length; i++)
				todosDcha[i].mueve();
			repaint();
			try{
				Thread.sleep(60);
			}
			catch (InterruptedException e){};
		}
	}
	
	public void paint (Graphics gg){
		for (int i = 0; i < todosDcha.length; i++)
			todosDcha[i].mostrar(gg);
	}

}
