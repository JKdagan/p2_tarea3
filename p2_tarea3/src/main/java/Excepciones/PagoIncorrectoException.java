package Excepciones;

public class PagoIncorrectoException extends Exception {
    /* constructor por defecto, crea una instancia de la excepcion con una cadena que explique la excepcion
    @param mensaje String
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }

}
