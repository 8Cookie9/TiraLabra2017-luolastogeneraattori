## Testausdokumentti

Testasin eri metodien suoritusnopeutta nanosekuntteina käyttäen Javan System.nanoTime(). Testasin aluksi createLeafs() ja createRooms() metodien suoritusnopeutta erikokoisilla luolastoilla:

### 10x10
**createLeafs()**
* 1004856
* 921777
* 974785
* 938851
* 974020
* Keskiarvo: 962857

**createRooms()**
* 603475
* 551231
* 518101
* 520140
* 555053
* Keskiarvo: 549600


### 20x20
**createLeafs()**
* 1011737
* 1062706
* 1002817
* 968413
* 1104755
* Keskiarvo: 1030085

**createRooms()**
* 1047160
* 1116224
* 1026772
* 973255
* 1055060
* Keskiarvo: 1043694


### 100x100
**createLeafs()**
* 1606801
* 2099163
* 1736772
* 1847885
* 1637128
* Keskiarvo: 1785549


**createRooms()**
* 2686328
* 2646826
* 2870326
* 3527063
* 2939644
* Keskiarvo: 2934037

createRooms() kesto riippuu createLeafs()-metodissa luotujen lehtien määrästä.

![Kuvaaja](https://image.prntscr.com/image/RWrZRWgyTwWUfZsqz4udsw.png)

X-akselilla createLeafs() ja Y-akselilla createRooms().
