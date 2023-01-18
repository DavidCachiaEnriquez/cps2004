import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    int mapSize = 10;
    Map map = new Map(mapSize);

    ArrayList<Player> players = new ArrayList<Player>();

    Scanner sc = new Scanner(System.in);

    GameManager(){
        map.drawMap();
        Player player1 = new Player(map);
        players.add(player1);
        
        demoMenu(player1);
    }

    void demoMenu(Player player){
        int menu = 0;
        while(menu != 6){
            System.out.println("\nDemo Menu");
            System.out.println("1. Display Map");
            System.out.println("2. Build Building");
            System.out.println("3. Show Number of Buildings");
            System.out.println("4. Print Village Details");
            System.out.println("5. Upgrade Building");
            System.out.println("6. Exit");

            System.out.println("\nEnter menu option");
            menu = sc.nextInt();

            switch(menu){
                case 1:
                map.drawMap();
                break;
                case 2: 
                player.buildBuilding();
                break;
                case 3: 
                System.out.println("\nTroop Buildings: " + player.homeVillage.trainingBuildings.size());
                for(int i = 0; i<player.homeVillage.trainingBuildings.size();i++){
                    System.out.print(" " + player.homeVillage.trainingBuildings.get(i).name);
                    System.out.println(": " + player.homeVillage.trainingBuildings.get(i).level);
                }

                System.out.println("\nResources Buildings: " + player.homeVillage.resourceBuildings.size());
                for(int i = 0; i<player.homeVillage.resourceBuildings.size();i++){
                    System.out.print(" " + player.homeVillage.resourceBuildings.get(i).name);
                    System.out.println(": " + player.homeVillage.resourceBuildings.get(i).level);
                }
                break;
                case 4: 
                player.homeVillage.printDetails();
                break;
                case 5:
                player.upgradeBuilding();
                break;
            }
        }
    }
}

