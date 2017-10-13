package com.luolastogeneraattori;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LeafTest {
    
    private Leaf root;
    
    @Before
    public void setUp() {
        this.root=new Leaf(0,0,40,40,6);
    }
    
    @Test
    public void splitJakautuuOsiin(){
        this.root.split(1.3);
        assertTrue(this.root.left().getHeight()*this.root.left().getWidth()+this.root.right().getHeight()*this.root.right().getWidth()==this.root.getHeight()*this.root.getWidth());
    }
    
    @Test
    public void splitEiJaaUudestaan(){
        this.root.split(1.3);
        assertFalse(this.root.split(1.3));
    }
    
    @Test
    public void splitJakaaOikein(){
        this.root.split(1.3);
        if(this.root.left().getWidth()<this.root.getWidth()){
            assertTrue(this.root.right().getX()>this.root.getX());
        }else{
            assertTrue(this.root.right().getY()>this.root.getY());
        }
    }
    
    @Test
    public void splitJakaaOikeinVaakasuunnassa(){
        Leaf leaf = new Leaf(0,0,20,40,6);
        assertTrue(leaf.split(1.3));
        assertTrue(leaf.left().getHeight()<leaf.getHeight()||leaf.right().getHeight()<leaf.getHeight());
        
    }
    
    @Test
    public void splitJakaaOikeinPystysuunnassa(){
        Leaf leaf = new Leaf(0,0,40,20,6);
        assertTrue(leaf.split(1.3));
        assertTrue(leaf.left().getWidth()<leaf.getWidth()||leaf.right().getWidth()<leaf.getWidth());
        
    }
    
    @Test
    public void liianPieniLehtiEiJakaudu(){
        Leaf leaf1 = new Leaf(0,0,11,11,6);
        assertFalse(leaf1.split(1.3));
        Leaf leaf2 = new Leaf(0,0,12,12,6);
        assertTrue(leaf2.split(1.3));
    }
    
    @Test
    public void testCreateRooms(){
        this.root.createRooms();
        assertTrue(this.root.room()!=null);
        this.root = new Leaf(0, 0, 40, 40,6);
        this.root.split(1.3);
        this.root.createRooms();
        assertTrue(this.root.room()==null);
    }
    
    @Test
    public void testCreateHallway(){
        Room room1 = new Room(0, 0, 3, 3);
        Room room2 = new Room(6, 0, 3, 3);
        Room room3 = new Room(0, 6, 3, 3);
        Room room4 = new Room(6, 6, 3, 3);
        this.root.createHallway(room1, room2);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getHeight()==1);
        this.root.createHallway(room1, room3);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getWidth()==1);
        this.root.createHallway(room1, room4);
        assertTrue(this.root.getHallway().size()==2&&this.root.getHallway().get(0).getHeight()==1&&this.root.getHallway().get(1).getWidth()==1);
        this.root.createHallway(room2, room3);
        assertTrue(this.root.getHallway().size()==2&&this.root.getHallway().get(0).getHeight()==1&&this.root.getHallway().get(1).getWidth()==1);
        this.root.createHallway(room2, room4);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getWidth()==1);
        this.root.createHallway(room3, room4);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getHeight()==1);
        this.root.createHallway(room2, room1);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getHeight()==1);
        this.root.createHallway(room3, room1);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getWidth()==1);
        this.root.createHallway(room4, room1);
        assertTrue(this.root.getHallway().size()==2&&this.root.getHallway().get(0).getHeight()==1&&this.root.getHallway().get(1).getWidth()==1);
        this.root.createHallway(room3, room2);
        assertTrue(this.root.getHallway().size()==2&&this.root.getHallway().get(0).getHeight()==1&&this.root.getHallway().get(1).getWidth()==1);
        this.root.createHallway(room4, room2);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getWidth()==1);
        this.root.createHallway(room4, room3);
        assertTrue(this.root.getHallway().size()==1&&this.root.getHallway().get(0).getHeight()==1);
    }
    
    @Test
    public void testGetRoom(){
        assertTrue(this.root.getRoom()==null);
        this.root.createRooms();
        assertTrue(this.root.getRoom()!=null);
    }
    
    @Test
    public void testRoom(){
        assertTrue(this.root.room()==null);
    }
    
    @Test
    public void testGetHallway(){
        assertTrue(this.root.getHallway()==null);
    }
    
    @Test
    public void testToString(){
        assertTrue(this.root.toString().equals("0 - 40, 0 - 40"));
    }
}
