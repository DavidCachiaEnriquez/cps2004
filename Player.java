import java.util.*;

public class Player {
    String playerName;
    Village homeVillage;

    Player(Map map){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player name: ");
        playerName = sc.next();
        
        homeVillage = new Village(playerName, map);
        
        sc.close();
    }

    void trainTroop(){
        
    }

    void buildBuilding(){
    }

    void upgradeBuilding(){
    }

    void attackVillage(){
    }

    void surrenderVillage(){
    }

    void pass(){
    }
}
