package com.luolastogeneraattori;

import java.util.ArrayList;

public class Dungeon {
    
    private final int width;
    private final int height;
    private final int maxsize=20;
    private ArrayList<Leaf> leafs;
    
    /**
     * 
     * @param width luolaston leveys
     * @param height luolaston korkeus
     */
    public Dungeon(int width, int height){
        this.width = width;
        this.height = height;
        this.leafs=new ArrayList<>();
    }
    
    public ArrayList<Leaf> getLeafs(){
        return this.leafs;
    }
    
    /**
     * Luo listan Leaf-olioita käyttäen Leaf:ssa sijaitsevaa split() metodia
     */
    public void createLeafs(){
        this.leafs = new ArrayList<>();
        Leaf root = new Leaf(0, 0, this.width, this.height);
        this.leafs.add(root);
        boolean split = true;
        while(split){
            split = false;
            for(int i=0;i<this.leafs.size();i++){
                Leaf leaf=this.leafs.get(i);
                if(leaf.left()==null && leaf.right()==null){
                    if(leaf.getWidth() > this.maxsize || leaf.getHeight() > this.maxsize || Math.random() > 0.75){
                        if(leaf.split()){
                            this.leafs.add(leaf.left());
                            this.leafs.add(leaf.right());
                            split = true;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 
     * @return palauttaa int[][] taulukon jonka arvot ovat 1 jos kohdassa on seinä tai 0 jos siinä ei ole seinää (0 = voi kulkea, 1 = ei voi kulkea)
     */
    public int[][] getDungeon(){
        int[][] dungeon=new int[this.width+1][this.height+1];
        for(int y=0;y<this.height+1;y++){
            for(int x=0;x<this.width+1;x++){
                dungeon[x][y]=1;
            }
        }
        for(Leaf leaf:this.leafs){
            Room room=leaf.room();
            if(room!=null){
                for(int y=room.getY();y<(room.getY()+room.getHeight());y++){
                    for(int x=room.getX();x<(room.getX()+room.getWidth());x++){
                        dungeon[x][y]=0;
                    }
                }
            }
            if(leaf.getHallway()!=null){
                for(Room r:leaf.getHallway()){
                    for(int y=r.getY();y<(r.getY()+r.getHeight());y++){
                        for(int x=r.getX();x<(r.getX()+r.getWidth());x++){
                            dungeon[x][y]=0;
                        }
                    }
                }
            }
        }
        return dungeon;
    }
    
    /**
     * 
     * @return palauttaa tekstimuotoisen version luolasta getDungeon() metodin pohjalta, jossa 0 ==> "  " ja 1 ==> "||"
     */
    @Override
    public String toString(){
        String s="";
        int[][] dungeon=this.getDungeon();
        for(int y=0;y<this.height;y++){
            for(int x=0;x<this.width;x++){
                if(dungeon[x][y]==1){
                    s+="||";
                }else{
                    s+="  ";
                }
            }
            s+="\n";
        }
        return s;
    }
}
