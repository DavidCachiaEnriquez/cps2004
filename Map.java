public class Map {
    int rows;
    private int columns;
    String[][] grid;

    // Constructor
    Map(int size){
        rows = size;
        columns = size;
        grid = new String[rows][columns];

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                grid[i][j] = "-";
            }
        }
    }

    // Function to add village marker
    void addVillage(int[] coord, String maker){
        grid[coord[0]][coord[1]] = maker;
    }

    // Function to remove village marker 
    void removeVillageFromMap(String marker){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == marker){
                    grid[i][j] = "-";
                }
            }
        }
    }

    // Function to draw map
    void drawMap(){
        System.out.println("     - - - Board Map - - - ");
        System.out.print("/  ");
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
    }
}
