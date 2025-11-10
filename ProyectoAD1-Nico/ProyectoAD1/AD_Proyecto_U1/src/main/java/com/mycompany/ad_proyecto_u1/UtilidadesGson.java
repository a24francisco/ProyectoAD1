/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class UtilidadesGson {
    public static API leerApi() throws MalformedURLException, IOException{

               // Se abre la conexión
            URL url = new URL("https://thesimpsonsapi.com/api/characters");
            URLConnection conexion = url.openConnection();
            conexion.connect();
            
            Gson gson = new Gson();
            API api;

            // Lectura
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String datos = br.readLine();
            api= gson.fromJson(datos, API.class);

        return api;

}
}
