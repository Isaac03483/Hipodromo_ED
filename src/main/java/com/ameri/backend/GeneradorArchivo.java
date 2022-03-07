package com.ameri.backend;

import com.ameri.modelos.Apuesta;
import com.ameri.modelos.NodoApuesta;
import com.ameri.utilidades.Lista;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GeneradorArchivo {

    private Lista<Apuesta> lista;

    public GeneradorArchivo(Lista<Apuesta> lista) {
        this.lista = lista;
    }

    public void generarArchivo(String columnas) throws IOException {
        FileDialog guardar = null;
        guardar = new FileDialog(guardar, "Guardar como", FileDialog.SAVE);
        guardar.setVisible(true);
        guardar.dispose();
        if(guardar.getFile() != null && guardar.getDirectory() != null){
            FileWriter writer;
            if(!Objects.equals(FilenameUtils.getExtension(guardar.getFile()), "csv")){
                writer= new FileWriter(guardar.getDirectory()+guardar.getFile()+".csv");
            } else {
                writer = new FileWriter(guardar.getDirectory()+guardar.getFile());
            }
            String resultado = columnas+"\n";
            resultado += escribirArchivo(lista.getPrimerNodo());
            writer.write(resultado);
            writer.close();
            JOptionPane.showMessageDialog(null, "Archivo guardado con éxito en la ruta: " +
                    "\n"+guardar.getDirectory(),"Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String escribirArchivo(NodoApuesta<Apuesta> nodo) {
        String resultado = "";
        NodoApuesta<Apuesta> temporal = nodo;
        while (temporal != null){
            resultado+=temporal.getValor().getNombreApostador()+","+temporal.getValor().getMonto()
                    +","+temporal.getValor().getPuntos()+","+temporal.getValor().getResultado().getResultado()[0]
                    +"," +temporal.getValor().getResultado().getResultado()[1]+","+temporal.getValor().getResultado().getResultado()[2]
                    +","+temporal.getValor().getResultado().getResultado()[3]+"," +temporal.getValor().getResultado().getResultado()[4]
                    +","+temporal.getValor().getResultado().getResultado()[5]+","+temporal.getValor().getResultado().getResultado()[6]
                    +"," +temporal.getValor().getResultado().getResultado()[7]+","+temporal.getValor().getResultado().getResultado()[8]
                    +","+temporal.getValor().getResultado().getResultado()[9]+"\n";
            temporal = temporal.getSiguiente();
        }
        return resultado;
    }
}
