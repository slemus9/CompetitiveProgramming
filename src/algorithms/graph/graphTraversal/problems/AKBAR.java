package algorithms.graph.graphTraversal.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.spoj.com/problems/AKBAR/
 */
public class AKBAR {

    private static HashMap<Integer, ArrayList<Integer>> G;
    private static HashMap<Integer, Integer> strenghts;
    private static Queue<Integer> q;
    private static boolean[] used;
    private static int[] guarded;
    private static int[] distances;

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
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                addToG(u, v);
                addToG(v, u);
            }

            for (int j = 0; j < m; j++) {
                String[] ks = br.readLine().split(" ");
                int k = Integer.parseInt(ks[0]);
                int s = Integer.parseInt(ks[1]);
                strenghts.put(k, s);
            }

            guarded = new int[n + 1];

            boolean optimum = true;

            for(int s : strenghts.keySet()){
                used = new boolean[n + 1];
                distances = new int[n + 1];
                optimum = bfs(s);
                if (!optimum) break;
            }

            if (optimum) System.out.println("Yes");
            else System.out.println("No");

        }
    }

    private static void addToG(int v, int u){
        if (G.containsKey(u)){
            G.get(u).add(v);
        }else {
            ArrayList<Integer> adj = new ArrayList<>();
            adj.add(v);
            G.put(u, adj);
        }
    }

    private static boolean bfs(int s){
        q.add(s);
        used[s] = true;
        guarded[s]++;
        int cities = strenghts.get(s);
        boolean notRepeated = true;

        while (!q.isEmpty() && notRepeated){
            int v = q.poll();

            if (guarded[v] > 1){
                notRepeated = false;
                break;
            }

            if (distances[v] < cities){
                for(int u: G.get(v)){
                    if (!used[u]){
                        used[u] = true;
                        guarded[u]++;
                        q.add(u);
                        distances[u] = distances[v] + 1;
                    }
                    if (guarded[u] > 1){
                        notRepeated = false;
                        break;
                    }
                }
            }
        }

        return notRepeated;
    }
}
