import java.util.ArrayList;

public class GameManager {

    int mapSize = 10;
    Map map = new Map(mapSize);

    ArrayList<Player> players = new ArrayList<Player>();

    GameManager(){
        map.drawMap();
        Player player1 = new Player(map);
        players.add(player1);
        map.drawMap();
    }
}

