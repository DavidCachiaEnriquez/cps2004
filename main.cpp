# include <iostream>
#include "main.hpp"

using namespace std;

gameManager::gameManager(){
}

bool gameManager::mineSetter(){
    return false;
}

void gameManager::numSetter(){
}

void gameManager::displayGrid(){
}

void gameManager::updateGrid(){
}

void gameManager::winCheck(){
}


int validation::validator(int max){
     int input;
    cout << "\nEnter number: ";
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
        int temp = validator.validator(GM.size-1);
    }while(true);
}


