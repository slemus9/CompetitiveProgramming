package algorithms.graph.graphTraversal.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.spoj.com/problems/AKBAR/
 */
public class AKBAR {

    private static HashMap<Integer, ArrayList<Integer>> G;
    private static HashMap<Integer, Integer> strenghts;
    private static Queue<Integer> q;
    private static boolean[] used;
    private static int[] guarded;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            G = new HashMap<>();
            strenghts = new HashMap<>();
            q = new LinkedList<>();

            String[] nrm = br.readLine().split(" ");
            int n = Integer.parseInt(nrm[0]);
            int r = Integer.parseInt(nrm[1]);
            int m = Integer.parseInt(nrm[2]);

            for (int j = 0; j < r; j++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(nrm[0]);
                int v = Integer.parseInt(nrm[1]);

                if (G.containsKey(u)){
                    G.get(u).add(v);
                }else {
                    ArrayList<Integer> adj = new ArrayList<>();
                    adj.add(v);
                    G.put(u, adj);
                }
            }

            for (int j = 0; j < m; j++) {
                String[] ks = br.readLine().split(" ");
                int k = Integer.parseInt(ks[0]);
                int s = Integer.parseInt(ks[1]);
                strenghts.put(k, s);
            }


            used = new boolean[G.size()];
            guarded = new int[G.size()];

        }
    }

    private static void bfs(int s){
        q.add(s);
        used[s] = true;
        while (!q.isEmpty()){
            int v = q.poll();
            for(int u: G.get(v)){
                if (!used[u]){
                    used[u] = true;
                    q.add(u);
                }
            }
        }
    }

}
