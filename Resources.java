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

    void printContent(){
        System.out.println(" Wood:             " + wood);
        System.out.println(" Rations:          " + rations);
        System.out.println(" Gold:             " + gold);
    }

    void updateStoreContent(int newWood, int newRations, int newGold){
        wood += newWood;
        rations += newRations;
        gold += newGold;
    }
}
