## Käyttöohje

Ohjelma suoritetaan suorittamalla .jar tiedosto.

Hyväksyttävät syöteet (ym. syötteistä):
Width, Height: 

* Minimi 10, koska sen alapuolella luolaston muodostaminen on vaikeaa
* Ei varsinaista maksimia jota ei hyväksytä, mutta yli 300 on yleensä turhan paljon ja saataa jumiuttaa ohjelman

Chance to split: 

* todennäköisyys, että maksimikokoa pienempi huone yritetään jakaa pienemmäksi
* luku 0 ja 100 (yli 100 toimii samalla tavalla kuin 100) väliltä (prosenttia)
* 100 

Minimum room size:

* 2 pienin mahdollinen (2x2 huoneet pienimpiä mahdollisia)
* pienempi kuin maksimikoko
* ei kannata laittaa liian isoa lukua (width/height nähden), koska tällöin huoneet ovat suuria ja luolastosta tulee aika tylsä

Maximum room size:

* suurempi kuin minimi

Randomness of the split direction:

* Kuinka satunnainen jaon suunta on, eli milloin jaetaan enemmän neliön muotoiseksi, ja milloin valitaan suunta satunnaisesti
* suuri luku kuten 10 tai 100 tekee huoneiden muodosta paljon satunnaisemmat
* luku 1.0 ja 2.0 väliltä tekee huoneista enemmän neliskulmaisia
* luku x tarkoittaa, että jos jaettava huone on x tai enemmän kertaa leveä kuin korkea, yritetään se jakaa pystysuunnassa ja jos x kertaa korkeampi kuin leveä, yritetään jakaa leveyssuunnassa.

.jar tiedosto löytyy suoraan TiraLabra2017-luolastogeneraattori/ :sta. Testitiedostoja ei tarvita.
