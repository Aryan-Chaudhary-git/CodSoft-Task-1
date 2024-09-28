import java.util.Scanner;
import java.util.Random;

public class GuessTheNumbersGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 3;         
        int maxAttempts = 5;      
        int score = 0;            
        int lowerBound = 1, upperBound = 100;  
        
        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nRound " + round + " of " + rounds + ":");
            boolean roundWon = false;
            
            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Enter your guess (" + lowerBound + " to " + upperBound + "): ");
                int guess = scanner.nextInt();
                
                if (guess < targetNumber) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Correct! You've guessed the number " + targetNumber + "!");
                    score++;
                    roundWon = true;
                    break;
                }
            }
            
            if (!roundWon) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + targetNumber + ".");
            }
        }
        
        System.out.println("\nGame over! You won " + score + " out of " + rounds + " rounds.");
        
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            main(null);  // Start the game again
        } else {
            System.out.println("Thanks for playing!");
        }
        
        scanner.close();
    }
}
