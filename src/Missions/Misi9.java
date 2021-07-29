package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi9 extends Misi {

    public Misi9(){

        setNamaMisi("Misi 9");
        setDeskripsiMisi("Pergilah ke bunker & tunggu hingga militer datang menyelamatkan.");
        setWilayahmisi("Bunker");
        setHadiah(0);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("||Kunci  telah ditemukan, pastikan mereka   memiliki stok  makanan yang cukup untuk  ||");
        System.out.println("||menunggu hingga  bantuan datang. Jangan sampai warga  meninggalkan lokasi tersebut ||");
        System.out.println("||hingga bala bantuan datang.                                                        ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

                setMisiClear(true);

                objPlayer.setExp(objPlayer.getExp() + getHadiah());

                System.out.println("=> Misi Selesai !!! <=");

                objPlayer.upgradeLevel();
            }
        }
    }

    //    ============== END OF METHOD ==============
}
