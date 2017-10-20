package com.luolastogeneraattori;

public class Dungeon {
    
    private final int width;
    private final int height;
    private final int maxsize;
    private final int minsize;
    private int splitChance;
    private double splitDirection;
    private List<Part> parts;
    private final Random random;
    private List<Part> partsSplit;
    
    /**
     * 
     * @param width luolaston leveys
     * @param height luolaston korkeus
     */
    public Dungeon(int width, int height){
        this.width = width;
        this.height = height;
        this.maxsize = Math.min(this.height, this.width)/4;
        this.minsize=6;
        this.parts = new List<>();
        this.random = new Random();
        this.splitChance=70;
        this.splitDirection=1.3;
    }
    
    /**
     * 
     * @param width luolaston leveys
     * @param height luolaston korkeus
     * @param minSize huoneiden minimikoko
     * @param maxSize osien maksimikoko
     * @param splitChance
     * @param splitDirection
     */
    public Dungeon(int width, int height, int minSize, int maxSize, int splitChance, double splitDirection){
        this.width = width;
        this.height = height;
        this.maxsize = maxSize;
        this.parts = new List<>();
        this.random = new Random();
        this.splitChance=splitChance;
        this.splitDirection=splitDirection;
        this.minsize=minSize;
    }
    
    public List<Part> getParts(){
        return this.parts;
    }
    
    /**
     * Luo listan Part-olioita käyttäen Part:ssa sijaitsevaa split() metodia.
     * partsSplit on lista, joka sisältää jaettavat osat (aluksi vain root).
     * Tämän jälkeen kutsutaan metodia splitParts() niin kauan kuin se palauttaa true.
     * @param splitChance 
     * @param splitDirection 
     */
    private void createParts(Part root){
        //osat laitetaan listaan
        this.parts = new List<>();
        //koko tilan  kokoinen Part; muodostuvan puun juuri
        this.partsSplit = new List<>();
        this.partsSplit.add(root);
        boolean split = true;
        while(split){
            split = this.splitParts(splitChance, splitDirection);
        }
    }
    
    /**
     * Luo listan tempList, ja käy läpi jokaisen partsSplit listalla olevan osan. Jokaiselle osalle:
     * se tallennetaan ensin parts-listaan, sitten katsotaan onko se suurempi kuin maksimikoko joko pysty- tai vaakasuunnassa,
     * TAI antaako Random luokan metodi newBoolean(splitChance) arvon true (Tämä tapahtuu (splitChance)% todennäköisydellä).
     * Jos jokin näistä ehdoista toteutuu, yritetään jakaa osa split() metodilla, ja tämän onnistuessa lisätään syntyvät lapset tempList-listaam.
     * Ja asetetaan split arvoksi true. Lopuksi korvataan lista partsSplit listalla tempList ja palautetaan split.
     * @param splitChance todennäköisyys joka määrittää yritetäänkö jakaa osa
     * @param splitDirection annetaan Part-luokan metodille split
     * @return onnistuiko jako
     */
    private boolean splitParts(double splitChance, double splitDirection){
        boolean split = false;
        List<Part> tempList = new List<>();
        for(int i=0;i<this.partsSplit.size();i++){ //käydään kaikki osat läpi ja yritetään jakaa ne kahteen osaan ja split-muuttujaan true jos yksikin osa jakautuu
            Part part=this.partsSplit.get(i);
            this.parts.add(part);
                if(part.getWidth() > this.maxsize || part.getHeight() > this.maxsize || this.random.newBoolean(splitChance)){
                    if(part.split(splitDirection)){
                        tempList.add(part.left());
                        tempList.add(part.right());
                        split = true;
                    }
                }
            }
        this.partsSplit=tempList;
        return split;
    }
    
    /**
     * Luo koko luolan tekemällä ensin koko luolaston kokoisen root osan, ja kutsumalla ensin createParts()-metodia käyttäen root-osaa parametrinä.
     * Lopuksi kutsutaan root-osan metodia createRooms(), joka luo huoneet ja käytävät.
     */
    public void createDungeon(){
        Part root = new Part(0, 0, this.width, this.height, this.minsize);
        this.createParts(root);
        root.createRooms();
    }
    
    /**
     * Alustaa taulukon arvolla 1 ja käy läpi kaikki huoneet ja käytävät ja muuttaa niiden alueiden arvoiksi 0.
     * @return palauttaa int[][] taulukon jonka arvot ovat 1 jos kohdassa on seinä tai 0 jos siinä ei ole seinää (0 = voi kulkea, 1 = ei voi kulkea)
     */
    public int[][] getDungeon(){
        int[][] dungeon=new int[this.width+1][this.height+1];
        //alustaa taulukon arvolla 1
        for(int y=0;y<this.height+1;y++){
            for(int x=0;x<this.width+1;x++){
                dungeon[x][y]=1;
            }
        }
        //käydään huoneet ja käytävät läpi ja asetetaan taulukossa niiden paikalle arvo 0
        for(int l=0;l<this.parts.size();l++){
            Part part = this.parts.get(l);
            Room room=part.room();
            if(room!=null){
                for(int y=room.getY();y<(room.getY()+room.getHeight());y++){
                    for(int x=room.getX();x<(room.getX()+room.getWidth());x++){
                        dungeon[x][y]=0;
                    }
                }
            }
            if(part.getHallway()!=null){
                for(int i=0; i<part.getHallway().size(); i++){
                    for(int y=part.getHallway().get(i).getY();y<(part.getHallway().get(i).getY()+part.getHallway().get(i).getHeight());y++){
                        for(int x=part.getHallway().get(i).getX();x<(part.getHallway().get(i).getX()+part.getHallway().get(i).getWidth());x++){
                            dungeon[x][y]=0;
                        }
                    }
                }
            }
        }
        return dungeon;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
