import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    int mapSize = 10;
    Map map = new Map(mapSize);

    ArrayList<Player> players = new ArrayList<Player>();

    Scanner sc = new Scanner(System.in);

    GameManager(){
        Player player1 = new Player(map);
        players.add(player1);
        
        System.out.print("\033[H\033[2J");  
        demoMenu(player1);
    }

    void demoMenu(Player player){
        int menu = 0;
        while(menu != 4){
            System.out.println("General Actions");
            System.out.println(" 1. Village Details");
            System.out.println(" 2. Display Map");
            System.out.println(" 3. New Turn");
            System.out.println(" 4. Exit");


            System.out.println("\nBuilding Actions");
            System.out.println(" 5. Buildings Details");
            System.out.println(" 6. Build Building");
            System.out.println(" 7. Upgrade Building");

            System.out.println("\nTroop Actions");
            System.out.println(" 8. Troop Details");
            System.out.println(" 9. Train Troops");

            System.out.println("\nArmy Actions");
            System.out.println(" 10. Display Army");
            System.out.println(" 11. Create Army");


            System.out.print("\nEnter menu option: ");
            menu = sc.nextInt();
            System.out.print("\033[H\033[2J");  

            switch(menu){
                case 1:
                player.printDetails();

                System.out.println("\nC to continue");
                sc.next();
                break;

                case 2:
                map.drawMap();

                System.out.println("\nC to continue");
                sc.next();
                break;
                
                case 3:
                player.pass();
                break;

                case 5: 
                System.out.println("\nBuilding Details");
                player.displayBuildings();

                System.out.println("\nC to continue");
                sc.next();
                break;
                
                case 6:
                System.out.print("\nBuild Building");
                player.buildBuilding();

                System.out.println("\nC to continue");
                sc.next();
                break;
                
                case 7:
                System.out.println("Upgrade Building");
                player.upgradeBuilding();

                System.out.println("\nC to continue");
                sc.next();
                break;

                case 8:
                System.out.println("\nDisplay Troops");
                player.displayTroops();

                System.out.println("\nC to continue");
                sc.next();
                break;
                
                case 9:
                System.out.println("\nTrain Troops");
                player.trainTroop();

                System.out.println("\nC to continue");
                sc.next();
                break;

                case 10:
                System.out.println("\nDisplay Army");
                player.displayArmy();

                System.out.println("\nC to continue");
                sc.next();
                break;

                case 11:
                System.out.println("\nCreate Army");
                player.createArmy();
                
                System.out.println("\nC to continue");
                sc.next();
                break;
            }
            System.out.print("\033[H\033[2J");  
        }

    }
}

