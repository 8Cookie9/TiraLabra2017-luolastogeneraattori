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

Tästä nähdään että sivunpituuksien kasvaessa käytetty aika kasvaa suurinpiirtein samaa tahtia.

##Aika- ja tilavaativuus:

Algoritmi jakaa tilan osiin (jotka ovat vähintään 4x4), joita on pahimmassa tapauksessa n/4, kun n on molempien sivujen pituus. Jakoja tapahtuu tällöin ((n/4)-1)((n/4)+1). Päästään esim. 16x16 kokoisessa luolassa neljään 4x4 palaan jakamalla osiin 15 kertaa. Yksi jako tapahtuu vakioajassa. Tämän jälkeen sijoitetaan huoneet pienimpiin osiin, jotka ovat muodostuneen puun lehtiä, eli n/4 huonetta. Yhden huoneen sijoittaminen tapahtuu vakioajassa. Huoneita sijoitetaan pahimmissa tapauksessa siis n/4. Käytävät tehdään yhtä monta kertaaa kuin osia, jotka eivät sisällä huonetta, eli ((n/4)-1)((n/4)+1)-(n/4). Käytävän tekeminen tapahtuu myös vakioajassa.

Tästä saadaan pahimman tapauksen aikavaativuudeksi (jako)+(huoneiden sijoitus)+(käytävien sijoitus)=((n/4)-1)((n/4)+1)+(n/4)+(((n/4)-1)((n/4)+1)-(n/4))=2((n/4)-1)((n/4)+1). Pahimman tapauksen aikavaativuus on siis luokkaa O(n^2), mihin alussa pyrinkin.

Algoritmin pahimman tapauksen tilavaativuus on osien määrä ((n/4)-1)((n/4)+1), huoneiden määrä n/4 ja käytäviin tarvittavien neliskulmioiden määrä 2(((n/4)-1)((n/4)+1)-(n/4)). Eli ((n/4)-1)((n/4)+1)+(n/4)+2(((n/4)-1)((n/4)+1)-(n/4))=3((n/4)-1)((n/4)+1)-(n/4). Pahimman tapauksen tilavaativuuskin on siis luokkaa O(n^2), mihin alussa pyrinkin.
