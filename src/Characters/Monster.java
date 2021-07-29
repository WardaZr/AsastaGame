package Characters;

import static General.GameInfo.*;

public class Monster extends Characters {

    private int defense;

    //    ============== START METHOD ==============

    @Override
    public void printCharacter(){
        super.printCharacter();
        System.out.println("HP      : " + getHp());
        System.out.println("Damage  : " + getDamage());
        System.out.println("Defense : " + getDefense());
        System.out.println("Level   : " + getLevel());
        System.out.println();
    }

    public void menyerang(){
        System.out.println("Monster menyerang");

        objPlayer.setHp(objPlayer.getHp() - getDamage());
    }

    public void bertahan(){
        System.out.println("Player menyerang");

        if (getDefense() < objPlayer.getDamage()){
            System.out.println("Monster bertahan");
            this.defense = getDefense() - objPlayer.getDamage();
            if(this.defense < 0){
                setHp(getHp()+this.defense);
            }
        }
        else {
            //asumsikan defense pemain sudah habis dipakai

            int hpMonster = objPlayer.getHp() + (getDefense() - objPlayer.getDamage());
            this.setHp(hpMonster);
            //asumsi hasil pengurangan defense adalah minus
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

    //    ============== END OF SETTER GETTER ==============

}
