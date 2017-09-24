## Viikkoraportti 3

Tein algoritmin jossain määrin toimivaksi ja kirjoitin testejä koodiille.

Ohjelma pystyy tällä hetkellä tuottamaan luolaston, jonka koko on käyttäjän päätettävissä.

Ainut ongelma johon törmäsin, on se, että välillä (harvoin) käytävän kulma puuttuu, jolloin se on muotoa (|| = seinä):
![kuva](https://image.prntscr.com/image/UInJZAhmTYKX1jTCWhz7Bw.png)

Huomasin ongelman vasta palautusta tehdessäni, joten en ehtinyt etsimään ratkaisua, uskoisin ratkaisun löytyvän createHallway() metodia tutkimalla.

Seuraavaksi:
1. Käytävien kanssa välillä esiintyvän ongelman korjaaminen.
2. Lisään käyttäjälle enemmän mahdollisuuksia vaikuttaa generoitavan luolaston ominaisuuksiin (tällä hetkellä vain leveys ja korkeus).
3. Refaktoroin koodia (esimerkiksi createHallway() metodi on isokokoinen)
4. Teen käyttöliittymän

Viikon aikana käytetty aika: 15 tuntia
