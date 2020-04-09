package MUA.S201901.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyFour {

    public static int numFourOccurences(int number){
        int occ = 0;

        while (number > 0){
            if (number % 10 == 4){
                occ ++;
            }
            number /= 10;
        }

        return occ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(numFourOccurences(number));
        }
    }
}
