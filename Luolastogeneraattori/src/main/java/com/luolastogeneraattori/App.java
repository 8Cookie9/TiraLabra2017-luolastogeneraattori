package com.luolastogeneraattori;

public class App {

    public static void main(String[] args) {
        System.out.println(new Random().newBoolean(50));
        Dungeon dungeon = new Dungeon(10,10);
        long aikaAlussa = System.nanoTime();
        dungeon.createLeafs();
        long aikaLopussa = System.nanoTime();
        System.out.println("CreateLeafs(): " + (aikaLopussa - aikaAlussa) + "ns.");
        
        aikaAlussa = System.nanoTime();
        dungeon.getLeafs().get(0).createRooms();
        aikaLopussa = System.nanoTime();
        System.out.println("CreateRooms: " + (aikaLopussa - aikaAlussa) + "ns.");
//        System.out.println("Leaf (x, y) : (x+width, y+height) :::: Room (x, y) : (x+width, y+height)");
//        for(Leaf leaf:dungeon.getLeafs()){
//            if(leaf.room()!=null){
//                System.out.println("("+leaf.getX()+", "+leaf.getY()+") : ("+(leaf.getX()+leaf.getWidth())+", "+(leaf.getY()+leaf.getHeight())+")"+" :::: "+"("+leaf.room().getX()+", "+leaf.room().getY()+") : ("+(leaf.room().getX()+leaf.room().getWidth())+", "+(leaf.room().getY()+leaf.room().getHeight())+")");
//            }
//        }
        
        System.out.println(dungeon);
    }
}
