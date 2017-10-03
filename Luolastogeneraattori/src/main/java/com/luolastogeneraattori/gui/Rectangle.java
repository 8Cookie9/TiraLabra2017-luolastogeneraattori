package com.luolastogeneraattori.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Rectangle extends JPanel{
    private int width;
    private int height;
    private boolean black;
    public Rectangle(int width, int height, boolean black){
        this.width=width;
        this.height=height;
        this.black=black;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.black){
            g.setColor(Color.black);
        }else{
            g.setColor(Color.white);
        }
        g.fillRect(0, 0, this.width, this.height);
    }
      
}
