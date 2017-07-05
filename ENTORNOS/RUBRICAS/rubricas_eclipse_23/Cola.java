package rubricas_eclipse_23;

import java.util.ArrayList;
import java.util.List;

public class Cola<Object>
{
	List<Object> lista;
	private int tamanyo;
	
	public Cola()
	{
		lista = new ArrayList<Object>();
		tamanyo = 0;
	}
	
	public void encola(Object objetoNuevo)
	{
		lista.add(objetoNuevo);
		this.tamanyo++;
	}
	
	public Object desencola() throws Exception
	{
		if (numElementos() == 0)
		{
			System.out.println("Error, no hay objetos en la Cola!");
		throw new Exception("ColaVacia");
		}
		else
		{
			Object objetoDesencolado = lista.get(0);
			this.tamanyo--;
			lista.remove(0);
		return objetoDesencolado;
		}
	}
	
	public int numElementos()
	{
	return this.tamanyo;
	}
}