/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_proyecto_u1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class AD_Proyecto_U1 {

    public static void main(String[] args) {
        try {
            SimpsonFrame smf = new SimpsonFrame();
            SimpsonController smc = new SimpsonController(smf);
            smf.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(AD_Proyecto_U1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
