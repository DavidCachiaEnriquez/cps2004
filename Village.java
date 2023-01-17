public class Village {
    String playerName;
    int health;
    int[][] location;

    Building buildings;
    Troops[] army;
    Resources store;

    Village(String name){
        playerName = name;

        store = new Resources();
        buildings = new Building();
    }


}
