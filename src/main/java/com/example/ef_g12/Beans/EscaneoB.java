package com.example.ef_g12.Beans;

public class EscaneoB {

    private int idEscaneo;
    private float largo;
    private float ancho;
    private float altura;
    private String resolucion;
    private float costo;
    private float tiempo;
    private String fecha;


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

    public int getIdEscaneo() {
        return idEscaneo;
    }

    public void setIdEscaneo(int idEscaneo) {
        this.idEscaneo = idEscaneo;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
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

    public String getEscaneo() {
        return escaneo;
    }

    public void setEscaneo(String escaneo) {
        this.escaneo = escaneo;
    }
}
