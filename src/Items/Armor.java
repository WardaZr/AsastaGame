package Items;

import static General.GameInfo.objPlayer;

public class Armor extends Item {

    private int defense;

    //    ============== START METHOD ==============


    @Override
    public void printItem () {
        super.printItem();
        System.out.println("Defense Item     : " + getDefense());

    }

    @Override
    public int getBenefit () {
        return this.defense;
    }

    public void upgrade(int defenseUp){

        setDefense(getDefense() + defenseUp);
    }

    @Override
    public void dipakai () {
        System.out.println(this.getNamaItem() + " dipakai");

        int defenseAwal = objPlayer.getDefense();
        objPlayer.setDefense(defenseAwal + getDefense());
        objPlayer.setObjItemDigunakan(1, this);

        //armor yang sebelumnya dipakai dimasukkan ke tas
        returnOldArmor();

        objPlayer.setObjItemDigunakan(1, this);
        objPlayer.getArrItem().remove(this);
    }

    public void armorTerkikis(int damageDiterima){
        this.defense -= damageDiterima;

        if (this.defense <= 0){
            objPlayer.setObjItemDigunakan(1, null);
        }
    }

    private void returnOldArmor(){
        if (objPlayer.getObjItemDigunakan(1) != null){

            //kembalikan item ke array item player
            Armor armorLama = (Armor) objPlayer.getObjItemDigunakan(1);
            objPlayer.getArrItem().add(armorLama);

            //kurangin defense player
            int defenseItem = armorLama.getBenefit();
            int defensePlayer = objPlayer.getDefense() - defenseItem;

            objPlayer.setDefense(defensePlayer);
        }
    }

    //    ============== END OF METHOD ==============

    //    ============== START SETTER GETTER ==============

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    //    ============== END OF GETTER ==============
}
