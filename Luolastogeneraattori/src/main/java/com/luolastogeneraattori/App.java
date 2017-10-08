package com.luolastogeneraattori;

import com.luolastogeneraattori.gui.GUI;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int w;
        int h;
        int min;
        int max;
        System.out.println("Syötä arvot luolaston eri ominaisuuksille. Väärä arvo korvataan automaattisesti oletusarvolla:");
        System.out.println("Leveys ja korkeus -- 50");
        System.out.println("Huoneen minimikoko -- 6");
        System.out.println("Huoneen maksimikoko -- 50");
        System.out.println("");
        try{
            System.out.print("Luolaston leveys (10-200): ");
            w = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            w = 50;
        }
        if(w<10 || w>200){
            w=50;
        }
        try{
            System.out.print("Luolaston korkeus (10-200): ");
            h = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            h = 50;
        }
        if(h<10 || h>200){
            h=50;
        }
        try{
            System.out.print("Huoneiden minimikoko (min 4): ");
            min = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            min = 6;
        }
        if(min<4 || min>Math.min(w, h)/5){
            w=6;
        }
        try{
            System.out.print("Huoneiden maksimikoko: ");
            max = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            max = Math.min(w, h)/4;
        }
        if(max<=min+3){
            max=50;
        }
        
        System.out.println(w+" "+h+" "+min+" "+max);
        
        Dungeon dungeon = new Dungeon(w,h,min,max);
//        long aikaAlussa = System.nanoTime();
//        dungeon.createLeafs();
//        long aikaLopussa = System.nanoTime();
//        System.out.println("CreateLeafs(): " + (aikaLopussa - aikaAlussa) + "ns.");
//        
//        aikaAlussa = System.nanoTime();
//        dungeon.getLeafs().get(0).createRooms();
//        aikaLopussa = System.nanoTime();
//        System.out.println("CreateRooms: " + (aikaLopussa - aikaAlussa) + "ns.");
//        
//        System.out.println(dungeon);
        dungeon.createLeafs();
        dungeon.getLeafs().get(0).createRooms();
        GUI gui = new GUI(dungeon);
        SwingUtilities.invokeLater(gui);
    }
}
