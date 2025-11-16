
package com.mycompany.ad_proyecto_u1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;



public class SimpsonController {
    
    private SimpsonFrame view;
    private Usuario u ;

    public SimpsonController(SimpsonFrame view) throws IOException {
        this.view = view;
        this.view.addBuscarActionListener(this.getBuscarActionListener());
        this.view.addIniciarSesionActionListener(this.getIniciarSesionActionListener());
        this.view.addCrearCuenta(this.getCrearCuentaActionListener());
        this.view.addRegistrarseActionListener(this.getRegistrarseActionListener());
        this.view.addAccederActionListener(this.getAccederActionListener());
        this.view.addOcultarActionListener(this.getOcultarActionListener());
        this.view.addCrearPersonajeActionListener(this.getCrearPersonajeActionListener());
        this.view.initComponentes();
        u = new Usuario("Nico","ABC"); 
    
    }
    
    
    public ActionListener getBuscarActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String nombre = view.getNombre();
            System.out.println(nombre);
            Personaje p = u.filtrarNombre(nombre);
           
           
            view.setID(p.getId());
            view.setEdad(p.getAge());
            view.setCumpleanhos(p.getBirthday());
            view.setTrabajo(p.getOccupation());
            view.setGenero(p.getGender());
            view.setFrase(p.genFraseAleatoria());
            System.out.println(p.getBirthday());
            
            if(!nombre.equals(p.getName())){
            
                JOptionPane.showMessageDialog(view,"El nombre en cuestión no existe");
            }
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
        
        
        }
    };
        return al;
    }
        public ActionListener getRegistrarseActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        
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
            crearPersonajeController cpc = new crearPersonajeController(cpd);
            cpd.setVisible(true);
        }
    };
        return al;
    }     
    
    
    
}
