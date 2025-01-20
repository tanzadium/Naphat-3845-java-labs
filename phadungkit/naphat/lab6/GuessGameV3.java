package phadungkit.naphat.lab6;

/*
 * This class extends GuessGameV2 to create the most advanced version of the number guessing game.
 * It adds game history tracking, detailed logging of each game session, and the ability to 
 * review past game performance.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 January 2025
 */
public class GuessGameV3 extends GuessGameV2 {

    private static final int MAX_GAMES = 100;  // Maximum number of games that can be stored
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];  // Array to store game history
    private static int recordIndex = 0;  
    private int[] guesses;     // Array to store all guesses made in current game
    private int guessCount;   
    private boolean win;       

    public GuessGameV3() {
        super();  // Call GuessGameV2's default constructor
        guessCount = 0;
        win = false;
        guesses = new int[getMaxTries()];  // Initialize guess history array
    }

    // Parameterized constructor for custom game configuration
    public GuessGameV3(int min, int max, int maxTry) {
        super(min, max, maxTry);  // Initialize base class with parameters
        guessCount = 0;
        win = false;
        guesses = new int[maxTry];  // Size guess array based on max tries
    }

    // Configures or reconfigures the game with new parameters
    // Resets game state while keeping history intact
    @Override
    public void configureGame(int min, int max, int maxTry) {
        super.configureGame(min, max, maxTry);  // Configure base class
        guessCount = 0;  // Reset guess counter
        win = false;     // Reset win status
        guesses = new int[maxTry];  // Create new guess array with new size
    }

    // Implements the main game logic with enhanced record keeping
    // Tracks each guess and maintains game history
    @Override
    public boolean playSingleGame() {
        generateAnswer();
        int guess;
        guessCount = 0;  // Reset guess counter
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");

        do {
            // Get player's guess
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            guess = getData.nextInt();

            // Validate input range
            if (guess < getMin() || guess > getMax()) {
                System.out.println("Invalid input: guess must be between " + getMin() + " and " + getMax());
                continue;  // Skip invalid guesses
            }

            // Record the valid guess in history
            guesses[guessCount] = guess;
            guessCount++;

            // Check guess against answer and provide feedback
            if (guess == getAnswer()) {
                win = true;
                System.out.println("Congratulations! You've guessed the number in " + guessCount + " attempts.");
                break;
            } else if (guess < getAnswer()) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }

        } while (guessCount < getMaxTries());

        // Handle game end condition
        if (!win) {
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
        }

        addGameRecord(this);  // Save the game record
        return win;
    }
    /*
     * Creates a detailed log of the current game session's details
     * This method constructs two strings:
     */ 
    public String getGameLog() {
        // Create main game information string with configuration and results
        String gameInfo = "Range: [" + getMin() + "-" + getMax() + "], Max Tries: " + getMaxTries() + ", Attempts: " + guessCount + ", Result: " + (win ? "Win" : "Lose") + ", Guesses: ";

        // Create string of all guesses with comma separation
        String guessInfo = "";
        for (int i = 0; i < guessCount; i++) {
            guessInfo += guesses[i];
            if (i < guessCount - 1) {
                guessInfo += ", ";  // Add comma between guesses, but not after last guess
            }
        }

        // Combine both strings and add closing bracket
        return gameInfo + guessInfo;
    }

    /*
     * Static method to add a game record to the history
     * Creates a deep copy of the game state for history
     */
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex < MAX_GAMES) {
            // Create new record with game configuration
            GuessGameV3 record = new GuessGameV3(game.getMin(), game.getMax(), game.getMaxTries());

            // Copy game state
            record.win = game.win;
            record.guessCount = game.guessCount;
            record.guesses = game.guesses.clone();  // Create deep copy of guesses
            record.setAnswer(game.getAnswer());

            // Add to history
            gameRecords[recordIndex++] = record;
        } else {
            System.out.println("Warning: Game record limit reached. This game will not be recorded.");
        }
    }

    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    public static int getRecordCount() {
        return recordIndex;
    }
}
