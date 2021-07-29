package Missions;

import Characters.Characters;
import General.GameInfo;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi2 extends Misi {

    private GameInfo objGameInfo;

    public Misi2(){

        setNamaMisi("Misi 2");
        setDeskripsiMisi("Pergilah ke lantai 7! \n=> Cari NPC untuk membantu merakit senjata agar bisa melawan monster.");
        setWilayahmisi("705");
        setHadiah(50);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Untuk menyelesaikan   seluruh misi,  arya tidak  bisa melakukannya sendiri.  Arya ||");
        System.out.println("|| memerlukan bantuan dari  orang yang memiliki  kemampuan.  Seluruh warga tau bahwa ||");
        System.out.println("|| salah satu warga apartemen  tersebut memiliki  keterampilan  dalam   merakit alat ||");
        System.out.println("|| elektonik. Dengan kondisi yang darurat seperti ini, orang tersebut bisa membantu  ||");
        System.out.println("|| Arya untuk menciptakan alat yang dapat digunakan untuk melawan monster.           ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(cariNpcRakit() && lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

                setMisiClear(true);
                objPlayer.setExp(objPlayer.getExp() + getHadiah());
                System.out.println("=> Misi 2 Berhasil! Npc Rakit ditemukan!");
                System.out.println("=> Exp bertambah : " + getHadiah());

                objPlayer.upgradeLevel();
            }
        }
    }

    public boolean cariNpcRakit(){

        for(Characters objCharacter : objPlayer.getArrCharacter()){
            if(objCharacter.getLevel().equals("Perakit")){
                return true;
            }
        }

        return false;
    }

    //    ============== END OF METHOD ==============
}
