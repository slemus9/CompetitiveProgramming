package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BirthdayCakeCandles {

    public static int candlesBlown(long[] candles){

        long max = 0;
        int count = 0;

        for (int i = 0; i < candles.length; i++) {
            if (candles[i] > max){
                max = candles[i];
                count = 0;
            }
            if(max == candles[i]){
                count ++;
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        long[] candles = new long[n];

        for (int i = 0; i < n; i++) {
            candles[i] = Long.parseLong(s[i]);
        }

        System.out.println(candlesBlown(candles));
    }
}
