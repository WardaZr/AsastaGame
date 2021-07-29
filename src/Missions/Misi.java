package Missions;

public abstract class Misi {

    private String wilayahmisi;
    private String namaMisi;
    private String deskripsiMisi;
    private boolean isMisiClear;
    private int hadiah;

    //    ============== START METHOD ==============

    public abstract void AlurMisi();

    public void Story(){
        System.out.println("=======================================================================================");
        System.out.println("||                                   STORY                                           ||");
        System.out.println("=======================================================================================");

    }

    public void printDeskripsi(){

        System.out.println("=======================================================================================");
        System.out.println("||                                   "+getNamaMisi()+"                                          ||");
        System.out.println("=======================================================================================");
        System.out.println("==> "+getDeskripsiMisi());
        System.out.println("=======================================================================================");

    }

    public boolean isItemBersyarat(){

        return false;
    }

    //    ============== END OF METHOD ==============


    //    ============== START SETTER GETTER ==============

    public String getNamaMisi() {
        return namaMisi;
    }
    public void setNamaMisi(String namaMisi) {
        this.namaMisi = namaMisi;
    }

    public String getDeskripsiMisi() {
        return deskripsiMisi;
    }
    public void setDeskripsiMisi(String deskripsiMisi) {
        this.deskripsiMisi = deskripsiMisi;
    }

    public int getHadiah() {
        return hadiah;
    }
    public void setHadiah(int hadiah) {
        this.hadiah = hadiah;
    }

    public boolean isMisiClear() {
        return isMisiClear;
    }
    public void setMisiClear(boolean misiClear) {
        isMisiClear = misiClear;
    }

    public String getWilayahmisi() {
        return wilayahmisi;
    }

    public void setWilayahmisi(String wilayahmisi) {
        this.wilayahmisi = wilayahmisi;
    }

    //    ============== END OF SETTER GETTER ==============
}
