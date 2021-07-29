package Missions;

import Items.Item;

import static General.GameInfo.*;

public class Misi5 extends Misi {

    public Misi5(){

        setNamaMisi("Misi 5");
        setDeskripsiMisi("Pergilah ke lantai 10 (rooftoop)! \n=> Cari flare dan gunakan untuk mengirim sinyal ke militer.");
        setWilayahmisi("Rooftop");
        setHadiah(20);
        setMisiClear(false);
    }

    //    ============== START METHOD ==============

    @Override
    public void Story(){
        super.Story();
        System.out.println("=======================================================================================");
        System.out.println("|| Untuk mengirimkan sinyal bantuan, arya memerlukan alat.  Pemilik apartemen selalu ||");
        System.out.println("|| menyimpan alat  untuk mengirim sinyal bantuan di rooftop untuk jaga  -  jaga dari ||");
        System.out.println("|| setiap kemungkinan.                                                               ||");
        System.out.println("=======================================================================================");
    }

    @Override
    public void AlurMisi() {

        if(objPlayer.cariItem("Flare") != null // ini ada
                && lokasiAktif.getNamaRuangan().equals(getWilayahmisi())){

            // dipakai
            nyalakanFlare();
            setMisiClear(true);

            objPlayer.setExp(objPlayer.getExp() + getHadiah());

            System.out.println("=> Misi 5 Berhasil. Sinyal sudah terkirim ke Militer");
            System.out.println("=> Exp bertambah : " + getHadiah());

            objPlayer.upgradeLevel();
        }

    }

    void nyalakanFlare(){
        for (Item objItem:objPlayer.getArrItem()) {

            if (objItem.getNamaItem().equals("Flare")){

                System.out.println("Berhasil menyalakan Flare");
                objItem.dipakai();
                objPlayer.getArrItem().remove(objItem);
                break;
            }
        }
    }

    //    ============== END OF METHOD ==============
}
