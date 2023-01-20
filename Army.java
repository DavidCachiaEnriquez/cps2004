import java.util.ArrayList;
import java.util.Scanner;

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

    Scanner sc = new Scanner(System.in);

    Army(ArrayList<Troops> homeTroops, double dist, int[] homeLoc, int[] targetLoc, boolean defending){
        if(defending == false){
            System.out.println("\nCreating army!");
            if(homeTroops.size() != 0){
                addTroops(homeTroops);
                addStats();
                marchDistance = dist;
                currentLocation = homeLoc;
                targetLocation = targetLoc;
            }else{
                System.out.println("No troops trained yet...");
            }
        }else{
            for(int i = 0; i < homeTroops.size(); i++){
                armyMembers.add(homeTroops.get(i));
            }
            addStats();
            marchDistance = dist;
            currentLocation = homeLoc;
            targetLocation = targetLoc;
        }
    }

    void addTroops(ArrayList<Troops> homeTroops){
        String name = "Soldier";
        troopType(homeTroops, name);
        
        name = "Cavalier";
        troopType(homeTroops, name);
        
        name = "Giant";
        troopType(homeTroops, name);
    }

    void troopType(ArrayList<Troops> homeTroops, String name){
        int num = numOfTroops(homeTroops, name);
        if(num != 0){
            System.out.print("Number of " + name + "s (" + num + "): ");
            int numS = sc.nextInt();
            addTroop(homeTroops, numS, name);
        }
    }

    int numOfTroops(ArrayList<Troops> homeTroops, String name){
        int num = 0;
        for(int i = 0; i < homeTroops.size(); i++){
            if(homeTroops.get(i).name == name){
                num++;
            }
        }
        return num;
    }

    void addTroop(ArrayList<Troops> homeTroops, int num, String name){
        for(int i = 0; i < homeTroops.size(); i++){
            Troops troop = homeTroops.get(i);
            while(num != 0){
                if(troop.name == name){
                    armyMembers.add(troop);
                    homeTroops.remove(i);
                    num--;
                }
            }
        }
    }


    void addStats(){
        // attackPower = 0; armyHealth = 0; resourceCC = 0; marchSpeed = 0;

        if(attackPower != 0){
            attackPower = 0;
            armyHealth = 0;
            resourceCC = 0;
            marchSpeed = 0;
        }

        for(int i = 0; i < armyMembers.size(); i++){
            
            attackPower += armyMembers.get(i).power;
            armyHealth += armyMembers.get(i).health;
            resourceCC += armyMembers.get(i).cc;
            
            if(armyMembers.get(i).speed < marchSpeed){
                marchSpeed = armyMembers.get(i).speed;
            }
        }
    }
}
