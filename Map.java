import java.util.Scanner;

public class Map {
    int rows;
    int columns;
    String[][] grid;

    Scanner sc = new Scanner(System.in);

    Map(int size){
        rows = size;
        columns = size;
        grid = new String[rows][columns];

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                grid[i][j] = "=";
            }
        }
    }

    void drawMap(){
        System.out.println("     - - - Board Map - - - ");
        System.out.print("@  ");
        for(int k = 0; k < rows; k++){
            System.out.print(k + "  ");
        }

        System.out.print("\n");
        for (int i = 0; i < rows; i++){
            System.out.print(i + "  ");
            for(int j = 0; j < columns; j++){
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("\nC to continue: ");
        sc.next();
    }

    void addVillage(int[] coord, String maker){
        grid[coord[0]][coord[1]] = maker;
    }
}
