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
    public void testGetLeafs() {
        assertTrue(this.dungeon.getLeafs().isEmpty());
    }

    @Test
    public void createLeafsLuoLehtiä() {
        this.dungeon.createLeafs();
        assertFalse(this.dungeon.getLeafs().isEmpty());
    }
    
    @Test
    public void createLeafsJuurenaKokoLuola() {
        this.dungeon.createLeafs();
        assertTrue(this.dungeon.getLeafs().get(0).getX()==0);
        assertTrue(this.dungeon.getLeafs().get(0).getY()==0);
        assertTrue(this.dungeon.getLeafs().get(0).getWidth()==20);
        assertTrue(this.dungeon.getLeafs().get(0).getHeight()==20);
    }
    
    @Test
    public void createLeafsOikeaMaaraLehtia(){
        this.dungeon.createLeafs();
        assertTrue(this.dungeon.getLeafs().size()%2==1);
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
        d.createLeafs();
        d.getLeafs().get(0).createRooms();
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
    public void testToString() {
        String s="";
        for(int i=0;i<20;i++){
            for(int i2=0;i2<20;i2++){
                s+="||";
            }
            s+="\n";
        }
        assertTrue(s.equals(dungeon.toString()));
    }
    
}
