package rehechosPractica.FrameEsqueleto;

import java.awt.Event;
import java.awt.Frame;

public class App extends Frame implements Runnable{
	
	final int WIDTH = 300, HEIGHT = 300;
	Thread app;
	int contador;
	
	public static void main(String[] args) {
		App ui = new App();
		init();
	}
	
	private static void init() {
		// TODO Auto-generated method stub
		
	}

	public App()
	{
		pack();
		resize(WIDTH, HEIGHT);
		show();
	}
	
	public void start()
	{
		app = new Thread(this);
		app.start();
	}
	
	public void run()
	{
		while(true)
		{
			System.out.printf("Llevo %d iteración(es)...%n", ++contador);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean handleEvent(Event ev)
	{
		if (ev.id == Event.WINDOW_DESTROY)
		{
			System.exit(0);
		return true;
		}
	return false;
	}
}
