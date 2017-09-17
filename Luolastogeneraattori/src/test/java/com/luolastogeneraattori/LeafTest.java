package com.luolastogeneraattori;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LeafTest {
    
    Leaf root;
    
    @Before
    public void setUp() {
        root=new Leaf(0,0,40,40);
    }
    
    @Test
    public void splitJakautuuOsiin(){
        root.split();
        assertTrue(root.left().getHeight()*root.left().getWidth()+root.right().getHeight()*root.right().getWidth()==root.getHeight()*root.getWidth());
    }
    
    @Test
    public void splitEiJaaUudestaan(){
        root.split();
        assertFalse(root.split());
    }
    
    @Test
    public void splitJakaaOikein(){
        root.split();
        if(root.left().getWidth()<root.getWidth()){
            assertTrue(root.right().getX()>root.getX());
        }else{
            assertTrue(root.right().getY()>root.getY());
        }
    }
    
    @Test
    public void splitJakaaOikeinVaakasuunnassa(){
        Leaf leaf = new Leaf(0,0,20,40);
        assertTrue(leaf.split());
        assertTrue(leaf.left().getHeight()<leaf.getHeight()||leaf.right().getHeight()<leaf.getHeight());
        
    }
    
    @Test
    public void splitJakaaOikeinPystysuunnassa(){
        Leaf leaf = new Leaf(0,0,40,20);
        assertTrue(leaf.split());
        assertTrue(leaf.left().getWidth()<leaf.getWidth()||leaf.right().getWidth()<leaf.getWidth());
        
    }
}
