package Items;

import static General.GameInfo.*;

public class Senjata extends Item {

    private int damage;

    //    ============== START METHOD ==============

    public void upgrade(int tambahDamage){

        setDamage(getDamage() + tambahDamage);
    }

    @Override
    public void printItem () {
        super.printItem();

        System.out.println("Damage Item     : " + getDamage());
    }

    @Override
    public int getBenefit () {
        return this.damage;
    }

    @Override
    public void dipakai () {

        System.out.println(this.getNamaItem() + " dipakai");

        int damageAwal = objPlayer.getDamage();
        objPlayer.setDamage(damageAwal + getDamage());

        //senjata yang sebelumnya dipakai dimasukkan ke tas
        returnOldSenjata();

        objPlayer.setObjItemDigunakan(0, this);
        objPlayer.getArrItem().remove(this);
    }

    public void returnDamage(Senjata senjataLama){
        int damageItem = senjataLama.getBenefit();
        int damagePlayer = objPlayer.getDamage() - damageItem;

        objPlayer.setDamage(damagePlayer);
    }

    public void returnOldSenjata(){
        if (objPlayer.getObjItemDigunakan(0) != null){

            Senjata senjataLama = (Senjata) objPlayer.getObjItemDigunakan(0);

            //kurangin damage player
            returnDamage(senjataLama);

            //kembalikan item ke array item player
            objPlayer.getArrItem().add(senjataLama);
        }
    }

    //    ============== END OF METHOD ==============


    //    ============== START SETTER GETTER ==============

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //    ============== END OF SETTER GETTER ==============
}
