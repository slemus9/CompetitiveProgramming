package algorithms.algebra.fundamentals.binaryExponentiation.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UVa: 1230 - MODEX
 */
public class MODEX {

    public static long binExpMod(long x, long y, long n){

        long x1 = 1;

        while (y > 1){
            if (y % 2 == 0) y /= 2;
            else {
                x1 = (x1 * x) % n;
                y = (y - 1)/2;
            }
            x = (x * x) % n;
        }

        return (x * x1) % n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            String[] xyn = br.readLine().split(" ");
            long x = Long.parseLong(xyn[0]);
            long y = Long.parseLong(xyn[1]);
            long n = Long.parseLong(xyn[2]);
            System.out.println(binExpMod(x, y, n));
        }

        br.readLine();
    }
}
