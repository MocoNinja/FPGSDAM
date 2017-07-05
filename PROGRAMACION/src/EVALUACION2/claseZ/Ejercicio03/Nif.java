package EVALUACION2.claseZ.Ejercicio03;
public class Nif {
	int dni;
	char letra;
	static char tabla[] = {'T',	'R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    public Nif(int dni, char letra) throws NifException, DniException{
    	if((dni>100000000) || (dni<9999999))
    		throw new DniException("El DNI no es correcto");
    	this.dni = dni;
    	if(letra != tabla[dni % 23])
    		throw new NifException("La letra no es correcta");
    	this.letra = letra;
    }
    public Nif(int dni) throws DniException{
    	if((dni>100000000) || (dni<9999999))
    		throw new DniException("El DNI no es correcto");
    	this.dni = dni;
    	letra = tabla[dni % 23];
    }
    
    public void escribir(){
    	System.out.printf("%d - %c\n", dni, letra);
    }
    
}