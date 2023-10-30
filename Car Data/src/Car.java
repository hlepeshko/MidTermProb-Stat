/**
 * Car class represents the cars data
 * 
 * @author Hope Lepeshko
 * @version 09/22/2023
 *
 */

public class Car 
{
	// Header stores the header line for the csv file
	// the header of the csv file is the first line of a csv and it defines 
	// the values the file will contain (the header is also separated by commas) 
	public static final String Header = "CarType, Year, Color, Miles";
	
	// Declare instance variables to store car's carType, color, year, and miles.
	private String carType;
	private String color;
	private int year;
	private int miles;
 
	// Constructor to initialize a Car object with carType, color, year, and miles.
	public Car(String carType, String color, int year, int miles)
	{
		this.carType = carType;
		this.color = color;
		this.year = year;
		this.miles = miles;
	}
	
	// Method used to convert a car object into a Sting formatted for a CSV file (add commas).
	// Splits the input CSV line into an array of parts
	public String toCsvString() 
	{
		// return carType,color,year,miles
		return carType + "," + color + "," + year + "," + miles;
	}
	
	// Static method to create a Car object form a CSV formatted String
	public static Car fromCsvString(String csvLine)
	{
		// Split the CSV formatted String into an array of parts using commas to sperate each part
		String[] parts = csvLine.split(",");
		
		// If statement to check if there are exactly four parts in the CSV file
		// One for carType, one for color, one for year, and one for miles.
		// If there is not exactly four types, say it Invalid
		if (parts.length != 4)
		{
			throw new IllegalArgumentException("Invalid CSV line data: " + csvLine);
		}
		
		// Remove everything except for the carType (index 0)
		String carType = parts[0].trim();
		
		// Remove everything except for color (index 1)
		String color = parts[1].trim();
		
		// Remove everything except for year (index 2)
		int year = Integer.parseInt(parts[2].trim());
		
		// Remove everything except for miles (index 3)
		int miles = Integer.parseInt(parts[3].trim());
		
		// Create a new Car object using the the values pulled form the CSV String
		return new Car(carType, color, year, miles);
	}	
}