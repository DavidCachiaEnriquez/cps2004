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
        System.out.println(" 1. Build Building");
        System.out.println(" 2. Upgrade Building");
        System.out.println(" 3. Buildings Details");
        System.out.println(" 4. Exit");

        System.out.print("\nMenu Selection: ");
        int menu = sc.nextInt();

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

    void troopMenu(){
        System.out.println("Troop Menu");
        System.out.println(" 1. Train Troops");
        System.out.println(" 2. Troop Details");

        System.out.print("\nMenu Selection: ");
        int menu = sc.nextInt();

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

    void armyMenu(){
        System.out.println("Army Menu");
        System.out.println(" 1. Create Army");
        System.out.println(" 2. Display Army");
        System.out.println(" 3. Exit");        

        System.out.print("\nMenu Selection: ");
        int menu = sc.nextInt();

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.createArmy(); break;
            case 2: homeVillage.displayArmy(); break;
        }

        if(menu != 3){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }

    void combatMenu(){
        System.out.println("Combat Menu");
        System.out.println(" 1. Surrender");
        System.out.println(" 2. Exit");

        System.out.print("\nMenu Selection: ");
        int menu = sc.nextInt();

        System.out.print("\033[H\033[2J");  
        switch(menu){
            case 1: homeVillage.gameSurrender(); break;
        }

        if(menu != 1 && menu != 2){
            System.out.print("\nC to Continue: ");
            sc.next();
        }
    }
}
