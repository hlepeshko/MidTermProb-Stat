import java.math.BigInteger;
import java.util.ArrayList;

/**
 * A utility class for calculations from chapter 2.
 * @author Hope Lepeshko
 */
public class StatisticsChapterTwo 
{
    /**
     * Finds the intersection of two lists.
     * @param list1 The first list.
     * @param list2 The second list.
     * @return The intersection of the two lists.
     */
    public ArrayList<Double> findIntersection(ArrayList<Double> list1, ArrayList<Double> list2) 
    {
        list1.retainAll(list2);
        return list1;
    }
    
    /**
     * Computes the union of two lists.
     * @param list1 The first list.
     * @param list2 The second list.
     * @return The union of the two lists.
     */
    public ArrayList<Double> findUnion(ArrayList<Double> list1, ArrayList<Double> list2) 
    {
        ArrayList<Double> union = new ArrayList<>(list1);
        for (Double value : list2) 
        {
            if (!union.contains(value)) 
            {
                union.add(value);
            }
        }
        return union;
    }
    
    /**
     * Computes the complement of list1 with respect to list2.
     * @param list1 The first list.
     * @param list2 The second list.
     * @return The complement of list1 with respect to list2.
     */
    public ArrayList<Double> findComplement(ArrayList<Double> list1, ArrayList<Double> list2) 
    {
        ArrayList<Double> complement = new ArrayList<>(list1);
        complement.removeAll(list2);
        return complement;
    }
    
    /**
     * Calculates the combination (n choose r).
     * @param n The total number.
     * @param r The number chosen from the total.
     * @return The combination of n choose r.
     */
    public BigInteger findCombination(int n, int r) 
    {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
    
    /**
     * Calculates the permutation (n permute r).
     * @param n The total number.
     * @param r The number of permutations.
     * @return The permutation of n permute r.
     */
    public BigInteger findPermutation(int n, int r) 
    {
        return factorial(n).divide(factorial(n - r));
    }

    /**
     * Calculates factorial of a number.
     * @param n The number.
     * @return The factorial of the number.
     */
    protected BigInteger factorial(int n) 
    {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) 
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    // Worked with Heather
}