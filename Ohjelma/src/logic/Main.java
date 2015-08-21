package logic;


/**
 * Created by Ralii on 1.8.15.
 */
/*
Ohjelman pääluokka joka käynnistää pelin pääluokan ja kysyy pelaajan vastauksen.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.startGame();
    }
}
