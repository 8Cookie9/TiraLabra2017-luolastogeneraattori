package com.luolastogeneraattori;

import java.util.ArrayList;

public class Leaf {

    private int x;
    private int y;
    private int height;
    private int width;
    private Leaf left;
    private Leaf right;
    private Room room;
    private ArrayList<Room> hallway;
    private final int minSize=6;
    
    /**
     * Lehti on suorakulmio, jonka vasen alakulma on kohdassa (x, y) ja oikea yläkulma kohdasa (x+width, y+height)
     * 
     * @param x Lehden x-koordinaatti
     * @param y Lehden y-koordinaatti
     * @param width Lehden leveys
     * @param height Lehden korkeus
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

    public ArrayList<Room> getHallway() {
        return hallway;
    }
    
    public Room room(){
        return this.room;
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
        if(max < this.minSize){
            return false;
        }
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
        if(this.width > this.height && this.width/this.height >= 1.25){
            splitHorizontally=false;
        }else if(this.height > this.width && this.height/this.width >= 1.25){
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
            max=this.width-this.minSize;
        }
        return max;
    }
    
    public void createRooms(){
        if(this.left()!=null ||this.right()!=null){
            if(this.left()!=null){
                this.left().createRooms();
            }
            if(this.right()!=null){
                this.right().createRooms();
            }
            if(this.left()!=null && this.right()!=null){
                this.createHallway(this.left().getRoom(), this.right().getRoom());
            }
        }else{
            int roomWidth=(int)Math.round((Math.random()*(this.width-5))+3);
            int roomHeight=(int)Math.round((Math.random()*(this.height-5))+3);
            int roomX=this.x+(int)Math.round((Math.random()*(this.width-roomWidth-2))+1);
            int roomY=this.y+(int)Math.round((Math.random()*(this.height-roomHeight-2))+1);
            this.room=new Room(roomX, roomY, roomWidth, roomHeight);
        }
    }

    /**
     * 
     * @return Palauttaa huoneen Room tästä lehdestä tai lähimmästä josta löytyy sellainen (palauttaa null jos huonetta ei löydy)
     */
    public Room getRoom(){
        if(this.room != null){
            return this.room;
        }else{
            Room leftRoom=null;
            Room rightRoom=null;
            if(this.left() != null){
                leftRoom = this.left().getRoom();
            }
            if(this.right() != null){
                rightRoom = this.right.getRoom();
            }
            if(leftRoom==null && rightRoom==null){
                return null;
            }else if(leftRoom != null){
                return leftRoom;
            }else{
                return rightRoom;
            }
        }
    }
    
    /**
     * Tekee Room olioista koostuvan käytävän parametreinä annettujen huoneiden välille
     * @param leftRoom
     * @param rightRoom 
     */
    public void createHallway(Room leftRoom, Room rightRoom){
        this.hallway = new ArrayList<>();
        int leftX=(int)Math.round(Math.random()*((leftRoom.getX()+leftRoom.getWidth()-2)-(leftRoom.getX()+1))+(leftRoom.getX()+1));
        int leftY=(int)Math.round(Math.random()*((leftRoom.getY()+leftRoom.getHeight()-2)-(leftRoom.getY()+1))+(leftRoom.getY()+1));
        int rightX=(int)Math.round(Math.random()*((rightRoom.getX()+rightRoom.getWidth()-2)-(rightRoom.getX()+1))+(rightRoom.getX()+1));
        int rightY=(int)Math.round(Math.random()*((rightRoom.getY()+rightRoom.getHeight()-2)-(rightRoom.getY()+1))+(rightRoom.getY()+1));
        int xDifference=rightX-leftX;
        int yDifference=rightY-leftY;
        
        if(xDifference < 0){
            if(yDifference < 0){
                if(Math.random() < 0.5){
                    this.hallway.add(new Room(rightX, leftY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(rightX, rightY, 1, Math.abs(yDifference)));
                }else{
                    this.hallway.add(new Room(rightX, rightY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(leftX, rightY, 1, Math.abs(yDifference)));
                }
            }else if(yDifference > 0){
                if(Math.random() < 0.5){
                    this.hallway.add(new Room(rightX, leftY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(rightX, leftY, 1, Math.abs(yDifference)));
                }else{
                    this.hallway.add(new Room(rightX, rightY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(leftX, leftY, 1, Math.abs(yDifference)));
                }
            }else{
                this.hallway.add(new Room(rightX, rightY, Math.abs(xDifference), 1));
            }
        }else if(xDifference > 0){
            if(yDifference < 0){
                if(Math.random() < 0.5){
                    this.hallway.add(new Room(leftX, rightY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(leftX, rightY, 1, Math.abs(yDifference)));
                }else{
                    this.hallway.add(new Room(leftX, leftY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(rightX, rightY, 1, Math.abs(yDifference)));
                }
            }else if(yDifference > 0){
                if(Math.random() < 0.5){
                    this.hallway.add(new Room(leftX, leftY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(rightX, leftY, 1, Math.abs(yDifference)));
                }else{
                    this.hallway.add(new Room(leftX, rightY, Math.abs(xDifference), 1));
                    this.hallway.add(new Room(leftX, leftY, 1, Math.abs(yDifference)));
                }
            }else{
                this.hallway.add(new Room(leftX, leftY, Math.abs(xDifference), 1));
            }
        }else{
            if(yDifference < 0){
                this.hallway.add(new Room(rightX, rightY, 1, Math.abs(yDifference)));
            }else{
                this.hallway.add(new Room(leftX, leftY, 1, Math.abs(yDifference)));
            }
        }
    }
    
    @Override
    public String toString(){
        return this.x+" - "+(this.x+this.width)+", "+this.y+" - "+(this.y+this.height);
    }
}