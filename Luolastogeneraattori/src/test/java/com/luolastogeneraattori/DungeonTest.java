package com.luolastogeneraattori;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class DungeonTest {
    private Dungeon dungeon;
    
    @Before
    public void setUp() {
        this.dungeon=new Dungeon(20,20);
    }

    @Test
    public void testGetParts() {
        assertTrue(this.dungeon.getParts().size()==0);
    }
    
    @Test
    public void testDungeon(){
        Dungeon d = new Dungeon(20,20,6,10,70,1.3);
        for(int x=0;x<d.getDungeon().length;x++){
            for(int y=0;y<d.getDungeon()[0].length;y++){
                assertTrue(d.getDungeon()[x][y]==this.dungeon.getDungeon()[x][y]);
            }
        }
    }

    @Test
    public void createPartsLuoOsia() {
        this.dungeon.createDungeon();
        assertFalse(this.dungeon.getParts().size()==0);
    }
    
    @Test
    public void createPartsJuurenaKokoLuola() {
        this.dungeon.createDungeon();
        assertTrue(this.dungeon.getParts().get(0).getX()==0);
        assertTrue(this.dungeon.getParts().get(0).getY()==0);
        assertTrue(this.dungeon.getParts().get(0).getWidth()==20);
        assertTrue(this.dungeon.getParts().get(0).getHeight()==20);
    }
    
    @Test
    public void createPartsOikeaMaaraLehtia(){
        this.dungeon.createDungeon();
        assertTrue(this.dungeon.getParts().size()%2==1);
    }
    
    @Test
    public void testGetDungeon() {
        boolean b = true;
        for(int i=0;i<20;i++){
            for(int i2=0;i2<20;i2++){
                if(this.dungeon.getDungeon()[i][i2]==0){
                    b = false;
                }
            }
        }
        assertTrue(b);
        Dungeon d = new Dungeon(40,40);
        d.createDungeon();
        b = false;
        for(int i=0;i<40;i++){
            for(int i2=0;i2<40;i2++){
                if(d.getDungeon()[i][i2]==1){
                    b = true;
                }
            }
        }
        assertTrue(b);
    }
    
    @Test
    public void testGetDungeon2(){
        this.dungeon.createDungeon();
        boolean b = false;
        for(int i=0;i<20;i++){
            for(int i2=0;i2<20;i2++){
                if(this.dungeon.getDungeon()[i][i2]==0){
                    b = true;
                }
            }
        }
        assertTrue(b);
    }
    
    @Test
    public void testGetWidth(){
        assertTrue(this.dungeon.getWidth()==20);
    }
    
    @Test
    public void testGetHeight(){
        assertTrue(this.dungeon.getHeight()==20);
    }
}
