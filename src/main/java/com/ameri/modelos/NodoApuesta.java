package com.ameri.modelos;

public class NodoApuesta<T>{

    private T valor;
    private NodoApuesta<T> anterior;
    private NodoApuesta<T> siguiente;

    public NodoApuesta(T valor, NodoApuesta<T> anterior, NodoApuesta<T> siguiente) {
        this.valor = valor;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoApuesta<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoApuesta<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoApuesta<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoApuesta<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "valor=" + valor;
    }
}
