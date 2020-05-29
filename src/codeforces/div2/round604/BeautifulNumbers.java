package codeforces.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulNumbers {

    public static void main(String[] args) throws IOException {
        FastReader br = new FastReader();
        int t = br.nextInt();

        for (int i = 0; i < t; i++) {
            int n = br.nextInt();
            int[] pos = new int[n + 1];

            for (int j = 0; j < n; j++) {
                pos[br.nextInt()] = j;
            }
            System.out.println(findBeautifulNumbers(pos));
        }
    }

    private static String findBeautifulNumbers(int[] pos){
        int currMax = 0;
        int currMin = Integer.MAX_VALUE;
        String res = "";

        for (int i = 1; i < pos.length; i++) {
            currMax = Math.max(currMax, pos[i]);
            currMin = Math.min(currMin, pos[i]);

            if (currMax - currMin == i - 1){
                res += '1';
            }else {
                res += '0';
            }
        }
        return res;
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
