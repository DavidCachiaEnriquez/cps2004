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

    // Constructor
    Army(ArrayList<Troops> homeTroops, double dist, int[] homeLoc, int[] targetLoc, boolean defending){
        if(defending == false){
            System.out.println("\nCreating army!");
            if(homeTroops.size() != 0){
                typesOfTroops(homeTroops);
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

    // Function to go through different troops types
    void typesOfTroops(ArrayList<Troops> homeTroops){
        String name = "Soldier";
        numOfTroops(homeTroops, name);
        
        name = "Cavalier";
        numOfTroops(homeTroops, name);
        
        name = "Giant";
        numOfTroops(homeTroops, name);
    }

    // Function to take number of troop to add
    void numOfTroops(ArrayList<Troops> homeTroops, String name){
        int num = troopPoolSize(homeTroops, name);
        if(num != 0){
            System.out.print("Number of " + name + "s (" + num + "): ");
            int numS = sc.nextInt();
            addTroop(homeTroops, numS, name);
        }
    }

    // Function to get number of troop in village pool
    int troopPoolSize(ArrayList<Troops> homeTroops, String name){
        int num = 0;
        for(int i = 0; i < homeTroops.size(); i++){
            if(homeTroops.get(i).name == name){
                num++;
            }
        }
        return num;
    }

    // Function to transfer troop from pool to army
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

    // Function to create army stats
    void addStats(){
        if(attackPower != 0){
            attackPower = 0; armyHealth = 0;
            resourceCC = 0; marchSpeed = 0;
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


    // Function to make army march
    void armyMarch(ArrayList<Player> players){
        if(marchSpeed > marchDistance){
            armiesCombat(players);
        }else{
            marchDistance -= marchSpeed;
        }
    }

    // Function to control army combat
    void armiesCombat(ArrayList<Player> players){
        Village defendingVillage = villageGetter(targetLocation, players);

        if(defendingVillage.homeTroops.size() > 0){
            Army defenceArmy = defendingVillage.defendingArmy();

            boolean winCheck = combatResult(defenceArmy);
            if(winCheck == true){
                defendingVillage.depositArmyMembers(defenceArmy);
            }else{
                defendingVillage.health -= attackPower;
                stealResources(defendingVillage);
            }

        }else{
            defendingVillage.health -= attackPower;
            stealResources(defendingVillage);
        }
        System.out.println();
    }

    // Function to get defending village
    Village villageGetter(int[] coord, ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            Village tempVillage = players.get(i).homeVillage;
            if(tempVillage.location == coord){
                return tempVillage;
            }
        }
        return null;
    }

    // Function to give result of combat
    boolean combatResult(Army defendingArmy){
        int damageCounterA = attackPower;
        int damageCounterB = defendingArmy.attackPower;

        defendingArmy.armyCombat(damageCounterA);
        defendingArmy.addStats();

        armyCombat(damageCounterB);
        addStats();

        return(armyMembers.size() == 0 ? true: false);
    }

    // Function to take damage from combat
    void armyCombat(int damage){
        while(damage > 0){
            if(armyMembers.size() > 0){
                if(armyMembers.get(0).health <= damage){
                    damage -= armyMembers.get(0).health;
                    armyMembers.remove(0);
                }else{
                    armyMembers.get(0).health -= damage;
                    damage -= damage;
                }
            }else{
                break;
            }
        }
    }

    // Function to steal resources
    void stealResources(Village village){
        for(int i = 0; i < resourceCC; i++){
            
            ArrayList<Integer> validResources = new ArrayList<Integer>();

            if(village.store.wood > 0){
                validResources.add(0);
            }
            if(village.store.rations > 0){
                validResources.add(1);
            }
            if(village.store.gold > 0){
                validResources.add(2);
            }
            
            if(validResources.size() > 0){
                int randomNum = validResources.get((int)(Math.random() * validResources.size()));
                
                if(randomNum == 0){
                    resourceStore[randomNum]++;
                    village.store.wood--;
                }else if(randomNum == 1){
                    resourceStore[randomNum]++;
                    village.store.rations--;
                }else{
                    resourceStore[randomNum]++;
                    village.store.gold--;
                }
            }else{
                System.out.println("No resources left");
                break;
            }
        }
    }
}
