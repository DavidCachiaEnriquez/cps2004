public class GameManager {
    GameManager(){
        Map map = new Map(10);

        Player player1 = new Player(map);

        map.drawMap();
    }
}
