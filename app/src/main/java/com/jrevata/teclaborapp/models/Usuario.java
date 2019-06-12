package com.jrevata.teclaborapp.models;


import com.orm.dsl.Table;

@Table
public class Usuario {

    public String  token;
    public String  usuario;
    public Integer codigo;
    public String  nomuno;
    public String  nomdos;
    public String paterno;
    public String  materno;
    public String  correo;
    public Integer rol;


    public Usuario(){

    }

    public Usuario(String token, String usuario, Integer codigo, String nomuno, String nomdos,String paterno, String materno, String correo, Integer rol) {
        this.token = token;
        this.usuario = usuario;
        this.codigo = codigo;
        this.nomuno = nomuno;
        this.nomdos = nomdos;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
        this.rol = rol;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomuno() {
        return nomuno;
    }

    public void setNomuno(String nomuno) {
        this.nomuno = nomuno;
    }

    public String getNomdos() {
        return nomdos;
    }

    public void setNomdos(String nomdos) {
        this.nomdos = nomdos;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
}
