package com.luolastogeneraattori.gui;

import com.luolastogeneraattori.Dungeon;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI implements Runnable{
    private JFrame frame;
    private Dungeon dungeon;
    
    public GUI(Dungeon dungeon){
        this.dungeon = dungeon;
    }

    @Override
    public void run() {
        frame = new JFrame("Dungeon");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int i=(Math.min((int) screenSize.getWidth(), (int) screenSize.getHeight())*2/3)/Math.max(this.dungeon.getWidth(), this.dungeon.getHeight());
        frame.setPreferredSize(new Dimension((this.dungeon.getWidth()*i), (this.dungeon.getHeight()*i)));
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(this.dungeon.getWidth(),this.dungeon.getHeight());
        container.setLayout(layout);
        
        int[][] d = this.dungeon.getDungeon();
        
        for(int x=0; x<this.dungeon.getWidth(); x++){
            for(int y=0; y<this.dungeon.getHeight(); y++){
                container.add(new Rectangle(100,100,d[x][y]==1));
            }
        }
    }
}
