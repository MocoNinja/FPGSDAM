package Ejercicio20Clase;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Juego extends Applet{
	
	public List<Ovalo> ovalos;
	public List<Rectangulo> rectangulos;
	
	public final int NUMERO_MAX = 100;
	
	public void init()
	{
		ovalos = new ArrayList<Ovalo>();
		rectangulos= new ArrayList<Rectangulo>();
		for (int i = 0; i < NUMERO_MAX; i++)
		{
			ovalos.add(new Ovalo());
		}
		rectangulos.add(new Rectangulo());
		
	}
}
