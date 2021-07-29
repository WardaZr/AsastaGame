package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi8 extends Misi {

    public Misi8(){

        setNamaMisi("Misi 8");
        setDeskripsiMisi("Pergilah ke lantai 1! \n=> Cari kunci untuk membuka bunker!");
        setWilayahmisi("107");
        setHadiah(100);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Lantai yang paling aman  adalah ruang bawah tanah atau Bunker. Ruangan tersebut   ||");
        System.out.println("|| selalu  terkunci, kunci  tersebut dipegang oleh  penjaga apartemen. Arya harus    ||");
        System.out.println("|| menemui penjaga yang masih selamat dan membawa kunci tersebut.                    ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(lokasiAktif.getNamaRuangan().equals(getWilayahmisi())
                    && objPlayer.cariItem("Kunci Bunker") != null
                    && lokasiAktif.getObjMonster() == null){

                setMisiClear(true);

                objPlayer.setExp(objPlayer.getExp() + getHadiah());

                System.out.println("=> Misi 8 Berhasil. Kunci Bunker Ditemukan!");
                System.out.println("=> Exp bertambah : " + getHadiah());

                objPlayer.upgradeLevel();
            }
        }
    }

    //    ============== END OF METHOD ==============
}
