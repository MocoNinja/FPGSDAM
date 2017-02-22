package Ejercicio20BIS;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletApp extends Applet implements Runnable
{
	Thread thread;
	Ovalo ovalo;
	
	public void init()
	{
		ovalo = new Ovalo();
		thread = new Thread();
		thread.start();
	}
	public void run()
	{
		while(true)
		{
			ovalo.mover();
			repaint();
			try {
				System.out.println(ovalo.x + ", " + ovalo.y);
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g)
	{
		ovalo.pintar(g);
	}

}
