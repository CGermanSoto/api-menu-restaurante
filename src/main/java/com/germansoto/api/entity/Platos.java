package com.germansoto.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Platos {
    private int numeroPlato;
    private String nombrePlato;
    private double precioPlato;
    private String descripcionPlato;

    public Platos() {
    }

    public Platos(int numeroPlato, String nombrePlato, double precioPlato, String descripcionPlato) {
        this.numeroPlato = numeroPlato;
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.descripcionPlato = descripcionPlato;
    }
}
