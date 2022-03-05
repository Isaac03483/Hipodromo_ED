package com.ameri.utilidades;

import com.ameri.modelos.NodoApuesta;

public class Lista<T> {

    private NodoApuesta<T> primerNodo;
    private NodoApuesta<T> ultimoNodo;

    public void agregar(T valor){

        if(primerNodo == null){
            primerNodo = new NodoApuesta<>(valor, null, null);
            ultimoNodo = primerNodo;
        } else {


            if(ultimoNodo == primerNodo){
                ultimoNodo = new NodoApuesta<>(valor, primerNodo, null);
                primerNodo.setSiguiente(ultimoNodo);
            } else {
                NodoApuesta<T> temporal = ultimoNodo;
                ultimoNodo = new NodoApuesta<>(valor, temporal, null);
                temporal.setSiguiente(ultimoNodo);
            }
        }

        imprimirNodos(ultimoNodo);
    }

    public NodoApuesta<T> getPrimerNodo(){
        return this.primerNodo;
    }

    public void imprimirNodos(NodoApuesta<T> nodo){

        if(nodo != null){
            System.out.println("nodo = " + nodo);

            if(nodo.getSiguiente() != null){
                imprimirNodos(nodo.getSiguiente());
            }
        }
    }

    public void eliminar(NodoApuesta<T> nodo){

        if(primerNodo == ultimoNodo){
            primerNodo = null;
            ultimoNodo = null;

        } else if (nodo == ultimoNodo){
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);

        } else if(nodo == primerNodo){
            primerNodo = primerNodo.getSiguiente();
            if(primerNodo.getAnterior() != null){
                primerNodo.setAnterior(null);
            }
        } else {
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
        }
        System.out.println("nodo eliminado = " + nodo);
    }

    public boolean estaVacia(){
        return primerNodo == null;
    }
}
