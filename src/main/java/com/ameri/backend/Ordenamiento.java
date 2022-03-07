package com.ameri.backend;

import com.ameri.enums.Orden;
import com.ameri.modelos.Apuesta;
import com.ameri.modelos.NodoApuesta;
import com.ameri.utilidades.Lista;

import java.text.CollationKey;
import java.text.Collator;

public class Ordenamiento {

    private Lista<Apuesta> lista;
    private Orden orden;

    public Ordenamiento(Lista<Apuesta> lista, Orden orden) {
        this.lista = lista;
        this.orden = orden;
    }

    public void ordenar(){
        if(this.orden == Orden.NUMERICO){
            System.out.println("orden = " + orden);
            this.ordenarNum();
        } else {
            System.out.println("entra acá");
            this.ordenarAlf();
        }
    }


    private void ordenarNum(){
        NodoApuesta<Apuesta> nodoInsertar = lista.getPrimerNodo().getSiguiente();

        while(nodoInsertar != null){
            NodoApuesta<Apuesta> primerNodo = nodoInsertar.getAnterior();

            while(primerNodo != null){

                if(primerNodo.getValor().getPuntos() >= nodoInsertar.getValor().getPuntos()){
                    if(primerNodo.getSiguiente().getValor().getPuntos() < nodoInsertar.getValor().getPuntos()){
                        this.lista.insertarEntre(primerNodo, primerNodo.getSiguiente(), nodoInsertar);
                    }
                    break;
                } else {
                    if(this.lista.getPrimerNodo() == primerNodo){
                        this.lista.insertarInicio(nodoInsertar);
                    }
                }

                primerNodo = primerNodo.getAnterior();
            }
            nodoInsertar = nodoInsertar.getSiguiente();
        }

    }


    private void ordenarAlf(){
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);

        NodoApuesta<Apuesta> nodoInsertar = lista.getPrimerNodo().getSiguiente();

        while(nodoInsertar != null){
            NodoApuesta<Apuesta> primerNodo = nodoInsertar.getAnterior();

            while(primerNodo != null){
                if(comparador.compare(nodoInsertar.getValor().getNombreApostador(), primerNodo.getValor().getNombreApostador()) < 0){
                    if(primerNodo == this.lista.getPrimerNodo()){
                        this.lista.insertarInicio(nodoInsertar);
                    } else {
                        if(comparador.compare(nodoInsertar.getValor().getNombreApostador(), primerNodo.getAnterior().getValor().getNombreApostador()) >= 0){
                            this.lista.insertarEntre(primerNodo.getAnterior(), primerNodo, nodoInsertar);
                            break;
                        }
                    }
                }

                primerNodo = primerNodo.getAnterior();
            }
            nodoInsertar = nodoInsertar.getSiguiente();
        }
    }
}
