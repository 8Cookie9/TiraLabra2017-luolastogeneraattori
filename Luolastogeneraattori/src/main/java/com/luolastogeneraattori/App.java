package com.luolastogeneraattori;

import com.luolastogeneraattori.gui.GUI;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
//        Dungeon dungeon = new Dungeon(100,100);
//        
//        long sum=0;
//        long min=10000000;
//        long max=0;
//        List<Long> res=new List<>();
//        for(int i=0;i<10000;i++){
//            long aikaAlussa = System.nanoTime();
//            dungeon.createDungeon();
//            long aikaLopussa = System.nanoTime();
//            System.out.println((aikaLopussa - aikaAlussa) + "ns.");
//            sum+=(aikaLopussa - aikaAlussa);
//            min=Math.min(min, (aikaLopussa - aikaAlussa));
//            max=Math.max(max, (aikaLopussa - aikaAlussa));
//            res.add((aikaLopussa - aikaAlussa));
//        }
//        double mean=sum/10000;
//        
//        System.out.println("Keskiarvo: "+mean);
//        System.out.println("Minimi: "+min);
//        System.out.println("Maksimi: "+max);
        
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
    }
}
