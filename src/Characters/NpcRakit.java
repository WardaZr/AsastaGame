package Characters;

import Items.Item;
import Items.Senjata;

import java.util.ArrayList;
import java.util.HashMap;

import static General.GameInfo.objPlayer;
import static General.GameEngine.scanner;

public class NpcRakit extends Characters{

    HashMap<Item, ArrayList<String>> ItemUpList = new HashMap<>();    //key Item itu item hasil updateannya, arrlist item itu si bahan2nya

    public NpcRakit(){

        this.setLevel("Perakit");

        //  tongkat baseball paku
        Senjata objBaseballPaku = new Senjata();
        ArrayList<String> arrBahanBP = new ArrayList<>();
        arrBahanBP.add("Tongkat Baseball");
        arrBahanBP.add("Paku");

        objBaseballPaku.setNamaItem("Baseball Paku");
        objBaseballPaku.setDeskripsiItem("Tongkat Baseball dibalut dengan Paku");
        objBaseballPaku.setDamage(20);
        objBaseballPaku.setKetersediaan("Tidak habis dipakai");
        ItemUpList.put(objBaseballPaku, arrBahanBP);

        //  tombak
        Senjata objTombak = new Senjata();
        ArrayList<String> arrBahanTombak = new ArrayList<>();
        arrBahanTombak.add("Pisau Dapur");
        arrBahanTombak.add("Tongkat Pel");
        arrBahanTombak.add("Lakban");

        objTombak.setNamaItem("Tombak");
        objTombak.setDeskripsiItem("Tombak yang Tajam");
        objTombak.setKetersediaan("Sekali Pakai");
        objTombak.setDamage(15);
        ItemUpList.put(objTombak, arrBahanTombak);

        //  bom
        Senjata objBom = new Senjata();
        ArrayList<String> arrBahanBom = new ArrayList<>();
        arrBahanBom.add("Korek Api");
        arrBahanBom.add("Botol Kaca");
        arrBahanBom.add("Bensin");

        objBom.setNamaItem("Bom");
        objBom.setDeskripsiItem("Bom yang dapat meledakan 1 ruangan");
        objBom.setKetersediaan("Sekali Pakai");
        objBom.setDamage(200);
        ItemUpList.put(objBom, arrBahanBom);
    }


    //player memilih ingin dibuatkan senjata apa
    public Item pilihList(){
        ArrayList<Item> arrItembaru = new ArrayList<>();

        int i = 1;

        for (Item senjataBaru : ItemUpList.keySet()) {
            System.out.printf("[%d] %s\n", i, senjataBaru.getNamaItem());   //print pilihan
            arrItembaru.add(senjataBaru);
            i++;
        }

        System.out.print("Pilih senjata : ");
        int pil = scanner.nextInt();
        System.out.println();

        if (pil < 1 || pil > ItemUpList.size()) return null;

        return arrItembaru.get(pil-1);
    }


    public void rakitItem(){
        Item itemBaru = pilihList();		//pilihan player

        if (itemBaru == null){
            System.out.println("Pilihan tidak tersedia");
        }
        else {
            //cek bahan
            boolean bahanLengkap = true;

            for (String objBahan : ItemUpList.get(itemBaru)){

                Item itemPlayer = objPlayer.cariItem(objBahan);

                if (itemPlayer == null){

                    System.out.println("Anda kurang " + objBahan + " untuk membuat " + itemBaru.getNamaItem());
                    bahanLengkap = false;   //bahan tidak lengkap

                }
            }

            // jika bahan lengkap, item dapat dirakit dan diserahkan ke player
            if (bahanLengkap){

                System.out.println("Berhasil merakit " + itemBaru.getNamaItem());

                serahkanItem(itemBaru);
            }
        }
    }

    public void serahkanItem(Item objItem){

        System.out.println("Item diserahkan kepada Player");
        objPlayer.getArrItem().add(objItem);   //add item hasil rakitan

        for (String objBahan : ItemUpList.get(objItem)){

            //hapus item player yang dijadikan bahan membuat item/senjata baru
            Item itemPlayer = objPlayer.cariItem(objBahan);
            objPlayer.getArrItem().remove(itemPlayer);
        }

        //hapus list bahan
        ItemUpList.remove(objItem);
    }
}
