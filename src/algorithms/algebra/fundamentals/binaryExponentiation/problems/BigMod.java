package algorithms.algebra.fundamentals.binaryExponentiation.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * UVA: 374 - Big Mod
 */
public class BigMod {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while (line != null){
            BigInteger B = new BigInteger(line);
            BigInteger P = new BigInteger(br.readLine());
            BigInteger M = new BigInteger(br.readLine());
            System.out.println(B.modPow(P, M));
            br.readLine();
            line = br.readLine();
        }
    }
}
