import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    int mapSize = 10;
    Map map = new Map(mapSize);

    ArrayList<Player> players = new ArrayList<Player>();

    int turnCounter = 1;

    Scanner sc = new Scanner(System.in);

    GameManager(){
        System.out.print("Enter number of players: ");
        int playerNum = sc.nextInt();
        System.out.println();

        
        for(int i = 0; i < playerNum; i++){
            playerAdder(map, players);
        }

        boolean winFlag = true;
        while(winFlag != false){
            turnController(players);

            armiesMarch(players);

            deathCheck(players);
            winFlag = winCheck(players);

            System.out.print("Turn " + turnCounter);
            turnCounter++;
            System.out.print("\nC to go to next turn: ");
            sc.next();
        }

    }

    void playerAdder(Map map, ArrayList<Player> players){
        Player playerTemp = new Player(map, players);
        players.add(playerTemp);
    }



    void turnController(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            players.get(i).demoMenuV2();
        }       
    }



    void armiesMarch(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            ArrayList<Army> armies = players.get(i).homeVillage.armies;

            for(int j = 0; j < armies.size(); j++){
                Army currArmy = armies.get(j);
                if(currArmy.marchSpeed > currArmy.marchDistance){
                    armiesCombat(currArmy);
                }else{
                    currArmy.marchDistance -= currArmy.marchSpeed;
                }
            }
        }
    }


    void armiesCombat(Army attackers){
        Village defendingVillage = villageGetter(attackers.targetLocation);

        if(defendingVillage.homeTroops.size() > 0){
            Army defenceArmy = defendingArmy(defendingVillage);

            combatResult(attackers, defenceArmy);
        }else{
            System.out.println("No defenders");
        }
        System.out.println();
    }

    Village villageGetter(int[] coord){
        for(int i = 0; i < players.size(); i++){
            Village tempVillage = players.get(i).homeVillage;
            if(tempVillage.location == coord){
                return tempVillage;
            }
        }
        return null;
    }

    Army defendingArmy(Village village){
        Army tempArmy = new Army(village.homeTroops, 0, village.location, village.location, true);
        for(int i = 0; i <= village.homeTroops.size()+1; i++){
            village.homeTroops.remove(0);
        }
        System.out.println(village.homeTroops.size());
        return tempArmy;
    }

    void combatResult(Army attackingArmy, Army defendingArmy){
        int damageCounterA = attackingArmy.attackPower;
        int damageCounterB = defendingArmy.attackPower;

        while(damageCounterA > 0){
            if(defendingArmy.armyMembers.size() > 0){
                if(defendingArmy.armyMembers.get(0).health <= damageCounterA){
                    damageCounterA -= defendingArmy.armyMembers.get(0).health;
                    defendingArmy.armyMembers.remove(0);
                }else{
                    defendingArmy.armyMembers.get(0).health -= damageCounterA;
                    damageCounterA -= damageCounterA;
                }
            }else{
                break;
            }
        }
        defendingArmy.addStats();

        while(damageCounterB != 0){
            if(attackingArmy.armyMembers.size() > 0){
                if(attackingArmy.armyMembers.get(0).health <= damageCounterB){
                    damageCounterB -= attackingArmy.armyMembers.get(0).health;
                    attackingArmy.armyMembers.remove(0);
                }else{
                    attackingArmy.armyMembers.get(0).health -= damageCounterB;
                    damageCounterB -= damageCounterB;
                }
            }else{
                break;
            }
        }
        attackingArmy.addStats();

        if(defendingArmy.armyMembers.size() == 0 && attackingArmy.armyMembers.size() != 0){
            System.out.println("\nAttackers Win");
        }else{
            System.out.println("\nDefenders Win");

        }
    }


    void deathCheck(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).homeVillage.health <= 0){
                players.remove(i);
            }
        }
    }



    boolean winCheck(ArrayList<Player> players){
        if(players.size() == 1){
            System.out.println("Congrats " + players.get(0).playerName + "!");
            return(false);
        }
        return true;
    }
}

