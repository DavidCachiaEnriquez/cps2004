import java.util.Scanner;

public class Player {
    // - - - Attributes - - - //
    String playerName;
    Village homeVillage;
    // - - - Attributes - - - //

    Scanner sc = new Scanner(System.in);

    Player(Map map){
        System.out.print("Enter player name: ");
        playerName = sc.next();

        homeVillage = new Village(playerName, map);
    }

    void trainTroop(){
    }

    void buildBuilding(){
        System.out.println("\nTypes of buildings: ");
        System.out.println("1. Troop Training");
        System.out.println("2. Resource Gathering");
        int choice = sc.nextInt();
        if(homeVillage.store.wood > 0){
            if(choice == 1){

                System.out.println("\nChoose type:");
                System.out.println("1. Barracks (Soldier)");
                System.out.println("2. Stables (Cavlier)");
                System.out.println("3. Gym (Giant)");
                
                int type = sc.nextInt();
                TrainingBuilding newBuild = new TrainingBuilding(type);
                homeVillage.store.wood-=1;
                homeVillage.trainingBuildings.add(newBuild);
            }else if(choice == 2){

                System.out.println("\nChoose type:");
                System.out.println("1. Lumberyad (Wood)");
                System.out.println("2. Mess Hall (Rations)");
                System.out.println("3. Mines (Gold)");

                int type = sc.nextInt();
                ResourceBuilding newBuild = new ResourceBuilding(type);
                homeVillage.store.wood-=1;
                homeVillage.resourceBuildings.add(newBuild);
            }
        }else{
            System.out.println("\nNot enough wood");
        }
    }    

    void upgradeBuilding(){
    }

    void attackVillage(){
    }

    void surrenderVillage(){
    }

    void pass(){
    }
}
