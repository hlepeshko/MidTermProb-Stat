/**
 * 
 * @author Hope Lepeshko
 * @version 09/24/2023
 *
 */
// Importing scanner class to obtain user input
import java.util.Scanner;
// importing HashSet to store different birthdays
import java.util.HashSet;
// Importing Set to prevent duplicate values
import java.util.Set;


public class BirthdayProbability 
{
	    // Main method to run the program
	    public static void main(String[] args) 
	    {
	        // Create a Scanner object to read user input
	        Scanner input = new Scanner(System.in);

	        // Prompt the user to enter the number of people in the class
	        System.out.println("Please enter the number of people in the class: ");
	        int classSize = input.nextInt();

	        // Prompt the user to enter the number of simulation they would like to run
	        System.out.println("Please enter the number of simulations you would like to run: ");
	        int numberOfRuns = input.nextInt();

	        // Declare and initialize a variable to count the number of duplicate birthdays
	        int duplicateCount = 0;

	        // For loop for each simulation run
	        // The loop will run 'numberOfRuns' times. The variable 'i' starts with 0 and increments up by 1
	        // until the loop reaches 'numberOfRuns - 1'
	        // If the user inputs 10 runs, this loop will run until 9 (which is actually 10 because it starts at 0!)
	        for (int i = 0; i < numberOfRuns; i++) 
	        {
	            // Check if the current run has duplicate birthdays
	        	// If statement calls 'hasDuplicateBirthday(classSize)' method
	        	// Which checks if any two people in the class share a birthday
	            if (hasDuplicateBirthday(classSize)) 
	            {
	                // If the method returns true the duplicateCount is increased by 1
	            	duplicateCount++;
	            }
	        }

	        
	        // Calculate the probability based on the number of runs with duplicate birthdays
	        double probability = ((double) duplicateCount / numberOfRuns) * 100;
	        
	        // Display the result
	        System.out.printf("The probability of having at least two people with the same birthday in a class of %d is %.2f%%\n", classSize, probability);
	    }


	    /**
	     * Declare a public static method called hasDuplicateBirthday
	     * Method to check if there are duplicate birthdays in a class of a given size
	     * 
	     * @param classSize
	     * @return boolean value / true or false
	     */
	    public static boolean hasDuplicateBirthday(int classSize) 
	    {
	        // Create a HashSet to store unique birthdays
	    	// Declare the variable birthdaySetbas a Set<Integer>
	        Set<Integer> birthdaySet = new HashSet<>();
	        
	        // Loop to generate a birthday for each person in the class
	        for (int i = 0; i < classSize; i++) 
	        {
	            // Create a new Person object
	            Birthday bDay = new Birthday();
	            
	            // Get the person's birthday
	            int birthday = bDay.getDob();
	            
	            // Check if this birthday is a duplicate
	            if (birthdaySet.contains(birthday)) 
	            {
	                return true;
	            }
	            
	            // Add the birthday to the set of unique birthdays
	            birthdaySet.add(birthday);
	        }
	        
	        // Return false if no duplicate birthdays are found
	        return false;
	    }
	    
	    // Reference: https://javabook.bloomu.edu/code-html/Chapter7/BirthdayParadox.html
	    // Checked with chat GPT
	
}
