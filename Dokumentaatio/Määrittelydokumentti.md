## Määrittelydokumentti

**Mitä algoritmeja ja tietorakenteita toteutat työssäsi**

Toteutan työssäni BSP-puun (Binary Space Partitioning), jota käytän tilan jakamiseen erilaisiin suorakulmion muotoisiin palasiin. Luolaston huoneet sijoitetaan näiden palasten sisälle ja yhdistetään käytävillä toisiinsa puurakennetta hyödyntäen (jokaisen tason sisar-lehtien huoneet yhdistetään toisiinsa). Luolaston generointi tapahtuu siis etukäteen.


**Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet**

Ongelma, jota ratkaisen on satunnaisen luolaston generointi, jossa jokaiseen paikkaan on mahdollista päästä luolaston jokaisesta paikasta. Valitsin BSP-puun, koska sen avulla pystyn yhdistämään helposti huoneet käytävillä. Lisäksi luolaston generointia on helppo muuttaa mieluisamman lopputuloksen saamiseksi muuttamalla tilan jakamista.


**Mitä syötteitä ohjelma saa ja miten näitä käytetään**

Ohjelma saa syötteeksi luolaston koon ~~ja huoneiden määrän~~, mitä käytetään luolastoa generoidessa tekemään siitä käyttäjän toiveiden mukainen.


**Tavoitteena olevat aika- ja tilavaativuudet**

Tavoitteena oleva pahimman tapauksen aikavaativuus on O(n^2), ja tilavaativuus O(n^2).


**Lähteet**

http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
https://gamedevelopment.tutsplus.com/tutorials/how-to-use-bsp-trees-to-generate-game-maps--gamedev-12268
ftp://ftp.sgi.com/other/bspfaq/faq/bspfaq.html
