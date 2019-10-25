package algorithms.graph.graphTraversal.problems;

import java.io.*;
import java.util.*;

public class AKBAR {

    private static Edge[] G;
    private static int[] strengths;
    private static int[] soldiers;
    private static int[] q;
    private static int[] used;
    private static int[] distances;
    private static int visited;

    public static void main(String[] args) throws IOException {
        IntIO in = new IntIO(System.in, 1<<14);
        int t = in.getInt();

        for (int i = 0; i < t; i++) {

            visited = 0;

            int n = in.getInt(), r = in.getInt(), m = in.getInt();

            G = new Edge[n];
            soldiers = new int[m];
            strengths = new int[m];
            distances = new int[n];

            for (int j = 0; j < r; j++) {
                int u = in.getInt() - 1, v = in.getInt() - 1;
                G[u] = new Edge(v, G[u]);
                G[v] = new Edge(u, G[v]);
            }

            for (int j = 0; j < m; j++) {
                int k = in.getInt() - 1, s = in.getInt();
                soldiers[j] = k;
                strengths[j] = s;
            }

            q = new int[n];
            used = new int[n];
            boolean optimum = true;

            Arrays.fill(used, -1);
            Arrays.fill(distances, -1);

            for (int j = 0; j < m; j++) {
                optimum = bfs(soldiers[j], strengths[j]);
                if (!optimum) break;
            }

            if (optimum && visited == n) System.out.println("Yes");
            else System.out.println("No");

        }
    }

    private static boolean bfs(int s, int cities){
        if (used[s] == -1){

            int start = 0, end = 0;
            q[end++] = s;
            used[s] = s;
            distances[s] = 0;
            visited++;
            boolean notRepeated = true;

            while (start < end && notRepeated){
                int v = q[start++];

                if (used[v] != s && used[v] > -1){
                    notRepeated = false;
                }else {
                    if (distances[v] < cities){
                        for(Edge e = G[v]; e != null; e = e.dest){
                            int u = e.to;
                            if (used[u] == -1){
                                used[u] = s;
                                visited++;
                                q[end++] = u;
                                distances[u] = distances[v] + 1;
                            }else {
                                if (used[u] != s){
                                    notRepeated = false;
                                    break;
                                }
                            }

                        }
                    }
                }
            }

            return notRepeated;
        }else {
            return false;
        }
    }

    private static class IntIO extends BufferedInputStream {
        public IntIO(final InputStream in)
        {
            super(in);
        }

        public IntIO(final InputStream in, final int buf_size)
        {
            super(in, buf_size);
        }

        public int getInt() throws IOException {
            int chr = read();
            while(chr<=' ') chr = read();
            int sum = chr-'0';
            while((chr = read())>' ') sum = (sum<<3)+sum+sum + chr-'0';
            return sum;
        }
    }

    private static class Edge{
        int to;
        Edge dest;
        Edge(int to, Edge dest){
            this.to = to;
            this.dest = dest;
        }
    }

}
