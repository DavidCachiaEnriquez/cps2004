import java.util.ArrayList;

public class TrainingBuilding { 
    String name;

    String troopName;
    int troopCost;
    int troopHealth;
    int troopPower;
    int troopCc;
    int troopSpeed;

    int level;
    
    // Constructor
    TrainingBuilding(int type){
        level = 1;
        if(type == 1){
            name = "Barracks"; troopName = "Soldier";
            troopCost = 1; troopHealth = 3; troopPower = 3; 
            troopCc = 3; troopSpeed = 3;
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

    void displayDetails(int i){
        System.out.print(" " + (i+1) + ". " + name + " - lvl." + level);
    }

    void createTroop(Resources store, ArrayList<Troops> homeTroops){
        store.rations -= troopCost;
        for(int i = 0; i < level; i++){
            Troops newTroop = new Troops(troopName, troopHealth, troopPower, troopCc, troopSpeed);
            homeTroops.add(newTroop);
        }
    }
}
