package MUA.S201901.s1.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstrings1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long number = Long.parseLong(br.readLine());
            long numberOfOnes = 0;

            for (int j = 0; j < n; j++) {
                long digit = number % 10;
                if (digit == 1){
                    numberOfOnes ++;
                }
                number /= 10;
            }
            System.out.println((numberOfOnes*(numberOfOnes + 1))/ 2);
        }
    }

}
