public class Village {
    String playerName;
    int health;
    int location;

    Building buildings;
    Troops[] army;
    Resources store;

    Village(String name){
        playerName = name;
        health = 10;

        store = new Resources();
        buildings = new Building();
    }

}
