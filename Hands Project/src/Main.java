/**
 * 
 * @author Hope Lepeshko
 * @version 09/29/2023
 *
 */
public class Main 
{
	// Main method
    public static void main(String[] args) 
    {
        HandEvaluator evaluator = new HandEvaluator();

        int numberOfTrials = 100000;
        // Evaluate for 5 card hand
        evaluator.runSimulation(numberOfTrials, 5);  
        // Evaluate for 7 card hand
        evaluator.runSimulation(numberOfTrials, 7);  
    }

}
