package com.example.mvargas.examen_carrito.common;

/**
 * Created by MVARGAS on 30/06/2015.
 */
public class Constants {
    public static final long SPLASH_SCREEN_DELAY = 2000 ;
    public final static String MAIL_PERSONAL="moni.va.mv@gmail.com";
    public final static String MAIL="alberto.lopez@gonet.us";
    public final static String SUBJECT="PracticaEnviar20150630MOVA ";
    public final static String APP_TAG="appSP";
    public final static String NOMBRE="et_nombre";
    public final static String APEPA="et_apepa";
    public final static String APEMA="et_apema";
    public final static String MENSAJE= "Ingrese todos los datos";
    public final static String ERROR_PASSWORD= "No coinciden los password";
    public static final String KEY_ID = "id";
    public static final String NAME = "name";
    public static final String TELEFONO = "telefono";
    public static final String USUARIO = "user";
    public static final String PASSWORD = "password";
    public static final String CORREO = "correo";
    public static final String TABLA_USUARIO = "tbusuarios";
    public static  final int DATABASE_VERSION=1;
    public static  final String DATABASE_NAME="dbexamencarrito.sqlite";
    public final static String CREA_USUARIO_TABLA = "CREATE TABLE IF NOT EXISTS Customers " + "(name TEXT, username TEXT, email TEXT, phone TEXT, password TEXT)";
    public final static String CREA_PRODUCTOS_TABLA = "CREATE TABLE IF NOT EXISTS Catalog " + "(code TEXT, name TEXT, mindesc TEXT, maxdesc TEXT, image TEXT, units INTEGER, price REAL)";
    public final static String OBTIENE_USUARIO_QUERY = "SELECT * FROM Customers" + "WHERE username =";
    public final static String TABLA_PRODUCTOS = "tbproductos";

}
