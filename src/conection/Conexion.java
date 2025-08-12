/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import controlador.Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import modelo.modelo;
import vista.VISTA;

/**
 *
 * @author leoxi
 */
public class Conexion {
    Connection Conect = null;
    modelo model = new modelo();
    VISTA view = new vista.VISTA();
    Controlador ctrl = new Controlador(view, model);
    public Connection conectar(){
        try{
            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Conect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/mvc","root","");
//                JOptionPane.showMessageDialog(null, "conectado a la Base de Datos !!!");
                ctrl.escribiLog("Conexion establecida");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"ERROR EN CONEXIÓN A DB",JOptionPane.ERROR_MESSAGE);
        }
        return Conect;
    }
}
