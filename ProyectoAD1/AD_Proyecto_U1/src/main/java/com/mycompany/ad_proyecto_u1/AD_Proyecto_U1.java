/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_proyecto_u1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author dam2_alu01@inf.ald
 */
public class AD_Proyecto_U1 {

    public static void main(String[] args) throws IOException {
        Usuario u = new Usuario("Invitado", " ");
        
        Personaje p= Personaje.crearPersonaje( 101,                   
    30,                           
    "12 de mayo de 1995",         
    "Masculino",                  
    "Ezequiel Vargas",             
    "imagenes/ezequiel.png",       
     Arrays.asList("Nunca es tarde para aprender.", "El conocimiento es poder."),                        
    "Ingeniero de software",       
    "Activo"                       );
        
        
        u.crearPersonaje(p);
        u.filtrarNombre("Homer SImpson");
        
        
        
        u.filtrarNombre("Bart Simpson");
       
        u.mostrarListaBuscados();
        
        
        
        
        
        
        
    
       
        
        
    }
    
}
