package Missions;

import static General.GameInfo.lokasiAktif;
import static General.GameInfo.objPlayer;

public class Misi6 extends Misi {

    public Misi6(){

        setNamaMisi("Misi 6");
        setDeskripsiMisi("Pergilah ke ruang cctv! \n=> Lihat posisi warga yang masih hidup!.");
        setWilayahmisi("501"); // can bikin
        setHadiah(60);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Arya harus bergegas untuk menyelamatkan seluruh warga. Dia tidak tau posisi warga ||");
        System.out.println("|| yang harus diselamatkan ada pada ruangan yang mana.                               ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if (lokasiAktif != null){
            if(lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

                setMisiClear(true);

                objPlayer.setExp(objPlayer.getExp() + getHadiah());

                setDeskripsiMisi("Pergilah ke ruang cctv! \n=> Lihat posisi warga yang masih hidup!.");
                System.out.println("=> Misi 6 Berhasil. \n=> Ruang CCTV ditemukan. \n=>" +
                        " NPC berada di Ruangan 103, 106, 205, 206, 209, 308, 405, 406, 410, 505, 506, 703,710 \n"); // npc biasa
                // npc serang: 2 orang (Ruangan : 205 & 405) -> khususon 1 orang aja
                // npc biasa 2 orang per ruangan
                // npc rakit udah
                // total 11 x 2 = 22 + 2 + 1 = 23 orang

                System.out.println("=> Exp bertambah : " + getHadiah());

                objPlayer.upgradeLevel();
            }
        }
    }

    //    ============== END OF METHOD ==============
}
