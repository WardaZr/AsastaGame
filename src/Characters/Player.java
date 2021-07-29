package Characters;

import Items.Armor;
import Items.Item;

import java.util.ArrayList;

import static General.GameEngine.scanner;
import static General.GameInfo.objPlayer;

public class Player extends Characters {

    private ArrayList<Item> arrItem = new ArrayList<>();
    private Item[] objItemDigunakan = new Item[3];
    //index 0 -> senjata  |  index 1 -> armor

    private ArrayList<Characters> arrCharacter = new ArrayList<>();

    private int hp;
    private int defense;
    private int levelPlayer;
    private int exp;

    //    ============== START METHOD ==============

    @Override
    public void printCharacter(){

        super.printCharacter();

        System.out.println("HP          : " + getHp());
        System.out.println("Damage      : " + getDamage());
        System.out.println("Defense     : " + getDefense());
        System.out.println("Level       : " + getLevel());
    }

    public void printItemDigunakan(){

        if (objItemDigunakan[0] == null && objItemDigunakan[1] == null){
            System.out.println("tidak ada item yang digunakan");
        }
        else {
            System.out.println("Item yang sedang digunakan >>");
            System.out.println("------------------------------------");
            for (int i = 0; i < 2; i++){
                if (objItemDigunakan[i] != null){
                    objItemDigunakan[i].printItem();
                    System.out.println();
                }
            }
        }
    }

    public void printItem(){
        if (arrItem.isEmpty()){
            System.out.println("Tas kosong");
        }
        else {
            int i = 1;

            for (Item item : arrItem){
                System.out.println(i + ". " + item.getNamaItem());
                i++;
            }
            System.out.println("Tekan 0 untuk kembali");
            System.out.print("Pilih Item : ");
            int pilItem = scanner.nextInt();

            if (pilItem <= arrItem.size() && pilItem > 0) {

                System.out.println("[1] Pakai Item");
                System.out.println("[2] Buang Item");

                System.out.print("___ : ");
                int pilAksi = scanner.nextInt();
                Item itemDipilih = arrItem.get(pilItem - 1);

                if (pilAksi == 1) itemDipilih.dipakai();
                else if (pilAksi == 2) itemDipilih.dibuang();
                else System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    public int menyerang(Monster objMonster){

        System.out.println("Player menyerang");

        return objMonster.getHp() - getDamage();
    }

    public void bertahan(Monster objMonster){

        System.out.println("Monster menyerang");

        if (getDefense() < objMonster.getDamage()){
            System.out.println("Player bertahan");
            this.defense = getDefense() - objMonster.getDamage();

            if (objItemDigunakan[1] != null){
                Armor armorDigunakan = (Armor) objItemDigunakan[1];
                armorDigunakan.armorTerkikis(objMonster.getDamage());
            }
        }
        else {
            //asumsikan defense pemain sudah habis dipakai

            int hpPlayer = getHp() + (getDefense() - objMonster.getDamage());
            this.setHp(hpPlayer);
            //asumsi hasil pengurangan defense adalah minus
        }
    }

    public void ajakNPC(Characters character){

        arrCharacter.add(character);
        System.out.println(character.getNama() + " Mengikutimu");
    }

    public void printNPC(){
        int totalNpc = objPlayer.getArrCharacter().size();
        System.out.println("Jumlah NPC yang bersama Player : " + totalNpc);

        if (totalNpc > 0){
            System.out.println("\nIngin berkomunikasi dengan NPC? \n1. ya \n0. tidak");
            System.out.print("___ :");
            int pilTalk = scanner.nextInt();

            if (pilTalk == 1){
                int i = 1;
                for (Characters characters : objPlayer.getArrCharacter()){
                    System.out.print(i + ". " );
                    characters.printCharacter();
                    System.out.println("   Status : NPC " + characters.getLevel());
                    System.out.println();
                    i++;
                }
                System.out.print("___ :");
                int pilNpc = scanner.nextInt();
                System.out.println();

                Characters NpcDipilih = objPlayer.getArrCharacter().get(pilNpc-1);

                //npc berdialog
                System.out.println(NpcDipilih.getNama() + " : ");
                System.out.println("Hai " + objPlayer.getNama() + ", saya " + NpcDipilih.getNama());
                System.out.println("Terimakasih telah menyelamatkan saya");
                System.out.println();

                //aksi untuk npc rakit
                if (NpcDipilih.getLevel().equals("Perakit")){
                    System.out.println("Ada yang bisa saya bantu? \n1. Rakit Item\n2. Tidak terimakasih");
                    System.out.print("___ : ");
                    int pilRakit = scanner.nextInt();

                    if (pilRakit == 1){
                        NpcRakit npcRakit = (NpcRakit) NpcDipilih;
                        npcRakit.rakitItem();
                    }
                }
            }
        }
    }

    public void upgradeLevel(){

        if(getExp() > 100){

            int levelUp = exp / 100;
            setLevelPlayer(getLevelPlayer() + levelUp);
            setExp(getExp() - (100 * levelUp));

            System.out.println("Level bertambah menjadi " + getLevelPlayer());
        }
    }

    public Item cariItem(String namaItem) {

        for (Item objItem : getArrItem()) {

            if (namaItem.equals(objItem.getNamaItem())) {
                return objItem;      //jika ditemukan
            }
        }

        return null; //tidak ketemu
    }

    //    ============== END OF METHOD ==============

//    ============== START SETTER GETTER ==============

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public ArrayList<Item> getArrItem() {
        return arrItem;
    }
    public ArrayList<Characters> getArrCharacter() {
        return arrCharacter;
    }

    public int getLevelPlayer() {
        return levelPlayer;
    }
    public void setLevelPlayer(int levelPlayer) {
        this.levelPlayer = levelPlayer;
    }

    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public Item getObjItemDigunakan (int index) {
        return objItemDigunakan[index];
    }
    public void setObjItemDigunakan (int index, Item objItemDigunakan) {
        this.objItemDigunakan[index] = objItemDigunakan;
    }

//    ============== END OF SETTER GETTER ==============
}
