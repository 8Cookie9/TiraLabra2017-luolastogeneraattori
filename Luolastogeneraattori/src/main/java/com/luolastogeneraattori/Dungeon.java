package com.luolastogeneraattori;

public class Dungeon {
    private int width;
    private int height;
    private int[][] dungeon; //1 = seinä, 0 = tyhjä tila 
    public Dungeon(int width, int height){
        this.width=width;
        this.height=height;
        this.dungeon=new int[width][height];
    }
    
    public int[][] getDungeon(){
        return this.dungeon;
    }
    
    public void generate(int rooms){
        int i=Math.min(((this.width-2)*(this.height-2))/9,rooms);
    }
    
    
}
