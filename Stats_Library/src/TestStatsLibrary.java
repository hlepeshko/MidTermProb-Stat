import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Test for chapters 1, 2, and 3.
 * 
 * @author Hope Lepeshko
 */
public class TestStatsLibrary {

    /**
     * Entry point for testing the statistics library functionalities.
     *
     * @param args Command line arguments (not used in this demonstration).
     */
    public static void main(String[] args) 
    {
        
        /** 
         * Instance for Chapter 1 statistics functions. 
         * */
        StatisticsChapterOne test_ch1 = new StatisticsChapterOne();

        /** 
         * Instance for Chapter 2 statistics functions. 
         * */
        StatisticsChapterTwo test_ch2 = new StatisticsChapterTwo();

        /** 
         * Instance for Chapter 3 statistics functions. 
         * */
        StatisticsChapterThree test_ch3 = new StatisticsChapterThree();

        // Prepare test data-sets.
        ArrayList<Double> testnums1 = new ArrayList<>();
        ArrayList<Double> testnums2 = new ArrayList<>();
        testnums1.add(1.0); testnums2.add(8.0);  
        testnums1.add(2.0); testnums2.add(2.0);
        testnums1.add(3.0); testnums2.add(4.0);
        testnums1.add(4.0); testnums2.add(6.0);
        testnums1.add(5.0); testnums2.add(5.0);
        testnums1.add(6.0); testnums2.add(7.0);
        testnums1.add(7.0); testnums2.add(9.0);
        testnums1.add(5.0); testnums2.add(5.0);

        // Test and display results for Chapter 1.
        double testMean = test_ch1.calculateMean(testnums1);
        double testMedian = test_ch1.calculateMedian(testnums1);
        double testMode = test_ch1.calculateMode(testnums1);
        double testStandardDeviation = test_ch1.calculateStandardDeviation(testnums1);
        System.out.println("Chapter 1:" );
        System.out.println("Average of testnums1: " + testMean);
        System.out.println("Median of testnums1: " + testMedian);
        System.out.println("Mode of testnums1: " + testMode);
        System.out.println("Standard Deviation of testnums1: " + testStandardDeviation);

        // Test and display results for Chapter 2.
        ArrayList<Double> testIntersection = test_ch2.findIntersection(testnums1,testnums2);
        System.out.println("Chapter 2");
        System.out.println("Intersection of testnums1 and testnums2: " + testIntersection);
        
        // Test and display results for Chapter 3.
        double binomialProb = test_ch3.binomialProbability(0.5, 5, 3);
        double geometricProb = test_ch3.geometricProbability(0.5, 2);
        double hypergeometricProb = test_ch3.hypergeometricProbability(50, 25, 10, 5);
        double negativeBinomialProb = test_ch3.negativeBinomialProbability(0.5, 3, 2);
        double poissonProb = test_ch3.poissonProbability(5, 3);
        double tchebysheffProb = test_ch3.tchebysheffProbability(2);
        
        System.out.println("Chapter 3:");
        System.out.println("Binomial Probability: " + binomialProb);
        System.out.println("Geometric Probability: " + geometricProb);
        System.out.println("Hypergeometric Probability: " + hypergeometricProb);
        System.out.println("Negative Binomial Probability: " + negativeBinomialProb);
        System.out.println("Poisson Probability: " + poissonProb);
        System.out.println("Tchebysheff's Inequality: " + tchebysheffProb);

       
    }
    // Worked with Heather
}