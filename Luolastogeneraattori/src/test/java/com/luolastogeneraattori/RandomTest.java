package com.luolastogeneraattori;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomTest {
    private Random random;
    
    @Before
    public void setUp() {
        this.random=new Random();
    }

    @Test
    public void testNewInt() {
        int min=100;
        int max=0;
        for(int i=0;i<100000;i++){
            int num=this.random.newInt(0, 100);
            if(num<min){
                min=num;
            }
            if(num>max){
                max=num;
            }
        }
        assertTrue(min>=0);
        assertTrue(max<=100);
    }

    @Test
    public void testNewBoolean() {
        int t=0;
        int f=0;
        for(int i=0;i<100000;i++){
            if(this.random.newBoolean(50)){
                t++;
            }else{
                f++;
            }
        }
        assertTrue(Math.abs(t-f)<10000);
    }
    
}
