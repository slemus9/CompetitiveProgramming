package algorithms.algebra.fundamentals.greatestCommonDivisor.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa: 10104 - Euclid Problem
 */
public class EuclidProblem {

    private static long x;
    private static long prevx;
    private static long y;
    private static long prevy;

    private static long xgcd(long a, long b){
        while (b > 0){
            long q = a/b;
            long tempx = x;
            long tempy = y;
            x = prevx - q*x;
            y = prevy - q*y;
            prevx = tempx;
            prevy = tempy;

            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            String[] ab = line.split(" ");
            long a = Long.parseLong(ab[0]);
            long b = Long.parseLong(ab[1]);

            x = 0;
            prevx = 1;
            y = 1;
            prevy = 0;

            long g = xgcd(Math.abs(a), Math.abs(b));
            System.out.println(prevx + " " + prevy + " " + g);

        }
    }
}
