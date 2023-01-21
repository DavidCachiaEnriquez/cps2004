import java.util.Scanner;
public class Validation {
    Scanner sc = new Scanner(System.in);

    int rangedInput(int min, int max){
        int input = 0;
        while(input < min || input > max){
            input = sc.nextInt();
            System.out.print(input < min || input > max ? "Invalid input, try again: ":"");
        }
        return input;
    }


    // GameManager.java
    int playerNumberInput(){
        int input = 0;
        while(input <= 0){
            input = sc.nextInt();
            System.out.print(input <= 0 ? "Invalid input, try again: ":"");
        }
        return input;
    }


    // Player.java
    String villageMarkerInput(){
        String input = "";
        while(input.length() != 1){
            input = sc.next();
            System.out.print(input.length() != 1 ? "Invalid input, try again: ":"");
        }
        return input;
    }
}
