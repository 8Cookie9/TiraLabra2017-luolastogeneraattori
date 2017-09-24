package com.luolastogeneraattori;

public class App {

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(40,40);
        dungeon.createLeafs();
        dungeon.getLeafs().get(0).createRooms();
        
//        System.out.println("Leaf (x, y) : (x+width, y+height) :::: Room (x, y) : (x+width, y+height)");
//        for(Leaf leaf:dungeon.getLeafs()){
//            if(leaf.room()!=null){
//                System.out.println("("+leaf.getX()+", "+leaf.getY()+") : ("+(leaf.getX()+leaf.getWidth())+", "+(leaf.getY()+leaf.getHeight())+")"+" :::: "+"("+leaf.room().getX()+", "+leaf.room().getY()+") : ("+(leaf.room().getX()+leaf.room().getWidth())+", "+(leaf.room().getY()+leaf.room().getHeight())+")");
//            }
//        }
        
        System.out.println(dungeon);
    }
}
