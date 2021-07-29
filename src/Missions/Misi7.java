package Missions;

import General.GameInfo;
import Locations.Lantai;

import static General.GameInfo.objPlayer;

public class Misi7 extends Misi {

    private GameInfo objGameInfo;


    public Misi7(){

        setNamaMisi("Misi 7");
        setDeskripsiMisi("Selamatkan seluruh warga yang masih hidup! \n => Ajak seluruh warga untuk masuk ke dalam bunker!.");
        setHadiah(100);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Posisi warga sudah diketahui,arya harus memastikan semua warga selamat.Menggunakan||");
        System.out.println("|| map dan informasi dari CCTV,  dia bisa menemukan warga dengan mudah.   Dia harus  ||");
        System.out.println("|| memastikan semua ikut dan berpindah ke tempat yang lebih aman.                  ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if(objPlayer.getArrCharacter().size() >= 17){ //target minimal

            setMisiClear(true);

            objPlayer.setExp(objPlayer.getExp() + getHadiah());

            System.out.println("=> Misi 7 Berhasil! Warga Ditemukan");
            System.out.println("=> Exp bertambah : " + getHadiah());

            objPlayer.upgradeLevel();
        }
    }

    //    ============== END OF METHOD ==============
}
