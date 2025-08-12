/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.modelo;
import vista.VISTA;

/**
 *
 * @author user
 */
public class Controlador implements ActionListener{

    private VISTA view;
    private modelo model;
    int numeroA = 0, numeroB = 0;
    
    public void escribiLog(String line){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        try(              
            FileWriter fw = new FileWriter("log/mateProLog.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)
            ){
                out.println("=> "+line+" -> "+dtf.format(LocalDateTime.now()));                
        } catch (IOException e) {
            System.out.println("no se puedo escribir en el log: " + e);                
        }
    }
    
    public void generaNumero(){
        int randomA, randomB;
        Random numero = new Random();
        randomA = numero.nextInt(10);
        String numRandomA = Integer.toString(randomA);
        randomB = numero.nextInt(10);
        String numRandomB = Integer.toString(randomB);
        System.out.println("numRandomA: "+numRandomA);
        System.out.println("numRandomB: "+numRandomB);
        
        switch (numRandomA) {
            case "0":
                view.lbl_A_N0.setVisible(true);
                numeroA = 0;
                break;
            case "1":
                view.lbl_A_N1.setVisible(true);
                numeroA = 1;
                break;
            case "2":
                view.lbl_A_N2.setVisible(true);
                numeroA = 2;
                break;
            case "3":
                view.lbl_A_N3.setVisible(true);
                numeroA = 3;
                break;
            case "4":
                view.lbl_A_N4.setVisible(true);
                numeroA = 4;
                break;
            case "5":
                view.lbl_A_N5.setVisible(true);
                numeroA = 5;
                break;
            case "6":
                view.lbl_A_N6.setVisible(true);
                numeroA = 6;
                break;
            case "7":
                view.lbl_A_N7.setVisible(true);
                numeroA = 7;
                break;
            case "8":
                view.lbl_A_N8.setVisible(true);
                numeroA = 8;
                break;
            case "9":
                view.lbl_A_N9.setVisible(true);
                numeroA = 9;
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es un numero entre 0 y 9", "ERROR EN GENERACIÓN DE RANDOM A", JOptionPane.ERROR_MESSAGE);
        }
        switch (numRandomB) {
            case "0":
                view.lbl_B_N0.setVisible(true);
                numeroB = 0;
                break;
            case "1":
                view.lbl_B_N1.setVisible(true);
                numeroB = 1;
                break;
            case "2":
                view.lbl_B_N2.setVisible(true);
                numeroB = 2;
                break;
            case "3":
                view.lbl_B_N3.setVisible(true);
                numeroB = 3;
                break;
            case "4":
                view.lbl_B_N4.setVisible(true);
                numeroB = 4;
                break;
            case "5":
                view.lbl_B_N5.setVisible(true);
                numeroB = 5;
                break;
            case "6":
                view.lbl_B_N6.setVisible(true);
                numeroB = 6;
                break;
            case "7":
                view.lbl_B_N7.setVisible(true);
                numeroB = 7;
                break;
            case "8":
                view.lbl_B_N8.setVisible(true);
                numeroB = 8;
                break;
            case "9":
                view.lbl_B_N9.setVisible(true);
                numeroB = 9;
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es un numero entre 0 y 9", "ERROR EN GENERACIÓN DE RANDOM B", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Controlador(VISTA view, modelo model){
        
        this.view = view;
        this.model = model;
        this.view.btnMultiplicar.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("Mate PRO");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        generaNumero();
    }
    
    public void actionPerformed(ActionEvent e){
        model.setNumUno(numeroA);
        model.setNumDos(numeroB);
        model.multiplicar();
        view.txtResultado.setText(String.valueOf(model.getResultado()));
    }

    public void mensaje(){
        JOptionPane.showMessageDialog(null,"las credenciales no coinciden!","INGRESO AL SISTEMA",JOptionPane.ERROR_MESSAGE);            
    }
        
}
