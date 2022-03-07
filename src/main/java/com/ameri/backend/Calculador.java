package com.ameri.backend;

import com.ameri.modelos.Apuesta;
import com.ameri.modelos.NodoApuesta;
import com.ameri.modelos.Resultado;

public class Calculador {


    public static void calcularPunteo(NodoApuesta<Apuesta> nodoApuesta, Resultado resultado){

        if(nodoApuesta != null){
            nodoApuesta.getValor().calcularPuntos(resultado);
            if(nodoApuesta.getSiguiente() != null){
                calcularPunteo(nodoApuesta.getSiguiente(), resultado);
            }
        }
    }
}
