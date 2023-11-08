package tarea3_logica;
import java.lang.reflect.Array;
import java.util.ArrayList;

/** Deposito generico para almacenar una clase de objetos
 *
 * @param <T> tipo de objeto al cual se le hara un deposito
 */
public class Deposito<T> {
    //* Deposito interno declarado
    private ArrayList<T> deposito;
    //* Constructor de la clase
    public Deposito() {
        this.deposito = new ArrayList<T>();
    }

    /** Agrega un objeto al deposito
     *
     * @param t objeto a agregar al deposito
     */
    public void addToDeposito(T t) {
        this.deposito.add(t);
    }

    /** Saca un objeto del deposito
     *
     * @return objeto T sacado del deposito
     */
    public T getFromDeposito() {
        if (deposito.size() == 0) return null;
        return this.deposito.remove(0);
    }

    /** Saca el deposito interno
     *
     * @return arraylist de objetos T
     */
    public ArrayList<T> getDeposito() {
        return this.deposito;
    }

    /** Devuelve la cantidad de objetos en el deposito
     *
     * @return cantidad de objetos en el deposito
     */
    public int cuantoHay() {
        return this.deposito.size();
    }

}
