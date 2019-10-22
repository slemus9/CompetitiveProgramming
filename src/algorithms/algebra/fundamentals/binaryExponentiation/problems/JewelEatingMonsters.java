package algorithms.algebra.fundamentals.binaryExponentiation.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ICPC: 3722 - Jewel-eating Monsters
 */
public class JewelEatingMonsters {

    private static long pow(long a, long n, long m){
        if (n == 0) return 1;
        long a1 = 1;
        while (n > 1){
            if (n % 2 == 0) n /= 2;
            else {
                a1 = (a % m * a1 % m) % m;
                n = (n - 1)/2;
            }
            a = (a % m * a % m) % m;
        }
        return (a * a1) % m;
    }

    private static long gcd(long a, long b){
        while (b > 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long inv(long a, long m){
        if (gcd(a, m) != 1) return -1;
        else return pow(a, m - 2, m);
    }

    private static long mod(long x, long m){
        return (x % m + m) % m;
    }

    /**
     * Power Sum: S_n = (a^{n + 1} - 1)/(a - 1)
     *
     * (N/D) mod n = (N * inv(D)) mod n = ( N mod n * inv(D) mod n) mod n
     * where inv(D) mod n = X and X satisfies:
     * (D * X) mod n = (D mod n * X mod n) mod n = 1
     *
     */
    private static long calculateCoins(long x, long a, long n, long c){

        long xn = ((x - 1) % c * pow(a, n, c)) % c;

        long N = (pow(a, n, c) - a % c) % c;
        long invD = inv(a - 1, c);

        long powerSum = (N * invD) % c;

        return mod(xn - powerSum, c);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long x = Long.parseLong(line[0]);
        long a = Long.parseLong(line[1]);
        long n = Long.parseLong(line[2]);
        long c = Long.parseLong(line[3]);

        while (x != 0 || a != 0 || n != 0 || c != 0){

            System.out.println(calculateCoins(x, a, n, c));

            line = br.readLine().split(" ");
            x = Long.parseLong(line[0]);
            a = Long.parseLong(line[1]);
            n = Long.parseLong(line[2]);
            c = Long.parseLong(line[3]);
        }
    }
}
