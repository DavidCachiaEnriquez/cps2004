import java.util.ArrayList;

public class Army {
    ArrayList<Troops> armyMembers = new ArrayList<Troops>();

    int attackPower = 0;
    int armyHealth = 0;

    int marchSpeed = 100;
    double marchDistance = 0;

    int resourceCC = 0;
    int resourceStore[] = {0, 0, 0}; 

    int[] currentLocation;
    int[] targetLocation;
}
