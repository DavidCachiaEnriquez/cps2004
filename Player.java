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

        System.out.print("Choose maker [@, £, $, %, &, #]:");
        homeVillage.villageMarker = sc.next();

        homeVillage = new Village(playerName, homeVillage.villageMarker, map);
    }

    void displayBuildings(){
        System.out.println("\nBuilding Details");
        System.out.println(" Troop Buildings: " + homeVillage.trainingBuildings.size());
        for(int i = 0; i<homeVillage.trainingBuildings.size();i++){
            System.out.print("  " + homeVillage.trainingBuildings.get(i).name);
            System.out.println(" - lvl." + homeVillage.trainingBuildings.get(i).level);
        }

        System.out.println(" Resources Buildings: " + homeVillage.resourceBuildings.size());
        for(int i = 0; i<homeVillage.resourceBuildings.size();i++){
            System.out.print("  " + homeVillage.resourceBuildings.get(i).name);
            System.out.println(" - lvl." + homeVillage.resourceBuildings.get(i).level);
        }
    }

    void buildBuilding(){
        System.out.println("\nTypes of buildings: ");
        System.out.println("1. Troop Training");
        System.out.println("2. Resource Gathering");
        int choice = sc.nextInt();
        if(homeVillage.store.wood > 0){
            if(choice == 1){

                System.out.println("\nChoose type:");
                System.out.println("1. Barracks (Soldier)");
                System.out.println("2. Stables (Cavlier)");
                System.out.println("3. Gym (Giant)");
                
                int type = sc.nextInt();
                String name = "";
                if(type == 1){
                    name = "Barracks";
                }else if(type == 2){
                    name = "Stables";
                }else if(type == 3){
                    name = "Gym";
                }

                boolean flag = true;
                for(int i = 0; i<homeVillage.trainingBuildings.size();i++){
                    if(homeVillage.trainingBuildings.get(i).name == name){
                        flag = false;
                    }
                }

                if(flag == true){
                    TrainingBuilding newBuild = new TrainingBuilding(name);
                    homeVillage.store.wood-=1;
                    homeVillage.trainingBuildings.add(newBuild);
                }else{
                    System.out.println("Already Built");
                }

            }else if(choice == 2){

                System.out.println("\nChoose type:");
                System.out.println("1. Lumberyad (Wood)");
                System.out.println("2. Mess Hall (Rations)");
                System.out.println("3. Mines (Gold)");

                int type = sc.nextInt();
                ResourceBuilding newBuild = new ResourceBuilding(type);
                homeVillage.store.wood-=1;
                homeVillage.resourceBuildings.add(newBuild);
            }
        }else{
            System.out.println("\nNot enough wood");
        }
    }    

    void upgradeBuilding(){
        System.out.println("\nUpgrade Building");
        System.out.println("Choose building type:");
        System.out.println(" 1. Troop Buildings");
        System.out.println(" 2. Resource Buildings");
        System.out.println(" 3. Cancel");
        int choice = sc.nextInt();

        int building;
        int upgradeCost;
        switch(choice){
            case 1:
            System.out.println("\nTroop Buildings");
            for(int i = 0; i<homeVillage.trainingBuildings.size();i++){
                System.out.print(" " + (i+1) + ". "  + homeVillage.trainingBuildings.get(i).name);
                System.out.print(" - lvl." + homeVillage.trainingBuildings.get(i).level);
                System.out.println(" - cost in gold: " + homeVillage.trainingBuildings.get(i).level);
            }
            System.out.print("Choose building to upgrade: ");
            building = sc.nextInt();

            upgradeCost = homeVillage.trainingBuildings.get(building-1).level;
            
            homeVillage.store.gold -= upgradeCost;
            homeVillage.trainingBuildings.get(building-1).level += 1;
            break;

            case 2:
            System.out.println("\nResource Buildings");
            for(int i = 0; i<homeVillage.resourceBuildings.size();i++){
                System.out.print(" " + (i+1) + ". "  + homeVillage.resourceBuildings.get(i).name);
                System.out.print(" - lvl." + homeVillage.resourceBuildings.get(i).level);
                System.out.println(" - cost in gold: " + homeVillage.resourceBuildings.get(i).level);
            }
            System.out.print("Choose building to upgrade: ");
            building = sc.nextInt();

            upgradeCost = homeVillage.resourceBuildings.get(building-1).level;
            
            homeVillage.store.gold -= upgradeCost;
            homeVillage.resourceBuildings.get(building-1).level += 1;
            break;
        }
    }

    void displayTroops(){
        System.out.println("\nDisplay Troops");
        System.out.println("Number of troops: " + homeVillage.troops.size());

        int numS = 0;
        int numC = 0;
        int numG = 0;

        for(int i = 0; i<homeVillage.troops.size();i++){
            if(homeVillage.troops.get(i).name == "Soldier"){
                numS += 1;
            }else if(homeVillage.troops.get(i).name == "Cavalier"){
                numC += 1;
            }else if(homeVillage.troops.get(i).name == "Giant"){
                numG += 1;
            }
        }
        System.out.println("Soldiers: " + numS);
        System.out.println("Cavalier: " + numC);
        System.out.println("Giant: " + numG);
    }

    void trainTroop(){
        System.out.println("Train Troops");
        if(homeVillage.trainingBuildings.size() != 0){
            for(int i = 0; i < homeVillage.trainingBuildings.size(); i++){
                System.out.println(" " + (i+1) + ". " + homeVillage.trainingBuildings.get(i).name);
            }
            int choice = sc.nextInt()-1;

            int cost = homeVillage.trainingBuildings.get(choice).troopCost;

            if(cost <= homeVillage.store.rations){
                homeVillage.store.rations -= cost;
                
                TrainingBuilding trainer = homeVillage.trainingBuildings.get(choice);
                String troopName = trainer.troopName;
                int troopHealth = trainer.troopHealth;
                int troopPower = trainer.troopPower;
                int troopCc = trainer.troopCc;
                int troopSpeed = trainer.troopSpeed;

                Troops newTroop = new Troops(troopName, troopHealth, troopPower, troopCc, troopSpeed);
                homeVillage.troops.add(newTroop);
            }else{
                System.out.println("Not enough rations");
            }
        }else{
            System.out.println("No training buildings built");
        }
    }

    void attackVillage(){
    }

    void surrenderVillage(){
    }

    void pass(){
    }
}
