package GoogleCodeJam2019.qualificationRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String p = br.readLine();
            StringBuilder ans = new StringBuilder();

            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == 'S'){
                    ans.append('E');
                }else {
                    ans.append('S');
                }
            }
            System.out.println(String.format("Case #%d: %s", i, ans));

        }


    }
}
