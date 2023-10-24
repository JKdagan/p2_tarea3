package Excepciones;

public class PagoInsuficienteException extends Exception {
    /* constructor por defecto, crea una instancia de la excepcion con una cadena que explique la excepcion
    @param mensaje String
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }

}
