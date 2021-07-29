package General;

import Locations.Ruangan;

import static General.GameInfo.*;
import static General.GameEngine.arrLantai;
import static General.GameEngine.scanner;

public class Menu {

    public int Menu1(){
        System.out.println("=======================================================================================");
        System.out.println("||                                                                                   ||");
        System.out.println("||                                 ASASTA ESCAPE                                     ||");
        System.out.println("||                                                                                   ||");
        System.out.println("=======================================================================================");
        System.out.println("|| Asasta Escape mengangkat cerita tentang kondisi Apartemen yang diserang  monster, ||");
        System.out.println("|| manusia akan meninggal setelah diserang oleh  monster  tersebut.   Cerita diawali ||");
        System.out.println("|| dengan seorang tokoh pemuda bernama Arya  yang pindah  ke Apartemen mahal bernama ||");
        System.out.println("|| OYA, dengan nomor kamar 90A. Disuatu pagi saat Arya terbangun, ia melihat keadaan ||");
        System.out.println("|| dan monster tersebut berusaha menuju Apartemen OYA. Secara terpaksa dan  sukarela,||");
        System.out.println("|| Arya harus menyelamatkan warga Apartemen OYA dengan mengandalkan item - item yang ||");
        System.out.println("|| ada di Apartemen tersebut.                                                        ||");
        System.out.println("=======================================================================================");
        System.out.println("[1].Play Game");
        System.out.println("[2].Exit");

        System.out.print("___ : ");
        return scanner.nextInt();
    }

    public void Story(){
        System.out.println("=======================================================================================");
        System.out.println("|| Disuatu pagi saat Arya terbangun,  ia melihat  keadaan luar sangat  kacau  karena ||");
        System.out.println("|| banyak monster yang  menyerang  manusia  sampai  meninggal  dan monster  tersebut ||");
        System.out.println("|| berusaha menuju Apartemen OYA. Apakah yang harus arya lakukan ?                   ||");
        System.out.println("=======================================================================================");
    }

    public void Menu2(){
        System.out.println("[1] Lihat Misi");
        System.out.println("[2] Lihat Item di tas");
        System.out.println("[3] Lihat Item digunakan");
        System.out.println("[4] Deskripsi Player");
        System.out.println("[5] Deskripsi Lokasi");
        System.out.println("[6] Pindah Lokasi");
        System.out.println("[7] Lihat NPC");
        System.out.print("___ : ");
    }

    public void PindahLokasi (){
        if (lokasiAktif != null){
            System.out.println("Keluar ruangan? \n1. ya \n0. tidak");
            System.out.print("___ : ");
            int pilEnter = scanner.nextInt();

            if (pilEnter == 1){
                lokasiAktif = null;
                System.out.println("Player keluar ruangan");
            }
        }
        else {

            System.out.println("[1] Pindah Ruangan");
            System.out.println("[2] Naik Lantai");
            System.out.println("[3] Turun Lantai");

            System.out.print("___ : ");
            int pilPindah = scanner.nextInt();
            System.out.println();

            aksiPindahLokasi(pilPindah);
        }
    }

    public void printLokasi(){

        if (lokasiAktif == null){

            lantaiAktif.printLantai();

            System.out.println("Anda berada di luar ruangan");
            System.out.println("Ingin masuk ruangan? \n1. ya \n0. tidak");
            System.out.print("___ : ");
            int pilEnter = scanner.nextInt();

            if (pilEnter == 1){
                lokasiAktif = lantaiAktif.pindahRuangan();
                if (lokasiAktif.isDikunci()){ //cek dikunci atau engga
                    if (objPlayer.cariItem("Kunci " + lokasiAktif.getNamaRuangan())!=null){
                        if(objPlayer.getObjItemDigunakan(2)!=null){ // mengecek punya kunci ga
                            lokasiAktif.masukRuangan();
                            System.out.println("kunci dimiliki.. ");
                            lokasiAktif.setDikunci(false);
                        }else{ //jika gapunya kunci
                            System.out.println("anda belum memiliki kunci ruangan " + lokasiAktif.getNamaRuangan());
                            lokasiAktif =null;
                        }
                    }
                    else{

                        lokasiAktif = null;
                    }
                }else{//jika ruangan ga dikunci
                    lokasiAktif.masukRuangan();
                }
            }
        }
        else {

            lokasiAktif.masukRuangan();
        }
    }

    private void aksiPindahLokasi(int pilPindah){
        int indexLantai = arrLantai.indexOf(lantaiAktif);
        int lantaiUp = indexLantai + 1;
        int lantaiDown = indexLantai-1;

        if (pilPindah == 1){
            lokasiAktif = lantaiAktif.pindahRuangan();
            if (lokasiAktif.isDikunci()){ //cek dikunci atau engga
                if (objPlayer.cariItem("Kunci " + lokasiAktif.getNamaRuangan())!=null){
                    if(objPlayer.getObjItemDigunakan(2)!=null){ // mengecek punya kunci ga
                        lokasiAktif.masukRuangan();
                        System.out.println("kunci dimiliki.. ");
                        lokasiAktif.setDikunci(false);
                    }else{ //jika gapunya kunci
                        System.out.println("anda belum memiliki kunci ruangan " + lokasiAktif.getNamaRuangan());
                        lokasiAktif =null;
                    }
                }
                else{

                    lokasiAktif = null;
                }
            }else{//jika ruangan ga dikunci
                lokasiAktif.masukRuangan();
            }
        }
        else if (pilPindah == 2){

            if (indexLantai == (arrLantai.size()-1)){
                System.out.println("Lantai " + lantaiAktif.getNamaLantai() + " adalah lantai teratas");
            }
            else{
                lantaiAktif = arrLantai.get(lantaiUp);
                lokasiAktif = null;
                System.out.println("Naik ke lantai " + lantaiAktif.getNamaLantai());
            }
        }
        else if (pilPindah == 3){

            if (indexLantai == 0){
                System.out.println("Lantai " + lantaiAktif.getNamaLantai() + " adalah lantai terbawah");
            }
            else {
                lantaiAktif = arrLantai.get(lantaiDown);
                lokasiAktif = null;
                System.out.println("Turun ke lantai " + lantaiAktif.getNamaLantai());
            }
        }
        else {
            System.out.println("Pilihan tidak tersedia");
        }
    }
}
