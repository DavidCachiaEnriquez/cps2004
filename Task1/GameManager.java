import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    private int mapSize = 10;
    private Map map = new Map(mapSize);

    private ArrayList<Player> players = new ArrayList<Player>();

    private int turnCounter = 1;

    private Scanner sc = new Scanner(System.in);
    private Validation validator = new Validation();

    // Constructor
    GameManager(){
        System.out.print("Enter number of players: ");
        int playerNum = validator.playerNumberInput();
        System.out.println();

        
        for(int i = 0; i < playerNum; i++){
            players.add(new Player(map, players));
        }

        boolean winFlag = true;
        while(winFlag != false){
            turnController(players);

            armiesActions(players);

            deathCheck(players);
            winFlag = winCheck(players);

            if(winFlag != false){
                System.out.print("Turn " + turnCounter);
                turnCounter++;
                System.out.print("\nC to go to next turn: ");
                sc.next();
            }
        }

    }

    // Function to control turn actions
    private void turnController(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            players.get(i).demoMenuV2();
        }       
    }

    // Functions to manage armies actions
    private void armiesActions(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            ArrayList<Army> armies = players.get(i).homeVillage.armies;

            for(int j = 0; j < armies.size(); j++){
                Army currArmy = armies.get(j);
                currArmy.armyMarch(players);
                currArmy.armyCleaner(armies, j);
            }
        }
    }

    // Function to check for any defeated villages
    private void deathCheck(ArrayList<Player> players){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).homeVillage.health <= 0){
                map.removeVillageFromMap(players.get(i).villageMarker);
                players.remove(i);
            }
        }
    }

    // Function to check for win condition
    private boolean winCheck(ArrayList<Player> players){
        if(players.size() == 1){
            System.out.println("Congrats " + players.get(0).playerName + "!");
            return(false);
        }
        return true;
    }
}

