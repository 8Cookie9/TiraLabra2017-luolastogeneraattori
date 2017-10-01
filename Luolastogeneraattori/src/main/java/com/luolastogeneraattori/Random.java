package com.luolastogeneraattori;

public class Random {
    
    public Random(){
        
    }
    
    public int newInt(int min, int max){
        return (int)Math.round(Math.random()*(max - min) + min);
    }
    
    public boolean newBoolean(double chance){
        return Math.random() <= (chance / 100);
    }
}
