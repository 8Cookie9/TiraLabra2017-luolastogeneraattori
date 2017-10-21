package com.luolastogeneraattori.gui;

import com.luolastogeneraattori.Dungeon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class DungeonGUI implements Runnable{
    
    private JFrame frame;
    private Dungeon dungeon;
    public DungeonGUI(Dungeon d){
        this.dungeon=d;
    }
    
    @Override
    public void run() {
        this.frame = new JFrame("Dungeon");
        int i=800/((this.dungeon.getWidth() + this.dungeon.getHeight())/2);
        frame.setPreferredSize(new Dimension(this.dungeon.getWidth()*i ,this.dungeon.getHeight()*i));
        frame.setMinimumSize(new Dimension(100, 100));
        this.frame.setAlwaysOnTop(true);
        
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(this.dungeon.getHeight(),this.dungeon.getWidth());
        container.setLayout(layout);
        
        int[][] d = this.dungeon.getDungeon();
        
        for(int y=0; y<this.dungeon.getHeight(); y++){
            for(int x=0; x<this.dungeon.getWidth(); x++){
                JLabel box = new JLabel();
                if(d[x][y]==0){
                    box.setBorder(BorderFactory.createLineBorder(Color.white));
                    box.setBackground(Color.white);
                    box.setOpaque(true);
                }else{
                    box.setBorder(BorderFactory.createLineBorder(Color.black));
                    box.setBackground(Color.black);
                    box.setOpaque(true);
                }
                container.add(box);
            }
        }
        
    }
    
}
