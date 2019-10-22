package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PlusMinus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        double rPos = 0.0;
        double rNeg = 0.0;
        double rZero = 0.0;

        for(String s : arr){
            int num = Integer.parseInt(s);
            if (num > 0){
                rPos += 1;
            }else if (num < 0){
                rNeg += 1;
            }else {
                rZero += 1;
            }
        }

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println((rPos / n) + "\n" + (rNeg / n) + "\n" + (rZero / n));
    }
}
