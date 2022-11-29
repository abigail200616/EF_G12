package com.example.ef_g12.Beans;

public class ImpresionB {

    private int idImpresion;
    private int densidad;
    private String grosor;
    private float altura;
    private String material;
    private boolean autoservicio;
    private float costo;
    private float tiempo;
    private String fecha;

    private String url;

    private boolean aprobado;
    private String motivoR;

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getMotivoR() {
        return motivoR;
    }

    public void setMotivoR(String motivoR) {
        this.motivoR = motivoR;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdImpresion() {
        return idImpresion;
    }

    public void setIdImpresion(int idImpresion) {
        this.idImpresion = idImpresion;
    }

    public int getDensidad() {
        return densidad;
    }

    public void setDensidad(int densidad) {
        this.densidad = densidad;
    }

    public String getGrosor() {
        return grosor;
    }

    public void setGrosor(String grosor) {
        this.grosor = grosor;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isAutoservicio() {
        return autoservicio;
    }

    public void setAutoservicio(boolean autoservicio) {
        this.autoservicio = autoservicio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
