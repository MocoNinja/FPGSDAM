package rubricas_eclipse_26;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Container
{
	private String propiedad;
	
	public Container(String propiedad)
	{
		this.propiedad = propiedad;
	}
	
	public String getProperty()
	{
	return this.propiedad;
	}
}


class Factory
{
//	private final int contenedores = Integer.MAX_VALUE - 1; // Demasiado jarcor para mi CPU
	private final int contenedores = 2500;
	
	public List<Container> createList()
	{
		final String[] posibilidades=
		{
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r",
		"s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", 
		"·", "+", "-", "_", "/", "@", "#", "€", "%", "$", "&"
		};
		Random rand = new Random();
		int contador = 0;
		List<Container> lista = new ArrayList<Container>();
		lista.add(new Container(posibilidades[rand.nextInt(posibilidades.length)]));
		while(++contador < contenedores)
		{
//			System.out.println("Generando paso " + contador);
			String clave = "";
			for (int i = 0; i <= lista.get(contador - 1).getProperty().length(); i++)
			{
				clave += posibilidades[rand.nextInt(posibilidades.length)];
			}
			lista.add(new Container(clave));
		}
	return lista;
	}
}