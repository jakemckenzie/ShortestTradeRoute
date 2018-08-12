import java.util.Random;

public class ShortestTradeRoute {
    
    public static void main(String[] args) {
        /**
         * @param testGiven this was the array given to us for the problem.
         */
        int[][] testGiven  = { {0, 2, 3, 7},
                                {0, 0, 2, 4},
                                {0, 0, 0, 2},
                                {0, 0, 0, 0}};
        /**
         * https://mathematica.stackexchange.com/questions/92666/how-to-zero-or-replace-the-diagonal-of-a-square-matrix
         * https://mathematica.stackexchange.com/questions/27408/have-the-random-functions-changed
         * https://link.springer.com/chapter/10.1007%2F3-540-46416-6_17
         */
        
        
    }

     /**
     * @param n left sided variable
     * @param m right sided variable
     * computes the maximum between n and m without branching
     * Hacker's Delight pg 100 Warren et al
     * 
     * also: https://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax
     */
    public int max(int n, int m) {
        return n ^ ((n ^ m) & -(n < m ? 1 : 0));
    }

    /**
     * @param 
     */
    /**
     * @param n left sided variable
     * @param m right sided variable
     * computes the minimum between n and m without branching
     * Hacker's Delight pg 100 Warren et al
     * 
     * also: https://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax
     */
    public int min(int n, int m) {
        return m ^ ((n ^ m) & -(n < m ? 1 : 0));
    }

    /**
     * I implemented XORShift and XORShift128plus after reading about how Java random works. 
     * Essentially they exist to make better psuedo-random seeds. 
     * 
     * https://en.wikipedia.org/wiki/Xorshift
     * https://www.javamex.com/tutorials/random_numbers/xorshift.shtml#.Wtmgwi7wZEY
     */

    private static long XORShift() {
        long x = System.currentTimeMillis();
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }
    private static long XORShift128plus() {
        long x = System.currentTimeMillis();
        long y = XORShift();    
        x ^= (x << 23);
        long z = x ^ y ^ (x >> 26);
        return z + x;
    }
}