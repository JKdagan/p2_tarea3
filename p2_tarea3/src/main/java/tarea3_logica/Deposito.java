package tarea3_logica;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deposito<T> {

    private ArrayList<T> deposito;

    public Deposito() {
        this.deposito = new ArrayList<T>();
    }
    public void addToDeposito(T t) {
        this.deposito.add(t);
    }
    public T getFromDeposito() {
        if (deposito.size() == 0) return null;
        return this.deposito.remove(0);
    }
    public ArrayList<T> getDeposito() {
        return this.deposito;
    }

    public int cuantoHay() {
        return this.deposito.size();
    }

}
