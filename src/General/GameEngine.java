package General;

import Characters.*;
import Items.*;
import Locations.*;
import Missions.*;

import java.util.ArrayList;
import java.util.Scanner;

import static General.GameInfo.*;

public class GameEngine {

    Menu menu = new Menu();
    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Lantai> arrLantai = new ArrayList<>();     // dijadikan static agar bisa diakses oleh map
    ArrayList<Misi> mission = new ArrayList<>();

    public GameEngine(){
        //set player
        objPlayer.setNama("ARYA");
        objPlayer.setDamage(20);
        objPlayer.setHp(100);
        objPlayer.setDefense(0);
        objPlayer.setLevelPlayer(1);
        objPlayer.setExp(0);
        objPlayer.setLevel("Player");

        //init bunker
        Lantai objBunker = new Lantai("Bunker","Ruang Bawah Tanah, Lokasi paling aman!");
        Ruangan objRuangBunker = new Ruangan("Bunker", "Ruangan bawah tanah, lokasi paling aman");
        //init lantai 1
        Lantai objLantai1 = new Lantai("1","Lantai 1");
        //101
        Ruangan objRuang101 = new Ruangan("101","Mini Market");
        Makanan objRoti = new Makanan();
        objRoti.setNamaItem("Roti");
        objRoti.setDeskripsiItem("Satu pak Roti");
        objRoti.setTambahHp(100);
        Makanan objAir = new Makanan();
        objAir.setNamaItem("Air Mineral");
        objAir.setDeskripsiItem("Satu Galon Air Mineral");
        objAir.setTambahHp(100);
        //102
        Ruangan objRuang102 = new Ruangan("102","Kamar 102");
        //103
        Ruangan objRuang103 = new Ruangan("103","Kamar 103");
        Characters objNpc131 = new Characters();
        objNpc131.setNama("Sari");
        objNpc131.setHp(100);
        objNpc131.setDamage(0);
        objNpc131.setLevel("Biasa");
        Characters objNpc132 = new Characters();
        objNpc132.setNama("Stefi");
        objNpc132.setHp(100);
        objNpc132.setDamage(0);
        objNpc132.setLevel("Biasa");
        //104
        Ruangan objRuang104 = new Ruangan("104","Kamar 104");
        //105
        Ruangan objRuang105 = new Ruangan("105","Kamar 105");
        Armor objArmor = new Armor();
        objArmor.setNamaItem("Armor");
        objArmor.setDeskripsiItem("Perisai untuk menahan moster");
        objArmor.setDefense(100);
        //106
        Ruangan objRuang106 = new Ruangan("106", "Kamar 106");
        Characters objNpc171 = new Characters();
        objNpc171.setNama("Supri");
        objNpc171.setHp(100);
        objNpc171.setDamage(0);
        objNpc171.setLevel("Biasa");
        Characters objNpc172 = new Characters();
        objNpc172.setNama("Jupri");
        objNpc172.setHp(100);
        objNpc172.setDamage(0);
        objNpc172.setLevel("Biasa");

        //107
        Ruangan objRuang107 = new Ruangan("107","Kamar Penjaga Apartemen");
        Item objKey = new Item();
        objKey.setNamaItem("Kunci Bunker");
        objKey.setDeskripsiItem("Kunci untuk membuka Bunker");
        Monster objMonsterBos = new Monster();
        objMonsterBos.setNama("BOS");
        objMonsterBos.setDefense(100);
        objMonsterBos.setHp(1000);
        objMonsterBos.setDamage(100);
        objMonsterBos.setLevel("Bos");
        objRuang107.setObjMonster(objMonsterBos);

        //108, 109
        Ruangan objRuang108 = new Ruangan("108", "Kamar 108");
        Ruangan objRuang109 = new Ruangan("109", "Kamar 109");
        //110
        Ruangan objRuang110 = new Ruangan("110", "Kantin");
        Makanan objNasi = new Makanan();
        objNasi.setNamaItem("Nasi Uduk");
        objNasi.setDeskripsiItem("Nasi uduk persediaan kantin");
        objNasi.setTambahHp(100);
        Makanan objTeh = new Makanan();
        objTeh.setNamaItem("Teh Manis");
        objTeh.setDeskripsiItem("Teh Manis Kemasan");
        objTeh.setTambahHp(100);
        //init lantai 2
        //init lantai 2
        Lantai objLantai2 = new Lantai("2","Lantai 2");
        //201,202,203,204
        Ruangan objRuang201 = new Ruangan("201","Kamar 201");
        Ruangan objRuang202 = new Ruangan("202","Kamar 202");
        Ruangan objRuang203 = new Ruangan("203","Kamar 203");
        Ruangan objRuang204 = new Ruangan("204","Kamar 204");
        //205
        Ruangan objRuang205 = new Ruangan("205","Kamar 205");
        NpcSerang objNpcSerang1 = new NpcSerang();
        objNpcSerang1.setNama("Joko");
        objNpcSerang1.setHp(100);
        objNpcSerang1.setDamage(50);
        //206
        Ruangan objRuang206 = new Ruangan("206","Kamar 206");
        Characters objNpc261 = new Characters();
        objNpc261.setNama("Citra");
        objNpc261.setHp(100);
        objNpc261.setDamage(0);
        objNpc261.setLevel("Biasa");
        Characters objNpc262 = new Characters();
        objNpc262.setNama("Baskara");
        objNpc262.setHp(100);
        objNpc262.setDamage(0);
        objNpc262.setLevel("Biasa");
        //207,208
        Ruangan objRuang207 = new Ruangan("207","Kamar 207");
        Ruangan objRuang208 = new Ruangan("208","Kamar 208");
        //209
        Ruangan objRuang209 = new Ruangan("209","Kamar 209");
        Characters objNpc291 = new Characters();
        objNpc291.setNama("Dika");
        objNpc291.setHp(100);
        objNpc291.setDamage(0);
        objNpc291.setLevel("Biasa");
        Characters objNpc292 = new Characters();
        objNpc292.setNama("Misha");
        objNpc292.setHp(100);
        objNpc292.setDamage(0);
        objNpc292.setLevel("Biasa");
        //210
        Ruangan objRuang210 = new Ruangan("210","Kamar 210");
        //init lantai 3
        Lantai objLantai3 = new Lantai("3","Lantai 3");
        //301,302
        Ruangan objRuang301 = new Ruangan("301","Kamar 301");
        Ruangan objRuang302 = new Ruangan("302","Kamar 302");
        //303
        Ruangan objRuang303 = new Ruangan("303","Dapur Umum");
        Senjata objPisau = new Senjata();
        objPisau.setNamaItem("Pisau");
        objPisau.setDeskripsiItem("Pisau Dapur");
        objPisau.setDamage(40);

        //304
        Ruangan objRuang304 = new Ruangan("304","Kamar 304");
        Item objLakban = new Item();
        objLakban.setNamaItem("Lakban");
        objLakban.setDeskripsiItem("Lakban hitam yang kuat");

        //305,306,307
        Ruangan objRuang305 = new Ruangan("305","Kamar 305");
        Ruangan objRuang306 = new Ruangan("306","Kamar 306");
        Ruangan objRuang307 = new Ruangan("307","Kamar 307");
        //308
        Ruangan objRuang308 = new Ruangan("308","Kamar 308");
        Characters objNpc381 = new Characters();
        objNpc381.setNama("Kodir");
        objNpc381.setHp(100);
        objNpc381.setDamage(0);
        objNpc381.setLevel("Biasa");
        Characters objNpc382 = new Characters();
        objNpc382.setNama("Siti");
        objNpc382.setHp(100);
        objNpc382.setDamage(0);
        objNpc382.setLevel("Biasa");
        //309,310
        Ruangan objRuang309 = new Ruangan("309","Kamar 309");
        Ruangan objRuang310 = new Ruangan("310","Kamar 310");

        //init lantai 4
        Lantai objlantai4 = new Lantai("4","Lantai 4");
        //401
        Ruangan objruangan401 = new Ruangan("401","Kamar 401");
        Senjata objPisau01 = new Senjata();
        objPisau01.setNamaItem("Pisau Mokuton");
        objPisau01.setDeskripsiItem("Pisau tradisional Jepang");
        objPisau01.setDamage(15);
        objruangan401.getArrItem().add(objPisau01);
        //402
        Ruangan objruangan402 = new Ruangan("402","Kamar 402");
        Makanan objObat = new Makanan();
        objObat.setNamaItem("Obat Luka");
        objObat.setDeskripsiItem("Untuk mengobati luka yang dalam ");
        objObat.setTambahHp(50);
        objruangan402.getArrItem().add(objObat);
        //403,404
        Ruangan objruangan403 = new Ruangan("403","Kamar 403");
        Ruangan objruangan404 = new Ruangan("404","Kamar 404");
        //405
        Ruangan objruangan405 = new Ruangan("405","Kamar 405");
        NpcSerang npcSerang2 = new NpcSerang();
        npcSerang2.setNama("Brian");
        npcSerang2.setHp(100);
        npcSerang2.setDamage(50);
        objruangan405.getArrNonPlayer().add(npcSerang2);

        //406
        Ruangan objruangan406 = new Ruangan("406","Kamar 406");
        Characters npc4081 = new Characters();
        npc4081.setNama("Sari");
        npc4081.setLevel("Biasa");
        npc4081.setHp(100);
        npc4081.setDamage(0);
        Characters npc4082 = new Characters();
        npc4082.setNama("Sariawan");
        npc4082.setLevel("Biasa");
        npc4082.setHp(100);
        npc4082.setDamage(0);
        objruangan406.getArrNonPlayer().add(npc4081);
        objruangan406.getArrNonPlayer().add(npc4082);
        //407,408,409
        Ruangan objruangan407 = new Ruangan("407","Kamar 407");
        Ruangan objruangan408 = new Ruangan("408","Kamar 408");
        Ruangan objruangan409 = new Ruangan("409","Kamar 409");
        //410
        Ruangan objruangan410 = new Ruangan("410","Kamar 410");
        Armor objHelm = new Armor();
        objHelm.setNamaItem("Helm");
        objHelm.setDeskripsiItem("Pelindung kepala");
        objHelm.setDefense(50);
        objruangan410.getArrNonPlayer().add(npc4081);
        objruangan410.getArrNonPlayer().add(npc4082);

        //init lantai 5
        Lantai objLantai5 = new Lantai("5","Lantai 5");
        //501
        Ruangan objRuangan501 = new Ruangan("501", "Ruangan 501");
        objRuangan501.setCCTVroom(true);
        //502,
        Ruangan objRuangan502 = new Ruangan("502", "Ruangan 502");
        objRuangan502.getArrItem().add(objRoti);
        objRuangan502.getArrItem().add(objNasi);
        Ruangan objRuangan503 = new Ruangan("503", "Ruangan 503");
        Ruangan objRuangan504 = new Ruangan("504", "Ruangan 504");
        //505
        Ruangan objRuangan505 = new Ruangan("505", "Ruangan 505");
        Characters objnpcR05 = new Characters();
        objnpcR05.setNama("Situmorang");
        objnpcR05.setHp(100);
        objnpcR05.setLevel("Biasa");
        objnpcR05.setDamage(0);
        objRuangan505.getArrNonPlayer().add(objnpcR05);
        objRuangan505.getArrNonPlayer().add(objNpc131);
        //506
        Ruangan objRuangan506 = new Ruangan("506", "Ruangan 506");
        Characters objnpcR06 = new Characters();
        objnpcR06.setNama("Sintha");
        objnpcR06.setHp(100);
        objnpcR06.setLevel("Biasa");
        objnpcR06.setDamage(0);
        objRuangan506.getArrNonPlayer().add(objnpcR06);
        objRuangan506.getArrNonPlayer().add(objNpc381);
        //507,508,609,510
        Ruangan objRuangan507 = new Ruangan("507", "Ruangan 507");
        Ruangan objRuangan508 = new Ruangan("508", "Ruangan 508");
        Ruangan objRuangan509 = new Ruangan("509", "Ruangan 509");
        Ruangan objRuangan510 = new Ruangan("510", "Ruangan 510");




        //init lantai6
        Lantai objLantai6 = new Lantai("6", "Lantai 6");
        //601,602,603,604,605
        Ruangan objRuang601 = new Ruangan("601","Kamar 601");
        Ruangan objRuang602 = new Ruangan("602","Kamar 602");
        Ruangan objRuang603 = new Ruangan("603","Kamar 603");
        Ruangan objRuang604 = new Ruangan("604","Kamar 604");
        Ruangan objRuang605 = new Ruangan("605","Kamar 605");
        //606
        Ruangan objRuang606 = new Ruangan("606","Kamar 606");
        Makanan objSarden = new Makanan();
        objSarden.setNamaItem("ABC");
        objSarden.setDeskripsiItem("Daging sarden kaleng");
        objSarden.setTambahHp(30);

        Makanan objKornet = new Makanan();
        objKornet.setNamaItem("Kornet Sapi");
        objKornet.setDeskripsiItem("Daging sapi kornet dalam kemasan kaleng");
        objKornet.setTambahHp(34);

        objRuang606.getArrItem().add(objSarden);
        objRuang606.getArrItem().add(objSarden);
        objRuang606.getArrItem().add(objKornet);
        //init kamar607/kamar arya
        Ruangan objKamarArya = new Ruangan("607", "Tempat tinggal arya");
        Item objMap = new Item();
        objMap.setNamaItem("Map");
        objMap.setDeskripsiItem("Peta lokasi apartemen");
        objKamarArya.getArrItem().add(objMap);

        Senjata objTongkatBase = new Senjata();
        objTongkatBase.setNamaItem("Tongkat Baseball");
        objTongkatBase.setDeskripsiItem("Tongkat Baseball dengan tanda tangan asli C.Ronaldo");
        objTongkatBase.setDamage(100);
        objKamarArya.getArrItem().add(objTongkatBase);
        //608,609,610
        Ruangan objRuang608 = new Ruangan("608","Kamar 608");
        Ruangan objRuang609 = new Ruangan("609","Kamar 609");
        Ruangan objRuang610 = new Ruangan("610","Kamar 610");

        //init lantai 7
        Lantai objLantai7 = new Lantai("7", "lantai 7");

        //701,702
        Ruangan objKamar701 = new Ruangan("701","Ruangan 701");
        Ruangan objKamar702 = new Ruangan("702","Ruangan 702");
        Item objPisauDapur = new Item();
        objPisauDapur.setNamaItem("Paku");
        objPisauDapur.setDeskripsiItem("Paku yang berkarat");
        objKamar702.getArrItem().add(objPisauDapur);
        //703,
        Ruangan objKamar703 = new Ruangan("703","Ruangan 703");
        objKamar703.getArrNonPlayer().add(objNpc132);
        objKamar703.getArrNonPlayer().add(objNpc292);
        //704,705
        Ruangan objKamar704 = new Ruangan("704","Ruangan 704");
        Ruangan objKamar705 = new Ruangan("705","Ruangan 705");
        NpcRakit objnpcRakit = new NpcRakit();
        objnpcRakit.setNama("levi");
        objnpcRakit.setHp(50);
        objKamar705.getArrNonPlayer().add(objnpcRakit);
        //706,707,708,709
        Ruangan objKamar706 = new Ruangan("706","Ruangan 706");
        Ruangan objKamar707 = new Ruangan("707","Ruangan 707");
        Ruangan objKamar708 = new Ruangan("708","Ruangan 708");
        Ruangan objKamar709 = new Ruangan("709","Ruangan Kosong Bekas Gudang");
        Item objHandphone = new Item();
        objHandphone.setNamaItem("HandPhone");
        objHandphone.setDeskripsiItem("HP Jadul yang bisa menangkap sinyal monster");
        //710
        Ruangan objKamar710 = new Ruangan("710","Ruangan 710");
        objKamar710.getArrNonPlayer().add(objnpcR06);
        objKamar710.getArrNonPlayer().add(objNpc292);

        //init lantai 8
        Lantai objLantai8 = new Lantai("8", "lantai 8");
        //801,802,803,804
        Ruangan objKamar801 = new Ruangan("801", "Ruangan 801");
        Ruangan objKamar802 = new Ruangan("802", "Ruangan 802");
        Ruangan objKamar803 = new Ruangan("803", "Ruangan 803");
        Ruangan objKamar804 = new Ruangan("804", "Ruangan 804");
        Item objKorekapi = new Item();
        objKorekapi.setNamaItem("Korek Api");
        objKorekapi.setDeskripsiItem("Korek Api yang digunakan untuk menyalakan bom");
        //805,806,807
        Ruangan objKamar805 = new Ruangan("805", "Ruangan 805");
        Ruangan objKamar806 = new Ruangan("806", "Ruangan 806");
        Ruangan objKamar807 = new Ruangan("807", "Ruangan 807");
        Ruangan objKamar808 = new Ruangan("808", "Ruangan 808");
        Item objBensin = new Item();
        objBensin.setNamaItem("Bensin");
        objBensin.setDeskripsiItem("Bensin untuk merakit bom");
        Item objBotolkaca = new Item();
        objBotolkaca.setNamaItem("Botol Kaca");
        objBotolkaca.setDeskripsiItem("Botol Kaca bekas ");
        //809,810
        Ruangan objKamar809 = new Ruangan("809", "Ruangan 809");
        Ruangan objKamar810 = new Ruangan("810", "Ruangan 810");



        //init lantai 9

        Lantai objLantai9 = new Lantai("9", "lantai 9");
        //901
        Ruangan objKamar901 = new Ruangan("901", "Ruangan 901");
        Makanan objroti = new Makanan();
        objroti.setNamaItem("Roti");
        objroti.setDeskripsiItem("Roti gandum");
        objroti.setTambahHp(20);

        Armor objblood = new Armor();
        objblood.setNamaItem("Blood-Replenishing");
        objblood.setDeskripsiItem("Ramuan untuk Menambah darah");
        objblood.setDefense(45);

        Ruangan objKamar902 = new Ruangan("902", "Ruangan 902");
        Ruangan objKamar903 = new Ruangan("903", "Ruangan 903");
        Ruangan objKamar904 = new Ruangan("904", "Ruangan 904");
        Ruangan objKamar905 = new Ruangan("905", "Ruangan 905");
        Ruangan objKamar906 = new Ruangan("906", "Ruangan 906");
        Monster objMonster2 = new Monster();
        objMonster2.setHp(200);
        objMonster2.setNama("Loki");
        objMonster2.setDamage(50);
        objMonster2.setDefense(75);
        objMonster2.setLevel("Spesial");


        Item objkunci = new Item();
        objkunci.setNamaItem("Kunci Rooftop");
        objkunci.setDeskripsiItem("Kunci untuk membuka rooftoop");

        Ruangan objKamar907 = new Ruangan("907", "Ruangan 907");
        Ruangan objKamar908 = new Ruangan("908", "Ruangan 908");
        Ruangan objKamar909 = new Ruangan("909", "Ruangan 909");
        Ruangan objKamar910 = new Ruangan("910", "Ruangan 910");


        //init rooftop

        Lantai objLantai10 = new Lantai("10", "lantai 10 / Rooftop");
        Ruangan objrofftop = new Ruangan("Rooftop","Rooftop dari gedung");
        Item objflare = new Item();
        objflare.setNamaItem("Flare");
        objflare.setDeskripsiItem("Flare untuk mengirim sinyal");


        //add bunker
        objRuangBunker.setDikunci(true);
        objBunker.getKamar().add(objRuangBunker);


        //add Lantai 1
        objLantai1.getKamar().add(objRuang101);
        objLantai1.getKamar().add(objRuang102);
        objLantai1.getKamar().add(objRuang103);
        objLantai1.getKamar().add(objRuang104);
        objLantai1.getKamar().add(objRuang105);
        objLantai1.getKamar().add(objRuang106);
        objLantai1.getKamar().add(objRuang107);
        objLantai1.getKamar().add(objRuang108);
        objLantai1.getKamar().add(objRuang109);
        objLantai1.getKamar().add(objRuang110);
        objRuang101.getArrItem().add(objRoti);
        objRuang101.getArrItem().add(objAir);
        objRuang103.getArrNonPlayer().add(objNpc131);
        objRuang103.getArrNonPlayer().add(objNpc132);
        objRuang105.getArrItem().add(objArmor);
        objRuang107.getArrItem().add(objKey);
        objRuang106.getArrNonPlayer().add(objNpc171);
        objRuang106.getArrNonPlayer().add(objNpc172);
        objRuang110.getArrItem().add(objTeh);
        objRuang110.getArrItem().add(objNasi);


        //add Lantai 2
        objLantai2.getKamar().add(objRuang201);
        objLantai2.getKamar().add(objRuang202);
        objLantai2.getKamar().add(objRuang203);
        objLantai2.getKamar().add(objRuang204);
        objLantai2.getKamar().add(objRuang205);
        objLantai2.getKamar().add(objRuang206);
        objLantai2.getKamar().add(objRuang207);
        objLantai2.getKamar().add(objRuang208);
        objLantai2.getKamar().add(objRuang209);
        objLantai2.getKamar().add(objRuang210);
        objRuang205.getArrNonPlayer().add(objNpcSerang1);
        objRuang206.getArrNonPlayer().add(objNpc261);
        objRuang206.getArrNonPlayer().add(objNpc262);
        objRuang209.getArrNonPlayer().add(objNpc291);
        objRuang209.getArrNonPlayer().add(objNpc292);


        //add Lantai 3
        objLantai3.getKamar().add(objRuang301);
        objLantai3.getKamar().add(objRuang302);
        objLantai3.getKamar().add(objRuang303);
        objLantai3.getKamar().add(objRuang304);
        objLantai3.getKamar().add(objRuang305);
        objLantai3.getKamar().add(objRuang306);
        objLantai3.getKamar().add(objRuang307);
        objLantai3.getKamar().add(objRuang308);
        objLantai3.getKamar().add(objRuang309);
        objLantai3.getKamar().add(objRuang310);
        objRuang303.getArrItem().add(objPisau);
        objRuang304.getArrItem().add(objLakban);
        objRuang308.getArrNonPlayer().add(objNpc381);
        objRuang308.getArrNonPlayer().add(objNpc382);

        //add Lantai 4
        objlantai4.getKamar().add(objruangan401);
        objlantai4.getKamar().add(objruangan402);
        objlantai4.getKamar().add(objruangan403);
        objlantai4.getKamar().add(objruangan404);
        objlantai4.getKamar().add(objruangan405);
        objlantai4.getKamar().add(objruangan406);
        objlantai4.getKamar().add(objruangan407);
        objlantai4.getKamar().add(objruangan408);
        objlantai4.getKamar().add(objruangan409);
        objlantai4.getKamar().add(objruangan410);

        //add Lantai 5
        objLantai5.getKamar().add(objRuangan501);
        objLantai5.getKamar().add(objRuangan502);
        objLantai5.getKamar().add(objRuangan503);
        objLantai5.getKamar().add(objRuangan504);
        objLantai5.getKamar().add(objRuangan505);
        objLantai5.getKamar().add(objRuangan506);
        objLantai5.getKamar().add(objRuangan507);
        objLantai5.getKamar().add(objRuangan508);
        objLantai5.getKamar().add(objRuangan509);
        objLantai5.getKamar().add(objRuangan510);

        //add Lantai 6
        objLantai6.getKamar().add(objRuang601);
        objLantai6.getKamar().add(objRuang602);
        objLantai6.getKamar().add(objRuang603);
        objLantai6.getKamar().add(objRuang604);
        objLantai6.getKamar().add(objRuang605);
        objLantai6.getKamar().add(objRuang606);
        objLantai6.getKamar().add(objKamarArya);
        objLantai6.getKamar().add(objRuang608);
        objLantai6.getKamar().add(objRuang609);
        objLantai6.getKamar().add(objRuang610);

        //add lantai 7
        objLantai7.getKamar().add(objKamar701);
        objLantai7.getKamar().add(objKamar702);
        objLantai7.getKamar().add(objKamar703);
        objLantai7.getKamar().add(objKamar704);
        objLantai7.getKamar().add(objKamar705);
        objLantai7.getKamar().add(objKamar706);
        objLantai7.getKamar().add(objKamar707);
        objLantai7.getKamar().add(objKamar708);
        objLantai7.getKamar().add(objKamar709);
        objLantai7.getKamar().add(objKamar710);

        //add lantai 8
        objKamar804.getArrItem().add(objKorekapi);
        objKamar808.getArrItem().add(objBensin);
        objKamar808.getArrItem().add(objBotolkaca);
        objLantai8.getKamar().add(objKamar801);
        objLantai8.getKamar().add(objKamar802);
        objLantai8.getKamar().add(objKamar803);
        objLantai8.getKamar().add(objKamar804);
        objLantai8.getKamar().add(objKamar805);
        objLantai8.getKamar().add(objKamar806);
        objLantai8.getKamar().add(objKamar807);
        objLantai8.getKamar().add(objKamar808);
        objLantai8.getKamar().add(objKamar809);
        objLantai8.getKamar().add(objKamar810);


        //add lantai 9
        objKamar906.setObjMonster(objMonster2);
        objKamar901.getArrItem().add(objroti);
        objKamar901.getArrItem().add(objblood);
        objKamar906.getArrItem().add(objkunci);
        objLantai9.getKamar().add(objKamar901);
        objLantai9.getKamar().add(objKamar902);
        objLantai9.getKamar().add(objKamar903);
        objLantai9.getKamar().add(objKamar904);
        objLantai9.getKamar().add(objKamar905);
        objLantai9.getKamar().add(objKamar906);
        objLantai9.getKamar().add(objKamar907);
        objLantai9.getKamar().add(objKamar908);
        objLantai9.getKamar().add(objKamar909);
        objLantai9.getKamar().add(objKamar910);

        //add lantai 10
        objrofftop.setDikunci(true);
        objrofftop.getArrItem().add(objflare);
        objLantai10.getKamar().add(objrofftop);

        //add arrLantai
        arrLantai.add(objBunker);
        arrLantai.add(objLantai1);
        arrLantai.add(objLantai2);
        arrLantai.add(objLantai3);
        arrLantai.add(objlantai4);
        arrLantai.add(objLantai5);
        arrLantai.add(objLantai6);
        arrLantai.add(objLantai7);
        arrLantai.add(objLantai8);
        arrLantai.add(objLantai9);
        arrLantai.add(objLantai10);

        //set monster biasa
        Monster objmonster01 = new Monster();
        objmonster01.setHp(100);
        objmonster01.setNama("Hera");
        objmonster01.setDamage(10);
        objmonster01.setLevel("Biasa");

        Monster objMonster1 = new Monster();
        objMonster1.setHp(100);
        objMonster1.setNama("Alexa");
        objMonster1.setDamage(10);
        objMonster1.setLevel("Biasa");

        objRuang104.setObjMonster(objMonster1);
        objRuang201.setObjMonster(objMonster1);
        objRuang202.setObjMonster(objMonster1);
        objRuang203.setObjMonster(objMonster1);
        objRuang204.setObjMonster(objMonster1);
        objRuang301.setObjMonster(objmonster01);
        objRuang302.setObjMonster(objmonster01);
        objRuang310.setObjMonster(objmonster01);
        objruangan401.setObjMonster(objmonster01);
        objruangan403.setObjMonster(objmonster01);
        objruangan404.setObjMonster(objmonster01);
        objRuangan503.setObjMonster(objMonster1);
        objRuangan504.setObjMonster(objMonster1);
        objRuangan510.setObjMonster(objMonster1);
        objKamar701.setObjMonster(objMonster1);
        objKamar702.setObjMonster(objMonster1);
        objKamar808.setObjMonster(objmonster01);



        //set lokasi awal player
        lokasiAktif = objKamarArya;
        lantaiAktif = objLantai6;
    }

    public void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void startMission(){
        menu.Story();
        missionList();

        int indexMisi = 0;
        Misi misiNow = mission.get(indexMisi);

        while (!isGameOver){
            menu.Menu2();
            int pil = scanner.nextInt();
            if (pil < 1 || pil > 7){
                System.out.println("Pilihan tidak tersedia");
            }
            else {
                aksi(pil, misiNow);
            }
            misiNow.AlurMisi();
            if (misiNow.isMisiClear()){
                indexMisi ++;
                misiNow = mission.get(indexMisi);
            }
        }
    }

    public void aksi(int pil, Misi misiNow){
        // lihat misi
        if (pil == 1) {
            misiNow.Story();
            misiNow.printDeskripsi();
        } else if (pil == 2) {                        //  Lihat item dalam tas player
            objPlayer.printItem();
        } else if (pil == 3){                         // lihat item yang digunakan
            objPlayer.printItemDigunakan();
        } else if (pil == 4) {                        // Deskripsi player
            objPlayer.printCharacter();
        } else if (pil == 5) {                        // deskripsi ruangan
            menu.printLokasi();
        } else if (pil == 6){                         // pindah lokasi
            menu.PindahLokasi();
        }
        else if (pil == 7) {                    // lihat npc
            objPlayer.printNPC();
        }
    }

    public void missionList(){
        Misi1 misi1 = new Misi1();
        Misi2 misi2 = new Misi2();
        Misi3 misi3 = new Misi3();
        Misi4 misi4 = new Misi4();
        Misi5 misi5 = new Misi5();
        Misi6 misi6 = new Misi6();
        Misi7 misi7 = new Misi7();
        Misi8 misi8 = new Misi8();
        Misi9 misi9 = new Misi9();

        mission.add(misi1);
        mission.add(misi2);
        mission.add(misi3);
        mission.add(misi4);
        mission.add(misi5);
        mission.add(misi6);
        mission.add(misi7);
        mission.add(misi8);
        mission.add(misi9);
    }
}
