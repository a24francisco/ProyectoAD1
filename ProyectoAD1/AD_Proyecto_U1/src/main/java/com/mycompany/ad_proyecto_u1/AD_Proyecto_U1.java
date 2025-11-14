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
        Usuario us = new Usuario("Invitadsssso", " ");
                 Personaje p1 = Personaje.crearPersonaje(
    201,                             // id
    27,                              // age
    "15 de agosto de 1997",          // birthday
    "Femenino",                      // gender
    "Lucia Fernandez",               // name
    "imagenes/lucia.png",            // portrait_path
    Arrays.asList(                   // phrases
        "Siempre hay una solución.",
        "La paciencia es poder.",
        "No temas avanzar lento, teme no avanzar."
    ),
    "Analista de datos",             // occupation
    "Activo"                         // status
);     
      
     
        us.mostrarListaBuscados();
        us.mostrarListaTotal();
        
        
        
        
        
    
       
        
        
    }
    
}
