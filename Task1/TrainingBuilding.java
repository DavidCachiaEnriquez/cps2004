import java.util.ArrayList;

public class TrainingBuilding { 
    String name;

    String troopName;
    int troopCost;
    private int troopHealth;
    private int troopPower;
    private int troopCc;
    private int troopSpeed;

    int level;
    
    // Constructor
    TrainingBuilding(int type){
        level = 1;
        if(type == 1){
            name = "Barracks"; troopName = "Soldier";
            troopCost = 1; troopHealth = 4; troopPower = 4; 
            troopCc = 4; troopSpeed = 4;
        }else if(type == 2){
            name = "Stables"; troopName = "Cavalier";
            troopCost = 2; troopHealth = 3; troopPower = 1; 
            troopCc = 5; troopSpeed = 7;
        }else if(type == 3){
            name = "Gym"; troopName = "Giant";
            troopCost = 5; troopHealth = 7; troopPower = 7; 
            troopCc = 7; troopSpeed = 1;
        }
    }

    // Function to checks if enough rations are available
    void checkRations(Resources store, ArrayList<Troops> homeTroops){
        int cost = troopCost;

        if(cost <= store.rations){
            createTroop(store, homeTroops);
        }else{
            System.out.println("Not enough rations...");
        }
    }

    // Functiont to train a new troop
    private void createTroop(Resources store, ArrayList<Troops> homeTroops){
        store.rations -= troopCost;
        for(int i = 0; i < level; i++){
            Troops newTroop = new Troops(troopName, troopHealth, troopPower, troopCc, troopSpeed);
            homeTroops.add(newTroop);
        }
    }

    // Function to upgrade building
    void upgradeTrainingBuilding(Resources store){
        int upgradeCost = level;
            if(store.gold >= upgradeCost){
                store.gold -= upgradeCost;
                level += 1;
                System.out.println("Upgraded!");
            }else{
                System.out.println("Not enough gold...");
            }
    }

    // Function to display details of the building
    void displayDetails(int i){
        System.out.print(" " + (i+1) + ". " + name + " - lvl." + level);
    }
}
