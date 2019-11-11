package MUA.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=6346
 */
public class BankCardVerifier {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] card = br.readLine().split(" ");
        while (card[0].charAt(0) != '0'){
            System.out.println(isValid(card));
            card = br.readLine().split(" ");
        }
    }

    private static String isValid(String[] card){
        int i = 0;
        long oddSum = 0;
        long evenSum = 0;

        for (int j = 0; j < card.length; j++) {
            String c_i = card[j];
            for (int k = 0; k < c_i.length(); k++) {
                int digit = Integer.parseInt(c_i.charAt(k) + "");
                if ((i + 1) % 2 == 0){
                    evenSum = mod( mod(evenSum, 10) + mod(digit, 10) , 10);
                }else {
                    int multBy2 = digit * 2 > 9 ? digit * 2 - 9 : digit * 2;
                    oddSum = mod( mod(oddSum, 10) + mod(multBy2, 10) , 10);
                }

                i++;
            }
        }

        if (mod(evenSum + oddSum, 10) == 0) return "Yes";
        else return "No";

    }

    private static long mod(long x, long n){
        return (x % n + n) % n;
    }
}
