package Characters;

public class Characters {

    private String nama;
    private String level;
    private int damage;
    private int hp;

    //    ============== START METHOD ==============

    public void printCharacter(){

        System.out.println("Nama    : " + getNama());
    }

    //    ============== END OF METHOD ==============

    //    ============== START SETTER GETTER ==============

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    //    ============== END OF SETTER GETTER ==============
}
