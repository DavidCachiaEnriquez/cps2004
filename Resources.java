public class Resources {
    int wood; int rations; int gold;
    int level;

    Resources(){
        wood = 5;
        rations = 5;
        gold = 5;
    }

    Resources(int type){
        if(type == 1){
            wood = 1; level = 1;
        }else if(type == 2){
            rations = 1; level = 1;
        }else if(type == 3){
            gold = 1; level = 1;
        }
    }
}
