package com.example.mvargas.examen_carrito.models;

import com.example.mvargas.examen_carrito.common.Contacts;

import java.util.ArrayList;

/**
 * Created by MVARGAS on 03/07/2015.
 */
public class Customer {
    private String nombre;
    private String telefono;
    private String usuario;
    private String password;
    private String correo;
    private int id;

    public Customer(String name, String phone, String email, String username, String password) {



    }
    public Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}