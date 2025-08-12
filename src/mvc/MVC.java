/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controlador.Controlador;
import modelo.modelo;
import vista.VISTA;

/**
 *
 * @author user
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        modelo model = new modelo();
        VISTA view = new vista.VISTA();
        
        Controlador ctrl = new Controlador(view, model);
        ctrl.iniciar();
    }
    
}
