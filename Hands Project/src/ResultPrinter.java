/**
 * 
 * @author Hope Lepeshko
 * @version 09/29/2023
 *
 */
public class ResultPrinter 
{
	public static void printProbabilities(int numberOfTrials, int pairCount, int threeOfKindCount, int fourOfKindCount,
            int straightCount, int flushCount, int fullHouseCount, int straightFlushCount, 
            int royalFlushCount) 
	{
		// Print probability of each hand to console
		System.out.println("Based on " + String.format("%,d", numberOfTrials) + " trials:");
		System.out.printf("The Probability of a Pair: %.2f%%\n", 100.0 * pairCount / numberOfTrials);
		System.out.printf("The Probability of a Three of a Kind: %.2f%%\n", 100.0 * threeOfKindCount / numberOfTrials);
		System.out.printf("The Probability of a Four of a Kind: %.2f%%\n", 100.0 * fourOfKindCount / numberOfTrials);
		System.out.printf("The Probability of a Straight: %.2f%%\n", 100.0 * straightCount / numberOfTrials);
		System.out.printf("The Probability of a Flush: %.2f%%\n", 100.0 * flushCount / numberOfTrials);
		System.out.printf("The Probability of a Full House: %.2f%%\n", 100.0 * fullHouseCount / numberOfTrials);
		System.out.printf("The Probability of a Straight Flush: %.2f%%\n", 100.0 * straightFlushCount / numberOfTrials);
		System.out.printf("The Probability of a Royal Flush: %.2f%%\n", 100.0 * royalFlushCount / numberOfTrials);
	}
}
