
package com.mycompany.ad_proyecto_u1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpsonController {
    
    private SimpsonFrame view;

    public SimpsonController(SimpsonFrame view) {
        this.view = view;
        this.view.addBuscarActionListener(this.getBuscarActionListener());
        this.view.addIniciarSesionActionListener(this.getIniciarSesionActionListener());
        this.view.addCrearCuenta(this.getCrearCuentaActionListener());
        this.view.addRegistrarseActionListener(this.getRegistrarseActionListener());
        this.view.addAccederActionListener(this.getAccederActionListener());
        this.view.addOcultarButonActionListener(this.getOcultarActionListener());
        this.view.initComponentes();
    
    }
    
    
    public ActionListener getBuscarActionListener(){
       
    ActionListener al = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {

            
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
    
    
    
}
