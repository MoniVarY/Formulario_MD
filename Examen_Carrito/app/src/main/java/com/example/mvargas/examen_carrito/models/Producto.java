package com.example.mvargas.examen_carrito.models;

/**
 * Created by code4jhon on 7/5/15.
 */
public class Producto {

    private String codigo;
    private int unidades;
    private String nombre;
    private String minDesc;
    private String maxDesc;
    private Double precio;
    private String imagen;
    private String id_producto;



    /*public Producto(int id,String code,int units,String name, String minDes, String maxDes, Double price,String img){
        id_producto=id;
        codigo=code;
        unidades=units;
        nombre=name;
        minDesc=minDes;

        maxDesc=maxDes;
        precio=price;
        imagen=img;

    }*/
    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMinDesc() {
        return minDesc;
    }

    public void setMinDesc(String minDesc) {
        this.minDesc = minDesc;
    }

    public String getMaxDesc() {
        return maxDesc;
    }

    public void setMaxDesc(String maxDesc) {
        this.maxDesc = maxDesc;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



}
