/**
 * 
 * @author Hope Lepeshko
 * @version 09/29/2023
 *
 */

// Import util.util package
import java.util.*;

// Declare class called HandEvaluator
public class HandEvaluator 
{

	// Declare private member variable called deck to represent a deck of cards
    private List<Card> deck;
	// Declare private member variable called hand to represent a players hand (the cards the player draws)  
    private List<Card> hand;

    // Inner class for Card representation
    private static class Card 
    {
        // Declare instance variable named value to represent the cards value (ex: Ace = 1, 2 = 2, Jack = 11)
    	int value;  
    	// Declare instance variable named suit to represent the cards suit
    	String suit;  // "Hearts", "Diamonds", "Clubs", "Spades"

        // Card constructor which initializes a new card with a value and a suit
    	Card(int value, String suit) 
        {
            this.value = value;
            this.suit = suit;
        }
    }

    // Deck constructor which initializes a new deck with an empty hand
    public HandEvaluator() 
    {
        deck = createDeck();
        hand = new ArrayList<>();
    }

    // Declares a private method to create a deck of cards
    private List<Card> createDeck() 
    {
        // Creates a new empty list. the list represent a deck of cards
    	List<Card> newDeck = new ArrayList<>();
        // Declare and initialize an Array of strings called 'suits'
    	String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        // For each loop goes through all the elements in the suits array
    	// Each iteration of the loop it assigns the current element to 'suit'
        for (String suit : suits) 
        {
            // For loop starting at 2
        	for (int i = 2; i <= 14; i++) 
            {
                // constructor called Card(i, suit) creates a new Card for each combination of i(being the card value) and suit
        		newDeck.add(new Card(i, suit));
            }
        }
        // Returns the newly created deck
        return newDeck;
    }

    
    // Declare drawHand method
    private void drawHand(int handSize) 
    {
        // Using java's collections class to shuffle the deck
    	Collections.shuffle(deck);
        // For loop initializes i and sets it equal to 0
    	// Loop continues as long as i is less than handSize
    	for (int i = 0; i < handSize; i++) 
        {
            // 'deck.size()' calling size method on the deck to get the current number of cards in the deck
    		// 'deck.size() - 1' because arrays start at 0
    		// 'deck.remove()' method called to remove a card from the deck
    		// 'deck.remove(deck.size() - 1)' removes a card from  at the last index
    		// The removed card is then added to the hand using 'hand.add'
    		hand.add(deck.remove(deck.size() - 1));
        }
    }

    // Method isPair used to check if the hand contains a pair
    private boolean isPair() 
    {
        // Call countOccurance method 
    	// .values().contains(2) checks if any card value occurs twice
    	return countOccurrences().values().contains(2);
    }

    // Method isThreeOfKind used to check if the hand contains three of a kind 
    private boolean isThreeOfKind() 
    {
        // Call countOccurance method 
    	// .values().contains(3) checks if any card value occurs three times	
    	return countOccurrences().values().contains(3);
    }

    // Method isFourOfKind used to check if the hand contains four of a kind 
    private boolean isFourOfKind() 
    {
        // Call countOccurance method 
    	// .values().contains(4) checks if any card value occurs four times
    	return countOccurrences().values().contains(4);
    }

    // Method isFlush used to check if the hand contains a flush
    // A flush being a hand that contains five cards all of the same suit, NOT of sequential rank
    private boolean isFlush() 
    {
        // Get the suit of the first card in the hand (at index 0) and assign it to 'suit'
    	String suit = hand.get(0).suit;
        // For each loop goes through each 'Card' in the 'hand' list
    	// Each iteration of the loop assigns the current card to 'card'
    	for (Card card : hand) 
        {
            // If statement goes through each card in the hand, and if it finds one card that has a different suit than the previous 
    		// It returns false because that would mean the hand does not contain a flush
    		if (!card.suit.equals(suit)) 
            {
                return false;
            }
        }
        return true;
    }

    // Method isStraight used to check if the hand contains a straight
    // A straight being a hand that contains five cards of sequential rank, NOT all of the same suit
    private boolean isStraight() 
    {
        // Create an empty list called 'values'
    	List<Integer> values = new ArrayList<>();
    	 // For each loop goes through each 'Card' in the 'hand' list
    	// Each iteration of the loop assigns the current card to 'card'
    	for (Card card : hand) 
        {
            // Add the numerical value of the card to the 'values' list
    		values.add(card.value);
        }
        // Used to sort the values from smallest to largest
    	Collections.sort(values);
        // For loop initializes int i and sets it equal to 1
    	// Loop runs while i is less than values.size
    	for (int i = 1; i < values.size(); i++) 
        {
            // If statement checks if the current number in the 'values' list is not exactly one more than the previous number.
    		// If it is not then we know the numbers are not sequential and therefore not a straight
    		if (values.get(i) != values.get(i - 1) + 1) 
            {
                return false;
            }
        }
        return true;
    }

    // Method isFullHouse used to check if the hand contains a full house
    // A full house being a hand that contains three of a kind AND a pair
    private boolean isFullHouse() 
    {
        // Declare a variable called 'occurrences' of the type Map<Integer, Integer>
    	// Assign the result of countOccurrences() to 'occurrences'
    	Map<Integer, Integer> occurrences = countOccurrences();
        // Determine if the hand is a full house and return the result
    	return occurrences.values().contains(2) && occurrences.values().contains(3);
    }

    // Method isStraightFlush used to check if the hand contains a Straight Flush
    // A Straight Flush being a hand that contains a straight AND a flush
    private boolean isStraightFlush() 
    {
        // check is the hand is a flush AND a straight then returns
    	return isFlush() && isStraight();
    }

    // Method isRoyalFlush used to check if the hand contains a Royal Flush
    // A Royal Flush being a hand that contains an Ace, King, Queen, Jack, and a 10
    // This is the BEST hand!
    private boolean isRoyalFlush() 
    {
        // Checks for a 10, jack, queen, king, and ace of the same suit and then returns
    	return isFlush() && hand.stream().anyMatch(card -> card.value == 14) && isStraight();
    }

    // Declares a private method called CountIccurances
    // Returns a Map<Integer, Integer>
    private Map<Integer, Integer> countOccurrences() 
    {
        // Initialize an empty hash map called valueCounts used to keep track of 
    	// the amount of times each card value appears in the hand
    	Map<Integer, Integer> valueCounts = new HashMap<>();
        // For each loop goes through each 'Card' in the 'hand' list
    	for (Card card : hand) 
        {
            // Update the count for the card's value in 'valueCounts' map
    		// value of current card updated to card.value
    		// valueCounts.getOrDefault(card.value, 0) checks the current count of the card value map. 
    		// If the value hasn't yet been added to the map then it will default to 0
    		// Increment the count by one
    		// valueCounts.put() updates the count for this card value in the map
    		valueCounts.put(card.value, valueCounts.getOrDefault(card.value, 0) + 1);
        }
        // Returns the valueCounts map
    	return valueCounts;
    }

    // Declare a public method called runSimulation
    // Method accepts two integer arguments. numberOfTrials and handSize
    public void runSimulation(int numberOfTrials, int handSize) 
    {
        int pairCount = 0, threeOfKindCount = 0, fourOfKindCount = 0, straightCount = 0, flushCount = 0,
            fullHouseCount = 0, straightFlushCount = 0, royalFlushCount = 0;

        // For loop initializes i and sets equal to zero
        // loop runs while i is less than numberOfTrials
        // Each run of the loop represents one trial
        for (int i = 0; i < numberOfTrials; i++) 
        {
            // calls the drawHand method and the hand size is equal to handSize
        	drawHand(handSize);

            // Increment count if specific hand is found
        	if (isPair()) pairCount++;
            if (isThreeOfKind()) threeOfKindCount++;
            if (isFourOfKind()) fourOfKindCount++;
            if (isStraight()) straightCount++;
            if (isFlush()) flushCount++;
            if (isFullHouse()) fullHouseCount++;
            if (isStraightFlush()) straightFlushCount++;
            if (isRoyalFlush()) royalFlushCount++;

            // Add all of the cards in the current hand back to deck
            deck.addAll(hand);
            // Clear the current hand
            hand.clear();
        }

        // Call the ResultPrinter to print out the probabilities
        ResultPrinter.printProbabilities(numberOfTrials, pairCount, threeOfKindCount, fourOfKindCount,
                                         straightCount, flushCount, fullHouseCount, straightFlushCount, 
                                         royalFlushCount);
    }

    // Declare main method
    public static void main(String[] args) 
    {
        // Create a new object of the HndEvaluator class and assign it to evaluator
    	HandEvaluator evaluator = new HandEvaluator();
        // Initialize the instance variable called numberOfTrials to 100,000 because Byron said to run 100,000 simulations or more
    	int numberOfTrials = 100000;
        // Call the runSimulation method on the 'evaluator' object for 5 card hands
    	evaluator.runSimulation(numberOfTrials, 5);  
    }
    
    // reference https://stackoverflow.com/questions/10363927/the-simplest-algorithm-for-poker-hand-evaluation
    // reference finding a straight: https://codereview.stackexchange.com/questions/36915/poker-hand-evaluation-finding-a-straight
    // Checked with chat GPT
    
}
