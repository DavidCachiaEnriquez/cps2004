import java.util.*;

public class Player {
    String playerName;
    Village homeVillage;

    Player(Map map){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player name: ");
        playerName = sc.nextLine();
        
        homeVillage = new Village(playerName, map);
        
        sc.close();
    }
}
