package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi4 extends Misi {

    public Misi4(){

        setNamaMisi("Misi 4");
        setDeskripsiMisi("Pergilah ke lantai 9! \n=> Lawan monster untuk mendapatkan kunci rooftoop!.");
        setWilayahmisi("906");
        setHadiah(70);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Sebelum menyelamatkan  lebih banyak warga,  arya harus mengirimkan sinyal bantuan.||");
        System.out.println("|| Tempat yang paling tepat untuk mengirimkan sinyal adalah tempat yang paling tinggi||");
        System.out.println("|| Rooftop merupakan tempat yang paling tepat, tetapi ruangan tersebut terkunci.     ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(lokasiAktif.getNamaRuangan().equals(getWilayahmisi())
                    && objPlayer.cariItem("Kunci Rooftop") != null
                    && lokasiAktif.getObjMonster() == null){

                setMisiClear(true);

                objPlayer.setExp(objPlayer.getExp() + getHadiah());

                System.out.println("=> Misi 4 Berhasil! \n=> Anda sudah mendapatkan kunci rooftop & Monster Spesial Dikalahkan.");
                System.out.println("=> Exp bertambah : " + getHadiah());

                objPlayer.upgradeLevel();
            }
        }
    }

    //    ============== END OF METHOD ==============
}
