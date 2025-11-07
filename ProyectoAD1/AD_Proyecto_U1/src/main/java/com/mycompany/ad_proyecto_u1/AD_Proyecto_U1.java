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

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class AD_Proyecto_U1 {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            // Se abre la conexión
            URL url = new URL("https://thesimpsonsapi.com/api/characters");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            // Lectura
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String datos = br.readLine();
            API api= gson.fromJson(datos, API.class);;
            System.out.println(api);
            

            //System.out.println(datos);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
