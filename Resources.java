public class Resources {
    int wood; int rations; int gold;
    int level;

    Resources(){
        wood = 3;
        rations = 3;
        gold = 3;
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
