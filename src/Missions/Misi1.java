package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi1 extends Misi {

    public Misi1(){

        setNamaMisi("Misi 1");
        setDeskripsiMisi("Carilah MAP untuk melihat denah apartemen.\n=> Ambil seluruh item yang ada di ruangan!!");
        setWilayahmisi("607");
        setHadiah(0);
        setMisiClear(false);
    }

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Arya  harus menyelamatkan  seluruh warga yang masih selamat  di dalam apartemen.  ||");
        System.out.println("|| Untuk  mengetahui  denah lokasi  apartemen diperlukan Map,  Map tersebut dimiliki ||");
        System.out.println("|| dimiliki oleh  semua warga di apartemen.  Kamar arya tidak memiliki  senjata yang ||");
        System.out.println("|| cukup untuk  mengalahkan monster,   tetapi arya bisa  menggunakan  alat  -  alat  ||");
        System.out.println("|| disekelilingnya untuk membantu  perjalanannya melawan monster.                    ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(objPlayer.cariItem("Map") != null && lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

                setMisiClear(true);
                System.out.println("=> Misi 1 Berhasil ! Map telah ditemukan.");
            }
        }
    }

    //    ============== START METHOD ==============


    //    ============== END OF METHOD ==============
}
