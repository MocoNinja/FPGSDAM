package mio_estudiar;
public class TablasVentas1{
	
    public static void main(String[] args) {
        int entradas [][]={{0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 2, 3, 4}};
		String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
		int vendidas[] = {0, 0, 0, 0, 0};
        int max = 0, min = 0;
        /*Sacar las entradas máximas y a qué dia corresponden*/
        for(int i= 0; i < entradas.length; i++){
            for (int j = 0; j < entradas[i].length; j++){
                vendidas[j] += entradas[i][j];
                if (i == entradas.length - 1){ //para evitar buscar el máximo antes del final
                    if (vendidas[j] > vendidas[max]){
                        max = j;
                    }
                    if (vendidas[j] < vendidas[min]){
                        min = j;
                    }
                } 
            }
        }
        System.out.printf("El día que más entradas se vendieron fue %s (%d vendidas). El que menos entradas, fue el %s (que fueron %d)...%n", dias[max], vendidas[max], dias[min], vendidas[min]);
    }
}