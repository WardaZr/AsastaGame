package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi3 extends Misi {

    public Misi3(){

        setNamaMisi("Misi 3");
        setDeskripsiMisi("Ambil item yang tersedia pada ruangan. \n=> Pergilah ke lantai 8 untuk mencari item perakit bom. " +
                "\nRakit lah bom dengan bantuan NPC Rakit");
        setWilayahmisi("808");
        setHadiah(45);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Senjata yang  arya miliki belum cukup untuk  mengalahkan monster yang lebih kuat. ||");
        System.out.println("|| Ia memerlukan  senjata yang lebih  mematikan untuk menang dari  monster tersebut. ||");
        System.out.println("|| Pada lantai 8, ada ruangan yang memiliki bahan - bahan yang bisa digunakan untuk  ||");
        System.out.println("|| merakit bom. Bom dapat memudahkan arya dalam melakukan  penyerangan pada monster  ||");
        System.out.println("|| yang lebih kuat.                                                                  ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(objPlayer.cariItem("Bom") != null && lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

                setMisiClear(true);
                objPlayer.setExp(objPlayer.getExp() + getHadiah());

                System.out.println("=> Misi 3 Berhasil! Bom berhasil dibuat!");
                System.out.println("=> Exp bertambah : " + getHadiah());

                objPlayer.upgradeLevel();
            }
        }
    }

    //    ============== END OF METHOD ==============
}
