package com.mycompany.ad_proyecto_u1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Roi
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    private File usuarios = new File("usuarios.txt");
    
    public Usuario(String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader(usuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2 && datos[0].equals(usuario) && datos[1].equals(contraseña)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registrarUsuario(String usuario, String contraseña) {
        if (usuario.isEmpty() || contraseña.isEmpty()){
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(usuarios, true))) {
            bw.write(usuario + "," + contraseña);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void guardarHistorial(String usuario, String resultado){
        //TODO BufferedWriter
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
