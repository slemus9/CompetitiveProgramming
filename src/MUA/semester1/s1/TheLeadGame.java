package MUA.semester1.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheLeadGame {

    public static String getWinner(String[] scoreboard){

        int acc1 = 0;
        int acc2 = 0;
        int lead = 0;
        int lead_i = 0;
        int winner = 0;

        for (int i = 0; i < scoreboard.length; i++) {
            String[] scores_i = scoreboard[i].split(" ");
            acc1 += Integer.parseInt(scores_i[0]);
            acc2 += Integer.parseInt(scores_i[1]);

            lead_i = Math.abs(acc1 - acc2);

            if (lead_i > lead){
                if (acc1 > acc2){
                    winner = 1;
                }else {
                    winner = 2;
                }
                lead = lead_i;
            }

        }

        return winner + " " + lead;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] scoreboard = new String[n];

        for (int i = 0; i < n; i++) {
            scoreboard[i] = br.readLine();
        }

        System.out.println(getWinner(scoreboard));
    }
}
