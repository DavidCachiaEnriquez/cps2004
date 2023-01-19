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
            armiesCombat(players);

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
            
        }
    }


    void armiesCombat(ArrayList<Player> players){

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

