import java.util.ArrayList;

/**
 * A utility class for calculations from chapter 1.
 * @author Hope Lepeshko
 */
public class StatisticsChapterOne 
{

    /**
     * Calculates the mean of a list of numbers.
     * @param numbers The list of numbers.
     * @return The mean of the numbers.
     */
    public double calculateMean(ArrayList<Double> numbers) 
    {
        double total = 0;
        for(double number : numbers) 
        {
            total += number;
        }
        return total / numbers.size();
    }
    
    /**
     * Calculates the median of a list of numbers.
     * @param numbers The list of numbers.
     * @return The median of the numbers.
     */
    public double calculateMedian(ArrayList<Double> numbers) 
    {
        int size = numbers.size();
        return (size + 1) / 2.0;
    }
    
    /**
     * Finds the mode of a list of numbers.
     * @param numbers The list of numbers.
     * @return The mode of the numbers.
     */
    public double calculateMode(ArrayList<Double> numbers) 
    {
        double frequentValue = 0.0;
        int highestCount = 0;

        for (int i = 0; i < numbers.size(); i++) 
        {
            int count = 0;
            for (int j = 0; j < numbers.size(); j++) 
            {
                if (numbers.get(j).equals(numbers.get(i))) 
                {
                    count++;
                }    
            }
            if (count > highestCount) {
                highestCount = count;
                frequentValue = numbers.get(i);
            }
        }
        return frequentValue;
    }
    
    /**
     * Calculates the standard deviation of a list of numbers.
     * @param numbers The list of numbers.
     * @return The standard deviation of the numbers.
     */
    public double calculateStandardDeviation(ArrayList<Double> numbers) 
    {
        double total = 0.0;
        double sumOfSquares = 0.0;

        for (double num : numbers) 
        {
            total += num;
            sumOfSquares += Math.pow(num, 2);
        }
        double variance = getVariance(sumOfSquares, total, numbers);
        return Math.sqrt(variance);
    }
    
    /**
     * Helper method to calculate variance.
     * @param sumOfSquares The sum of the squares of the numbers.
     * @param total The sum of the numbers.
     * @param numbers The list of numbers.
     * @return The variance.
     */
    private double getVariance(double sumOfSquares, double total, ArrayList<Double> numbers) 
    {
        double mean = total / numbers.size();
        return sumOfSquares / numbers.size() - Math.pow(mean, 2);
    }
    // Worked with Heather
}
