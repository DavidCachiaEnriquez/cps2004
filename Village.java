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

    ArrayList<Troops> homeTroops = new ArrayList<Troops>();
    ArrayList<Army> armies = new ArrayList<Army>();

    ArrayList<TrainingBuilding> trainingBuildings = new ArrayList<TrainingBuilding>();
    ArrayList<ResourceBuilding> resourceBuildings = new ArrayList<ResourceBuilding>();
    // - - - Attributes - - - //

    Scanner sc = new Scanner(System.in);

    Village(String name, String marker, Map map){
        ownerName = name;
        health = 50;
        villageMarker = marker;

        int[] coord = locationSetter(map.rows, map);
        location = coord;
        map.addVillage(coord, marker);
    }

    int[] locationSetter(int size, Map map){
        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        while(map.grid[x][y] != "-"){
            x = (int)(Math.random() * size);
            y = (int)(Math.random() * size);
        }

        int[] coord = {x, y};
        return(coord);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    void villageDetails(){
        System.out.println("- - Village Details - -");
        System.out.println(" Village owner:    " + ownerName);
        System.out.println(" Village symbol:   " + villageMarker);
        System.out.println(" Village health:   " + health);
        System.out.println(" Location:         (" + location[1] + ", " + location[0] + ")");

        System.out.println("\n Resources");
        store.printContent();
    }


    
    void buildBuilding(){        
        System.out.println("Types of Buildings: ");
        System.out.println(" 1. Troop Training");
        System.out.println(" 2. Resource Gathering");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt();

        if(store.wood > 0){

            if(choice == 1){
                System.out.print("\033[H\033[2J");
                System.out.println("Choose building:");
                System.out.println(" 1. Barracks (Soldier)");
                System.out.println(" 2. Stables (Cavlier)");
                System.out.println(" 3. Gym (Giant)");
                System.out.println(" 4. Cancel");
                
                System.out.print("\nMenu selection: ");
                int type = sc.nextInt();
                
                if(type != 4){
                    boolean flag = false;

                    if(type == 1){
                        flag = existCheckerT(trainingBuildings, "Soldier");
                    }else if(type == 2){
                        flag = existCheckerT(trainingBuildings, "Cavalier");
                    }else if(type == 3){
                        flag = existCheckerT(trainingBuildings, "Giant");
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
                        flag = existCheckerR(resourceBuildings, "Lumberyard");
                    }else if(type == 2){
                        flag = existCheckerR(resourceBuildings, "Mess Hall");
                    }else if(type == 3){
                        flag = existCheckerR(resourceBuildings, "Mines");
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
    }    

    boolean existCheckerT(ArrayList<TrainingBuilding> building, String name){
        for(int i = 0; i < building.size(); i++){
            if(building.get(i).troopName == name){
                return(true);
            }
        }
        return(false);
    }

    boolean existCheckerR(ArrayList<ResourceBuilding> building, String name){
        for(int i = 0; i < building.size(); i++){
            if(building.get(i).name == name){
                return(true);
            }
        }
        return(false);
    }



    void upgradeBuilding(){
        System.out.println("Choose building type:");
        System.out.println(" 1. Troop Buildings");
        System.out.println(" 2. Resource Buildings");
        System.out.println(" 3. Cancel");

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
            System.out.print("\033[H\033[2J");
            System.out.println("Troop Buildings");
            upgradeTroops();
            break;

            case 2:
            System.out.print("\033[H\033[2J");
            System.out.println("Resource Buildings");
            upgradeResources();
            break;
        }
    }

    void upgradeTroops(){
        if(trainingBuildings.size() > 0){
            for(int i = 0; i<trainingBuildings.size();i++){
                System.out.print(" " + (i+1) + ". "  + trainingBuildings.get(i).name);
                System.out.print(" - lvl." + trainingBuildings.get(i).level);
                System.out.println(" - cost in gold: " + trainingBuildings.get(i).level);
            }
            System.out.print("\nChoose building to upgrade: ");
            int building = sc.nextInt();

            TrainingBuilding upgradeBuilding = trainingBuildings.get(building-1);
            upgradeBuilding.upgradeTrainingBuilding(store);
        }else{
            System.out.println(" No troop buildings yet...");
        }
    }

    void upgradeResources(){
        if(resourceBuildings.size() > 0){
            for(int i = 0; i<resourceBuildings.size();i++){
                System.out.print(" " + (i+1) + ". "  + resourceBuildings.get(i).name);
                System.out.print(" - lvl." + resourceBuildings.get(i).level);
                System.out.println(" - cost in gold: " + resourceBuildings.get(i).level);
            }
            System.out.print("Choose building to upgrade: ");
            int building = sc.nextInt();

            ResourceBuilding upgradeBuilding = resourceBuildings.get(building-1);
            upgradeBuilding.upgradeTrainingBuilding(store);
        }else{
            System.out.println(" No resource buildings yet...");
        }
    }



    void displayBuildings(){
        displayTBuilds();
        displayRBuilds();
    }

    void displayTBuilds(){
        if(trainingBuildings.size() != 0){
            System.out.println("Troop Buildings: ");
            for(int i = 0; i<trainingBuildings.size();i++){
                trainingBuildings.get(i).displayDetails(i);
            }
        }else{
            System.out.println(" No troop buildings yet...");
        }
    }

    void displayRBuilds(){
        if(resourceBuildings.size() != 0){
            System.out.println("\nResources Buildings");
            for(int i = 0; i<resourceBuildings.size();i++){
                resourceBuildings.get(i).displayDetails(i);
            }
        }else{
            System.out.println("\n No resource buildings yet...");
        }
    }



    void trainTroop(){
        displayTBuilds();

        System.out.print("\nMenu selection: ");
        int choice = sc.nextInt()-1;

        int cost = trainingBuildings.get(choice).troopCost;

        if(cost <= store.rations){
            trainingBuildings.get(choice).createTroop(store, homeTroops);
        }else{
            System.out.println("Not enough rations...");
        }

    }



    void displayVillageTroops(){
        System.out.println("Village Troops:");
        displayTroops(homeTroops);
    }

    void displayTroops(ArrayList<Troops> troops){
        if(troops.size() != 0){
            int[] troopArray = countNumberOfTroops(troops);

            System.out.print((troopArray[0] != 0) ? " Soldiers: " + troopArray[0] : "");
            System.out.print((troopArray[1] != 0) ? "\n Cavaliers: " + troopArray[1] : "");
            System.out.println((troopArray[2] != 0) ? "\n Giants: " + troopArray[2]:"");
        }else{
            System.out.println(" No troops trained yet...");
        }
    }

    int[] countNumberOfTroops(ArrayList<Troops> villageTroops){
        int[] troopArray = new int[3];

        for(int i = 0; i < villageTroops.size(); i++){
            if(villageTroops.get(i).name == "Soldier"){
                troopArray[0]++;
            }else if(villageTroops.get(i).name == "Cavalier"){
                troopArray[1]++;
            }else if(villageTroops.get(i).name == "Giant"){
                troopArray[2]++;
            }
        }

        return(troopArray);
    }



    void attackVillage(ArrayList<Player> players, Map map){
        System.out.println("Attacking Village!");
        
        map.drawMap();
        ArrayList<Player> otherPlayers = listWithoutUser(players);
        Player target = chooseTarget(otherPlayers);

        target.homeVillage.reducedVillageDetails();

        double dist = totalDistance(target.homeVillage.location);
        System.out.println("Distance: " + dist);

        Army newArmy = new Army(homeTroops, dist, location, target.homeVillage.location, false);
        armies.add(newArmy);
    }

    ArrayList<Player> listWithoutUser(ArrayList<Player> players){
        ArrayList<Player> tempList = new ArrayList<Player>();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).playerName != ownerName){
                tempList.add(players.get(i));
            }
        }
        return tempList;
    }

    Player chooseTarget(ArrayList<Player> choices){
        System.out.println("\nChoose Target");
        for(int i  = 0; i <choices.size(); i++){
            System.out.println(" " + (i+1) + ". " + choices.get(i).playerName);
        }

        System.out.print("\nTarget number: ");
        int i = sc.nextInt()-1;

        return choices.get(i);
    }

    void reducedVillageDetails(){
        System.out.println("\nVillage owner:    " + ownerName);
        System.out.println("Village symbol:   " + villageMarker);
        System.out.println("Location:         (" + location[1] + ", " + location[0] + ")");
    }

    double totalDistance(int[] tLocation){
        int x1 = location[1]; int y1 = location[0];
        int x2 = tLocation[1]; int y2 = tLocation[0];

        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }



    void displayArmies(){
    }

    
    void pass(){
        updateResources();
        updateArmies();
    }

    void updateResources(){
        for(int i = 0; i < resourceBuildings.size(); i++){
            ResourceBuilding building = resourceBuildings.get(i);
            int[] newResources = building.generateResources();
            store.updateStoreContent(newResources[0], newResources[1], newResources[2]);
        }
    }

    void updateArmies(){
        for(int i = 0; i < armies.size(); i++){
            System.out.println(armies.get(i).armyMembers.size());
        }
    }


    void depositArmyMembers(Army army){
        for(int i = 0; i < army.armyMembers.size(); i++){
            homeTroops.add(army.armyMembers.get(i));
        }
    }



    Army defendingArmy(){
        Army tempArmy = new Army(homeTroops, 0, location, location, true);
        for(int i = 0; i <= homeTroops.size(); i++){
            homeTroops.remove(0);
        }
        System.out.println(homeTroops.size());
        return tempArmy;
    }






    void gameSurrender(){
        health = 0;
    }
}
