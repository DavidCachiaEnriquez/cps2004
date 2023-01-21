import java.util.Scanner;
public class Validation {
    Scanner sc = new Scanner(System.in);

    String villageMarkerInput(){
        String input = "";
        while(input.length() != 1){
            System.out.print("Invalid marker, try again: ");
            input = sc.next();
        }
        return input;
    }
}
