package com.luolastogeneraattori;

public class BSP {
    private int x;
    private int y;
    private int height;
    private int width;
    private BSP left;
    private BSP right;
    
    public BSP(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public void setLeft(BSP left) {
        this.left = left;
    }

    public void setRight(BSP right) {
        this.right = right;
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

    public BSP left() {
        return left;
    }

    public BSP right() {
        return right;
    }
    
    public void split(boolean start){
        if(!start){
            
        }
    }
}
