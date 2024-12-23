package phadungkit.naphat.lab6;

public class GuessGame {

    private int minRange;
    private int maxRange;
    private int maxTry;
    private int answer;
    private int attempts;

    public GuessGame() {
        this.minRange = 1;
        this.maxRange = 100;
        this.maxTry = 10;
        this.attempts = 0;
        this.answer = 0;
    }

    public GuessGame(int min, int max, int maxTry) {
        this.minRange = min;
        this.maxRange = max;
        this.maxTry = maxTry;
        this.answer = 0;
        this.attempts = 0;
    }

    public int getMin() {
        return minRange;
    }

    public void setMin(int minRange) {
        this.minRange = minRange;
    }

    public int getMax() {
        return maxRange;
    }

    public void setMax(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getMaxTries() {
        return maxTry;
    }

    public void setMaxTries(int maxTry) {
        this.maxTry = maxTry;
    }

    public int getAnswer() {
        answer = minRange + (int) (Math.random() * (maxRange - minRange + 1));
        return answer;
    }

    public boolean playSingleGame() {
        int attempts = 0;
        int guess;
        getAnswer();
        System.out.println("Welcome to a number guessing game!");
        do {
            System.out.print("Enter an integer between " + minRange + " and " + maxRange + ": ");
            guess = NumberGuessingOOPGame.getData.nextInt();
            attempts++;
            if (guess < minRange || guess > maxRange) {
                System.out.println("The number must be between " + minRange + " and " + maxRange);
                attempts--;
            } else if (guess == answer) {
                if (attempts == 1) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempt.");
                    return true;
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attemps.");
                    return true;
                }
            } else if (guess < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        } while (attempts < maxTry);
        System.out.println("Sorry, you've used all attempts. The correct answer was: " + answer);
        return false;

    }

}
