package com.mycompany.ad_proyecto_u1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class Personaje  implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private int age;
    
    private String birthday;
    private String gender;
    private String name;
    private String occupation;
    private String portrait_path;
    private List<String> phrases;
    private String status;

    @Override
    public String toString() {
        return " id=" + id + ", name=" + name+", age=" + age + ", birthday=" + birthday + ", gender=" + gender +   ", occupation=" + occupation  + ", phrases=" + phrases + ", status=" + status + '}';
    }

    public void mostrarUsuario(){
         
        System.out.println(" Nombre: " + name);
        System.out.println(" ID: " + id);
        System.out.println(" Edad: " + age + " (" + birthday + ")");
        System.out.println("️ Género: " + gender);
        System.out.println(" Ocupación: " + occupation);
        System.out.println(" Imagen: " + portrait_path);
        System.out.println(" Frases: " + genFraseAleatoria());
        System.out.println(" Estado: " + status);
    }

    public  static Personaje crearPersonaje(int id, int age, String birthday, String gender, String name, String portrait_path, List<String> phrases,String occupation, String status) {
        Personaje p= new Personaje();
        p.id = id;
        p.age = age;
        p.birthday = birthday;
        p.gender = gender;
        p.name = name;
        p.occupation = occupation;
        p.portrait_path = portrait_path;
        p.phrases = phrases;
       
        p.status = status;
        return p;
    }
    
    public  String genFraseAleatoria(){
        Random r= new Random();
        int n= r.nextInt(0,phrases.size()-1);
        return phrases.get(n);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPortrait_path() {
        return portrait_path;
    }

    public void setPortrait_path(String portrait_path) {
        this.portrait_path = portrait_path;
    }

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {
        this.phrases = phrases;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}