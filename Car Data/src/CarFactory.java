/**
 * CarFactory class generates random car objects
 * 
 * @author Hope Lepeshko
 * @version 09/22/2023
 *
 */

//Import statement to get the Random class from the java.util package
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


/** Notes to self - Remember:
* (member is being used to describe the variables and methods that make up things of a class or object)
* 
* 'private' is a keyword known as an access modifier, meaning the variable or method is only 
* accessible with in the same class
* 
* 'static' is a keyword which indicates that the member belongs to the class itself, rather 
* than to instances of the class (objects)
* You can access the member using the class name
* ex: CarFactory.memberName
* 
* 'final' is a keyword which indicates that a member's value can NOT be changed after it has
*  been initialized
*  For variables this means they are constants
*  For methods this means they can't be overridden by a subclass
*/


public class CarFactory 
{
	// Define an array of possible car types
	// The variable is written in all capital letter because it is a constant
	private static final String[] POSSIBLE_CAR_TYPES = {"Sedan", "Sport", "SUV", "Truck", "Van"};
	
	// Define the minimum and maximum manufacturing year for cars (I'm using cars made in the last 50 years)
	// The variables are written in all capital letter because they are constants
	private static final int MIN_YEAR = 1973;
	private static final int MAX_YEAR = 2023;
	
	// Define an array of of possible car colors
	// The variable is written in all capital letter because it is a constant
	private static final String[] POSSIBLE_CAR_COLORS = {"Red", "Black", "White", "Blue", "Gray"};
	
	// Create an instance of the Random class to generate random values
	private static final Random random = new Random();
	
	
	// Generate random car type
	private static String getRandomCarType()
		{
			// Using a weighted random selection to make Sedans more popular
			// Adding Sedan in the list twice to increase the chances of it being randomly selected
			String[] adjustedCarTypes = {"Sedan", "Sedan", "Sport", "SUV", "Truck", "Van"};
			// Generate a random integer between 0 and the number of possible car types in the adjustedCarTypes array
			// in this case it would generate a random integer between 0 and 5 because the array has 6 elements
			return adjustedCarTypes[random.nextInt(adjustedCarTypes.length)];
		}
		
		

		// Generate random car color
	    // method declaration
		private static String getRandomCarColor()
		{
			// Using a weighted random selection to make the color red more popular
			// Adding Red in the list twice to increase the chances of it being randomly selected
			String[] adjustedCarColors = {"Red", "Red", "Black", "White", "Blue", "Gray"};
			// Generate a random integer between 0 and the number of possible car colors in the adjustedCarColors array
			// in this case it would generate a random integer between 0 and 5 because the array has 6 elements
			return adjustedCarColors[random.nextInt(adjustedCarColors.length)];
		}
		

		
	// Generate random miles up to and including 250,000
	// method declaration
	private static int getRandomMiles()
		{
		// Return a random integer between 0 and 250,000
		// If i had put 'return random.nextInt(250000)' it would only generate a random 
		// integer between 0 and 249,999 because the upper limit is exclusive
		return random.nextInt(250001);
		}
	
	
	// Generate random year within the last 50 years
	// method declaration
	private static int getRandomYear() 
	{
        // Generates a random integer between 0 and MAX_YEAR - MIN_YEAR
		return random.nextInt(MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR;
    }
	
	// Defining public method called generatAndExportCars
	// method takes in 2 parameters - numCars and outputFileName
	public static void generateAndExportCars(int numCars, String outputFileName) 
	{
        // try block
		// Used to execute code that may have an error
		try 
        {
            // Creating a new tool named 'writer' to write data to CSV
			// the writer tool will write to the file names 'outputFileName'
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            // Using 'writer' tool to write the header of the file (from the Car class)
            writer.write(Car.Header);
            // Adding a new line after the header
            writer.newLine();

            // For loop to generate each car's data
            // i declared and set to zero
            // The loop will continue as long as i is less than numCars
            for (int i = 0; i < numCars; i++) 
            {
                // Generating random car type
            	String carType = getRandomCarType();
            	// Generating random car color
                String color = getRandomCarColor();
                // Generating random car year
                int year = getRandomYear();
                // Generating random car miles
                int miles = getRandomMiles();

                // Using the random things we just generated to create a car with
                // a type, color, year, and miles
                Car car = new Car(carType, color, year, miles);
                // Using writer to convert to CSV
                writer.write(car.toCsvString());
                // Using writer to create a new line in the CSV file
                writer.newLine();
            }

            // Close the writer
            writer.close();
        } 
		// Catch any errors and prevent crash
		catch (IOException e) 
		{
            // If we catch an error print the error message
			e.printStackTrace();
        }
    }
	
	// Reference: https://www.tabnine.com/code/java/packages/Car
	// Reference: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedWriter.html
	// Reference: https://www.javatpoint.com/java-bufferedwriter-class
	
	
}
	

