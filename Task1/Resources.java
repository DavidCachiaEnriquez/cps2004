public class Resources {
    int wood; int rations; int gold;

    // Constructor - General
    Resources(){
        wood = 5; rations = 5; gold = 5;
    }

    // Constructor - Specific
    Resources(int type){
        wood = (type == 1) ? 1 : 0;
        rations = (type == 2) ? 1 : 0;
        gold = (type == 3) ? 1 : 0;
    }

    // Function to print contents
    void printContent(){
        System.out.println(" Wood:             " + wood);
        System.out.println(" Rations:          " + rations);
        System.out.println(" Gold:             " + gold);
    }

    // Function to update amount of resources
    void updateStoreContent(int newWood, int newRations, int newGold){
        wood += newWood;
        rations += newRations;
        gold += newGold;
    }
}
