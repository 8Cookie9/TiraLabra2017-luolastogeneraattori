## Testausdokumentti

Testasin eri metodien suoritusnopeutta nanosekuntteina käyttäen Javan System.nanoTime(). Testasin aluksi createDungeon() metodin (koko algoritmin) suoritusnopeutta erikokoisilla luolastoilla. Otin jokaisesta 3 keskiarvoa ylös kun metodin suorittaa 10000 kertaa.

Totetus koodilla (luokassa App.java):

```java
Dungeon dungeon = new Dungeon(100,100);
long sum=0;
for(int i=0;i<10000;i++){
    long aikaAlussa = System.nanoTime();
    dungeon.createDungeon();
    long aikaLopussa = System.nanoTime();
    sum+=(aikaLopussa - aikaAlussa);
}
long ka=sum/10000;

System.out.println("Keskiarvo: "+ka);
```

muuttamalla new Dungeon(100,100) kutsun parametrejä, esim. new Dungeon(30,30)

### 30x30
**createDungeon()**

* 12646ns
* 12707ns
* 12444ns

≈ 13μs

### 50x50
**createDungeon()**

* 27969ns
* 27471ns
* 28535ns

≈28μs

### 100x100
**createDungeon()**

* 81214ns
* 81558ns
* 78857ns

≈80μs

### 200x200
**createDungeon()**

* 196646ns
* 196170ns
* 198321ns

≈200μs

### 400x400
**createDungeon()**

* 436919ns
* 434759ns
* 427136ns

≈430μs

![kuvaaja](https://i.imgur.com/Z1Yv1U5.png)

Tästä nähdään että sivunpituuksien kasvaessa käytetty aika kasvaa suurinpiirtein samaa tahtia.
