package Productos;

abstract class Producto {

    private int serie;

    public Producto(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String getNombre();

    public String toString() {
        return "Nombre: " + this.getNombre() + " Serie: " + this.getSerie() + ".";
    }
}
