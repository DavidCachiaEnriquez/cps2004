import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String playerName;     
    String villageMarker;  
    Village homeVillage;    

    private Map worldMap;     
    private ArrayList<Player> players;     

    private Scanner sc = new Scanner(System.in);
    private Validation validator = new Validation();

    // Constructor
    Player(Map map, ArrayList<Player> allPlayers){
        worldMap = map;
        players = allPlayers;

        System.out.print("Enter player name: ");
        playerName = sc.next();

        System.out.print("Enter marker: ");
        villageMarker = validator.villageMarkerInput();

        homeVillage = new Village(playerName, villageMarker, map);
        System.out.println();
    }

    // Main menu
    void demoMenuV2(){
        int menu = 0;
        while(menu != 5 && menu != 6 && menu != 7 && homeVillage.health != 0){
            System.out.print("\033[H\033[2J");
            System.out.println("Main Menu");
            System.out.println(" 1. General Commands");
            System.out.println(" 2. Buildings Commands");
            System.out.println(" 3. Troop Commands");
            System.out.println(" 4. Combat Commands");
            System.out.println(" 5. Surrender");
            System.out.println(" 6. Pass");
            System.out.println(" 7. Exit Game");

            System.out.print("\nMenu Selection: ");
            menu = validator.rangedInput(1, 7);

            if(menu == 7){
                System.out.println("\nExiting...");
                System.exit(0);
            }else{            
                System.out.print("\033[H\033[2J");  
                switch(menu){
                    case 1: generalMenu(); break;
                    case 2: buildingMenu(); break;
                    case 3: troopMenu(); break;
                    case 4: homeVillage.attackVillage(players, worldMap); sc.next(); break;
                    case 5: homeVillage.gameSurrender(); break;
                    case 6: homeVillage.pass(); break;
                }
            }
        }
    }

    // General actions menu
    private void generalMenu(){
        System.out.println("General Menu");
        System.out.println(" 1. Village Details");
        System.out.println(" 2. Display Map");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu Selection: ");
        int menu = validator.rangedInput(1, 3);

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.villageDetails(); break;
            case 2: worldMap.drawMap(); break;
        }

        if(menu != 3){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }

    // Building actions menu
    private void buildingMenu(){
        System.out.println("Buildings Menu");
        System.out.println(" 1. Build Building");
        System.out.println(" 2. Upgrade Building");
        System.out.println(" 3. Buildings Details");
        System.out.println(" 4. Cancel");

        System.out.print("\nMenu Selection: ");
        int menu = validator.rangedInput(1, 4);

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.buildBuilding(); break;
            case 2: homeVillage.upgradeBuilding(); break;
            case 3: homeVillage.displayBuildings();; break;
        }

        if(menu != 4){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }

    // Troop actions menu
    private void troopMenu(){
        System.out.println("Troop Menu");
        System.out.println(" 1. Train Troops");
        System.out.println(" 2. Troop Details");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu Selection: ");
        int menu = validator.rangedInput(1, 3);

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.trainTroop(); break;
            case 2: homeVillage.displayVillageTroops(); break;
        }

        if(menu != 3){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }
}
