/**
 * 
 * Class to assign random birthdays to people
 * 
 * @author Hope Lepeshko
 * @version 09/24/2023
 *
 */
import java.util.Random;
public class Birthday 
{
	// Declare an integer to store a person's date of birth, excluding the year
	private int dob;
	
	// Constructor for the Birthday class
	public Birthday()
	{
		// Create a new random object
		Random random = new Random();
		
		// Generate a random month between 1 and 12
		// nextInt(int bound) includes 0, so nextInt(12) will pull form 0 to 11
		// so I have to add + 1 to make it pull form 1 to 12
		int month = random.nextInt(12) + 1;
		
		 // Initialize the variable for day
        int day;
        
        // Use conditional statements to determine the range of days for each month
        if (month == 2) 
        {
            // If the month is February: 28 days
            day = random.nextInt(28) + 1;
        } 
        else if (month == 4 || month == 6 || month == 9 || month == 11) 
        {
            // If the month is April, June, September, or November: 30 days
            day = random.nextInt(30) + 1;
        } 
        else 
        {
            // Remaining months (April, June, September, and November): 31 days
            day = random.nextInt(31) + 1;
        }
		
		// Store the birthday as an integer in the format of MMDD
        // Multiplying the month by 100 and adding the day allows me store the month 
        // and day as one integer. For example my birthday March 29th would be stored as 329
        // My mom's birthday November 11th would be stored as 1102
		this.dob = month * 100 + day;	
	}
	
	//Getter method to retrieve the person's birthday
	public int getDob()
	{
		return this.dob;
	}
	
	// DOuble checked with Heather
}
