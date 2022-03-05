package com.ameri.backend;

import com.ameri.modelos.Apuesta;
import com.ameri.modelos.Resultado;
import com.ameri.swing.FrameCarga;
import com.ameri.utilidades.Lista;

import javax.swing.*;
import java.io.*;

public class ManejadorIngresoApuesta implements Runnable{

    private JDialog frameCarga;
    private Lista<Apuesta> lista;

    public ManejadorIngresoApuesta(JDialog frameCarga, Lista<Apuesta> lista){
        this. frameCarga = frameCarga;
        this.lista = lista;
    }

    public void buscarArchivo(){
        JFileChooser buscarArchivo = new JFileChooser();
        int opcion = buscarArchivo.showOpenDialog(this.frameCarga);

        if(opcion == JFileChooser.APPROVE_OPTION){

            String archivo = buscarArchivo.getSelectedFile().getAbsolutePath();


            try{
                File archivoLeer = new File(archivo);
                if(archivoLeer.exists()){
                    this.escribirArchivo(archivoLeer);

                }
            } catch(NullPointerException | ArrayIndexOutOfBoundsException e){

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


    /**
     * método que escribe el archivo recibido en el área de texto
     * @param archivoLeer
     * @throws IOException
     */
    private void escribirArchivo(File archivoLeer) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(archivoLeer));
        String linea = lector.readLine();
        while(linea != null){

            agregarApuesta(linea);
            //System.out.println(linea);
            linea = lector.readLine();
        }
        JOptionPane.showMessageDialog(null, "Archivo cargado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        lector.close();

    }

    private void agregarApuesta(String linea) throws ArrayIndexOutOfBoundsException{
        String[] valores = linea.split(",");
        int[] resultado = new int[10];
        String nombre= valores[0];
        double monto= Double.parseDouble(valores[1]);
        resultado[0]= Integer.parseInt(valores[2]);
        resultado[1]= Integer.parseInt(valores[3]);
        resultado[2]= Integer.parseInt(valores[4]);
        resultado[3]= Integer.parseInt(valores[5]);
        resultado[4]= Integer.parseInt(valores[6]);
        resultado[5]= Integer.parseInt(valores[7]);
        resultado[6]= Integer.parseInt(valores[8]);
        resultado[7]= Integer.parseInt(valores[9]);
        resultado[8]= Integer.parseInt(valores[10]);
        resultado[9]= Integer.parseInt(valores[11]);

        lista.agregar(new Apuesta(nombre, monto, new Resultado(resultado)));
        ((FrameCarga)this.frameCarga).getTextArea().append("APOSTADOR AGREGADO CON EL NOMBRE: "+nombre+"\n");
    }

    public void agregarApuesta(String nombre, double monto, Resultado resultado){
        lista.agregar(new Apuesta(nombre, monto, resultado));
    }

    @Override
    public void run() {

        try{
            buscarArchivo();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
