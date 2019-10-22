package codeforces.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IlyaAndQueries1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[] arr = computeSumArray(s);

        for (int i = 0; i < n; i++) {
            String[] q = br.readLine().split(" ");
            int l = Integer.parseInt(q[0]) - 1;
            int r = Integer.parseInt(q[1]) - 1;
            System.out.println(arr[r] - arr[l]);
        }
    }

    private static int[] computeSumArray(String s){
        int[] arr = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            arr[i] = arr[i - 1] + (s.charAt(i) == s.charAt(i - 1) ? 1 : 0);
        }
        return arr;
    }
}
