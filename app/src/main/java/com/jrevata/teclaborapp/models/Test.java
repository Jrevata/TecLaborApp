package com.jrevata.teclaborapp.models;

public class Test {

    private String usuario;
    private int creatividad;
    private int persuasion;
    private int colaboracion;
    private int adaptabilidad;
    private int productividad;
    private int empleabilidad;

    public Test(String usuario, int creatividad, int persuasion, int colaboracion, int adaptabilidad, int productividad, int empleabilidad) {
        this.usuario = usuario;
        this.creatividad = creatividad;
        this.persuasion = persuasion;
        this.colaboracion = colaboracion;
        this.adaptabilidad = adaptabilidad;
        this.productividad = productividad;
        this.empleabilidad = empleabilidad;
    }

    public Test(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCreatividad() {
        return creatividad;
    }

    public void setCreatividad(int creatividad) {
        this.creatividad = creatividad;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(int colaboracion) {
        this.colaboracion = colaboracion;
    }

    public int getAdaptabilidad() {
        return adaptabilidad;
    }

    public void setAdaptabilidad(int adaptabilidad) {
        this.adaptabilidad = adaptabilidad;
    }

    public int getProductividad() {
        return productividad;
    }

    public void setProductividad(int productividad) {
        this.productividad = productividad;
    }

    public int getEmpleabilidad() {
        return empleabilidad;
    }

    public void setEmpleabilidad(int empleabilidad) {
        this.empleabilidad = empleabilidad;
    }
}
