/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_proyecto_u1;

import java.util.List;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class API {
    private int count;
    private String next;
    private String prev;
    private int pages=60;
    private List<Personaje> results;

    public API(int count, String next, String prev) {
        this.count = count;
        this.next = next;
        this.prev = prev;
        
    }

    @Override
    public String toString() {
        return "API{" + "count=" + count + ", next=" + next + ", prev=" + prev + ", pages=" + pages + ", results=" + results + '}';
    }
    
    
}
