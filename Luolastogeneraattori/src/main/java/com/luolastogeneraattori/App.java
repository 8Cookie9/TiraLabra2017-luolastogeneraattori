package com.luolastogeneraattori;

import com.luolastogeneraattori.gui.GUI;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Luolaston leveys: ");
        int w = Integer.parseInt(scanner.nextLine());
        System.out.print("Luolaston korkeus: ");
        int h = Integer.parseInt(scanner.nextLine());
        
        Dungeon dungeon = new Dungeon(w,h);
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
