/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_proyecto_u1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String contraseña;
    public List<Personaje> buscados;
    public List<Personaje> total;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.buscados = new ArrayList<>();
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

    public void añadirListado(Personaje p) {
        buscados.add(p);
    }

    public void mostrarLista() {
        for (Personaje p : buscados) {
            System.out.println(p);
        }
    }

    public void SerializarBusqueda(String nombre) {

        try {
            FileOutputStream fos = new FileOutputStream(nombre);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buscados);

            oos.close();

            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DesserializarBusqueda(String nombre) {
        ArrayList<Personaje> busqueda = null;

        try (FileInputStream fis = new FileInputStream(nombre); 
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            busqueda = (ArrayList) ois.readObject();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        
            
        

    }
    public void SerializarLista(String nombre) {

        try {
            FileOutputStream fos = new FileOutputStream(nombre+".list");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buscados);

            oos.close();

            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DesserializarLista(String nombre) {
        ArrayList<Personaje> busqueda = null;

        try (FileInputStream fis = new FileInputStream(nombre+".list"); 
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            busqueda = (ArrayList) ois.readObject();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        
            
        

    }
    
    public void crearPersonaje(Personaje p){
        
        int contador=0;
        for (int i = 0; i < buscados.size()-1; i++) {
            if (buscados.get(i).getId()==p.getId()) {
                contador++;
            }
           
        }
        if (contador<0) {
            System.out.println("ID ya existenete");
        }
        else{
       total.add(p);
        }
    }

}
