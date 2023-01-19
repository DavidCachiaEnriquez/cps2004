import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Village {
    // - - - Attributes - - - //
    String ownerName;
    String villageMarker;
    int health;
    int[] location;

    Resources store = new Resources();

    ArrayList<Troops> troops = new ArrayList<Troops>();
    ArrayList<Army> armies = new ArrayList<Army>();

    ArrayList<TrainingBuilding> trainingBuildings = new ArrayList<TrainingBuilding>();
    ArrayList<ResourceBuilding> resourceBuildings = new ArrayList<ResourceBuilding>();
    // - - - Attributes - - - //

    Scanner sc = new Scanner(System.in);

    Village(String name, String marker, Map map){
        ownerName = name;
        health = 50;
        villageMarker = marker;

        int[] coord = locationSetter(map.rows);
        location = coord;
        map.addVillage(coord, marker);
    }

    int[] locationSetter(int size){
        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        int[] coord = {x, y};
        return(coord);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    void villageDetails(){
        System.out.println("- - Village Details - -");
        System.out.println(" Village owner:    " + ownerName);
        System.out.println(" Village symbol:   " + villageMarker);
        System.out.println(" Village health:   " + health);
        System.out.println(" Location:         (" + location[0] + ", " + location[1] + ")");

        System.out.println("\n Resources");
        store.printContent();

        System.out.println("\n Troops");
        System.out.println(" Stationed Troops: " + troops.size());
        System.out.println(" Armies created:   " + armies.size());
    }

    void pass(){
        for(int i = 0; i < resourceBuildings.size(); i++){
            ResourceBuilding building = resourceBuildings.get(i);
            int[] newResources = building.generateResources();
            store.updateStoreContent(newResources[0], newResources[1], newResources[2]);
        }
    }


    void displayBuildings(){
        if(trainingBuildings.size() != 0){
            System.out.println(" Troop Buildings: ");

            for(int i = 0; i<trainingBuildings.size();i++){
                System.out.print("  " + trainingBuildings.get(i).name);
                System.out.println(" - lvl." + trainingBuildings.get(i).level);
            }

        }else{
            System.out.println(" No troop buildings yet...");
        }

        if(resourceBuildings.size() != 0){
            System.out.println("\n Resources Buildings");

            for(int i = 0; i<resourceBuildings.size();i++){
                System.out.print("  " + resourceBuildings.get(i).name);
                System.out.println(" - lvl." + resourceBuildings.get(i).level);
            }

        }else{
            System.out.println("\n No resource buildings yet...");
        }

        System.out.print("\nC to continue: ");
        sc.next();
    }

    void buildBuilding(){        
        System.out.println("\nTypes of Buildings: ");
        System.out.println(" 1. Troop Training");
        System.out.println(" 2. Resource Gathering");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt();

        if(store.wood > 0){

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

                        for(int i = 0; i < trainingBuildings.size(); i++){

                            if(trainingBuildings.get(i).troopName == "Soldier"){
                                flag = true;
                            }

                        }

                    }else if(type == 2){

                        for(int i = 0; i < trainingBuildings.size(); i++){

                            if(trainingBuildings.get(i).troopName == "Cavalier"){
                                flag = true;
                            }

                        }
                    }else if(type == 3){

                        for(int i = 0; i < trainingBuildings.size(); i++){

                            if(trainingBuildings.get(i).troopName == "Giant"){
                                flag = true;
                            }
                            
                        }
                    }

                    if(flag == false){
                        TrainingBuilding newBuild = new TrainingBuilding(type);
                        store.wood-=1;
                        trainingBuildings.add(newBuild);
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

                        for(int i = 0; i < resourceBuildings.size(); i++){

                            if(resourceBuildings.get(i).name == "Lumberyard"){
                                flag = true;
                            }

                        }
                    }else if(type == 2){

                        for(int i = 0; i < resourceBuildings.size(); i++){

                            if(resourceBuildings.get(i).name == "Mess Hall"){
                                flag = true;
                            }

                        }

                    }else if(type == 3){

                        for(int i = 0; i < resourceBuildings.size(); i++){

                            if(resourceBuildings.get(i).name == "Mines"){
                                flag = true;
                            }
                            
                        }

                    }

                    if(flag == false){
                        ResourceBuilding newBuild = new ResourceBuilding(type);
                        store.wood-=1;
                        resourceBuildings.add(newBuild);
                        System.out.println("Built!");
                    }else{
                        System.out.println("Already Built");
                    }
                }

            }

        }else{
            System.out.println("\nNot enough wood...");
        }

        System.out.print("\nC to continue: ");
        sc.next();
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
            if(trainingBuildings.size() > 0){
                for(int i = 0; i<trainingBuildings.size();i++){
                    System.out.print(" " + (i+1) + ". "  + trainingBuildings.get(i).name);
                    System.out.print(" - lvl." + trainingBuildings.get(i).level);
                    System.out.println(" - cost in gold: " + trainingBuildings.get(i).level);
                }
                System.out.print("\nChoose building to upgrade: ");
                building = sc.nextInt();

                upgradeCost = trainingBuildings.get(building-1).level;
                if(store.gold >= upgradeCost){
                    store.gold -= upgradeCost;
                    trainingBuildings.get(building-1).level += 1;
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
            if(resourceBuildings.size() > 0){
                for(int i = 0; i<resourceBuildings.size();i++){
                    System.out.print(" " + (i+1) + ". "  + resourceBuildings.get(i).name);
                    System.out.print(" - lvl." + resourceBuildings.get(i).level);
                    System.out.println(" - cost in gold: " + resourceBuildings.get(i).level);
                }
                System.out.print("Choose building to upgrade: ");
                building = sc.nextInt();

                upgradeCost = resourceBuildings.get(building-1).level;
                if(store.gold >= upgradeCost){

                    store.gold -= upgradeCost;
                    resourceBuildings.get(building-1).level += 1;
                    System.out.println("Upgraded!");
                }else{
                    System.out.println("Not enough gold...");
                }
            }else{
                System.out.println(" No resource buildings yet...");
            }
            break;
        }

        
        System.out.print("\nC to continue: ");
        sc.next();
    }


    void displayTroops(){
        ArrayList<Troops> villageTroops = troops;
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

        System.out.print("\nC to continue: ");
        sc.next();
    }

    void trainTroop(){
        if(trainingBuildings.size() != 0){
            for(int i = 0; i < trainingBuildings.size(); i++){
                System.out.println(" " + (i+1) + ". " + trainingBuildings.get(i).name);
            }

            System.out.print("\nMenu selection: ");
            int choice = sc.nextInt()-1;

            int cost = trainingBuildings.get(choice).troopCost;

            if(cost <= store.rations){
                store.rations -= cost;
                for(int i = 0; i < trainingBuildings.get(choice).level; i++){
                    TrainingBuilding trainer = trainingBuildings.get(choice);
                    String troopName = trainer.troopName;
                    int troopHealth = trainer.troopHealth;
                    int troopPower = trainer.troopPower;
                    int troopCc = trainer.troopCc;
                    int troopSpeed = trainer.troopSpeed;

                    Troops newTroop = new Troops(troopName, troopHealth, troopPower, troopCc, troopSpeed);
                    troops.add(newTroop);
                }
            }else{
                System.out.println("Not enough rations...");
            }
        }else{
            System.out.println("No training buildings built yet...");
        }

        System.out.print("\nC to continue: ");
        sc.next();
    }


    void displayArmy(){
        if(armies.size() != 0){
            System.out.println("Number of armies: " + armies.size());
            for(int i = 0; i < armies.size();i++){
                
                System.out.println("Army " + (i+1));
                ArrayList<Troops> armyTroops = armies.get(i).armyMembers;
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
        
        System.out.print("\nC to continue: ");
        sc.next();
    }

    void createArmy(){
        Army army = new Army();

        System.out.println("\nPrepared Troops:");
        ArrayList<Troops> villageTroops = troops;
        
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
                armies.add(army);
            }
        }else{
            System.out.println("No troops trained yet...");
        }
      
        System.out.print("\nC to continue: ");
        sc.next();
    }


    void gameSurrender(){
        health = 0;
        pass();
    }

}
