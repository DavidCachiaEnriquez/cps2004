import java.lang.Math;

public class Village {
    // - - - Attributes - - - //
    String ownerName;
    int health;

    int[] location;

    Resources store = new Resources();
    // - - - Attributes - - - //


    Village(String name, Map map){
        ownerName = name;
        health = 10;

        int[] coord = locationSetter(map.rows);
        location = coord;
        map.addVillage(coord);

        printDetails();
    }

    int[] locationSetter(int size){

        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        int[] coord = {x, y};
        return(coord);
    }

    void printDetails(){
        System.out.println("\nVillage Details");
        System.out.println("Village owner:\t" + ownerName);
        System.out.println("Village health:\t" + health);
        System.out.println("Location:\t(" + location[0] + ", " + location[1] + ")");

        System.out.println("----------");
        System.out.println("Resources");
        System.out.println("Bricks: \t" + store.bricks);
        System.out.println("Rations:\t" + store.rations);
        System.out.println("Gold:   \t" + store.gold);
    }

}
