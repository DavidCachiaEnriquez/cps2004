import java.util.Scanner;

public class Player {
    // - - - Attributes - - - //
    String playerName;
    Village homeVillage;
    // - - - Attributes - - - //

    Scanner sc = new Scanner(System.in);

    Player(Map map){
        System.out.print("Enter player name: ");
        playerName = sc.next();

        homeVillage = new Village(playerName, map);
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
