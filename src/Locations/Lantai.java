package Locations;
import java.util.ArrayList;
import java.util.Scanner;

public class Lantai {

    private ArrayList<Ruangan> arrRuangan = new ArrayList<>();

    private String namaLantai;
    private String deskripsiLantai;

    private final Scanner scanner = new Scanner(System.in);

    public Lantai(String namaLantai, String deskripsiLantai){

        this.namaLantai = namaLantai;
        this.deskripsiLantai = deskripsiLantai;
    }

    //    ============== START METHOD ==============

    public void printLantai(){
        System.out.println("Lokasi");
        System.out.println("_______________________________");
        System.out.println("Lantai        :" + getNamaLantai());
        System.out.println("Deskripsi     :" + getDeskripsiLantai());
        System.out.println();
    }

    public Ruangan pindahRuangan(){
        int n = 1;

        System.out.println("\nRuangan lantai " + getNamaLantai());
        System.out.println("_______________________________");
        for (Ruangan ruangan : arrRuangan){
            System.out.println(n + ". " + ruangan.getNamaRuangan());
            n++;
        }
        System.out.print("Masuk ke ruangan : ");
        int pilRoom = scanner.nextInt();

        return arrRuangan.get(pilRoom - 1);
    }

    //    ============== END OF METHOD ==============


    //    ============== START SETTER GETTER ==============

    public String getNamaLantai () {
        return namaLantai;
    }

    public String getDeskripsiLantai () {
        return deskripsiLantai;
    }

    public ArrayList<Ruangan> getKamar () {
        return arrRuangan;
    }

    //    ============== END OF SETTER GETTER ==============
}
