/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luolastogeneraattori;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jaakko
 */
public class RoomTest {
    private Room room;
    
    @Before
    public void setUp() {
        this.room=new Room(0,1,2,3);
    }

    @Test
    public void testGetX() {
        assertTrue(this.room.getX()==0);
    }

    @Test
    public void testGetY() {
        assertTrue(this.room.getY()==1);
    }

    @Test
    public void testGetWidth() {
        assertTrue(this.room.getWidth()==2);
    }

    @Test
    public void testGetHeight() {
        assertTrue(this.room.getHeight()==3);
    }
    
}
