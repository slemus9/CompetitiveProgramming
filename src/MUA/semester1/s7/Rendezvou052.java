package MUA.semester1.s1.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rendezvou052 {

    static final int INFINITY = 1000000;

    public static int fw(int[][] graph){

        //printSolution(graph);
        //System.out.println();

        int v = graph.length;
        int[][] dist = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 1; k < v; k++) {
            for (int i = 1; i < v; i++) {
                for (int j = 1; j < v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minHouse = 0;
        int sumMin = Integer.MAX_VALUE;

        for (int i = 1; i < v; i++) {
            int sum = 0;
            for (int j = 1; j < v; j++) {
                if (dist[i][j] != INFINITY){
                    sum += dist[i][j];
                }
            }
            if (sum < sumMin){
                sumMin = sum;
                minHouse = i;
            }
        }

        //printSolution(dist);

        return minHouse;

    }

    public static void printSolution(int dist[][])
    {
        int v = dist.length;
        for (int i=0; i<v; ++i)
        {
            for (int j=0; j<v; ++j)
            {
                if (dist[i][j]==INFINITY)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int t = 1;

        while (n != 0){
            int[][] graph = new int[n + 1][n + 1];
            String[] houseNames = new String[n + 1];

            for (int i = 1; i < n + 1; i++) {
                houseNames[i] = br.readLine();
            }

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {

                    if(i == j){
                        graph[i][j] = 0;
                    }else {
                        graph[i][j] = INFINITY;
                    }
                }
            }


            for (int i = 0; i < m; i++) {
                String[] ijk = br.readLine().split(" ");
                int x = Integer.parseInt(ijk[0]);
                int y = Integer.parseInt(ijk[1]);
                int k = Integer.parseInt(ijk[2]);
                graph[x][y] = k;
                graph[y][x] = k;
            }

            int minHouse = fw(graph);
            System.out.println("Case #" + t + " : " + houseNames[minHouse]);

            t++;
            nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
        }
    }
}
