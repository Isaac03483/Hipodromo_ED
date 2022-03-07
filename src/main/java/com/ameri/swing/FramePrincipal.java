/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ameri.swing;

import com.ameri.backend.Calculador;
import com.ameri.backend.GeneradorArchivo;
import com.ameri.backend.Ordenamiento;
import com.ameri.backend.Verificacion;
import com.ameri.enums.Orden;
import com.ameri.modelos.Apuesta;
import com.ameri.modelos.Resultado;
import com.ameri.utilidades.Lista;

import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author ameri
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        this.listaApuesta = new Lista<>();
        initComponents();
        this.setLocationRelativeTo(null);
        this.orden = Orden.ALFABETICO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        ApuestaEntrada = new javax.swing.JButton();
        ApuestaCierre = new javax.swing.JButton();
        ResultadoEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("MENÚ PRINCIPAL");
        etiquetaTitulo.setFocusable(false);
        etiquetaTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        ApuestaEntrada.setText("Ingreso de apuestas");
        ApuestaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApuestaEntradaActionPerformed(evt);
            }
        });

        ApuestaCierre.setText("Cierre de apuestas");
        ApuestaCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApuestaCierreActionPerformed(evt);
            }
        });

        ResultadoEntrada.setText("Ingreso de Resultados");
        ResultadoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultadoEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiquetaTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(ApuestaEntrada)
                .addGap(47, 47, 47)
                .addComponent(ApuestaCierre)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResultadoEntrada)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(etiquetaTitulo)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApuestaEntrada)
                    .addComponent(ApuestaCierre))
                .addGap(18, 18, 18)
                .addComponent(ResultadoEntrada)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApuestaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApuestaEntradaActionPerformed
        // TODO add your handling code here:


        try{
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Opciones para el ingreso de Apuestas:" +
                    "\n1. Ingreso de apuesta(s) por medio de un archivo de texto." +
                    "\n2. Ingreso de apuesta(s) manualmente.", "Hipodromo", JOptionPane.INFORMATION_MESSAGE));

            switch (opcion){
                case 1:
                    new FrameCarga(this, true).setVisible(true);
                    break;

                case 2:
                    new FrameIngresoApuesta(this, true).setVisible(true);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e){

        }

    }//GEN-LAST:event_ApuestaEntradaActionPerformed

    private void ApuestaCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApuestaCierreActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cerrar las apuestas?" +
                "\n ya no podrá agregar más apuestas hasta que se obtengan los resultados de la carrera.");
        System.out.println(option);

        if(option == 0){
            Verificacion verificacion =new Verificacion(this.listaApuesta);
            Lista<Apuesta> rechazadas = verificacion.getRechazadas();
            if(!rechazadas.estaVacia()){
                GeneradorArchivo generadorArchivo = new GeneradorArchivo(rechazadas);
                try {
                    generadorArchivo.generarArchivo("Nombre,Monto,Puntos,1er lugar,2do lugar,3er lugar,4to lugar, 5to lugar" +
                            ",6to lugar,7mo lugar,8vo lugar,9no lugar,10mo lugar");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            this.ApuestaEntrada.setEnabled(false);
            this.ApuestaEntrada.setToolTipText("Apuestas temporalmente bloqueadas.");
        }
    }//GEN-LAST:event_ApuestaCierreActionPerformed

    private void ResultadoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultadoEntradaActionPerformed
        // TODO add your handling code here:
        new FrameResultados(this, true).setVisible(true);


        if(this.resultado != null && !this.listaApuesta.estaVacia()){
            Calculador.calcularPunteo(this.listaApuesta.getPrimerNodo(), this.resultado);
            new Ordenamiento(this.listaApuesta, this.orden).ordenar();
            try {
                new GeneradorArchivo(this.listaApuesta).generarArchivo("Nombre,Monto,Puntos,1er lugar,2do lugar,3er lugar,4to lugar, 5to lugar" +
                        ",6to lugar,7mo lugar,8vo lugar,9no lugar,10mo lugar");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.ApuestaEntrada.setEnabled(true);
        this.ApuestaEntrada.setToolTipText("");
        this.listaApuesta.vaciarLista();

    }//GEN-LAST:event_ResultadoEntradaActionPerformed

    public Lista<Apuesta> getListaApuesta(){
        return this.listaApuesta;
    }

    public Resultado getResultado(){
        return this.resultado;
    }

    public void setResultado(Resultado resultado){
        this.resultado = resultado;
    }

    public void setOrden(Orden orden){
        this.orden = orden;
    }

    public Orden getOrden(){
        return this.orden;
    }

    private Lista<Apuesta> listaApuesta;
    private Resultado resultado;
    private Orden orden;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApuestaCierre;
    private javax.swing.JButton ApuestaEntrada;
    private javax.swing.JButton ResultadoEntrada;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
