package com.ameri.backend;

import com.ameri.modelos.Apuesta;
import com.ameri.modelos.NodoApuesta;
import com.ameri.modelos.Resultado;
import com.ameri.utilidades.Lista;

public class Verificacion {

    private Lista<Apuesta> lista;
    private Lista<Apuesta> rechazadas;

    public Verificacion(Lista<Apuesta> lista){
        this.lista = lista;
        this.rechazadas = new Lista<>();
        verificarApuestas(lista.getPrimerNodo());
    }

    public Verificacion(){}


    private void verificarApuestas(NodoApuesta<Apuesta> nodoApuesta){
        if(nodoApuesta != null){
            verificarResultados(nodoApuesta.getValor().getResultado(), nodoApuesta);
            if(nodoApuesta.getSiguiente() != null){
                verificarApuestas(nodoApuesta.getSiguiente());
            }
        }
    }

    private void verificarResultados(Resultado resultado, NodoApuesta<Apuesta> nodo){

        if(tieneRepetido(resultado.getResultado(), 0) || tieneRepetido(resultado.getResultado(), 1)
        || tieneRepetido(resultado.getResultado(), 2) || tieneRepetido(resultado.getResultado(), 3)
        || tieneRepetido(resultado.getResultado(), 4) || tieneRepetido(resultado.getResultado(), 5)
        || tieneRepetido(resultado.getResultado(), 6) || tieneRepetido(resultado.getResultado(), 7)
        || tieneRepetido(resultado.getResultado(), 8) || tieneRepetido(resultado.getResultado(), 9)){
            lista.eliminar(nodo);
            this.rechazadas.agregar(nodo.getValor());
        }
    }

    public boolean verificarResultadosRepetidos(int[] resultados){
        return tieneRepetido(resultados, 0) || tieneRepetido(resultados, 1)
                || tieneRepetido(resultados, 2) || tieneRepetido(resultados, 3)
                || tieneRepetido(resultados, 4) || tieneRepetido(resultados, 5)
                || tieneRepetido(resultados, 6) || tieneRepetido(resultados, 7)
                || tieneRepetido(resultados, 8) || tieneRepetido(resultados, 9);
    }

    public boolean tieneRepetido(int[] resultados, int inicio){

        for(int i = inicio+1; i < resultados.length; i++){
            if(resultados[inicio] == resultados[i] || resultados[inicio] > 10 || resultados[inicio] < 1){
                return true;
            }
        }

        return false;
    }

    public Lista<Apuesta> getRechazadas(){
        return rechazadas;
    }
}
