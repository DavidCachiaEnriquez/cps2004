import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    // - - - Attributes - - - //
    String playerName;
    String villageMarker;
    Village homeVillage;

    Map worldMap;
    // - - - Attributes - - - //

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
                printDetails();

                System.out.print("\nC to continue: ");
                sc.next();
                break;

                case 2:
                worldMap.drawMap();

                System.out.print("\nC to continue: ");
                sc.next();
                break;
                
                case 3:
                pass();
                break;

                case 4: 
                System.out.println("\nBuilding Details");
                displayBuildings();

                System.out.print("\nC to continue: ");
                sc.next();
                break;
                
                case 5:
                System.out.print("\nBuild Building");
                buildBuilding();

                System.out.print("\nC to continue: ");
                sc.next();
                break;
                
                case 6:
                System.out.println("Upgrade Building");
                upgradeBuilding();

                System.out.print("\nC to continue: ");
                sc.next();
                break;

                case 7:
                System.out.println("\nDisplay Troops");
                displayTroops();

                System.out.print("\nC to continue: ");
                sc.next();
                break;
                
                case 8:
                System.out.println("\nTrain Troops");
                trainTroop();

                System.out.print("\nC to continue: ");
                sc.next();
                break;

                case 9:
                System.out.println("\nDisplay Army");
                displayArmy();

                System.out.print("\nC to continue: ");
                sc.next();
                break;

                case 10:
                System.out.println("\nCreate Army");
                createArmy();
                
                System.out.print("\nC to continue: ");
                sc.next();
                break;
                
                case 11:
                homeVillage.health = 0;
                pass();
                break;
            }
            System.out.print("\033[H\033[2J");  
        }

    }

    void printDetails(){
        System.out.println("\n- - Village Details - -");
        System.out.println(" Village owner:    " + homeVillage.ownerName);
        System.out.println(" Village symbol:   " + homeVillage.villageMarker);
        System.out.println(" Village health:   " + homeVillage.health);
        System.out.println(" Location:         (" + homeVillage.location[0] + ", " + homeVillage.location[1] + ")");

        System.out.println("\n Resources");
        System.out.println(" Wood:             " + homeVillage.store.wood);
        System.out.println(" Rations:          " + homeVillage.store.rations);
        System.out.println(" Gold:             " + homeVillage.store.gold);

        System.out.println("\n Troops");
        System.out.println(" Stationed Troops: " + homeVillage.troops.size());
        System.out.println(" Armies created:   " + homeVillage.armies.size());
    }


    void displayBuildings(){
        if(homeVillage.trainingBuildings.size() != 0){
            System.out.println(" Troop Buildings: ");
            for(int i = 0; i<homeVillage.trainingBuildings.size();i++){
                System.out.print("  " + homeVillage.trainingBuildings.get(i).name);
                System.out.println(" - lvl." + homeVillage.trainingBuildings.get(i).level);
            }
        }else{
            System.out.println(" No troop buildings yet...");
        }

        if(homeVillage.resourceBuildings.size() != 0){
            System.out.println("\n Resources Buildings");
            for(int i = 0; i<homeVillage.resourceBuildings.size();i++){
                System.out.print("  " + homeVillage.resourceBuildings.get(i).name);
                System.out.println(" - lvl." + homeVillage.resourceBuildings.get(i).level);
            }
        }else{
            System.out.println("\n No resource buildings yet...");
        }
    }

    void buildBuilding(){
        System.out.println("\nTypes of Buildings: ");
        System.out.println(" 1. Troop Training");
        System.out.println(" 2. Resource Gathering");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt();

        if(homeVillage.store.wood > 0){
            if(choice == 1){
                System.out.println("\nChoose type:");
                System.out.println(" 1. Barracks (Soldier)");
                System.out.println(" 2. Stables (Cavlier)");
                System.out.println(" 3. Gym (Giant)");
                System.out.println(" 4. Cancel");
                
                System.out.print("\nMenu selection: ");
                int type = sc.nextInt();
                
                if(type != 4){
                    boolean flag = false;
                    if(type == 1){
                        for(int i = 0; i < homeVillage.trainingBuildings.size(); i++){
                            if(homeVillage.trainingBuildings.get(i).troopName == "Soldier"){
                                flag = true;
                            }
                        }
                    }else if(type == 2){
                        for(int i = 0; i < homeVillage.trainingBuildings.size(); i++){
                            if(homeVillage.trainingBuildings.get(i).troopName == "Cavalier"){
                                flag = true;
                            }
                        }
                    }else if(type == 3){
                        for(int i = 0; i < homeVillage.trainingBuildings.size(); i++){
                            if(homeVillage.trainingBuildings.get(i).troopName == "Giant"){
                                flag = true;
                            }
                        }
                    }

                    if(flag == false){
                        TrainingBuilding newBuild = new TrainingBuilding(type);
                        homeVillage.store.wood-=1;
                        homeVillage.trainingBuildings.add(newBuild);
                        System.out.println("Built!");
                    }else{
                    System.out.println("Already Built");
                }
                }

            }else if(choice == 2){
                System.out.println("\nChoose type:");
                System.out.println(" 1. Lumberyad (Wood)");
                System.out.println(" 2. Mess Hall (Rations)");
                System.out.println(" 3. Mines (Gold)");
                System.out.println(" 4. Cancel");

                System.out.print("\nMenu selection: ");
                int type = sc.nextInt();

                if(type != 4){
                    boolean flag = false;
                    if(type == 1){
                        for(int i = 0; i < homeVillage.resourceBuildings.size(); i++){
                            if(homeVillage.resourceBuildings.get(i).name == "Lumberyard"){
                                flag = true;
                            }
                        }
                    }else if(type == 2){
                        for(int i = 0; i < homeVillage.resourceBuildings.size(); i++){
                            if(homeVillage.resourceBuildings.get(i).name == "Mess Hall"){
                                flag = true;
                            }
                        }
                    }else if(type == 3){
                        for(int i = 0; i < homeVillage.resourceBuildings.size(); i++){
                            if(homeVillage.resourceBuildings.get(i).name == "Mines"){
                                flag = true;
                            }
                        }
                    }

                    if(flag == false){
                        ResourceBuilding newBuild = new ResourceBuilding(type);
                        homeVillage.store.wood-=1;
                        homeVillage.resourceBuildings.add(newBuild);
                        System.out.println("Built!");
                    }else{
                        System.out.println("Already Built");
                    }
                }
            }
        }else{
            System.out.println("\nNot enough wood...");
        }
    }    

    void upgradeBuilding(){
        System.out.println("Choose building type:");
        System.out.println(" 1. Troop Buildings");
        System.out.println(" 2. Resource Buildings");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt();

        int building;
        int upgradeCost;
        switch(choice){
            case 1:
            System.out.println("\nTroop Buildings");
            if(homeVillage.trainingBuildings.size() > 0){
                for(int i = 0; i<homeVillage.trainingBuildings.size();i++){
                    System.out.print(" " + (i+1) + ". "  + homeVillage.trainingBuildings.get(i).name);
                    System.out.print(" - lvl." + homeVillage.trainingBuildings.get(i).level);
                    System.out.println(" - cost in gold: " + homeVillage.trainingBuildings.get(i).level);
                }
                System.out.print("\nChoose building to upgrade: ");
                building = sc.nextInt();

                upgradeCost = homeVillage.trainingBuildings.get(building-1).level;
                if(homeVillage.store.gold >= upgradeCost){
                    homeVillage.store.gold -= upgradeCost;
                    homeVillage.trainingBuildings.get(building-1).level += 1;
                    System.out.println("Upgraded!");
                }else{
                    System.out.println("Not enough gold...");
                }
            }else{
                System.out.println(" No troop buildings yet...");
            }
            break;

            case 2:
            System.out.println("\nResource Buildings");
            if(homeVillage.resourceBuildings.size() > 0){
                for(int i = 0; i<homeVillage.resourceBuildings.size();i++){
                    System.out.print(" " + (i+1) + ". "  + homeVillage.resourceBuildings.get(i).name);
                    System.out.print(" - lvl." + homeVillage.resourceBuildings.get(i).level);
                    System.out.println(" - cost in gold: " + homeVillage.resourceBuildings.get(i).level);
                }
                System.out.print("Choose building to upgrade: ");
                building = sc.nextInt();

                upgradeCost = homeVillage.resourceBuildings.get(building-1).level;
                if(homeVillage.store.gold >= upgradeCost){

                    homeVillage.store.gold -= upgradeCost;
                    homeVillage.resourceBuildings.get(building-1).level += 1;
                    System.out.println("Upgraded!");
                }else{
                    System.out.println("Not enough gold...");
                }
            }else{
                System.out.println(" No resource buildings yet...");
            }
            break;
        }
    }


    void displayTroops(){
        ArrayList<Troops> villageTroops = homeVillage.troops;
        if(villageTroops.size() != 0){
            int numOfS = 0; int numOfC = 0; int numOfG = 0;
            
            for(int i = 0; i < villageTroops.size(); i++){
                if(villageTroops.get(i).name == "Soldier"){
                    numOfS++;
                }else if(villageTroops.get(i).name == "Cavalier"){
                    numOfC++;
                }else if(villageTroops.get(i).name == "Giant"){
                    numOfG++;
                }
            }

            System.out.print((numOfS != 0) ? "Soldiers: " + numOfS : "");
            System.out.print((numOfC != 0) ? "\nCavaliers: " + numOfC : "");
            System.out.println((numOfG != 0) ? "\nGiants: " + numOfG:"");
        }else{
            System.out.println("No troops trained yet...");
        }
    }

    void trainTroop(){
        if(homeVillage.trainingBuildings.size() != 0){
            for(int i = 0; i < homeVillage.trainingBuildings.size(); i++){
                System.out.println(" " + (i+1) + ". " + homeVillage.trainingBuildings.get(i).name);
            }

            System.out.print("\nMenu selection: ");
            int choice = sc.nextInt()-1;

            int cost = homeVillage.trainingBuildings.get(choice).troopCost;

            if(cost <= homeVillage.store.rations){
                homeVillage.store.rations -= cost;
                for(int i = 0; i < homeVillage.trainingBuildings.get(choice).level; i++){
                    TrainingBuilding trainer = homeVillage.trainingBuildings.get(choice);
                    String troopName = trainer.troopName;
                    int troopHealth = trainer.troopHealth;
                    int troopPower = trainer.troopPower;
                    int troopCc = trainer.troopCc;
                    int troopSpeed = trainer.troopSpeed;

                    Troops newTroop = new Troops(troopName, troopHealth, troopPower, troopCc, troopSpeed);
                    homeVillage.troops.add(newTroop);
                }
            }else{
                System.out.println("Not enough rations...");
            }
        }else{
            System.out.println("No training buildings built yet...");
        }
    }


    void displayArmy(){
        if(homeVillage.armies.size() != 0){
            System.out.println("Number of armies: " + homeVillage.armies.size());
            for(int i = 0; i < homeVillage.armies.size();i++){
                
                System.out.println("Army " + (i+1));
                ArrayList<Troops> armyTroops = homeVillage.armies.get(i).armyMembers;
                int numOfS = 0; int numOfC = 0; int numOfG = 0;
                
                for(int j = 0; j < armyTroops.size(); j++){
                    if(armyTroops.get(j).name == "Soldier"){
                        numOfS++;
                    }else if(armyTroops.get(j).name == "Cavalier"){
                        numOfC++;
                    }else if(armyTroops.get(j).name == "Giant"){
                        numOfG++;
                    }
                }
            
                System.out.print((numOfS != 0) ? " Soldiers: " + numOfS : "");
                System.out.print((numOfC != 0) ? "\n Cavaliers: " + numOfC : "");
                System.out.println((numOfG != 0) ? "\n Giants: " + numOfG:"");
            }
        }else{
            System.out.println("No armies formed yet...");
        }
    }

    void createArmy(){
        Army army = new Army();

        System.out.println("\nPrepared Troops:");
        ArrayList<Troops> villageTroops = homeVillage.troops;
        
        if(villageTroops.size() != 0){

            int numOfS = 0; int numOfC = 0; int numOfG = 0;
            for(int i = 0; i < villageTroops.size(); i++){
                if(villageTroops.get(i).name == "Soldier"){
                    numOfS++;
                }else if(villageTroops.get(i).name == "Cavalier"){
                    numOfC++;
                }else if(villageTroops.get(i).name == "Giant"){
                    numOfG++;
                }
            }

            System.out.print((numOfS != 0) ? " Soldiers: " + numOfS : "");
            System.out.print((numOfC != 0) ? "\n Cavaliers: " + numOfC : "");
            System.out.println((numOfG != 0) ? "\n Giants: " + numOfG:"");

            System.out.println("\nAdding Troops to Army");
            
            if(numOfS != 0){
                System.out.println("Number of Soldiers: ");
                int input = sc.nextInt();
                while(input > numOfS | input < 0){
                    if(input > numOfS | input < 0){
                        System.out.print("Invalid number of troops");
                        input = sc.nextInt();
                    }
                }
                

                for(int i = 0; i < villageTroops.size(); i++){
                    if(villageTroops.get(i).name == "Soldier"){
                        army.armyMembers.add(villageTroops.get(i));
                        villageTroops.remove(i);
                        input--;
                    }
                    if(input < 0){
                        break;
                    }
                }
            }

            if(numOfC != 0){
                System.out.println("Number of Cavaliers: ");
                int input = sc.nextInt();
                while(input > numOfC | input < 0){
                    if(input > numOfC | input < 0){
                        System.out.println("Invalid number of troops");
                        input = sc.nextInt();
                    }
                }

                for(int i = 0; i < villageTroops.size(); i++){
                    if(villageTroops.get(i).name == "Cavalier"){
                        army.armyMembers.add(villageTroops.get(i));
                        villageTroops.remove(i);
                        input--;
                    }
                    if(input < 0){
                        break;
                    }
                }
            }

            if(numOfG != 0){
                System.out.println("Number of Giants: ");
                int input = sc.nextInt();
                while(input > numOfG | input < 0){
                    if(input > numOfG | input < 0){
                        System.out.println("Invalid number of troops");
                        input = sc.nextInt();
                    }
                }

                for(int i = 0; i < villageTroops.size(); i++){
                    if(villageTroops.get(i).name == "Giant"){
                        army.armyMembers.add(villageTroops.get(i));
                        villageTroops.remove(i);
                        input--;
                    }
                    if(input < 0){
                        break;
                    }
                }
            }

            if(army.armyMembers.size() > 0){
                homeVillage.armies.add(army);
            }
        }else{
            System.out.println("No troops trained yet...");
        }
    }


    

    void attackVillage(){
    }

    void pass(){
        for(int i = 0; i < homeVillage.resourceBuildings.size(); i++){
            Resources villageStore = homeVillage.store;
            ResourceBuilding building = homeVillage.resourceBuildings.get(i);

            int wood = building.resourceType.wood * building.level;
            int rations = building.resourceType.rations * building.level;
            int gold = building.resourceType.gold * building.level;

            villageStore.wood += wood;
            villageStore.rations += rations;
            villageStore.gold += gold;
        }
    }
}
