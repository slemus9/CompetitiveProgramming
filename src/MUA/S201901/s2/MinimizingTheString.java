package MUA.S201901.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizingTheString {

    public static int getRemovalPoint(int n, String s){

        int i;
        boolean finished = false;

        for (i = 0; i < n - 1 && !finished; i++) {

            if (s.charAt(i) > s.charAt(i + 1)){
                finished = true;
            }
        }

        if (!finished){
            i = n;
        }

        return i - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int i = getRemovalPoint(n, s);

        for (int j = 0; j < n; j++) {
            if (j != i){
                System.out.print(s.charAt(j));
            }
        }

    }
}
