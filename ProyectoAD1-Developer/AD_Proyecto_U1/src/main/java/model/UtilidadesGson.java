/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class UtilidadesGson {
     public static List leerApi() throws MalformedURLException, IOException {
        List<Personaje>personajes= new ArrayList<>();
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
        api = gson.fromJson(datos, API.class);

        for (Personaje a : api.getResults()) {
            personajes.add(a);
        }
        return personajes;

    }
}
