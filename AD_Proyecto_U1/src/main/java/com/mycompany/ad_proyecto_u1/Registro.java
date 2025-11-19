/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_proyecto_u1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frana
 */
public class Registro {

    List<Usuario> regUser = new ArrayList<>();

    private File registro = new File("registro.txt");

    public Registro() {
        cargarUsuariosCreados();
    }

    public void addUser(Usuario u) {
        regUser.add(u);
    }

    public Usuario validarUsuario(String nombre, String contraseña) {

        try (BufferedReader br = new BufferedReader(new FileReader(registro))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2 && datos[0].equals(nombre) && datos[1].equals(contraseña)) {
                    return new Usuario(nombre, contraseña);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
     public boolean validarUsuarioRepetido(String nombre) {

        try (BufferedReader br = new BufferedReader(new FileReader(registro))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if ( datos[0].equals(nombre)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void guardarHistorial() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(registro))) {
            for (Usuario user : regUser) {
                bw.write(user.getNombre() + "," + user.getContraseña());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarUsuariosCreados() {
        try (BufferedReader br = new BufferedReader(new FileReader(registro))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre=datos[0];
                String contraseña=datos[1];
                if (datos.length == 2) {
                    Usuario u= new Usuario(nombre, contraseña);
                    regUser.add(u);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
