package com.luolastogeneraattori.gui;

import com.luolastogeneraattori.Dungeon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeListener;
import javafx.scene.input.MouseEvent;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GUI implements Runnable{
    private JFrame frame;
    private DungeonGUI dGUI;
    
    public GUI(){
        this.dGUI=new DungeonGUI(new Dungeon(50,50));
    }

    @Override
    public void run() {
        frame = new JFrame("Dungeon Generator");
        frame.setPreferredSize(new Dimension(600 ,300));
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponentsMain(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponentsMain(Container container){
        GridLayout layout = new GridLayout(6,3);
        container.setLayout(layout);
        JTextField width = new JTextField("100");
        JTextField height = new JTextField("100");
        JTextField min = new JTextField("6");
        JTextField max = new JTextField("30");
        JTextField splitChance = new JTextField("70");
        JTextField splitDirection = new JTextField("1.3");
        JButton generate = new JButton("Generate");
        generate.addActionListener((ActionEvent e) -> {
            if(this.validate(width.getText(), height.getText(), min.getText(), max.getText(), splitChance.getText(), splitDirection.getText())){
                Dungeon d=new Dungeon(Integer.parseInt(width.getText()),Integer.parseInt(height.getText()),Integer.parseInt(min.getText())+2,Integer.parseInt(max.getText())+2,Integer.parseInt(splitChance.getText()),Double.parseDouble(splitDirection.getText()));
                d.createDungeon();
                SwingUtilities.invokeLater(new DungeonGUI(d));
            }else{
                JOptionPane.showMessageDialog(container, "Invalid values");
            }
        });
        container.add(new JLabel("Width"));
        container.add(new JLabel("Height"));
        container.add(new JLabel("Chance to split (%)"));
        
        container.add(width);
        container.add(height);
        container.add(splitChance);
        
        container.add(new JLabel("Minimum room size (min. 2)"));
        container.add(new JLabel("Maximum room size"));
        container.add(new JLabel("Randomness of the split direction"));
        
        container.add(min);
        container.add(max);
        container.add(splitDirection);
        
        container.add(new JLabel());
        container.add(new JLabel());
        container.add(new JLabel());
        
        container.add(new JLabel());
        container.add(generate);
        container.add(new JLabel());
    }
    
    private boolean validate(String width, String height, String minSize, String maxSize, String splitChance, String splitDirection){
        try{
            int w = Integer.parseInt(width);
            int h = Integer.parseInt(height);
            int min = Integer.parseInt(minSize)+2;
            int max = Integer.parseInt(maxSize)+2;
            int chance = Integer.parseInt(splitChance);
            double dir = Double.parseDouble(splitDirection);
            if(w<10 || w>300){
                return false;
            }else if(h<10 || h>300){
                return false;
            }else if(min<4){
                return false;
            }else if(max<min){
                return false;
            }else if(chance<0){
                return false;
            }else if(dir<0){
                return false;
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
