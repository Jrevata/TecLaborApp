package com.jrevata.teclaborapp.models;

import com.orm.dsl.Table;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

@Table
public class Test {

    private String usuario;
    private String nombre;
    private int creatividad;
    private int persuasion;
    private int colaboracion;
    private int adaptabilidad;
    private int productividad;
    private int empleabilidad;
    private Date fecha;

    public Test(String usuario, int creatividad, int persuasion, int colaboracion, int adaptabilidad, int productividad, int empleabilidad, Date fecha) {
        this.usuario = usuario;
        this.creatividad = creatividad;
        this.persuasion = persuasion;
        this.colaboracion = colaboracion;
        this.adaptabilidad = adaptabilidad;
        this.productividad = productividad;
        this.empleabilidad = empleabilidad;
        this.fecha = fecha;
    }

    public Test(String usuario, String nombre, int creatividad, int persuasion, int colaboracion, int adaptabilidad, int productividad, int empleabilidad, Date fecha) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.creatividad = creatividad;
        this.persuasion = persuasion;
        this.colaboracion = colaboracion;
        this.adaptabilidad = adaptabilidad;
        this.productividad = productividad;
        this.empleabilidad = empleabilidad;
        this.fecha = fecha;
    }


    public String toJSON(){

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("creatividad", getCreatividad());
            jsonObject.put("persuasion", getPersuasion());
            jsonObject.put("colaboracion", getColaboracion());
            jsonObject.put("adaptabilidad", getAdaptabilidad());
            jsonObject.put("productividad", getProductividad());

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public void setEmpleabilidad() {

        this.empleabilidad = getAdaptabilidad()+getColaboracion()+getCreatividad()+getPersuasion()+getProductividad();
    }
}
