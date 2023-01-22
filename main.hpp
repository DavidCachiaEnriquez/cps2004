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
    public:
        int size = 16;
        int numOfMines = 40;
        int counter = 0;
        cell grid[16][16];

        gameManager();
        bool mineSetter();
        void numSetter(int row, int column);
        void displayGrid();
        void updateGrid();
        void winCheck();
};

class validation{
    public:
        int validator(int max);
};

