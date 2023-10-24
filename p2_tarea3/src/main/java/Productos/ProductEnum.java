package Productos;

public enum ProductEnum {
    COCA_COLA(1, 1200),
    SPRITE(2, 1200),
    FANTA(3, 1000),
    SUPER8(4, 300),
    SNICKERS(5, 400),
    NULO(6,0);

    //* entero para identificar el codigo(tipo de producto)
    private int codigo;

    //* entero para identificar el precio según el codigo
    private int precio;

    //* constructor por defecto
    ProductEnum(int codigo, int precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
    //* String con condicional switch, según sea el codigo retornará un nombre distinto
    public String getNombre(){
        switch (codigo){
            case 1:
                return "Coca-Cola";
            case 2:
                return "Sprite";
            case 3:
                return "Fanta";
            case 4:
                return "Super 8";
            case 5:
                return "Snickers";
            default:
                return "Producto Desconocido";
        }
    }
    //* getter para dar el codigo
    public int getCodigo() {
        return codigo;
    }
    //* getter para del el precio
    public int getPrecio() {
        return precio;
    }
}