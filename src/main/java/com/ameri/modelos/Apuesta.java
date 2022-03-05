package com.ameri.modelos;

public class Apuesta {

    private String nombreApostador;
    private double monto;
    private int puntos = 0;
    private Resultado resultado;

    public Apuesta(String nombreApostador, double monto, Resultado resultado) {
        this.nombreApostador = nombreApostador;
        this.monto = monto;
        this.resultado = resultado;
    }

    public String getNombreApostador() {
        return nombreApostador;
    }

    public void setNombreApostador(String nombreApostador) {
        this.nombreApostador = nombreApostador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Apuesta{" +
                "nombreApostador='" + nombreApostador + '\'' +
                ", monto=" + monto +
                ", puntos=" + puntos +
                ", resultado=" + resultado +
                '}';
    }
}
