package Modelo;

public class Articulo {

    private String codigo;
    private String descripcion;
    private float precioCompra;
    private float precioVenta;
    private int stock;
    private int cantidad; // Se va a usar a la hora de saber la cantidad de un articulo en el pedido

    public Articulo(String codigo, String descripcion, float precioCompra, float precioVenta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = 50;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Otros metodos y tostring

    public void addStock(int cantidad) {
        this.stock += cantidad;
    }

    public boolean deleteStock(int cantidad) {
        if (this.stock < cantidad) return false;
        this.stock -= cantidad;
        return true;
    }

    public float calculaPrecioVentaTotal(int unidades) {
        return this.precioVenta * unidades;
    }

    public float calculaGananciaVenta(int unidades) {
        return (this.precioVenta - this.precioCompra) * unidades;
    }

    public boolean hayStock() {
        return this.stock > 0;
    }

    @Override
    public String toString() {
        return  "\n[ ------------------------ Artículo ------------------------ ]" +
                "\n| Codigo: " + codigo +
                "\n| Descripcion: " + descripcion +
                "\n| PrecioCompra: " + precioCompra + "€" +
                "\n| PrecioVenta: " + precioVenta + "€" +
                "\n| Stock: " + stock +
                "\n[ ---------------------------------------------------------- ";
    }
}
