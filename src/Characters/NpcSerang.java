package Characters;

public class NpcSerang extends Characters {


    private int damage;

    //    ============== START METHOD ==============

    public NpcSerang(){
        this.setLevel("Penyerang");
    }

    @Override
    public void printCharacter(){

        super.printCharacter();

        System.out.println("   HP      : " + getHp());
        System.out.println("   Damage  : " + getDamage());
    }

    public int menyerang(Monster objMonster){

        System.out.println(this.getNama() + " ikut menyerang");

        return objMonster.getHp() - getDamage();
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
