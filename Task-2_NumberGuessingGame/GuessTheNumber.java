import java.util.Scanner;
import java.util.Random;

/*
    javac GuessTheNumber.java
    java GuessTheNumber
 */
class Game{
    int userNumber;
    int compNumber;
    int guess = 0;

    public int CompNumber(){
        Random r = new Random();
        compNumber = r.nextInt(100) + 1;
        return compNumber;
    }

    public int UserNumber(){
            Scanner sc = new Scanner(System.in);
            userNumber = sc.nextInt();
        return userNumber;
    }

//    public void NoOfGuess(){
//        System.out.println("The total number of guesses: " +guess);
//    }

//    public boolean Guess(){
//        guess = 5;
//        return true;
//    }

    public boolean isCorrectNumber(){
        guess++;
            if (userNumber == compNumber) {
                System.out.println("Congratulations!! You have guessed the number correct...");
                System.out.format("Yes! %d is the correct number and you guessed it in %d attempts...",userNumber,guess);
                return true;
            } else if (userNumber > compNumber) {
                System.out.println("You have guessed number greater than the correct number...");
                return false;
            } else {
                System.out.println("You have guessed number smaller than the correct number...");
                return false;
            }
    }

}
public class GuessTheNumber {
    public static void main(String[] args) {

        //Generating input number from user
        System.out.println("Welcome to 'Guess The Number' Game!!");
        System.out.println("Enter a number between 1 and 100: ");
        Game guessNumber = new Game();

//        Scanner sc = new Scanner(System.in);
//        guessNumber.userNumber = sc.nextInt();
        //System.out.println(guessNumber.UserNumber());
            //guessNumber.UserNumber();

        //Generating random number from computer
//        Random r = new Random();
//        guessNumber.compNumber = r.nextInt(100) + 1;
//        System.out.println(guessNumber.compNumber);
        guessNumber.CompNumber();

        //Whether the guessed number is correct or not
        while(true){
            guessNumber.UserNumber();
            guessNumber.isCorrectNumber();
        }
    }
}

