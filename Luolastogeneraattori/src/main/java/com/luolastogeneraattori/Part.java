package com.luolastogeneraattori;

public class Part {

    private final int x;
    private final int y;
    private final int height;
    private final int width;
    private Part left;
    private Part right;
    private Room room;
    private List<Room> hallway;
    private final int minSize;
    private final Random random;
    
    /**
     * Part (osa) on suorakulmio, jonka vasen alakulma on kohdassa (x, y) ja oikea yläkulma kohdasa (x+width, y+height)
     * 
     * @param x Lehden x-koordinaatti
     * @param y Lehden y-koordinaatti
     * @param width Lehden leveys
     * @param height Lehden korkeus
     * @param minSize huoneiden minimikoko
     */
    public Part(int x, int y, int width, int height, int minSize){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.left=null;
        this.right=null;
        this.random=new Random();
        this.minSize=minSize;
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

    public Part left() {
        return left;
    }

    public Part right() {
        return right;
    }

    public List<Room> getHallway() {
        return hallway;
    }
    
    public Room room(){
        return this.room;
    }
    
    /**
     * Jakaa tämän osan alueen kahteen osaan joko pysty- tai vaakasuunnassa riippuen tämän osan muodosta (tai satunnaisesti).
     * @param splitDirection annetaan metodille horizontalSplit()
     * @return Palauttaa onnistuiko jako
     */
    public boolean split(double splitDirection){
        if(this.left!=null || this.right!=null){
            return false;
        }
        boolean splitHorizontally=this.horizontalSplit(splitDirection);
        int max=this.max(splitHorizontally);
        if(max < this.minSize){
            return false;
        }
        int splitLocation=this.random.newInt(this.minSize, max);
        this.left = (splitHorizontally ? new Part(this.x, this.y, this.width, splitLocation, this.minSize) : new Part(this.x, this.y, splitLocation, this.height, this.minSize));
        this.right = (splitHorizontally ? new Part(this.x, this.y+splitLocation, this.width, this.height-splitLocation, this.minSize) : new Part(this.x+splitLocation, this.y, this.width-splitLocation, this.height, this.minSize));
        return true;
    }
    
    /**
     * Jaon suunta on määrätty, jos tämä osa on splitDirectio-kertaa korkeampi kuin leveä,
     * tai leveämpi kuin korkea.
     * @return Jaetaanko tämä osa pysty- (false) vai vaakasuunnassa (true)
     */
    private boolean horizontalSplit(double splitDirection){
        boolean splitHorizontally=this.random.newBoolean(50);
        if(this.width > this.height && this.width/this.height >= splitDirection){
            splitHorizontally=false;
        }else if(this.height > this.width && this.height/this.width >= splitDirection){
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
    
    /**
     * Tekee huoneet tämän osan jälkeläisiin, joilla ei ole jälkeläisiä
     * (puun lehtiin)
     */
    public void createRooms(){
        if(this.left()!=null || this.right()!=null){
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
            this.createRoom();
        }
    }
    
    
    /**
     * Luo huoneen tähän osaan, huone ei saa koskea reunoja.
     */
    private void createRoom(){
        int roomWidth=this.random.newInt(this.minSize, this.width-2);
        int roomHeight=this.random.newInt(this.minSize, this.height-2);
        int roomX=this.x+this.random.newInt(1, this.width-roomWidth-1);
        int roomY=this.y+this.random.newInt(1, this.height-roomHeight-1);
        this.room=new Room(roomX, roomY, roomWidth, roomHeight);
    }

    /**
     * Jossa tässä osassa on huone, palautetaan se, jos ei, yritetään löytää huone tämän osan lapsista (left() ja right())
     * jos näistäkään ei löydy huonetta
     * @return Palauttaa huoneen Room tästä osasta tai lähimmästä josta löytyy sellainen (palauttaa null jos huonetta ei löydy)
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
            }else if(leftRoom!=null && rightRoom!=null){
                if(this.random.newBoolean(50)){
                    return leftRoom;
                }else{
                    return rightRoom;
                }
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
        this.hallway = new List<>();
        int leftX=this.random.newInt(leftRoom.getX()+1, leftRoom.getX()+leftRoom.getWidth()-2);
        int leftY=this.random.newInt(leftRoom.getY()+1, leftRoom.getY()+leftRoom.getHeight()-2);
        int rightX=this.random.newInt(rightRoom.getX()+1, rightRoom.getX()+rightRoom.getWidth()-2);
        int rightY=this.random.newInt(rightRoom.getY()+1, rightRoom.getY()+rightRoom.getHeight()-2);
        
    }
    
    /**
     * Metodi käy läpi erilaiset vaihtoehdot huoneiden sijainnista toisiinsa nähden
     * ja muodostaa listan joka sisältää 1 tai 2 hunetta, jotka muodostavat käytävän huoneiden
     * välille. Käytävien muoto valitaan satunnaisesti rnd muuttujan arvon perusteella.
     * @param leftX Huoneen 1 käytävän x-koordinaatti
     * @param leftY Huoneen 1 käytävän y-koordinaatti
     * @param rightX Huoneen 2 käytävän x-koordinaatti
     * @param rightY Huoneen 2 käytävän y-koordinaatti
     * @return Lista jossa on 1 tai 2 Room-oliota, muodostavat yhdessä käytävän.
     */
    private List<Room> getHallways(int leftX, int leftY, int rightX, int rightY){
        List<Room> list = new List<>();
        int xDifference=rightX-leftX;
        int yDifference=rightY-leftY;
        boolean rnd=this.random.newBoolean(50);
         if(xDifference < 0){
            if(yDifference < 0){
                list.add(new Room(rightX, (rnd ? leftY : rightY), Math.abs(xDifference), 1));
                list.add(new Room((rnd ? rightX : leftX), rightY, 1, Math.abs(yDifference)));
            }else if(yDifference > 0){
                list.add(new Room(rightX, (rnd ? leftY : rightY), (rnd ? Math.abs(xDifference) : (Math.abs(xDifference)+1)), 1));
                list.add(new Room((rnd ? rightX : leftX), leftY, 1, Math.abs(yDifference)));
            }else{
                list.add(new Room(rightX, rightY, Math.abs(xDifference), 1));
            }
        }else if(xDifference > 0){
            if(yDifference < 0){
                list.add(new Room(leftX, (rnd ? rightY : leftY), (rnd ? Math.abs(xDifference) : (Math.abs(xDifference)+1)), 1));
                list.add(new Room((rnd ? leftX : rightX), rightY, 1, Math.abs(yDifference)));
            }else if(yDifference > 0){
                list.add(new Room(leftX, (rnd ? leftY : rightY), Math.abs(xDifference), 1));
                list.add(new Room((rnd ? rightX : leftX), leftY, 1, Math.abs(yDifference)));
            }else{
                list.add(new Room(leftX, leftY, Math.abs(xDifference), 1));
            }
        }else{
            if(yDifference < 0){
                list.add(new Room(rightX, rightY, 1, Math.abs(yDifference)));
            }else{
                list.add(new Room(leftX, leftY, 1, Math.abs(yDifference)));
            }
        }
         return list;
    }
}