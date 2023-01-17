public class Troops {
    int cost;
    int health;
    int power;
    int cc;
    int speed;

    void trainSoldier(){
        health = 5;
        power = 5;
        cc = 3;
        speed = 5;
    }

    void trainCavalry(){
        health = 5;
        power = 3;
        cc = 5;
        speed = 10;
    }

    void trainGiant(){
        health = 10;
        power = 7;
        cc = 10;
        speed = 3;
    }

}
