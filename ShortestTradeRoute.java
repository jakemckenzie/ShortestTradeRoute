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
         * @param test N4 generated in mathematica using f[n_] = UpperTriangularize[Table[RandomInteger[{1, n}], {i, 1, n}, {j, 1, n}]]
         * where f[4]
         */
        int[][] testN4     = { {1, 4, 3, 4}, 
                                {0, 3, 3, 4}, 
                                {0, 0, 3, 4}, 
                                {0, 0, 0, 4}};
        /**
         * @param test N5 generated in mathematica where (see definition above) for f[5]
         */
        int[][] testN5     = { {1, 4, 1, 1, 3}, 
                                {0, 5, 3, 5, 4}, 
                                {0, 0, 4, 1, 2}, 
                                {0, 0, 0, 2, 4}, 
                                {0, 0, 0, 0, 3}};
        /**
         * @param test N6 generated in mathematica where (see definition above) for f[6]
         */
        int[][] testN6     = { {2, 1, 3, 5, 5, 4}, 
                                {0, 6, 3, 1, 1, 6}, 
                                {0, 0, 3, 5, 3, 2}, 
                                {0, 0, 0, 1, 3, 5}, 
                                {0, 0, 0, 0, 2, 3}, 
                                {0, 0, 0, 0, 0, 2}};
        /**
         * @param test N7 generated in mathematica where (see definition above) for f[7]
         */
        int[][] testN7     = { {7, 6, 5, 2, 7, 1, 1}, 
                                {0, 7, 4, 5, 7, 6, 6}, 
                                {0, 0, 2, 3, 3, 5, 7}, 
                                {0, 0, 0, 4, 5, 1, 4}, 
                                {0, 0, 0, 0, 7, 4, 7}, 
                                {0, 0, 0, 0, 0, 2, 6}, 
                                {0, 0, 0, 0, 0, 0, 6}};
        /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */
        int[][] testN8     = { {6, 8, 8, 2, 8, 3, 8, 1}, 
                                {0, 2, 4, 3, 4, 8, 7, 8}, 
                                {0, 0, 6, 3, 7, 5, 5, 7}, 
                                {0, 0, 0, 8, 8, 3, 6, 5}, 
                                {0, 0, 0, 0, 1, 1, 3, 3}, 
                                {0, 0, 0, 0, 0, 5, 7, 6}, 
                                {0, 0, 0, 0, 0, 0, 8, 3}, 
                                {0, 0, 0, 0, 0, 0, 0, 1}};
        /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */
        int[][] testN9      = { {2, 7, 6, 4, 3, 6, 1, 8, 6}, 
                                {0, 9, 9, 1, 9, 9, 5, 5, 6}, 
                                {0, 0, 5, 9, 3, 9, 2, 3, 2}, 
                                {0, 0, 0, 7, 8, 7, 2, 6, 5}, 
                                {0, 0, 0, 0, 8, 3, 2, 3, 2}, 
                                {0, 0, 0, 0, 0, 6, 1, 6, 6}, 
                                {0, 0, 0, 0, 0, 0, 1, 7, 5}, 
                                {0, 0, 0, 0, 0, 0, 0, 4, 7}, 
                                {0, 0, 0, 0, 0, 0, 0, 0, 8}};
        int[][] testN10     = { {2, 5, 8, 5, 6, 1, 9, 6, 9, 3}, 
                                {0, 2, 2, 8, 1, 10, 8, 1, 3, 5}, 
                                {0, 0, 10, 6, 3, 5, 5, 1, 2, 9}, 
                                {0, 0, 0, 5, 10, 3, 10, 8, 6, 6}, 
                                {0, 0, 0, 0, 10, 8, 2, 6, 8, 10}, 
                                {0, 0, 0, 0, 0, 8, 4, 9, 10, 5}, 
                                {0, 0, 0, 0, 0, 0, 10, 1, 7, 9}, 
                                {0, 0, 0, 0, 0, 0, 0, 4, 1, 2}, 
                                {0, 0, 0, 0, 0, 0, 0, 0, 6, 3}, 
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 3}}
         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */

         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */

         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */

         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */

         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
         */

         /**
         * @param test N4 generated in mathematica where (see definition above) for f[8]
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