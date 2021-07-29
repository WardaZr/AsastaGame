package General;

import Characters.*;
import Items.*;

import java.util.Random;
import java.util.Scanner;

import static General.GameInfo.*;

public class Bertarung {

    //    ============== START METHOD ==============

    public boolean bertarung(Monster objMonster){

        int isSerang;
        boolean isStop = false;
        int opsi = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        isSerang = random.nextInt(2);

        while(!isStop){

            if(isSerang == 1){

                //  Giliran Player
                int pil;

                System.out.println("Pilihan Player :");
                System.out.println("1. Menyerang");
                System.out.println("2. Pakai item");
                System.out.println("3. Keluar Ruangan");
                System.out.print("___ :");
                opsi = scanner.nextInt();

                if(opsi == 1){

                    if(objMonster.getLevel().equals("Bos") || objMonster.getLevel().equals("Spesial")){
                        if (objMonster.getDefense() ==0){
                            objMonster.setHp(objPlayer.menyerang(objMonster));
                        }else{
                            objMonster.bertahan();
                        }
                    }
                    else{

                        objMonster.setHp(objPlayer.menyerang(objMonster));
                    }

                    objMonster.setHp(cekNpcMenyerang(objMonster));       //jika ada npc penyerang, ia akan membantu player melawan monster

                    System.out.println("Hp monster : " + objMonster.getHp());
                }
                else if (opsi == 2){

                    if (objPlayer.getArrItem().isEmpty()){
                        System.out.println("Player tidak memiliki Item");
                    }
                    else {

                        int i = 1;
                        for (Item objItem : objPlayer.getArrItem()){
                            System.out.println(i + ". " + objItem.getNamaItem());
                            i++;
                        }
                        System.out.print("Choose your item : ");
                        pil = scanner.nextInt();

                        if (pil < 1 || pil > objPlayer.getArrItem().size()){

                            System.out.println("Pilihan tidak tersedia");
                        }
                        else {

                            objPlayer.getArrItem().get(pil-1).dipakai();
                        }
                    }
                }

                else if(opsi == 3){

                    isStop = true;
                }
                isSerang = 0;
            }
            else{

                // giliran monster
                if(objPlayer.getDefense() <= 0){

                    objMonster.menyerang();
                }
                else{

                    objPlayer.bertahan(objMonster);
                }

                System.out.println("Hp Player : " + objPlayer.getHp());

                isSerang = 1;

            }
            System.out.println("Damage player " + objPlayer.getDamage());

            if (opsi == 1){

                //jika player menggunakan item sekali pakai saat menyerang
                if (objPlayer.getObjItemDigunakan(0) != null){

                    if (objPlayer.getObjItemDigunakan(0).getKetersediaan().equals("Sekali Pakai")){

                        Senjata senjataDipakai = (Senjata) objPlayer.getObjItemDigunakan(0);
                        senjataDipakai.returnDamage(senjataDipakai);
                        objPlayer.setObjItemDigunakan(0, null);
                    }
                }
            }

            System.out.println();
            if (objMonster.getHp() <= 0 || objPlayer.getHp() <= 0){
                isStop = true;
            }
        }

        return !isPlayerWin(objMonster);
    }

    public boolean isPlayerWin(Monster objMonster){
        boolean isWin = false;

        if (objPlayer.getHp() <= 0){
            System.out.println("GAME OVER!!!");
            isGameOver = true;
        }
        else if (objMonster.getHp() <= 0){
            monsterDead(objMonster);
            lokasiAktif.setObjMonster(null);
            isWin = true;
        }

        return isWin;
    }

    public void monsterDead(Monster objMonster){

        if(objMonster.getHp() <= 0) {

            int expWin = 0;

            switch (objMonster.getLevel()) {
                case "Bos":
                    expWin = 100;
                    break;
                case "Spesial":
                    expWin = 50;
                    break;
                case "Biasa":
                    expWin = 25;
                    break;
            }

            objPlayer.setExp(objPlayer.getExp() + expWin);
            objPlayer.upgradeLevel();

            System.out.println("Monster telah dikalahkan!");
            System.out.println("Exp bertambah : " + expWin);
        }
    }

    public int cekNpcMenyerang(Monster objMonster){

        for (Characters character : objPlayer.getArrCharacter()){

            if (character.getLevel().equals("Penyerang")){

                NpcSerang objNpcSerang = (NpcSerang) character;
                objMonster.setHp(objNpcSerang.menyerang(objMonster));
            }
        }

        return objMonster.getHp();
    }

    //    ============== END OF METHOD ==============
}
