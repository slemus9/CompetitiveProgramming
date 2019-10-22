package algorithms.algebra.fundamentals.binaryExponentiation.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa: 11029 - Leading and Trailing
 */
public class LeadingAndTrailing {

    public static long binExpMod(long n, long k, long m){
        long a1 = 1;
        if (n == k) return 1;
        while (k > 1){
            if (k % 2 == 0) k/= 2;
            else {
                a1 = (n % m * a1 % m) % m;
                k = (k - 1)/2;
            }
            n = (n % m * n % m) % m;
        }
        return (a1 * n) % m;
    }


    public static int getFirstDigits(long n, long k){
        double x = k * Math.log10(n);
        double d = x - Math.floor(x);
        double result = Math.pow(10, d) * 100;
        return (int)(Math.floor(result));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] nk = br.readLine().split(" ");
            long n = Long.parseLong(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String lastThree = binExpMod(n, k, 1000) + "";
            if (lastThree.length() == 0) lastThree = "000" + lastThree;
            else if (lastThree.length() == 1) lastThree = "00" + lastThree;
            else if (lastThree.length() == 2) lastThree = "0" + lastThree;

            System.out.println(getFirstDigits(n, k) + "..." + lastThree);
        }
    }
}
