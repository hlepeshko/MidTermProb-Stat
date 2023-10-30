/**
 * CarTester class to generate a CSV file and give success message
 * 
 * @author Hope Lepeshko
 * @version 09/22/2023
 *
 */
// Declare new class called CarTester
public class CarTester 
{
	// Main method
	public static void main(String[] args) 
	{
        // Call the generateAndExportCars method form the CarFactory class
		// Generates exactly 1,000 cars to a CSV file names Cars.CSV
		CarFactory.generateAndExportCars(1000, "Cars.csv");
        // Message to user printed 
		System.out.println("The cars have been successfully exported to a CSV file named Cars.csv");
    }
}
