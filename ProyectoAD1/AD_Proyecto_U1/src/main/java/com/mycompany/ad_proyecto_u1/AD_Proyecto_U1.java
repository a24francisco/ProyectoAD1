/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_proyecto_u1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class AD_Proyecto_U1 {

    public static void main(String[] args) {
        try {
            List<Personaje> lista = UtilidadesGson.listarPersonajes(UtilidadesGson.leerApi());
            Usuario u = new Usuario("Invitado", " ");
            //u.añadirListado(UtilidadesGson.filtrarNombre("Bart Simpson",lista));
           

            u.crearPersonaje(1,35,"12 de mayo de 1990","Masculino","Ezequiel Vargas","imagenes/ezequiel.png",Arrays.asList("Nunca es tarde para aprender.", "El conocimiento es poder."),"Ingeniero de software","Activo");
            u.crearPersonaje(p);
            
            u.añadirListado(p);
            System.out.println("Serializar");
            u.SerializarLista(u.getNombre());
            
            //u.añadirListado(UtilidadesGson.filtrarID(8, lista));
            System.out.println("Desserializar");
            u.DesserializarLista(u.getNombre());

            /*  System.out.println("");
            u.mostrarLista();
            System.out.println("");*/
        } catch (IOException ex) {
            Logger.getLogger(AD_Proyecto_U1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
