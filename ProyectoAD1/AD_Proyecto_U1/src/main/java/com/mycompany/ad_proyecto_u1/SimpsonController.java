
package com.mycompany.ad_proyecto_u1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class SimpsonController {
    
    private SimpsonFrame view;
    private Usuario u ;
    public Registro r= new Registro();

    public SimpsonController(SimpsonFrame view) throws IOException {
        this.view = view;
        u=new Usuario("invitado","");
        this.view.addBuscarActionListener(this.getBuscarActionListener());
        this.view.addIniciarSesionActionListener(this.getIniciarSesionActionListener());
        this.view.addCrearCuenta(this.getCrearCuentaActionListener());
        this.view.addRegistrarseActionListener(this.getRegistrarseActionListener());
        this.view.addAccederActionListener(this.getAccederActionListener());
        this.view.addOcultarActionListener(this.getOcultarActionListener());
        this.view.addCrearPersonajeActionListener(this.getCrearPersonajeActionListener());
        this.view.addBorrarPersonajeActionListener(this.getBorrarActionListener());
        this.view.initComponentes();
        
    
    }
    public ActionListener getBorrarActionListener(){
        ActionListener al= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= view.getNombre();
                u.delUsuario(nombre);
                System.out.println("eyy");
                view.setName("");
                view.setID(' ');
                view.setCumpleanhos("");
                view.setGenero("");
                view.setEdad(' ');
                view.setFrase("");
                view.setTrabajo("");
                
                
            }
            
        };
        return al;
        
    }
    
    public ActionListener getBuscarActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           //u=r.validarUsuario(u);
            String nombre = view.getNombre();
            System.out.println(nombre);
            Personaje p = u.filtrarNombre(nombre);
           
           
            view.setID(p.getId());
            view.setEdad(p.getAge());
            view.setCumpleanhos(p.getBirthday());
            view.setTrabajo(p.getOccupation());
            view.setGenero(p.getGender());
            view.setFrase(p.genFraseAleatoria());
           
            
          
        }
    };
        return al;
    }
   
    public ActionListener getIniciarSesionActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
        view.setVisibleButtonInicioSesion(true);
        view.setVisibleButtonCrearCuenta(false);  
            
        }
    };
        return al;
    }
    public ActionListener getCrearCuentaActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          view.setVisibleButtonCrearCuenta(true);  
          view.setVisibleButtonInicioSesion(false);
        }
    };
        return al;
    }
    public ActionListener getAccederActionListener(){

    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            Usuario val=r.validarUsuario(view.getUsuarioIniciarTextField(), view.getContraseñaIniciarTextField());
            if (val!=null) {
                 u=val;
                view.setUsuarioActivoLabel(view.getUsuarioIniciarTextField());
            System.out.println("Sesion iniciada correctamente");
            }
            else{
            }
 
        }
    };
        return al;
    }
  public ActionListener getRegistrarseActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            String nombre=view.getUsuarioRegistroTextField();
            String contraseña=view.getContraseñaRegistroTextField();
            try {
               u= new Usuario(nombre,contraseña);
               r.addUser(u);
               r.guardarHistorial();
            } catch (IOException ex) {
                Logger.getLogger(SimpsonController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
            
           
            System.out.println("Usuario registrado correctamente");
            
        }
    };
        return al;
    }
    
    
    
    public ActionListener getOcultarActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            view.initComponentes();
        }
    };
        return al;
    }
          
      public ActionListener getCrearPersonajeActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            crearPersonajeJDialog cpd = new crearPersonajeJDialog(view,true);
            crearPersonajeController cpc = new crearPersonajeController(cpd,u);
            cpd.setVisible(true);
        }
    };
        return al;
    }     
    
    
    
}
