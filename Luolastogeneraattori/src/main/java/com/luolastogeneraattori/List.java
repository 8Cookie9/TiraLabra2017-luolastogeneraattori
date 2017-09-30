package com.luolastogeneraattori;

public class List<E> {
    
    private final int initialValue = 10;
    private Object[] list;
    private int size;
    private int currentMaxSize;
    public List(){
        this.list = new Object[this.initialValue];
        this.size = 0;
        this.currentMaxSize = this.initialValue;
    }
    public List(int init){
        this.list = new Object[init];
        this.size = 0;
        this.currentMaxSize = init;
    }
    
    /**
     * Lisää halutun asian listaan, jos sisäinen lista on täysi, tehdään uusi, 2-kertaa suurempi lista, 
     * jonne kopioidaan vanhan listan sisältö.
     * @param object lisättävä asia
     */
    public void add(E object){
        if(this.size == this.currentMaxSize){
            Object[] newList = new Object[this.currentMaxSize*2];
            for(int i=0; i<this.currentMaxSize; i++){
                newList[i]=this.list[i];
            }
            this.currentMaxSize*=2;
            this.list = newList;
        }
        this.list[this.size] = object;
        this.size++;
    }
    
    /**
     * Palauttaa list[i] jos i välillä 0 <= listan koko (size), muuten palauttaa null
     * @param i palautettavan olion sijainti listassa
     * @return palautettava olio
     */
    public E get(int i){
        if(i<0 || i>this.currentMaxSize){
            return null;
        }else{
            return (E) this.list[i];
        }
    }
    
    public int size(){
        return this.size;
    }
}
