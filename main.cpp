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
                        grid[i][j].mine = "XX";
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
    int randNum = rand() % 2;
    if(randNum>0) return true; 
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
}

void gameManager::updateGrid(){
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
    gameManager GM;
    validation validator;
    do{
        cout << "Row number: ";
        int row = validator.validator(GM.size-1);

        cout << "\nColumn number: ";
        int column = validator.validator(GM.size-1);

        cout << "\n\n";
    }while(true);
}


