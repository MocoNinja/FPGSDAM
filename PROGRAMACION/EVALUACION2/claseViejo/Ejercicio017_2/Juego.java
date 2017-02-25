package claseViejo.Ejercicio017_2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego extends Applet implements Runnable
{
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	Thread ani;
	Graphics ninja;
	Image imagen;
	int puntos = 0;
	List<Pelota> listica = new ArrayList<Pelota>();
	Pelota bola;
	public int fallos;
	Random rand = new Random();	
	boolean endgame = false;
	boolean fallo = false;
	int manqueza = 0;
	

	public void init()
	{
		setBackground(Color.black);
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		for (int i = 0; i <= 2; i++)
		{
			listica.add(new Pelota());
		}
	}
	public void start()
	{
		ani = new Thread(this);
		ani.start();
	}
	
	@Override
	public void run() 
	{
		while(true){
			if (listica.size() == 0)
			{
				endgame = true;
				System.out.println("End");
				repaint();
				break;
			}
			for (int i = 0; i < listica.size(); i++){
				listica.get(i).mueve(listica);
			}
			try{
				Thread.sleep(45);
				repaint();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			};
		}
	}
	
	public void paint (Graphics gg){
		imagen = this.createImage(HEIGHT, WIDTH);
		ninja = imagen.getGraphics();
		ninja.setColor(Color.WHITE);
		ninja.drawRect(Pelota.PARED_I, Pelota.TECHO, Pelota.PARED_D + Pelota.RADIO_MAX, Pelota.SUELO + Pelota.RADIO_MAX);
		if (endgame)
		{
			ninja.setColor(Color.RED);
			ninja.setFont(new Font("Comic Sans MS",Font.PLAIN, 48));
			ninja.drawString("Congraturation", 200, 400); 
			ninja.drawString("Eres el master de las pelotas", 100, 600);
		} 
		else if (fallo)
		{
			manqueza ++;
			gg.setColor(Color.RED);
			ninja.setFont(new Font("Comic Sans MS",Font.PLAIN, 48));
			gg.drawString("MANCO", 200, 400); 
			String mensaje = "Has sido manco ";
			mensaje += manqueza;
			mensaje += " veces...";
			if (manqueza < 5)
			{
				gg.drawString(mensaje, 200, 300);			
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else 
			{
				mensaje = "Eres tan mancho que te echo del juego";
				gg.drawString(mensaje, 200, 300);			
				repaint();
				try {
					Thread.sleep(2000);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			fallo = false;
			
		}
		else 
		{
			for (int i = 0; i < listica.size(); i++){
				listica.get(i).pinta(ninja);
			}
		}
		gg.drawImage(imagen, 0, 0, this);
	}

	public boolean mouseDown(Event ev, int x, int y)
	{
		fallos = 0;
		for (int i = 0; i < listica.size(); i++){
			if (listica.get(i).contains(x,y)){
				System.out.println("Muere");
				listica.remove(i);
		return true;
			} 
			else
			{
				fallos++;
				System.out.println(fallos);
				if (fallos == listica.size())
				{
					listica.add(new Pelota());
					fallo = true;
		break;
				}
			}
		}
	return false;
	}
	
}
