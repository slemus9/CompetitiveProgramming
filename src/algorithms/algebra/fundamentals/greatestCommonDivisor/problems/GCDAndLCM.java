package algorithms.algebra.fundamentals.greatestCommonDivisor.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.codechef.com/problems/FLOW016
 */
public class GCDAndLCM {

    private static long gcd(long a, long b){
        while (b > 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] ab = br.readLine().split(" ");
            long a = Long.parseLong(ab[0]);
            long b = Long.parseLong(ab[1]);
            long g = gcd(a, b);
            long l = (a / g) *b;
            System.out.println(g + " " + l);
        }
    }
}
