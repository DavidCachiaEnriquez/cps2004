import java.util.Scanner;
public class Validation {
    private Scanner sc = new Scanner(System.in);

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

    // Function for general input validation
    int rangedInput(int min, int max){
        int input = 0;
        while(input < min || input > max){
            input = sc.nextInt();
            System.out.print(input < min || input > max ? "Invalid input, try again: ":"");
        }
        return input;
    }
}
