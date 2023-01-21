public class ResourceBuilding {
    String name;
    int level;
    Resources resourceType;
    
    // Constructor
    ResourceBuilding(int type){
        level = 1;
        switch(type){
            case 1:
                name = "Lumberyard";
                resourceType = new Resources(type);
            break;

            case 2:
                name = "Mess Hall";
                resourceType = new Resources(type);
            break;

            case 3:
                name = "Mines";
                resourceType = new Resources(type);
            break;
        }
    }

    // Function to give amount of wood to add
    int generateWood(){
        return(resourceType.wood * level);
    }

    // Function to give amount of rations to add
    int generateRations(){
        return(resourceType.rations * level);
    }
    
    // Function to give amount of gold to add
    int generateGold(){
        return(resourceType.gold * level);
    }

    // Function to give amount of resources to add
    int[] generateResources(){
        int[] temp = {generateWood(), generateRations(), generateGold()};
        return(temp);
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

}
