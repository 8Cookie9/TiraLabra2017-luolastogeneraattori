package com.luolastogeneraattori;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListTest {
    private List<Integer> listInt;
    
    
    @Before
    public void setUp() {
        this.listInt=new List<>();
    }
    
    @Test
    public void toinenKonstruktori(){
        List<Integer> newList = new List<>();
        assertNull(newList.get(0));
    }
    
    @Test
    public void testAdd() {
        assertTrue(this.listInt.size()==0);
        this.listInt.add(1);
        assertTrue(this.listInt.size()==1);
    }

    @Test
    public void testGet() {
        assertNull(this.listInt.get(0));
        assertNull(this.listInt.get(-10));
        assertNull(this.listInt.get(100));
        this.listInt.add(123);
        assertNotNull(this.listInt.get(0));
    }  
}
