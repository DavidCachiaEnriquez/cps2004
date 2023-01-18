public class TrainingBuilding { 
    String name;

    String troopName;
    int troopCost;
    int troopHealth;
    int troopPower;
    int troopCc;
    int troopSpeed;

    int level;
    
    TrainingBuilding(int type){
        level = 1;
        if(type == 1){
            name = "Barracks"; troopName = "Soldier";
            troopCost = 1; troopHealth = 5; troopPower = 5; 
            troopCc = 3; troopSpeed = 5;
        }else if(type == 2){
            name = "Stables"; troopName = "Cavalier";
            troopCost = 2; troopHealth = 5; troopPower = 3; 
            troopCc = 5; troopSpeed = 10;
        }else if(type == 3){
            name = "Gym"; troopName = "Giant";
            troopCost = 5; troopHealth = 10; troopPower = 7; 
            troopCc = 7; troopSpeed = 3;
        }
    }


    
}
