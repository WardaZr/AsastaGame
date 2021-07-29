package General;

import Characters.Player;
import Locations.Lantai;
import Locations.Ruangan;

//kegunaan dari static atribut adalah dapat diakses tanpa membuat objek
public class GameInfo {
    static Boolean isGameOver = false;     //jika true, maka game berakhir
    public static Player objPlayer = new Player();
    public static Ruangan lokasiAktif;
    public static Lantai lantaiAktif;
}
