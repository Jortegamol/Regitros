/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoweb;

import java.io.Serializable;

/**
 *
 * @author GSS_ING
 */
public class Usuario implements Serializable{
    
    private int idUsuario;
    private String nombre;
    private String apPat;
    private String apMat;
    private String genero;
    private int estado ;
    private String ubicacion;
    private String telefono;
    private String correo;
    private String password;
    
    
    public Usuario(){
        
    }
    
    public Usuario(int idUsuario, String nombre, String apPat, String apMat,String genero, int estado, String ubicacion, String telefono, String correo, String password)
    {
        this.idUsuario= idUsuario;
        this.nombre= nombre;
        this.apPat= apPat;
        this.apMat= apMat;
        this.genero=genero;
        this.estado=estado;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave= ").append(idUsuario).append("\n");
        sb.append("Nombre= ").append(getNombre()).append("\n");   
        return sb.toString();
    }
   
    
}
