package Items;

import Locations.Lantai;
import Locations.Ruangan;

import static General.GameEngine.arrLantai;
import static General.GameEngine.scanner;

public class MethodItemSpesial {

    public static void lihatMap(){

        int pilLantai = 1;

        while (pilLantai !=0 ){
            int i = 1;
            for (Lantai objLantai : arrLantai){
                System.out.println(i + ". Lantai " + objLantai.getNamaLantai());
                i++;
            }

            System.out.println("0. Tutup Map");
            System.out.print("lihat lantai : ");
            pilLantai = scanner.nextInt();
            System.out.println();

            if (pilLantai <= arrLantai.size() && pilLantai > 0){

                for (Ruangan objRuangan : arrLantai.get(pilLantai-1).getKamar()) {
                    objRuangan.printRuangan();
                }
            }
            System.out.println();
        }
    }

    public static void lihatCCTV(){
        int pilLantai = 1;
        int pilRuangan = 1;

        while (pilLantai != 0 && pilRuangan != 0){
            int i = 1;
            for (Lantai objLantai : arrLantai){
                System.out.println(i + ". " + objLantai.getNamaLantai());
                i++;
            }

            System.out.println("0. Tutup Monitor");
            System.out.print("lihat lantai : ");
            pilLantai = scanner.nextInt();
            System.out.println();

            if (pilLantai <= arrLantai.size() && pilLantai > 0){

                int j = 1;
                System.out.println("Daftar Ruangan yang ada penghuninya");
                for (Ruangan objRuangan : arrLantai.get(pilLantai-1).getKamar()) {
                    if (!objRuangan.getArrNonPlayer().isEmpty() || objRuangan.getObjMonster() != null){
                        System.out.println(j + ". " + objRuangan.getNamaRuangan());
                    }
                    j++;
                }
                System.out.println("0. Tutup Monitor");
                System.out.print("lihat lantai : ");
                pilRuangan = scanner.nextInt();

                if (pilRuangan <= arrLantai.get(pilLantai-1).getKamar().size() && pilRuangan > 0){
                    Ruangan objRuangan = arrLantai.get(pilLantai-1).getKamar().get(pilRuangan-1);

                    if (!objRuangan.getArrNonPlayer().isEmpty()){
                        objRuangan.printNpc();
                    }
                    else {
                        System.out.println("Tidak NPC dalam ruangan");
                    }

                    if (!objRuangan.getArrItem().isEmpty()){
                        objRuangan.printItem();
                    }
                    else {
                        System.out.println("Tidak item dalam ruangan");
                    }

                    if (objRuangan.getObjMonster() != null){
                        System.out.println("Monster dalam Ruangan >>");
                        System.out.println("-----------------------------");
                        System.out.println("Monster level " + objRuangan.getObjMonster().getLevel());
                    }
                    else {
                        System.out.println("Tidak monster dalam ruangan");
                    }
                }
            }
            System.out.println();
        }
    }
}
