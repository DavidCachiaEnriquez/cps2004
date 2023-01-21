import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    int mapSize = 10;
    Map map = new Map(mapSize);

    ArrayList<Player> players = new ArrayList<Player>();

    int turnCounter = 1;

    Scanner sc = new Scanner(System.in);

    // Constructor
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

            armiesActions(players);

            deathCheck(players);
            winFlag = winCheck(players);

            System.out.print("Turn " + turnCounter);
            turnCounter++;
            System.out.print("\nC to go to next turn: ");
            sc.next();
        }

    }

    // Function to add new player
    void playerAdder(Map map, ArrayList<Player> players){
        Player playerTemp = new Player(map, players);
        players.add(playerTemp);
    }

    // Function to control turn actions
    void turnController(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            players.get(i).demoMenuV2();
        }       
    }

    // Functions to manage armies actions
    void armiesActions(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            ArrayList<Army> armies = players.get(i).homeVillage.armies;

            for(int j = 0; j < armies.size(); j++){
                Army currArmy = armies.get(j);
                currArmy.armyMarch(players);
            }
        }
    }

    // Function to check for any defeated villages
    void deathCheck(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).homeVillage.health <= 0){
                players.remove(i);
            }
        }
    }

    // Function to check for win condition
    boolean winCheck(ArrayList<Player> players){
        if(players.size() == 1){
            System.out.println("Congrats " + players.get(0).playerName + "!");
            return(false);
        }
        return true;
    }
}

