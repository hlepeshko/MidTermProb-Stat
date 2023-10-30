import java.lang.Math;
import java.math.BigInteger;

/**
 * A utility class for calculations from chapter 3.
 * @author Hope Lepeshko
 */
public class StatisticsChapterThree extends StatisticsChapterTwo {

    /**
     * Calculates binomial probability.
     * @param p The probability of success.
     * @param n The number of trials.
     * @param y The number of successful outcomes.
     * @return The binomial probability.
     */
    public double binomialProbability(double p, int n, int y) {
        double q = 1-p;
        return findCombination(n,y).doubleValue() * Math.pow(p, y) * Math.pow(q, (n-y));
    }
    
    /**
     * Calculates geometric probability.
     * @param p The probability of success.
     * @param x The number of trials required to get the first success.
     * @return The geometric probability.
     */
    public double geometricProbability(double p, int x) {
        return Math.pow(1 - p, x - 1) * p;
    }

    /**
     * Computes hypergeometric probability.
     * @param N Total number of objects.
     * @param K Number of success states in the population.
     * @param n Number of draws.
     * @param k Number of observed successes.
     * @return The hypergeometric probability.
     */
    public double hypergeometricProbability(int N, int K, int n, int k) {
        return findCombination(K, k).doubleValue() * findCombination(N-K, n-k).doubleValue() / findCombination(N, n).doubleValue();
    }

    /**
     * Calculates negative binomial probability.
     * @param p Probability of success.
     * @param r Number of successes.
     * @param k Number of failures before the r-th success.
     * @return The negative binomial probability.
     */
    public double negativeBinomialProbability(double p, int r, int k) {
        return findCombination(k + r - 1, r - 1).doubleValue() * Math.pow(p, r) * Math.pow(1 - p, k);
    }

    /**
     * Computes Poisson probability.
     * @param lambda The average number of successes within a given region.
     * @param k The actual number of successes.
     * @return The Poisson probability.
     */
    public double poissonProbability(double lambda, int k) {
        return (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k).doubleValue();
    }

    /**
     * Calculates Tchebysheff's inequality for a given k value.
     * @param k The number of standard deviations.
     * @return The probability that the random variable is within k standard deviations of its mean.
     */
    public double tchebysheffProbability(double k) {
        return 1 - (1 / (k * k));
    }

    // Worked with Heather
}
