/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_proyecto_u1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    
    
    
    }
    private ActionListener getGuardarButton(){
    
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
               String nombre = view.getName();
                int id = view.getId();
                String trabajo = view.getTrabajo();
                String cumpleaños = view.getCumpleaños();
                int edad = view.getEdad();
                String frase = view.getPhrases();
                String genero =view.getGenero();
                
               Personaje p = Personaje.crearPersonaje(id,edad,cumpleaños,genero,nombre,null,List.of(frase),trabajo,null
);
                u.crearPersonaje(p);
                //System.out.println("Boton");
                view.dispose();
            }
    
    };
        return al;
}
}
