package rubricas_eclipse_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generadores {
	private  Integer[] vectorGenerado;
	private List<Integer> listaGenerada;
	
	public Generadores(int tamanyo, boolean esVector) {
		if (esVector){
			generarVector(tamanyo);
//			System.out.println("Vector generado: ");
			leerVector(vectorGenerado);
			ordenarVector(vectorGenerado);
//			System.out.println("Vector generado ordenado: ");
			leerVector(vectorGenerado);
			System.out.println();
		} else{
			generarLista(tamanyo);
//			System.out.println("Lista generado: ");
			leerLista(listaGenerada);
			ordenarLista(listaGenerada);
//			System.out.println("Lista generado ordenado: ");
			leerLista(listaGenerada);
			System.out.println();
			
		}
	}
	
	private void generarVector(int tamanyo){
		vectorGenerado = new Integer[tamanyo];
		Random rand = new Random();
		for (int i = 0; i < tamanyo; i++){
			vectorGenerado[i] = rand.nextInt(250) - 125;
		}
	}
	
	private void ordenarVector(Integer[] vector){
		int aux;
		int indiceAux;
		for (int i = 1; i < vector.length; i++){
			indiceAux = i;
			while (indiceAux > 0){
				if (vector[indiceAux] < vector[indiceAux - 1]){
					aux = vector[indiceAux];
					vector[indiceAux] = vector[indiceAux - 1];
					vector[indiceAux - 1] = aux;
					indiceAux--;
				} else break;
			}
		}
	}
	
	private void leerVector(Integer[] vector){
		System.out.print("{");
		int indice = 0;
		while(indice < vector.length){
			System.out.printf(" %5d ", vector[indice++]);
		}
		System.out.println("}");
	}

	public Integer[] getVector(){
		return this.vectorGenerado;
	}

	private void generarLista(int tamanyo){
		listaGenerada = new ArrayList<>();
		Random rand = new Random();
		while(tamanyo-- > 0){
			listaGenerada.add(rand.nextInt(250) - 125);
		}
	}
	
	private void ordenarLista(List<Integer> lista){
		Collections.sort(lista);
	}
	
	private void leerLista(List<Integer> lista){
		System.out.print("{");
		int indice = 0;
		while(indice < lista.size()){
			System.out.printf(" %5d ", lista.get(indice++));
		}
		System.out.println("}");
	}
	
	public List<Integer> getLista(){
		return this.listaGenerada;
	}

}
