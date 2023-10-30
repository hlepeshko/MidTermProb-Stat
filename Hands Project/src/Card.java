/**
 * 
 * @author Hope Lepeshko
 * @version 09/29/2023
 */

// Defining enum type called Suit
// Because I'm using the special data type enum to represent a group of constants
// the constants are all written in capital letters
enum Suit
{
	// Possible suits in a deck of cards
	DIAMONDS, HEARTS, SPADES, CLUBS
}

class Card 
{
	// Instance variable of the type Suit
	// final keyword used, once the variable is initialized is can NOT be changed
	private final Suit cardSuit;
	// Instance variable of the type String
	// final keyword used, once the variable is initialized is can NOT be changed
	private final String cardValue;
	
	
	// Constructor for the Card class
	public Card(Suit cardSuit, String cardValue)
	{
		// Assign the value of cardSuit parameter to the cardSuit instance variable
		this.cardSuit = cardSuit;
		// Assign the value of cardValue parameter to the cardValue instance variable
		this.cardValue = cardValue;
	}
	
	// Getter method for the cardSuit instance variable
	public Suit getCardSuit()
	{
		return cardSuit;
	}
	
	// Getter method for the cardValue instance variable
	public String getCardValue()
	{
		return cardValue;
	}
	
	
}
