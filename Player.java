import java.util.Scanner;

public class Player {
    String playerName;      // Name of player name
    String villageMarker;   // Symbol used to mark the player's village
    Village homeVillage;    // Player's home village

    Map worldMap;           // Game map

    Scanner sc = new Scanner(System.in);

    Player(Map map){
        worldMap = map;
        System.out.print("Enter player name: ");
        playerName = sc.next();

        System.out.print("Choose maker [@, £, $, %, &, #]: ");
        villageMarker = sc.next();

        homeVillage = new Village(playerName, villageMarker, map);
        System.out.println();
    }

    void demoMenu(){
        int menu = 0;
        while(menu != 3 && menu != 11){
            System.out.println("General Actions");
            System.out.println(" 1. Village Details");
            System.out.println(" 2. Display Map");
            System.out.println(" 3. Pass Turn");

            System.out.println("\nBuilding Actions");
            System.out.println(" 4. Buildings Details");
            System.out.println(" 5. Build Building");
            System.out.println(" 6. Upgrade Building");

            System.out.println("\nTroop Actions");
            System.out.println(" 7. Troop Details");
            System.out.println(" 8. Train Troops");

            System.out.println("\nArmy Actions");
            System.out.println(" 9. Display Army");
            System.out.println(" 10 Create Army");

            System.out.println("\nCombat Actions");
            System.out.println(" 11. Surrender");


            System.out.print("\nEnter menu option: ");
            menu = sc.nextInt();
            System.out.print("\033[H\033[2J");  

            switch(menu){
                case 1:
                    homeVillage.villageDetails();
                break;

                case 2:
                    worldMap.drawMap();
                break;
                
                case 3:
                    homeVillage.pass();
                break;

                case 4: 
                    System.out.println("\nBuilding Details");
                    homeVillage.displayBuildings();
                break;
                
                case 5:
                    System.out.print("\nBuild Building");
                    homeVillage.buildBuilding();
                break;
                
                case 6:
                    System.out.println("Upgrade Building");
                    homeVillage.upgradeBuilding();
                break;

                case 7:
                    System.out.println("\nDisplay Troops");
                    homeVillage.displayTroops();
                break;
                
                case 8:
                    System.out.println("\nTrain Troops");
                    homeVillage.trainTroop();
                break;

                case 9:
                    System.out.println("\nDisplay Army");
                    homeVillage.displayArmy();
                break;

                case 10:
                    System.out.println("\nCreate Army");
                    homeVillage.createArmy();
                break;
                
                case 11:
                    homeVillage.gameSurrender();
                break;
            }
            System.out.print("\033[H\033[2J");  
        }

    }

}
