package MUA.S201901.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerSequenceDividing {

    public static int minDiffDisjointSets(int n){

        int[] possibility = {1, 1, 0, 0};

        return possibility[(n - 1) % 4];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minDiffDisjointSets(n));
    }
}
