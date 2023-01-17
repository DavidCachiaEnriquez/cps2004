import java.lang.Math;

public class Village {
    String playerName;
    int health;
    int[] location;

    Building buildings;
    Troops[] army;
    Resources store;

    Village(String name, Map map){
        playerName = name;
        health = 10;

        int[] coord = locationSetter(map.rows);
        location = coord;
        map.addVillage(coord);

        store = new Resources();
        buildings = new Building();
    }

    int[] locationSetter(int size){

        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        int[] coord = {x, y};
        return(coord);
    }

}
