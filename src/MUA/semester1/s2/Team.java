package MUA.semester1.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Team {

    public static boolean canImplementSolution(String[] ps){

        int c = 0;

        for (String p: ps) {
            if (Integer.parseInt(p) == 1){
                c ++;
            }
            if (c == 2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int c = 0;

        for (int i = 0; i < n; i++) {
            String ps = br.readLine();
            c += (canImplementSolution(ps.split(" ")) ? 1 : 0);
        }
        System.out.println(c);
    }

}
