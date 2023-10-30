import java.util.Random;
/**
 * MontyHallGame class simulates the monty hall game to test different player stratagies
 * @author Hope Lepeshko
 */

public class MontyHallGame {

    private static final int TRIALS = 100000;
    private static final int DOORS = 3;

    /**
     * Simulates a single round of the Monty Hall game.
     * 
     * @param switchDoors Specifies if the player switches doors after a dud is revealed.
     * @return true if the player wins the prize, false otherwise.
     */
    private static boolean playGame(boolean switchDoors) 
    {
        Random random = new Random();
        int prizeDoor = random.nextInt(DOORS);
        int chosenDoor = random.nextInt(DOORS);

        // Host opens a dud door
        int openedDoor;
        do 
        {
            openedDoor = random.nextInt(DOORS);
        } 
        while (openedDoor == chosenDoor || openedDoor == prizeDoor);

        // Switch doors if the strategy is to switch
        if (switchDoors) 
        {
            for (int i = 0; i < DOORS; i++) 
            {
                if (i != chosenDoor && i != openedDoor) 
                {
                    chosenDoor = i;
                    break;
                }
            }
        }

        return chosenDoor == prizeDoor;
    }
    
    /**
     * Main method to simulate the Monty Hall game multiple times for both strategies (stay or switch)
     * and print out the winning percentages.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) 
    {
        int stayWins = 0;
        int switchWins = 0;

        for (int i = 0; i < TRIALS; i++) 
        {
            if (playGame(false)) stayWins++;
            if (playGame(true)) switchWins++;
        }

        double stayPercentage = (double) stayWins / TRIALS * 100;
        double switchPercentage = (double) switchWins / TRIALS * 100;

        System.out.printf("Keeping original door strategy yields a win %.2f%%\n", stayPercentage, "of the time");
        System.out.printf("Switching door strategy yields a win %.2f%%\n", switchPercentage, "of the time");
    }
}
