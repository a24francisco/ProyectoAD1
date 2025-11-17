/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ad_proyecto_u1;

/**
 *
 * @author Nico
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {

   private Image backgroundImage;

    public PanelConFondo(String path) {
        backgroundImage = new ImageIcon(path).getImage();
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); // si quieres posiciones absolutas
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo escalada al tamaño del panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

