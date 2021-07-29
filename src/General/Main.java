package General;

public class Main {
    static Menu menu = new Menu();

    public static void main (String[] args) {
        int pil = 1;
        while (pil == 1){
            pil = menu.Menu1();

            if (pil == 1){
                GameEngine objGameEngine = new GameEngine();
                objGameEngine.cls();
                objGameEngine.startMission();
            }
        }
    }
}
