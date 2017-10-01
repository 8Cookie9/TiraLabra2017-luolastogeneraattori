## Toteutusdokumentti

**Ohjelman yleisrakenne**
Ohjelman toiminnan kannalta tärkeimmät luokat ovat Leaf, Dungeon ja Room. Room luokka kuvaa suorakulmion muotoista huonetta eikä sisällä muuta toiminnallisuutta. Leaf-luokka pitää sisällään muodostuvan puun lehden, joka kuvaa Room luokan tavoin suorakulmiota. Leaf-luokalla on metodi split, joka jakaa sen ehtojen mukaan kahteen osaan, joista tulee lehden vasen ja oikea lapsi. Lehdellä on myös metodi huoneiden tekemiseen lehden sisälle ja metodi joka yhdistää kaksi huonetta käytävällä toisiinsa. Dungeon-luokka kuvaa koko luolaa, sillä on leveys ja korkeus, metodit luolan tulostamiseen ja saamiseen int[][] taulukkona, sekä createLeafs()-metodi joka luo puun Leaf-oliosta. Näitä kutsutaan App-luokan main-metodista. List-luokka toteuttaa lista-tietorakenteen, ja Random-luokka pitää sisällään satunnaisuuteen liittyvät metodit.


