public class Resources {
    int wood; int rations; int gold;

    Resources(){
        wood = 5;
        rations = 5;
        gold = 5;
    }

    Resources(int type){
        if(type == 1){
            wood = 1;
        }else if(type == 2){
            rations = 1;
        }else if(type == 3){
            gold = 1;
        }
    }
}
