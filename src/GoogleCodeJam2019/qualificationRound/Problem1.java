package GoogleCodeJam2019.qualificationRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 1; i <= t; i++) {
            String num = br.readLine();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            for (int j = 0; j < num.length(); j++) {
                if(num.charAt(j) == '4'){
                    a.append('3');
                    b.append('1');
                }else{
                    a.append(num.charAt(j));
                    b.append('0');
                }
            }

            int j = 0;
            while (j < b.length() && b.charAt(j) == '0'){
                j++;
            }

            System.out.println(String.format("Case #%d: %s %s", i, a, b.substring(j)));
        }
    }

}
