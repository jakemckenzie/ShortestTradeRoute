import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ShortestTradeRoute {
    
    public static void main(String[] args) throws IOException{

        /**
         * @param testGiven this was the array given to us for the problem.
         */
        int[][] testGiven  = { {0, 2, 3, 7},
                                {0, 0, 2, 4},
                                {0, 0, 0, 2},
                                {0, 0, 0, 0}};
        /**
         * So I generated many random matrices for testing in mathematica. I decided to generate them there because the tools
         * for generating random numbers is much more mature in mathematica and I could easily generate better unpredictability
         * using their tools.
         * 
         * Mathematica uses Rule30CA which passes the big crush suite, which is a very high bar statistical test for 
         * randomness. The documentation I used in researching this is below.
         * 
         * https://mathematica.stackexchange.com/questions/92666/how-to-zero-or-replace-the-diagonal-of-a-square-matrix
         * https://mathematica.stackexchange.com/questions/27408/have-the-random-functions-changed
         * https://link.springer.com/chapter/10.1007%2F3-540-46416-6_17
         * 
         * The first set of test files was produced with the following definition:
         * 
         * f[n_] = UpperTriangularize[Table[RandomInteger[{1, n}], {i, 1, n}, {j, 1, n}], 1]
         * and
         * Table[Export["pureRule30CA" <> ToString[i] <> ".txt", Grid[f[i]], "Table"], {i, 4, 10}]
         * Table[Export["pureRule30CA" <> ToString[i] <> ".txt", Grid[f[i]], "Table"], {i, {25, 50, 100, 200, 400, 800}}]
         * 
         * The second set of test files was produced with the following definition:
         * 
         * g[n_] = UpperTriangularize[Table[RandomInteger[{1, n}] + RandomInteger[{1, i}], {i, 1, n}, {j, 1, n}], 1]
         * and
         * Table[Export["increasingRule30CA" <> ToString[i] <> ".txt", Grid[g[i]], "Table"], {i, 4, 10}]
         * Table[Export["increasingRule30CA" <> ToString[i] <> ".txt", Grid[g[i]], "Table"], {i, {25, 50, 100, 200, 400, 800}}]
         * 
         * I hope it is clear to the reader what is going on with these definitions. The first set is pure random numbers in the range of 1 to n
         * where n is the row and column size of the matrix I want to produce. The choice of a good random number range was difficult. If more time
         * were given I think 1 to n^2 would be a better range. The second set is the definition prior plus a random number that range increases with
         * the row length of the entry it is in. 
         * 
         * @param testCommandLine the command line text file asked of us that reads in a random file that is tab delineated.
         * I didn't like the use of NA so I made sure that it could read in a file of zeros instead. I assumed this was okay
         * to do because you told us we didn't have to worry about even reading in from a file.
         */

       int[][] testCommandLine = Files.lines(FileSystems.getDefault().getPath(args[0]))
                                    .map(item -> item.chars().filter(i -> (char) i != '\t').map(Character::getNumericValue).toArray())
                                    .toArray(int[][]::new); 
        
        for (int i = 0; i < testCommandLine[0].length; i++){
            for (int j = 0; j < testCommandLine.length; j++) {
                System.out.print(testCommandLine[i][j]+" ");
            }
            System.out.print("\n");
        }
        
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