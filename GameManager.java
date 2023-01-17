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
                    System.out.println("\n1. Troops: " + player.homeVillage.trainingBuildings.size());
                    System.out.println("2. Resources: " + player.homeVillage.resourceBuildings.size());
                    
                    int choice = sc.nextInt();
                    System.out.println();

                    if(choice == 1){
                        for(int i = 0; i<player.homeVillage.trainingBuildings.size();i++){
                            int cost = player.homeVillage.trainingBuildings.get(i).troopCost;
                            if(cost == 1){
                                System.out.println("Barracks: " + player.homeVillage.trainingBuildings.get(i).level);
                            }else if(cost == 2){
                                System.out.println("Stable: " + player.homeVillage.trainingBuildings.get(i).level);
                            }else if(cost == 5){
                                System.out.println("Gym: " + player.homeVillage.trainingBuildings.get(i).level);
                            }
                        }
                    }else if(choice == 2){
                        for(int i = 0; i<player.homeVillage.resourceBuildings.size();i++){
                            if(player.homeVillage.resourceBuildings.get(i).resourceType.wood == 1){
                                System.out.println("Lumberyard: " + player.homeVillage.resourceBuildings.get(i).resourceType.level);
                            }else if(player.homeVillage.resourceBuildings.get(i).resourceType.rations == 1){
                                System.out.println("Mess hall: " + player.homeVillage.resourceBuildings.get(i).resourceType.level);
                            }else if(player.homeVillage.resourceBuildings.get(i).resourceType.gold == 1){
                                System.out.println("Mines: " + player.homeVillage.resourceBuildings.get(i).resourceType.level);
                            }
                        }
                    }

                    break;
                case 4: 
                    player.homeVillage.printDetails();
                    break;
            }
        }
    }
}

