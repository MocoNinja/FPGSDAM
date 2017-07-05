package EVALUACION1.examen;


public class Ejercicio4 {

	public static void main(String[] args) {
		
		int[] votos = {1590, 1800, 1000, 300, 100};
		String[] partidos = {"PP", "PSOE", "Pod.", "Ciu.", "PAR"};
		int[] cocientes = {1,1,1,1,1};
		final int escanios = 4;
		
		//detectaMax(votos, partidos);
		asignaEscanios(escanios, votos, partidos, cocientes);
	}
	
	public static int detectaMaxRatio (int[] votos, int[] cocientes){
		int max = 0;
		for (int i = 0; i < votos.length; i++){
			if ((votos[i]/cocientes[i]) >(votos[max]/cocientes[max])){
				max = i;
			}
		}
	return max;
	}
	
	public static void leeVector(int[] vector){
		for (int i = 0; i < vector.length; i++){
			System.out.println(vector[i]);
		}
	}
	
	public static void asignaEscanios(int escanios, int[] votos, String[] partidos, int[] cocientes){
		int ratio = 0;
		int max = 0;
		for (int i = 1; i <= escanios; i++){
			max = detectaMaxRatio(votos, cocientes);
			for (int j = 0; j < votos.length; j++){
				ratio = votos[j] / cocientes[j];
				//System.out.printf("El partido %s tiene un ratio de %d (%d votos dividido por %d...%n", partidos[j], ratio, votos[j], cocientes[i]);
				if (j == max){
					cocientes[j]++;
				}
			}
			System.out.printf("El escaño numero %d se asigna al %s...%n", i, partidos[max]);
		}
	}

}
