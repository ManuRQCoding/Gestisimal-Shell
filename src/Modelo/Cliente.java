package Modelo;

import java.sql.Array;
import java.util.ArrayList;
import Modelo.Pedido;

public class Cliente {

    private ArrayList<Factura> facturas;
    private String nombre;
    private String movil;
    private String identificacion;
    private String tipo; //Tipo -> true: particular | false: empresa
    private boolean activo;

    public Cliente(String movil, String identificacion, String nombre, boolean tipo) {//Tipo=true (particular) False=empresa
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.activo = true;
        this.movil = movil;
        this.facturas = new ArrayList<>();
        if(tipo){
            this.tipo = "particular";
        }else{
            this.tipo = "empresa";
        }

    }

    //Getters and Setters


    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "\n[ ------------------------ Cliente ------------------------ ]" +
                "\n| Identificacion: " + identificacion +
                "\n| Nombre: " + nombre +
                "\n| Tipo: " + tipo +
                "\n| Activo: "+ isActivo() +
                "\n[ --------------------------------------------------------- ]";
    }
}
