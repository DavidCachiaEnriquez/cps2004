# include <iostream>
# include <cstdlib>

#include "main.hpp"

using namespace std;

gameManager::gameManager(){
    int currMines = 0;

    do{
        currMines = 0;
        for(int i = 0; i < size; i++){
            bool checker = false;
            for(int j = 0; j < size; j++){
                grid[i][j] = cell();
                grid[i][j].marker = "--";
                if(currMines < numOfMines){
                    checker = mineSetter();
                    if(checker == true){
                        grid[i][j].mine = true;
                        grid[i][j].marker = "XX";
                        currMines++;
                    }
                }
            }
        }
    }while(currMines < numOfMines);
    
    for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j].mine == true){
                    numSetter(i, j);
                }
            }
        }
}

bool gameManager::mineSetter(){
    int randNum = rand() % 11;
    if(randNum>9) return true; 
    else return false;
}

void gameManager::numSetter(int row, int column){
    if(row != 0 && grid[row-1][column].mine == false){ //Above
        grid[row-1][column].mineNum++;
    }

    if(row != (size-1) && grid[row+1][column].mine == false){ //Below
        grid[row+1][column].mineNum++;
    }

    if(column != 0 && grid[row][column-1].mine == false){ //Left
        grid[row][column-1].mineNum++;
    }

    if(column != (size-1) && grid[row][column+1].mine == false){ //Right
        grid[row][column+1].mineNum++;
    }

    if(row != 0 && column != 0 && grid[row-1][column-1].mine == false){ //Above, Left
        grid[row-1][column-1].mineNum++;
    }

    if(row != 0 && column != (size-1) && grid[row-1][column+1].mine == false){ //Above. Right
        grid[row-1][column+1].mineNum++;
    }

    if(row != (size-1) && column != 0 && grid[row+1][column-1].mine == false){ //Below, Left
        grid[row+1][column-1].mineNum++;
    }

    if(row != (size-1) && column != (size-1) && grid[row+1][column+1].mine == false){ //Below, Right
        grid[row+1][column+1].mineNum++;
    }
}

void gameManager::displayGrid(){
        
    cout << "\\\\ ";
    for(int i = 0; i < size; i++){
        if(i <= 9) cout << "0";
        cout << i; cout << " ";
    }
    cout << "\n";

    for(int i = 0;i<size;i++){
        if(i <= 9) cout << "0";
        cout << i; cout << " ";

        for(int j = 0;j<size;j++){
            cout << grid[i][j].marker;
            cout << " ";
        }
        cout << "\n";
    }

}

void gameManager::updateGrid(int row, int column){
    if(grid[row][column].mine == true){
        grid[row][column].marker = "XX";

        displayGrid();
        cout << "\nYou lose";
        exit(0);
    } 
    if(grid[row][column].mineNum != 0){
        grid[row][column].marker = ("0" + to_string(grid[row][column].mineNum));
        grid[row][column].visibility = true;
    }else{
        grid[row][column].marker = "0" + to_string(grid[row][column].mineNum); //Centre
        grid[row][column].visibility = true;

        if(row == 0 && column == 0){
            // Top Left    
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row+1][column+1].marker = "0" + to_string(grid[row+1][column+1].mineNum); //Down, Right
            grid[row+1][column+1].visibility = true;

        }else if(row == 0 && column == size-1){
            // Top Right 
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row+1][column-1].marker = "0" + to_string(grid[row+1][column-1].mineNum); //Down, Left
            grid[row+1][column-1].visibility = true;

        }else if(row == size-1 && column == 0){
            // Bot Left
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row-1][column+1].marker = "0" + to_string(grid[row-1][column+1].mineNum); //Up, Right
            grid[row-1][column+1].visibility = true;

        }else if(row == size-1 && column == size-1){
            // Bot Right
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row-1][column-1].marker = "0" + to_string(grid[row-1][column-1].mineNum); //Up, Left
            grid[row-1][column-1].visibility = true;

        }else if(row == 0){
            // Top
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row+1][column+1].marker = "0" + to_string(grid[row+1][column+1].mineNum); //Down, Right
            grid[row+1][column+1].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row+1][column-1].marker = "0" + to_string(grid[row+1][column-1].mineNum); //Down, Left
            grid[row+1][column-1].visibility = true;

        }else if(row == size-1){
            // Bot
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row-1][column+1].marker = "0" + to_string(grid[row-1][column+1].mineNum); //Up, Right
            grid[row-1][column+1].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row-1][column-1].marker = "0" + to_string(grid[row-1][column-1].mineNum); //Up, Left
            grid[row-1][column-1].visibility = true;

        }else if(column == 0){
            // Left
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row-1][column+1].marker = "0" + to_string(grid[row-1][column+1].mineNum); //Up, Right
            grid[row-1][column+1].visibility = true;
            grid[row+1][column+1].marker = "0" + to_string(grid[row+1][column+1].mineNum); //Down, Right
            grid[row+1][column+1].visibility = true;

        }else if(column == size-1){
            // Right
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row-1][column-1].marker = "0" + to_string(grid[row-1][column-1].mineNum); //Up, Left
            grid[row-1][column-1].visibility = true;
            grid[row+1][column-1].marker = "0" + to_string(grid[row+1][column-1].mineNum); //Down, Left
            grid[row+1][column-1].visibility = true;

        }else{ 
            // Centre
            grid[row-1][column].marker = "0" + to_string(grid[row-1][column].mineNum); //Up
            grid[row-1][column].visibility = true;
            grid[row+1][column].marker = "0" + to_string(grid[row+1][column].mineNum); //Down
            grid[row+1][column].visibility = true;
            grid[row][column+1].marker = "0" + to_string(grid[row][column+1].mineNum); //Right
            grid[row][column+1].visibility = true;
            grid[row-1][column+1].marker = "0" + to_string(grid[row-1][column+1].mineNum); //Up, Right
            grid[row-1][column+1].visibility = true;
            grid[row+1][column+1].marker = "0" + to_string(grid[row+1][column+1].mineNum); //Down, Right
            grid[row+1][column+1].visibility = true;
            grid[row][column-1].marker = "0" + to_string(grid[row][column-1].mineNum); //Left
            grid[row][column-1].visibility = true;
            grid[row-1][column-1].marker = "0" + to_string(grid[row+1][column-1].mineNum); //Up, Left
            grid[row-1][column-1].visibility = true;
            grid[row+1][column-1].marker = "0" + to_string(grid[row-1][column-1].mineNum); //Down, Left
            grid[row+1][column-1].visibility = true;
        }
    }
}

void gameManager::winCheck(){
    
}


int validation::validator(int max){
     int input;
    cin >> input;
    do{
        if(input <= max && input >= 0){
            return input;
        }else{
            cout << "Invalid input, try again: ";
            cin >> input;
        }
    }while(true);
}


int main(){
    gameManager mineSweeper;
    validation validator;
    do{
        mineSweeper.displayGrid();

        cout << "\nColumn number: ";
        int column = validator.validator(mineSweeper.size-1);

        cout << "Row number: ";
        int row = validator.validator(mineSweeper.size-1);

        mineSweeper.updateGrid(row, column);
        mineSweeper.winCheck();
        cout << "\n\n";
    }while(true);
}


