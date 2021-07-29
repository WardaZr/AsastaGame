package Items;

import static General.GameInfo.objPlayer;

public class Makanan extends Item {

    private int tambahHp;

    //    ============== START METHOD ==============

    public Makanan(){
        this.setKetersediaan("Sekali pakai");
    }

    @Override
    public void printItem () {
        super.printItem();

        System.out.println("Menambah HP sebesar     : " + getTambahHp());
    }

    @Override
    public int getBenefit () {
        return this.tambahHp;
    }

    @Override
    public void dipakai () {
        System.out.println(this.getNamaItem() + " dikonsumsi");

        int hpAwal = objPlayer.getHp();
        objPlayer.setHp(hpAwal + getTambahHp());
        System.out.println("Hp bertambah " + getTambahHp() + " poin");

        if (getKetersediaan().equals("Sekali Pakai")){
            objPlayer.getArrItem().remove(this);
        }
    }

    //    ============== END OF METHOD ==============


    //    ============== START SETTER GETTER ==============

    public int getTambahHp() {
        return tambahHp;
    }
    public void setTambahHp(int tambahHp) {
        this.tambahHp = tambahHp;
    }

    //    ============== END OF SETTER GETTER ==============

}
