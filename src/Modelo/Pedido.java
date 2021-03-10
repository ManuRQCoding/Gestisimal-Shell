package Modelo;

import java.util.ArrayList;
import Modelo.Articulo;

public class Pedido {
    private String id;
    private Cliente cliente;
    private String tipoEnvio; // Fisico o Domicilio
    private boolean estado; //True: pendiente, False: enviado.
    private ArrayList<Articulo> articulos;

    public Pedido(String id, Cliente cliente, String tipoEnvio, ArrayList<Articulo> articulos) {
        this.id = id;
        this.cliente = cliente;
        this.tipoEnvio = tipoEnvio;
        this.estado = true;
        this.articulos = articulos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        String datosArticulo = "";
        for (Articulo a : articulos) {
            datosArticulo += "\n\t\t[ ------------- Artículo ------------- ]" +
                             "\n\t\t| Nombre: " + a.getDescripcion() +
                             "\n\t\t| Cantidad: " + a.getCantidad();
        }

        return  "\n\t-*****************- PEDIDO -*****************-" +
                "\n\t* ID del pedido: " + id +
                "\n\t* Tipo de envío: " + tipoEnvio +
                "\n\t* Estado: " + ( estado ? "Pendiente" : "Enviado") +
                "\n\t\t[ -------------- Cliente ------------- ]" +
                "\n\t\t| " + ( cliente.getTipo().equalsIgnoreCase("particular") ? "DNI: " : "CIF: ") + cliente.getIdentificacion() +
                "\n\t\t| Nombre: " + cliente.getNombre() +
                datosArticulo +
                "\n\t\t[ ------------------------------------ ]" +
                "\n\t-********************************************-";
    }
}
