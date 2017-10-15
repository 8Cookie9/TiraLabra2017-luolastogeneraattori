## Toteutusdokumentti

### Ohjelman yleisrakenne

Ohjelman toiminnan kannalta tärkeimmät luokat ovat Part, Dungeon ja Room. Room luokka kuvaa suorakulmion muotoista huonetta eikä sisällä muuta toiminnallisuutta.

Part-luokka pitää sisällään osan, joka kuvaa Room luokan tavoin suorakulmiota. Part-luokalla on metodi split(), joka jakaa sen (ehtojen mukaan) kahteen osaan, joista tulee tämän vasen ja oikea lapsi. Osalla on myös metodi huoneiden tekemiseen osan sisälle ja metodi joka yhdistää kaksi huonetta käytävällä toisiinsa ja tallentaa käytävän (muodostaa yhdestä tai kahdesta suorakulmiosta) tämän osan sisään.

Dungeon-luokka kuvaa koko luolaa, sillä on leveys ja korkeus, metodit luolan tulostamiseen ja saamiseen int[][] taulukkona, sekä createDungeon()-metodi joka luo koko luolan. Tämä tapahtuu luomalla ensin osan joka kuvaa koko luolaa ja jakamalla sen osiin ja syntyneitä osia osiin niin kauan kuin pystytään. Tämän jälkeen luodaan huone jokaiseen osaan jolla ei ole lapsi (left() ja right()), koska tällöin tämä on puun lehti ja yksi pienimmistä osista. Lopuksi luodaan käytävät huoneiden välille, siten jokaisesta osasta, jossa ei ole huonetta etsitään kaksi sen jälkeläistä joissa on huone, ja muodostetaan käytävä näiden välille.

Näitä kutsutaan App-luokan main-metodista. List-luokka toteuttaa lista-tietorakenteen, ja Random-luokka pitää sisällään satunnaisuuteen liittyvät metodit.


### Aika- ja tilavaativuus:

Algoritmi jakaa tilan osiin (jotka ovat vähintään 4x4), joita on pahimmassa tapauksessa n/4, kun n on molempien sivujen pituus. Jakoja tapahtuu tällöin ((n/4)-1)((n/4)+1). Päästään esim. 16x16 kokoisessa luolassa neljään 4x4 palaan jakamalla osiin 15 kertaa. Yksi jako tapahtuu vakioajassa. Tämän jälkeen sijoitetaan huoneet pienimpiin osiin, jotka ovat muodostuneen puun lehtiä, eli n/4 huonetta. Yhden huoneen sijoittaminen tapahtuu vakioajassa. Huoneita sijoitetaan pahimmissa tapauksessa siis n/4. Käytävät tehdään yhtä monta kertaaa kuin osia, jotka eivät sisällä huonetta, eli ((n/4)-1)((n/4)+1)-(n/4), näiden huoneiden löytäminen tapahtuu kuitenkin puuta läpikäymällä, mihin kuluu pahimmillaan aikaa puun korkeuden verran eli sqrt(((n/4)-1)((n/4)+1)+1)-1. Yhteensä siis ((n/4)-1)((n/4)+1)-(n/4) * (sqrt(((n/4)-1)((n/4)+1)+1)-1) Käytävän tekeminen tapahtuu myös vakioajassa.

Tästä saadaan pahimman tapauksen aikavaativuudeksi (jako)+(huoneiden sijoitus)+(käytävien sijoitus)=((n/4)-1)((n/4)+1)+(n/4)+(((n/4)-1)((n/4)+1)-(n/4) * (sqrt(((n/4)-1)((n/4)+1)+1)-1)). Pahimman tapauksen aikavaativuus on siis luokkaa O(n^2), mihin alussa pyrinkin.

Algoritmin pahimman tapauksen tilavaativuus on osien määrä ((n/4)-1)((n/4)+1), huoneiden määrä n/4 ja käytäviin tarvittavien neliskulmioiden määrä 2(((n/4)-1)((n/4)+1)-(n/4)). Eli ((n/4)-1)((n/4)+1)+(n/4)+2(((n/4)-1)((n/4)+1)-(n/4))=3((n/4)-1)((n/4)+1)-(n/4). Pahimman tapauksen tilavaativuuskin on siis luokkaa O(n^2), mihin alussa pyrinkin.


### Työn puutteet ja parannusehdotukset:
Työstä puuttuu mahdollisuus valita huoneiden tarkka määrä.

### Lähteet:
* http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
* https://gamedevelopment.tutsplus.com/tutorials/how-to-use-bsp-trees-to-generate-game-maps--gamedev-12268 ftp://ftp.sgi.com/other/bspfaq/faq/bspfaq.html
