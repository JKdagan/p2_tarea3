package Monedas;

public abstract class Moneda implements Comparable<Moneda> {

    private int serie;
    public static int aux_serie = 1;
    public Moneda(int serie) {
        this.serie = serie;
    }

    public abstract int getValor();
    public int getSerie() {
        return this.serie;
    }

    public static void incrementarSerie() {
        Moneda100.serie_100++;
        Moneda500.serie_500++;
        Moneda1000.serie_1000++;
        Moneda1500.serie_1500++;
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
