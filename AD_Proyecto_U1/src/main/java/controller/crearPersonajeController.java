/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import View.crearPersonajeJDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Personaje;
import model.Registro;
import model.Usuario;

/**
 *
 * @author dam2_alu11@inf.ald
 */
public class crearPersonajeController {
    
    crearPersonajeJDialog view;
    Usuario u;
    Registro r= new Registro();

    public crearPersonajeController(crearPersonajeJDialog view,Usuario u) {
    
    this.view = view;
    this.u=u;
    this.view.guardarButtonACtionListener(this.getGuardarButton());
    this.view.cancelarButtonACtionListener(this.getCancelarButton());
    
    
    
    }
    private ActionListener getGuardarButton(){
    
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              try{
                String nombre = view.getName();
                int id = view.getId();
                String trabajo = view.getTrabajo();
                String cumpleaños = view.getCumpleaños();
                int edad = view.getEdad();
                String frase = view.getPhrases();
                String genero =view.getGenero();
                  if (nombre.isEmpty()) {
                      JOptionPane.showMessageDialog(view, "Complete el nombre");
                      return;
                  }
               Personaje p = Personaje.crearPersonaje(id,edad,cumpleaños,genero,nombre,null,List.of(frase),trabajo,null);
                  if (u.crearPersonaje(p)) {
                      JOptionPane.showMessageDialog(view, "Personaje creado correctamente");
                      view.dispose();
                  }
                  else{
                       JOptionPane.showMessageDialog(view, "El id ya existe");
                  }
                    
                
              }
             catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(view, "La edad o el id no puede contener letras");
                    }
                }
               
               
            
    
    };
        return al;
}
    
    public ActionListener getCancelarButton(){
        ActionListener al= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        };
        return al;
    }
}
