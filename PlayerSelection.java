// For Task 10 we are to create one full program that takes a player’s details, applies all the checks and decisions from the earlier tasks 1-9, and prints a complete Player Report with a fall-through demo.
import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {

        String name;
        int age;
        double height;
        double weight;
        int jerseyNumber;
        final double POUND = 0.45359237;
        final int METER = 100;

        Scanner sc = new Scanner(System.in);

        // Getting Player's details
        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter age: ");
        age = sc.nextInt();

        System.out.print("Enter height (in meters): ");
        height = sc.nextDouble();

        System.out.print("Enter weight (in lbs): ");
        weight = sc.nextDouble();

        System.out.print("Enter jersey number: ");
        jerseyNumber = sc.nextInt();

        // Convert height and weight
        double heightInCm = height * METER;
        double weightInKg = weight * POUND;
        int roundedWeightKg = (int) weightInKg;

        // Eligibility Check (using boolean "yes" or "no")
        boolean eligible = (age >= 18 && age <= 35 && roundedWeightKg < 90);

        // Category of Player
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        // Using switch case for Player's position
        String position;
        switch (jerseyNumber){
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Player position not known";
        }

        // Checking Attacker's jersey number
        String attacker = (jerseyNumber == 9 || jerseyNumber == 10 || jerseyNumber == 11) ? "Yes" : "No";

        // Lineup Decision
        String lineupDecision;
        if (age < 20) {
            lineupDecision = "Bench";
        } else if (age <= 30) {
            lineupDecision = (roundedWeightKg < 80) ? "Starting Lineup" : "Bench";
        } else {
            lineupDecision = "Bench";
        }

        // Final Decision of Player
        String finalDecision = eligible ? "Play" : "Rest";

        // Full report of Player
        System.out.println("\n PLAYER REPORT  ");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightInCm + " cm");
        System.out.println("Weight: " + roundedWeightKg + " kg");
        System.out.println("Jersey: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker jersey: " + attacker);
        System.out.println("Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        // Fall through demo example
        System.out.println("\n  UNWANTED FALL-THROUGH DEMO ");
        int demoJersey = 2;
        switch (demoJersey) {
            case 2:
                System.out.println("Defender");
            case 5:
                System.out.println("Defender");
                break;
            default:
                System.out.println("Exiting");
        }

        sc.close();
    }
}
