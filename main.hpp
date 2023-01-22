#include <string>
using namespace std;

class cell{
    public:
        string marker;
        bool visibility;
        bool mine;
        int mineNum = 0;
};

class gameManager{
    private:
        int numOfMines = 40;
        int counter = 0;
        cell grid[16][16];

        bool mineSetter();
        void numSetter(int row, int column);

    public:
        int size = 16;
    
        gameManager();    
        void displayGrid();
        void updateGrid(int row, int column);
        void winCheck();
};

class validation{
    public:
        int validator(int max);
};

