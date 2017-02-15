package Ejercicio03;
public class Nif{
    int dni;
    char letra;

    /*
    * Hay atributos de objeto y de clase:
    * Cada objeto tendra su propio atributo dni y letra (los valores seran diferentes segun el objeto)
    * La tabla es un atributo de la clase: su contenido (valor) es comun a todos los objetos de esa clase
    * 
    * Lo hacemos static porque se puede acceder al atributo a través del *nombre de la clase*
    *       -> La razon es que este modificador static hace que sea un atributo de clase
    */

    static char[] letras = {'T', 'R', 'W', 'A', 'G','M', 'Y', 'F', 'P', 'D','X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L','C', 'K', 'E'}; //La letra es el resto del dni entre 5

    //public Nif(int dni, char letra) throws Exception{ //superada por nuestra clase
    public Nif(int dni, char letra) throws NifException, DniException{ 
    /*Esto ultimo permite lanzar excepciones de la clase Exception (la mas general)*/
            //Nueva excepcion: que el dni introducido sea mayor de 8 cifras
        if ((dni > 100000000) || (dni < 99999999)){ //Condicion de agustin
            throw new DniException("DNI incorrecto");
        } else {
            this.dni = dni;
        }
        if (letra != letras[dni % 23]){
            throw new NifException("Letra Incorrecta"); //Puede omitirse el parametro
        } else {
            this.letra = letra;
        }
    }
    public Nif(int dni) throws NifException, DniException{
        if ((dni/100000000 >= 1) || (dni / 1000000 <= 1)){ //MI condicion; estaba bien, pero no funcionaba porque la puse en el constructor equivocado. OJO.
            throw new DniException("DNI incorrecto");
        } else {
            this.dni = dni;
        }
        this.letra = letras[dni%23]; //Mucho mejor esto
    }
    
    public void leerNif(){
        System.out.println(dni + "-" + letra);
    }
}