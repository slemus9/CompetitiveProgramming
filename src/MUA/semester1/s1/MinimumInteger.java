package MUA.semester1.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumInteger {

    public static int findMinimumIntegerNotInRange(int l, int r, int d){

        if (l % d == 0){
            if (l - d > 0){
                return d;
            }
        }else {
            if (l/d >= 1){
                return d;
            }
        }

        if (r % d == 0){
            return r + d;
        }else {
            return (r/d + 1)*d;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {

            String[] query_i = br.readLine().split(" ");
            int l = Integer.parseInt(query_i[0]);
            int r = Integer.parseInt(query_i[1]);
            int d = Integer.parseInt(query_i[2]);

            System.out.println(findMinimumIntegerNotInRange(l, r, d));
        }
    }
}
