package com.luolastogeneraattori;

public class Leaf {

    private int x;
    private int y;
    private int height;
    private int width;
    private Leaf left;
    private Leaf right;
    private final int minSize=6;
    
    /**
     * Lehti on suorakulmio, jonka vasen alakulma on kohdassa (x, y) ja oikea yläkulma kohdasa (x+width, y+height)
     * 
     * @param x Lehden x-koordinaatti
     * @param y Lehden y-koordinaatti
     * @param width Lehden leveys
     * @param height Lehden korkeus
     * @param minSize Lehden minikoko sekä pysty että vaakasuunnassa
     */
    public Leaf(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.left=null;
        this.right=null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Leaf left() {
        return left;
    }

    public Leaf right() {
        return right;
    }
    
    /**
     * Jakaa lehden kahteen osaan joko pysty- tai vaakasuunnassa riippuen lehden muodosta (tai satunnaisesti).
     * 
     * @return Palauttaa onnistuiko jako
     */
    public boolean split(){
        if(this.left!=null || this.right!=null){
            return false;
        }
        boolean splitHorizontally=this.horizontalSplit();
        int max=this.max(splitHorizontally);
        int splitLocation=(int)Math.round(Math.random()*(max-this.minSize)+this.minSize);
        if(splitHorizontally){
            this.left = new Leaf(this.x, this.y, this.width, splitLocation);
            this.right = new Leaf(this.x, this.y+splitLocation, this.width, this.height-splitLocation);
        }else{
            this.left = new Leaf(this.x, this.y, splitLocation, this.height);
            this.right = new Leaf(this.x+splitLocation, this.y, this.width-splitLocation, this.height);
        }
        return true;
    }
    
    /**
     * 
     * @return Jaetaanko lehti pysty- (false) vai vaakasuunnassa (true)
     */
    private boolean horizontalSplit(){
        boolean splitHorizontally=Math.random() > 0.5;
        if(this.width/this.height > 1.25){
            splitHorizontally=false;
        }else if(this.height/this.width > 1.25){
            splitHorizontally=true;
        }
        return splitHorizontally;
    }
    
    /**
     * 
     * @param horizontal jaon suunta: true = vaaka, false = pysty
     * @return palauttaa jaon maksimikoon
     */
    private int max(boolean horizontal){
        boolean splitHorizontally=horizontal;
        int max;
        if(splitHorizontally){
            max=this.height-this.minSize;
        }else{
            max=this.height-this.minSize;
        }
        return max;
    }
    
    @Override
    public String toString(){
        return this.x+" - "+(this.x+this.width)+", "+this.y+" - "+(this.y+this.height);
    }
}