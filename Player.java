import java.util.Scanner;

public class Player {
    String playerName;     
    String villageMarker;  
    Village homeVillage;    

    Map worldMap;          

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

    
    void demoMenuV2(){
        int menu = 0;
        while(menu != 6){
            System.out.print("\033[H\033[2J");
            System.out.println("Main Menu");
            System.out.println(" 1. General Commands");
            System.out.println(" 2. Buildings Commands");
            System.out.println(" 3. Troop Commands");
            System.out.println(" 4. Army Commands");
            System.out.println(" 5. Combat Commands");
            System.out.println(" 6. Exit");

            System.out.print("\nMenu Selection: ");
            menu = sc.nextInt();

            if(menu == 6){
                System.out.println("Exiting...");
            }else{            
                System.out.print("\033[H\033[2J");  
                switch(menu){
                    case 1: generalMenu(); break;
                    case 2: buildingMenu(); break;
                    case 3: troopMenu(); break;
                    case 4: armyMenu(); break;
                    case 5: combatMenu(); break;
                }
            }
        }
    }

    void generalMenu(){
        System.out.println("General Menu");
        System.out.println(" 1. Village Details");
        System.out.println(" 2. Display Map");
        System.out.println(" 3. Pass Turn");
        System.out.println(" 4. Exit");

        System.out.print("\nMenu Selection: ");
        int menu = sc.nextInt();

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.villageDetails(); break;
            case 2: worldMap.drawMap(); break;
            case 3: homeVillage.pass(); break;
        }

        if(menu != 3 && menu != 4){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }

    void buildingMenu(){
        System.out.println("Buildings Menu");
        System.out.println(" 1. Buildings Details");
        System.out.println(" 2. Build Building");
        System.out.println(" 3. Upgrade Building");
        System.out.println(" 4. Exit");
    }

    void troopMenu(){
        System.out.println("Troop Menu");
        System.out.println(" 1. Troop Details");
        System.out.println(" 2. Train Troops");
        System.out.println(" 3. Exit");
    }

    void armyMenu(){
        System.out.println("Army Menu");
        System.out.println(" 1. Display Army");
        System.out.println(" 2. Create Army");
        System.out.println(" 3. Exit");        
    }

    void combatMenu(){
        System.out.println("Combat Menu");
        System.out.println(" 1. Surrender");
        System.out.println(" 2. Exit");
    }
}
