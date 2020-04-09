package MUA.S201901.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snowball {

    public static int finalWeithSnowball(int w, int h, int u1, int d1, int u2, int d2){

        for (int i = h; i >= 0; i--) {
            w += i;

            if (i == d1){
                w -= u1;
            }else if(i == d2){
                w -= u2;
            }

            if(w < 0){
                w = 0;
            }
        }

        return w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//        String[] snowball = br.readLine().split(" ");
//        String[] stone1 = br.readLine().split(" ");
//        String[] stone2 = br.readLine().split(" ");
//
//
//        int w = Integer.parseInt(snowball[0]);
//        int h = Integer.parseInt(snowball[1]);
//        int u1 = Integer.parseInt(stone1[0]);
//        int d1 = Integer.parseInt(stone1[1]);
//        int u2 = Integer.parseInt(stone2[0]);
//        int d2 = Integer.parseInt(stone2[1]);

        for (int i = 0; i < 100; i++) {
            double r = Math.sqrt(i);
            System.out.println(i + " " + r);
            System.out.println(r == (int)r);
        }
    }
}
