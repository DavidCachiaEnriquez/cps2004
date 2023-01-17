public class ResourceBuilding {
    
    Resources resourceType;
    
    ResourceBuilding(int type){
        if(type == 1){
            resourceType = new Resources(type);
        }else if(type == 2){
            resourceType = new Resources(type);
        }else if(type == 3){
            resourceType = new Resources(type);
        }
    }
}
