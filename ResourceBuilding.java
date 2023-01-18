public class ResourceBuilding {
    String name;
    int level;
    Resources resourceType;
    
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
    
}
