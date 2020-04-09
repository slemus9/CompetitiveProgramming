package MUA.S201901.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FootballMatch {

    public static class Match{
        int goalsHome = 0;
        int goalsAway = 0;

        String homeTeam = null;
        String awayTeam = null;

        public void addGoal(String team){
            if (homeTeam == null){
                homeTeam = team;
            }
            if (team.equals(homeTeam)){
                goalsHome ++;
            }else {

                if(awayTeam == null){
                    awayTeam = team;
                }
                goalsAway ++;
            }
        }

        public String matchResult(){
            if (goalsHome > goalsAway){
                return homeTeam;
            }else if(goalsHome < goalsAway){
                return awayTeam;
            }else {
                return "Draw";
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            Match m = new Match();

            for (int j = 0; j < n; j++) {
                m.addGoal(br.readLine());
            }
            System.out.println(m.matchResult());

        }
    }
}