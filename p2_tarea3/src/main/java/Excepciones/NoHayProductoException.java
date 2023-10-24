package Excepciones;

public class NoHayProductoException extends Exception{
    /* constructor por defecto, crea una instancia de la excepcion con una cadena que explique la excepcion
    @param mensaje String
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }

}