package com.mycompany.ad_proyecto_u1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Roi
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    private File usuarios = new File("usuarios.txt");
    private File registro = new File("registro.txt");
    public List<Personaje> buscados;
    public List<Personaje> total;
    private SimpsonFrame view;
    
    public Usuario(String nombre, String contraseña) throws IOException{
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.buscados = new ArrayList<>();
        this.total = UtilidadesGson.leerApi();
        DesserializarLista();
        DesserializarBusqueda();
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(registro))){
            bw.write(usuario + ":" + resultado);
            bw.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
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


    private void SerializarBusqueda() {

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

      private List DesserializarBusqueda() {
        File file= new File(nombre+".src");
        if (file.exists()) {
             try (FileInputStream fis = new FileInputStream(nombre+".src"); 
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            this.buscados = (ArrayList<Personaje>) ois.readObject();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return buscados;
        }
        return null;
       
    }
    
    private void SerializarLista() {
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

    private List  DesserializarLista() {
        File file= new File(nombre+".list");
        ArrayList<Personaje> total = null;
        if (file.exists()) {
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
        return null;
        
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
            System.out.println("ID ya existente");
        }
        else{
       total.add(p);
       SerializarLista();
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
            // x.mostrarUsuario();
              buscados.add(x);
              SerializarBusqueda();
            return x;
          
        } else {
            System.out.println("Usuario no encontrado");
            JOptionPane.showMessageDialog(view,"Este nombre no existe o está mal escrito");
            return null;
        }
    }
    
    public void delUsuario(String nombre){
        int contador=0;
        nombre= nombre.toUpperCase();
        Personaje x= new Personaje();
        for(Personaje per:total){
            if (per.getName().toUpperCase().equals(nombre)) {
                x=per;
                contador++;
            }
        }
        if (contador>0) {
            x.mostrarUsuario();
            total.remove(x);
            SerializarLista();
        }
        System.out.println(contador);
    }
}
