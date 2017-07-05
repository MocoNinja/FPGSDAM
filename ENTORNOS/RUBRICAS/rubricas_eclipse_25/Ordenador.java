package rubricas_eclipse_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordenador {
	List<Integer> lista1, lista2, listaFinal;
	int repeticiones = 0;
	
	public Ordenador(List<Integer> lista1, List<Integer> lista2){
		this.lista1 = lista1;
		this.lista2 = lista2;
		listaFinal = ordenarListas();
		leerLista();
	}
	
	public Ordenador(Integer[] lista1, Integer[] lista2){
		this.lista1 = Arrays.asList(lista1);
		this.lista2 = Arrays.asList(lista2);
		listaFinal = ordenarListas();
		leerLista();
	}
	
	public List<Integer> getResultado(){
		return listaFinal;
	}
	
	private List<Integer> ordenarListas(){
		int indiceLista1 = 0, indiceLista2 = 0;
		List<Integer> listaFinal = new ArrayList<>();
		int numeroInserciones = lista1.size() + lista2.size();
		int numeroInsertar;
		
		for (int i = 0; i < numeroInserciones - 1; i++){
			if (indiceLista1 == lista1.size()) numeroInsertar = lista2.get(indiceLista2++);
			else if (indiceLista2 == lista2.size()) numeroInsertar = lista1.get(indiceLista1++);
			else  numeroInsertar = (lista1.get(indiceLista1) <= lista2.get(indiceLista2)) ? lista1.get(indiceLista1++) : lista2.get(indiceLista2++);
			if (listaFinal.size() > 1 && numeroInsertar == listaFinal.get(listaFinal.size() -1)) repeticiones++;
			listaFinal.add(numeroInsertar);
		}
		System.out.println("Ha habido " + repeticiones + " números repetidos");
		return listaFinal;
	}
	
	private void leerLista(){
		System.out.print("Lista final: \n{");
		for (Integer numero : listaFinal) System.out.printf(" %3d", numero);
		System.out.println("}");
	}
}
