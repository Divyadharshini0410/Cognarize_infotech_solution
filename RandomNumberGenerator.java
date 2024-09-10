import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator {

    public static void main(String[] args) {

        int randomNumber = RandomNumberGenerator();
        RandomNumberChecker(randomNumber);
    }

    public static int RandomNumberGenerator() {
        int generatedNumber = (int) (Math.random() * 10 + 1);
        return generatedNumber;
    }

    public static void RandomNumberChecker(int generatedNumber) {

        int attempts = 0;
        int maximumAttempts = 5;
        Scanner scan = new Scanner(System.in);

        while (attempts < maximumAttempts) {
            System.out.println("Enter the number" + attempts + " attmept");
            int userInput = scan.nextInt();
            attempts++;

            if (userInput == generatedNumber) {
                System.out.println("Congrats you did it ");
                break;
            } else if (userInput < generatedNumber) {
                System.out.println("Your guess is too low,Enter the highest number");
            } else {
                System.out.println("Your guess is to high.Enter the lowest number");
            }

            if (attempts == maximumAttempts) {
                System.out.println("You reaches the maximum attempt");
                System.out.println("The Random number is: " + generatedNumber);
            }

        }
    }
}
