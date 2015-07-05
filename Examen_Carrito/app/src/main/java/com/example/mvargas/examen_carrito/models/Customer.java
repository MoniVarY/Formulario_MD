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
    private String contrasena;
    private String correo;
    private int id_cliente;

    public Customer(int id,String name, String phone, String email, String username, String password) {

        id_cliente=id;
        nombre=name;
        telefono=phone;
        correo=email;
        usuario=username;
        contrasena=password;


    }


    public int getId() {
        return id_cliente;
    }

    public void setId(int id) {
        this.id_cliente= id;
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
        return contrasena;
    }

    public void setPassword(String password) {
        this.contrasena = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
