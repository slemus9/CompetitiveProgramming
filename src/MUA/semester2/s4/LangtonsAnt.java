package MUA.semester2.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class LangtonsAnt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" +");
        int n = Integer.parseInt(line[0]);
        String c = line[1];
        int x = Integer.parseInt(line[3]);
        int y = Integer.parseInt(line[2]);

        while (n != 0 || x != 0 || y != 0 || c.compareTo("0") != 0){

            String binRep = (new BigInteger(c)).toString(2);
            String zs = "";

            while ((zs.length() + binRep.length()) < n*n){
                zs += "0";
            }
            binRep = zs + binRep;

            int[][] M = constructMatrix(binRep, n);
            int currX = n - x;
            int currY = y - 1;
            int currDir = 'U';
            boolean canMove  = true;

            while (!(currX == 0 && currY == n - 1) && canMove){
                if (!isValid(currX, currY, n)){
                    canMove = false;
                }else {

                    int[] newCoor = move(currX, currY, M[currX][currY], currDir);
                    M[currX][currY] = M[currX][currY] == 1 ? 0 : 1;
                    currX = newCoor[0];
                    currY = newCoor[1];
                    currDir = newCoor[2];
                }
            }

            if (canMove) System.out.println("Yes");
            else System.out.println("Kaputt!");

            line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            c = line[1];
            x = Integer.parseInt(line[3]);
            y = Integer.parseInt(line[2]);
        }
    }

    private static int[] move(int x, int y, int color, int currDir){
        int[] coor = new int[3];
        if (currDir == 'U'){
            coor[0] = x;
            if (color == 1){
                coor[1] = y + 1;
                coor[2] = 'R';
            }else {
                coor[1] = y - 1;
                coor[2] = 'L';
            }
        }else if (currDir == 'R'){
            coor[1] = y;
            if (color == 1){
                coor[0] = x + 1;
                coor[2] = 'D';
            }else {
                coor[0] = x - 1;
                coor[2] = 'U';
            }
        }else if (currDir == 'D'){
            coor[0] = x;
            if (color == 1){
                coor[1] = y - 1;
                coor[2] = 'L';
            }else {
                coor[1] = y + 1;
                coor[2] = 'R';
            }
        }else if (currDir == 'L'){
            coor[1] = y;
            if (color == 1){
                coor[0] = x - 1;
                coor[2] = 'U';
            }else {
                coor[0] = x + 1;
                coor[2] = 'D';
            }
        }

        return coor;
    }

    private static boolean isValid(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static int[][] constructMatrix(String binRep, int n){
        int[][] M = new int[n][n];
        int k = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                M[i][j] = Integer.parseInt(binRep.charAt(k) + "");
                k++;
            }
        }
        return M;
    }
}
