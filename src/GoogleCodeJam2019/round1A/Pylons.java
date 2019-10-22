package GoogleCodeJam2019.round1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Pylons {

    static class Pair{
        int x;
        int y;
        boolean visited;

        public Pair(int x, int y, boolean visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            Pair[][] G = new Pair[r + 1][c + 1];
            HashSet<Pair> marked = new HashSet<>();

            for (int j = 1; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    G[i][j] = new Pair(i, j, false);
                }
            }



        }
    }
}
