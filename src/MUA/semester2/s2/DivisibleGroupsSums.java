package MUA.semester2.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DivisibleGroupsSums {

    private static int mod(int x, int n){
        return (x % n + n) % n;
    }

    private static HashMap<String, Long> memo;
    private static int N;
    private static int M;
    private static int D;

    private static long countGroups(int[] a, int i, int sum, int m){

        String k = String.format("%d,%d,%d,%d",D , i, sum, m);

        if (memo.containsKey(k)){
            return memo.get(k);
        }

        long result;
        if (i == N || m == 0){
            result = m == 0 && mod(sum, D) == 0 ? 1 : 0;
            memo.put(k, result);
            return result;
        }else {
            result = countGroups(a,i + 1, mod(mod(sum, D) + mod(a[i], D), D), m - 1)
                    + countGroups(a, i + 1, sum, m);
            memo.put(k, result);
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NQ = br.readLine().split(" ");
        N = Integer.parseInt(NQ[0]);
        int Q = Integer.parseInt(NQ[1]);
        int iter = 1;

        while (N != 0 || Q != 0){

            memo = new HashMap<>();
            int[] a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            System.out.printf("SET %d:\n", iter);
            for (int i = 0; i < Q; i++) {

                String[] DM = br.readLine().split(" ");
                D = Integer.parseInt(DM[0]);
                M = Integer.parseInt(DM[1]);

                long count = countGroups(a,0, 0, M);

                System.out.printf("QUERY %d: %d\n", i + 1, count);

            }

            iter++;
            NQ = br.readLine().split(" ");
            N = Integer.parseInt(NQ[0]);
            Q = Integer.parseInt(NQ[1]);
        }
    }
}
