public class GameManager {
    GameManager(){
        Map map = new Map(10);

        Player player1 = new Player();

        System.out.print("\nPlayer name: " + player1.playerName);

        map.drawMap();
    }
}
