public class ResourceBuilding {
    String name;
    int level;
    Resources resourceType;
    
    ResourceBuilding(int type){
        switch(type){
            case 1:
            name = "Lumberyard";
            resourceType = new Resources(type);
            level = 1;
            break;

            case 2:
            name = "Mess Hall";
            resourceType = new Resources(type);
            level = 1;
            break;

            case 3:
            name = "Mines";
            resourceType = new Resources(type);
            level = 1;
            break;
        }
    }
    
}
