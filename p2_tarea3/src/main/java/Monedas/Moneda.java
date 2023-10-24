package Monedas;

public abstract class Moneda implements Comparable<Moneda> {

    private int serie;

    public Moneda(int serie) {
        this.serie = serie;
    }

    public abstract int getValor();

    public int getSerie() {
        return this.serie;
    }

    public int compareTo(Moneda m) {
        if (this.getValor() < m.getValor()) {
            return -1;
        } else if (this.getValor() > m.getValor()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Valor: " + this.getValor() + " Serie: " + this.getSerie() + ".";
    }
}
