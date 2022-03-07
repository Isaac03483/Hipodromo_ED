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

    }

    public NodoApuesta<T> getPrimerNodo(){
        return this.primerNodo;
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


    /*
    public void intercambiar(NodoApuesta<T> primerNodo, NodoApuesta<T> segundoNodo){
        if(this.primerNodo == primerNodo && this.ultimoNodo == segundoNodo){

            this.ultimoNodo = primerNodo;
            this.primerNodo = segundoNodo;
            this.ultimoNodo.setSiguiente(null);
            this.primerNodo.setAnterior(null);
            this.primerNodo.setSiguiente(this.ultimoNodo);
            this.ultimoNodo.setAnterior(this.primerNodo);

        } else if(this.primerNodo == primerNodo){
            this.primerNodo = segundoNodo;
            primerNodo.setSiguiente(segundoNodo.getSiguiente());
            segundoNodo.getSiguiente().setAnterior(primerNodo);
            this.primerNodo.setAnterior(null);
            this.primerNodo.setSiguiente(primerNodo);
            primerNodo.setAnterior(this.primerNodo);

        } else if(this.ultimoNodo == segundoNodo){

            this.ultimoNodo = primerNodo;
            segundoNodo.setAnterior(primerNodo.getAnterior());
            primerNodo.getAnterior().setSiguiente(segundoNodo);
            this.ultimoNodo.setSiguiente(null);
            this.ultimoNodo.setAnterior(segundoNodo);
            segundoNodo.setSiguiente(this.ultimoNodo);


        } else {

            primerNodo.getAnterior().setSiguiente(segundoNodo);
            segundoNodo.setAnterior(primerNodo.getAnterior());
            segundoNodo.getSiguiente().setAnterior(primerNodo);
            primerNodo.setSiguiente(segundoNodo.getSiguiente());
            segundoNodo.setSiguiente(primerNodo);
            primerNodo.setAnterior(segundoNodo);
        }

    }*/

    public void insertarInicio(NodoApuesta<T> nodoInsertar){
        if(this.ultimoNodo == nodoInsertar){
            nodoInsertar.getAnterior().setSiguiente(null);
            this.ultimoNodo = nodoInsertar.getAnterior();
        } else {
            nodoInsertar.getAnterior().setSiguiente(nodoInsertar.getSiguiente());
            nodoInsertar.getSiguiente().setAnterior(nodoInsertar.getAnterior());
        }
        this.primerNodo.setAnterior(nodoInsertar);
        nodoInsertar.setSiguiente(this.primerNodo);
        nodoInsertar.setAnterior(null);
        this.primerNodo = nodoInsertar;
    }


    public void insertarEntre(NodoApuesta<T> primerNodo, NodoApuesta<T> segundoNodo, NodoApuesta<T> nodoInsertar){
        if(this.ultimoNodo == nodoInsertar){
            nodoInsertar.getAnterior().setSiguiente(null);
            this.ultimoNodo = nodoInsertar.getAnterior();
        } else {
            nodoInsertar.getAnterior().setSiguiente(nodoInsertar.getSiguiente());
            nodoInsertar.getSiguiente().setAnterior(nodoInsertar.getAnterior());
        }

        primerNodo.setSiguiente(nodoInsertar);
        nodoInsertar.setAnterior(primerNodo);
        segundoNodo.setAnterior(nodoInsertar);
        nodoInsertar.setSiguiente(segundoNodo);

    }

    public void vaciarLista(){
        this.primerNodo = null;
        this.ultimoNodo = null;
    }
}
