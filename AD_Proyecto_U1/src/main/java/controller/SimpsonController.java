package controller;


import com.mycompany.ad_proyecto_u1.SimpsonFrame;

import com.mycompany.ad_proyecto_u1.crearPersonajeJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Personaje;
import model.Registro;
import model.Usuario;

public class SimpsonController {

    private SimpsonFrame view;
    private Usuario u;
    public Registro r = new Registro();

    public SimpsonController(SimpsonFrame view) throws IOException {
        this.view = view;
        u = new Usuario("invitado", "");
        this.view.addBuscarActionListener(this.getBuscarActionListener());
        this.view.addIniciarSesionActionListener(this.getIniciarSesionActionListener());
        this.view.addCrearCuenta(this.getCrearCuentaActionListener());
        this.view.addRegistrarseActionListener(this.getRegistrarseActionListener());
        this.view.addAccederActionListener(this.getAccederActionListener());
        this.view.addOcultarActionListener(this.getOcultarActionListener());
        this.view.addCrearPersonajeActionListener(this.getCrearPersonajeActionListener());
        this.view.addBorrarPersonajeActionListener(this.getBorrarActionListener());
        this.view.addEditarPersonajeActionListener(this.getEditarButtonActionListener());
        this.view.initComponentes();

    }

    public ActionListener getBorrarActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getUsuarioActivoLabel().equals("INVITADO")) {

                    JOptionPane.showMessageDialog(view, "El invitado no puede acceder a la función de Borrar Personaje");
                } else {
                    String nombre = view.getNombre();
                    u.delUsuario(nombre);

                    view.setName("");
                    view.clearID();
                    view.setCumpleanhos("");
                    view.setGenero("");
                    view.clearEdad();
                    view.setFrase("");
                    view.setTrabajo("");

                }
            }
        };
        return al;

    }

    public ActionListener getBuscarActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String nombre = view.getNombre();
                System.out.println(nombre);
                Personaje p = u.filtrarNombre(nombre);
                if (p.getPhrases().size() > 1) {
                    view.setID(p.getId());
                    view.setEdad(p.getAge());
                    view.setCumpleanhos(p.getBirthday());
                    view.setTrabajo(p.getOccupation());
                    view.setGenero(p.getGender());
                    view.setFrase(p.genFraseAleatoria());
                    view.bloquearCampoId();
                } else {
                    view.setID(p.getId());
                    view.setEdad(p.getAge());
                    view.setCumpleanhos(p.getBirthday());
                    view.setTrabajo(p.getOccupation());
                    view.setGenero(p.getGender());
                    view.setFrase(p.getPhrases().get(0));
                    view.bloquearCampoId();
                }
            }
        };
        return al;
    }

    public ActionListener getIniciarSesionActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisibleButtonInicioSesion(true);
                view.setVisibleButtonCrearCuenta(false);

            }
        };
        return al;
    }

    public ActionListener getCrearCuentaActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisibleButtonCrearCuenta(true);
                view.setVisibleButtonInicioSesion(false);
            }
        };
        return al;
    }

    public ActionListener getAccederActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Usuario val = r.validarUsuario(view.getUsuarioIniciarTextField(), view.getContraseñaIniciarTextField());
                if (val != null) {
                    u = val;
                    view.setUsuarioActivoLabel(view.getUsuarioIniciarTextField());
                    System.out.println("Sesion iniciada correctamente");
                } else {
                    JOptionPane.showMessageDialog(view, "Credenciales incorrectas");
                }

            }
        };
        return al;
    }

    public ActionListener getRegistrarseActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = view.getUsuarioRegistroTextField();
                String contraseña = view.getContraseñaRegistroTextField();
                if (r.validarUsuarioRepetido(nombre)) {
                    JOptionPane.showMessageDialog(view, "Usuario ya existente");
                } else {
                    try {
                        u = new Usuario(nombre, contraseña);
                        r.addUser(u);
                        r.guardarHistorial();
                    } catch (IOException ex) {
                        Logger.getLogger(SimpsonController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JOptionPane.showMessageDialog(view, "Usuario registrado correctamente");

                }
            }
        };
        return al;
    }

    public ActionListener getOcultarActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                view.initComponentes();
            }
        };
        return al;
    }

    public ActionListener getCrearPersonajeActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (view.getUsuarioActivoLabel().equals("INVITADO")) {

                    JOptionPane.showMessageDialog(view, "El invitado no puede acceder a la función de Crear Personaje");
                } else {

                    crearPersonajeJDialog cpd = new crearPersonajeJDialog(view, true);
                    crearPersonajeController cpc = new crearPersonajeController(cpd, u);
                    cpd.setVisible(true);
                }

            }
        };
        return al;
    }

    public ActionListener getEditarButtonActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (view.getUsuarioActivoLabel().equals("INVITADO")) {

                    JOptionPane.showMessageDialog(view, "El invitado no puede acceder a la función de Editar Personaje");
                } else {
                    try {
                        String nombre = view.getNombre();

                        int edad = Integer.parseInt(view.getEdad());

                        String cumple = view.getCumpleaños();
                        String trabajo = view.getTrabajo();
                        String genero = view.getGenero();
                        String frase = view.getFrase();
                        u.delUsuario(nombre);
                        Personaje x = Personaje.crearPersonaje(Integer.parseInt(view.getId()), edad, cumple, genero, nombre, null, List.of(frase), trabajo, null);
                        u.crearPersonaje(x);
                    }catch(NullPointerException e){
                         JOptionPane.showMessageDialog(view, "El usuario no existe");
                    } 
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(view, "La edad no puede contener letras");

                    }

                }
            }
        };
        return al;
    }

}
