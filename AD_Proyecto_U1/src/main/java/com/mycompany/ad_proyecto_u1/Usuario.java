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

    public Usuario(String nombre, String contraseña) throws IOException {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.buscados = new ArrayList<>();
        this.total = UtilidadesGson.leerApi();
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

  

    public void mostrarListaBuscados() {
        for (Personaje p : buscados) {
            System.out.println(p);
        }
    }
     public void mostrarListaTotal() {
        for (Personaje p : total) {
            System.out.println(p);
        }
    }


    public void SerializarBusqueda() {

        try {
            FileOutputStream fos = new FileOutputStream(nombre+".src");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buscados);

            oos.close();

            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List DesserializarBusqueda() {
        ArrayList<Personaje> busqueda = null;

        try (FileInputStream fis = new FileInputStream(nombre+".src"); 
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            this.buscados = (ArrayList<Personaje>) ois.readObject();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return busqueda;
        
            
        

    }
    public void SerializarLista() {

        try {
            FileOutputStream fos = new FileOutputStream(nombre+".list");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(total);

            oos.close();

            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List  DesserializarLista() {
        ArrayList<Personaje> total = null;

        try (FileInputStream fis = new FileInputStream(nombre+".list"); 
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            this.total = (ArrayList<Personaje>) ois.readObject();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return total;
        
            
        

    }
    
    public void crearPersonaje(Personaje p){
        if (p==null){return;}
        
        int contador=0;
        for (int i = 0; i < total.size(); i++) {
            if (total.get(i).getId()==p.getId()) {
                contador++;
            }
           
        }
        if (contador>0) {
            System.out.println("ID ya existenete");
        }
        else{
       total.add(p);
        }
    }
    public  Personaje filtrarNombre(String nombre) {
        int contador = 0;
        Personaje x = new Personaje();
        nombre=nombre.toUpperCase();
        for (Personaje p : total) {
            if (nombre.equals(p.getName().toUpperCase())) {
                x = p;
                contador++;

            }

        }
        if (contador > 0) {
             x.mostrarUsuario();
              buscados.add(x);
            return x;
          
        } else {
            System.out.println("Usuario no encontrado");
            return null;
        }

    }

}
