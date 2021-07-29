package Locations;

import General.Bertarung;
import Items.Item;
import Characters.*;

import java.util.ArrayList;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;
import static Items.MethodItemSpesial.lihatCCTV;
import static General.GameEngine.scanner;

public class Ruangan {

    private ArrayList<Item> arrItem = new ArrayList<>();
    private ArrayList<Characters> arrNonPlayer = new ArrayList<>();
    private Monster objMonster ;

    private String namaRuangan;
    private String deskripsiRuangan;
    private boolean isDikunci;

    private boolean isCCTVroom;

    private Bertarung objBertarung = new Bertarung();

    public Ruangan(String namaRuangan, String deskripsiRuangan){
        this.namaRuangan = namaRuangan;
        this.deskripsiRuangan = deskripsiRuangan;
        isDikunci = false;
        isCCTVroom = false;
    }

    //    ============== START METHOD ==============

    public void printRuangan(){
        System.out.println("Nama        :" + getNamaRuangan());
        System.out.println("Deskripsi   :" + getDeskripsiRuangan());
        System.out.println(isDikunci());
        System.out.println();
    }

    public void printNpc(){

        System.out.println("NPC dalam Ruangan >>");
        System.out.println("-----------------------------");

        int i = 1;
        for (Characters objnpc : arrNonPlayer){
            System.out.println(i + ". "+objnpc.getNama());
            i++;
        }
        System.out.println();
    }

    public void printItem(){
        int i = 1;

        System.out.println("Item dalam Ruangan >>");
        System.out.println("-----------------------------");

        for (Item objItem : arrItem) {
            System.out.println(i + ". " + objItem.getNamaItem());
            i++;
        }
    }

    public void masukRuangan(){
        System.out.println("Lokasi");
        System.out.println("_______________________________");
        printRuangan();

        boolean isExit = aksiTerhadapMonster();

        if (!isExit){

            aksiTerhadapNpc();

            aksiTerhadapItem();

            System.out.println();

            if (isCCTVroom){
                System.out.println("Ada monitor CCTV >>");
                System.out.println("----------------------------");
                System.out.println("Lihat monitor CCTV? \n1. ya \n0. tidak");
                System.out.print("___ : ");
                int pilLihat = scanner.nextInt();

                if (pilLihat == 1){
                    lihatCCTV();
                }
            }
        }
    }

    public boolean aksiTerhadapMonster (){
        boolean isExit = false;

        if (objMonster == null){ //cek jika di lokasi tidak ada monster
            System.out.println("Tidak terdapat monster");
        }
        else {
            System.out.println("ADA MONSTER !!!");
            System.out.println("=============================");
            objMonster.printCharacter();
            isExit = objBertarung.bertarung(objMonster);
        }

        return isExit;
    }

    public void aksiTerhadapNpc(){

        if (arrNonPlayer.isEmpty()){

            System.out.println("Tidak terdapat NPC");
        }
        else {

            printNpc();

            for (Characters objnpc: getArrNonPlayer()){
                objPlayer.ajakNPC(objnpc);
            }
            arrNonPlayer.removeAll(arrNonPlayer);
        }
    }

    public void aksiTerhadapItem(){
        if (arrItem.isEmpty()){ //cek jika di lokasi tidak ada senjata & item

            System.out.println("Tidak terdapat Item didalamnya..");
        }
        else {

            printItem();

            System.out.println("Tekan 0 jika tidak ingin mengambil");
            System.out.print("Pilih item mau diambil : ");
            int pil = scanner.nextInt();

            if (pil != 0){
                arrItem.get(pil-1).diambil();
                ambilItem(arrItem.get(pil-1));
            }
        }
    }

    public void ambilItem(Item objItem){
        getArrItem().remove(objItem);
    }

    public void pindahkanNpc(Characters objnpc){
        getArrNonPlayer().remove(objnpc);
    }

    //    ============== END OF METHOD ==============

    //    ============== START SETTER GETTER ==============

    public boolean isDikunci () {
        return isDikunci;
    }
    public void setDikunci (boolean dikunci) {
        isDikunci = dikunci;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public String getDeskripsiRuangan() {
        return deskripsiRuangan;
    }

    public ArrayList<Item> getArrItem () {
        return arrItem;
    }
    public ArrayList<Characters> getArrNonPlayer () {
        return arrNonPlayer;
    }

    public Monster getObjMonster() {
        return objMonster;
    }

    public void setObjMonster(Monster objMonster) {
        this.objMonster = objMonster;
    }

    public boolean isCCTVroom () {
        return isCCTVroom;
    }
    public void setCCTVroom (boolean CCTVroom) {
        isCCTVroom = CCTVroom;
    }
    //    ============== END OF SETTER GETTER ==============

}
