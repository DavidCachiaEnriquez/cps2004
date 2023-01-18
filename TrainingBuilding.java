public class TrainingBuilding { 
    String name;

    String troopName;
    int troopCost;
    int troopHealth;
    int troopPower;
    int troopCc;
    int troopSpeed;

    int level;
    
    TrainingBuilding(String type){
        if(type == "Barracks"){
            name = "Barracks"; troopName = "Soldier";
            troopCost = 1; troopHealth = 5; troopPower = 5; 
            troopCc = 3; troopSpeed = 5; level = 1;
        }else if(type == "Stables"){
            name = "Stables"; troopName = "Cavalier";
            troopCost = 2; troopHealth = 5; troopPower = 3; 
            troopCc = 5; troopSpeed = 10; level = 1;
        }else if(type == "Gym"){
            name = "Gym"; troopName = "Giant";
            troopCost = 5; troopHealth = 10; troopPower = 7; 
            troopCc = 7; troopSpeed = 3; level = 1;
        }
    }
}
