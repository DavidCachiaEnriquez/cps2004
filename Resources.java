public class Resources {
    int wood; int rations; int gold;

    Resources(){
        wood = 5; rations = 5; gold = 5;
    }

    Resources(int type){
        wood = (type == 1) ? 1 : 0;
        rations = (type == 2) ? 1 : 0;
        gold = (type == 3) ? 1 : 0;
    }
}
