package Items;

import Locations.Lantai;

import static General.GameInfo.*;
import static Items.MethodItemSpesial.lihatMap;

public class Item {

    private String namaItem;
    private String deskripsiItem;
    private String ketersediaan;

    //    ============== START METHOD ==============

    public void printItem(){
        System.out.println("Nama Item       : " + getNamaItem());
        System.out.println("Deskripsi Item  : " + getDeskripsiItem());
    }

    public void diambil() {

        System.out.println(this.namaItem + " diambil player");
        objPlayer.getArrItem().add(this);     //tambahkan  objek ini (this) pada player
    }

    public void dipakai(){
        String arrNama = this.namaItem;
        String[] arrtempNamaKunci = arrNama.split(" ");
        if (this.namaItem.equals("Map")){
            lihatMap();
        }else if (arrtempNamaKunci[0].equals("Kunci")){
            objPlayer.setObjItemDigunakan(2,this);
        }
        else {
            System.out.println("Item hanya bisa disimpan");
        }

    }

    public int getBenefit(){return 0;}

    public void dibuang(){

        System.out.println(this.namaItem + " dibuang player ke ruangan");
        lokasiAktif.getArrItem().add(this);  //tambah ke lokasi aktif player
        objPlayer.getArrItem().remove(this); //hapus dari player
    }

    //    ============== END OF METHOD ==============

    //    ============== START SETTER GETTER ==============

    public String getNamaItem() {
        return namaItem;
    }
    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public String getDeskripsiItem() {
        return deskripsiItem;
    }
    public void setDeskripsiItem(String desKripsiItem) {
        this.deskripsiItem = desKripsiItem;
    }

    public String getKetersediaan() {
        return ketersediaan;
    }
    public void setKetersediaan(String ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    //    ============== END OF SETTER GETTER ==============

}
