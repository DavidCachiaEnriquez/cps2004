public class TrainingBuilding {
    int troopCost;
    int troopHealth;
    int troopPower;
    int troopCc;
    int troopSpeed;

    int level;
    
    TrainingBuilding(int type){
        if(type == 1){
            troopCost = 1; troopHealth = 5; troopPower = 5; 
            troopCc = 3; troopSpeed = 5; level = 1;
        }else if(type == 2){
            troopCost = 2; troopHealth = 5; troopPower = 3; 
            troopCc = 5; troopSpeed = 10; level = 1;
        }else if(type == 3){
            troopCost = 5; troopHealth = 10; troopPower = 7; 
            troopCc = 7; troopSpeed = 3; level = 1;
        }
    }
}
