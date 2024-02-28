package org.example.coordinacion.models;

public class BDG {
    private String nombreBanda;
    private String nombreSubzona;
    private String categoria;
    private String nombreComandante;
    private String gradoComandante;

    public BDG(String nombreBanda, String nombreSubzona, String categoria, String nombreComandante, String gradoComandante) {
        this.nombreBanda = nombreBanda;
        this.nombreSubzona = nombreSubzona;
        this.categoria = categoria;
        this.nombreComandante = nombreComandante;
        this.gradoComandante = gradoComandante;
    }

    public BDG() {
        
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public String getNombreSubzona() {
        return nombreSubzona;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombreComandante() {
        return nombreComandante;
    }

    public String getGradoComandante() {
        return gradoComandante;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public void setNombreSubzona(String nombreSubzona) {
        this.nombreSubzona = nombreSubzona;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNombreComandante(String nombreComandante) {
        this.nombreComandante = nombreComandante;
    }

    public void setGradoComandante(String gradoComandante) {
        this.gradoComandante = gradoComandante;
    }
}

